package com.example.demo.service.implemenacija;

import com.example.demo.service.DashboardService;
import org.springframework.context.annotation.Profile;

@Profile("prod")
public class DashboardServiceProd implements DashboardService {
    @Override
    public String getDashboard() {
        return "dashboardProd";
    }
}
