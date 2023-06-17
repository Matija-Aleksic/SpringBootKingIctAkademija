package com.example.demo.service.implemenacija;

import com.example.demo.service.DashboardService;

public class DashboardServiceProd implements DashboardService {
    @Override
    public String getDashboard() {
        return "dashboardProd.html";
    }
}
