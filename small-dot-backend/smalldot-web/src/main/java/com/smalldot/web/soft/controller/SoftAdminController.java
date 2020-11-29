package com.smalldot.web.soft.controller;

import com.smalldot.base.ExeResult;
import com.smalldot.service.soft.bo.SearchSoftBo;
import com.smalldot.service.soft.bo.SoftBo;
import com.smalldot.service.soft.service.SoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;

@RestController
@RequestMapping("/softadmin")
@Validated
public class SoftAdminController {
    @Autowired
    private SoftService softService;
    @RequestMapping("/save")
    public ExeResult save(@RequestBody SoftBo soft){
        return ExeResult.success(softService.save(soft));
    }
    @RequestMapping("/upload")
    public ExeResult upload(MultipartFile file) throws IOException {
        return ExeResult.success(softService.upload(file));
    }

    @RequestMapping("/list")
    public ExeResult list(SearchSoftBo soft){
        return ExeResult.success(softService.list(soft));
    }
    @RequestMapping("/delete")
    public ExeResult delete(@NotBlank(message = "参数错误") String id){
        return ExeResult.success(softService.delete(id));
    }
}
