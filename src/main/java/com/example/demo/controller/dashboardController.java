package com.example.demo.controller;

import com.example.demo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping(value = "/dashboard")
    public String getDashboard(){
        return dashboardService.getDashboard();
    }


}
