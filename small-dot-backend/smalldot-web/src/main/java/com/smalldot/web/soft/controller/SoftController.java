package com.smalldot.web.soft.controller;

import com.smalldot.base.ExeResult;
import com.smalldot.service.soft.bo.SearchSoftBo;
import com.smalldot.service.soft.bo.SoftBo;
import com.smalldot.service.soft.service.SoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soft")
public class SoftController {
    @Autowired
    private SoftService softService;

    @RequestMapping("/list")

    public ExeResult list(SearchSoftBo soft){
        return ExeResult.success(softService.list(soft));
    }
}
