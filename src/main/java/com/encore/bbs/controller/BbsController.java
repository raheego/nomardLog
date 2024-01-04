package com.encore.bbs.controller;

import com.encore.bbs.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @GetMapping("/")
    public ModelAndView getList(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("list");

        return mav;
    }
}
