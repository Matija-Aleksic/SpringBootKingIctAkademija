package com.example.demo.controller;

import com.example.demo.service.DashboardService;
import com.example.demo.service.PageSuffixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboardController {

    @Autowired
    private DashboardService dashboardService;
    @Autowired
    @Qualifier("html")
    private PageSuffixService pageSuffixService;

    @GetMapping(value = "/dashboard")
    public String getDashboard(){
        return dashboardService.getDashboard();
    }


}
