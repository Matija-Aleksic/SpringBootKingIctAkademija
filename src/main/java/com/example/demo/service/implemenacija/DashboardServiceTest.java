package com.example.demo.service.implemenacija;

import com.example.demo.service.DashboardService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceTest implements DashboardService {
    @Override
    public String getDashboard() {
        return "dashboardTest.html";
    }
}
