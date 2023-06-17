package com.example.demo.service.implemenacija;

import com.example.demo.service.DashboardService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!test & !prod")
public class DashboardServiceDefault implements DashboardService {
    @Override
    public String getDashboard() {
        return "dashboard";
    }
}
