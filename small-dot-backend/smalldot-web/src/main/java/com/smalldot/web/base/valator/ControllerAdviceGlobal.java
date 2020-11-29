package com.smalldot.web.base.valator;

import com.smalldot.base.ExeResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
@Component
public class ControllerAdviceGlobal {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExeResult handle(Exception exception) {
        exception.printStackTrace();
        StringBuffer msg = new StringBuffer();
        if (exception instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exs = (MethodArgumentNotValidException) exception;
            BindingResult bindingResult = exs.getBindingResult();
            if(bindingResult!=null){
                List<ObjectError> allErrors = bindingResult.getAllErrors();
                if(CollectionUtils.isNotEmpty(allErrors)){
                    allErrors.forEach(error->{
                        String defaultMessage = error.getDefaultMessage();
                        msg.append(defaultMessage+",");
                    });
                }
            }

        }else{

            msg.append(exception.getMessage());
        }
        return ExeResult.fail(msg.toString());
    }
}
