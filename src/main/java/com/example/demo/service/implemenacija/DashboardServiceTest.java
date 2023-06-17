package com.example.demo.service.implemenacija;

import com.example.demo.service.DashboardService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Profile("test")
@Service
public class DashboardServiceTest implements DashboardService {
    @Override
    public String getDashboard() {
        return "dashboardTest";
    }


}
