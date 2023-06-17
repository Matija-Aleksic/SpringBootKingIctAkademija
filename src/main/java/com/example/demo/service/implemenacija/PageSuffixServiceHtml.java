package com.example.demo.service.implemenacija;

import com.example.demo.service.PageSuffixService;
import org.springframework.stereotype.Service;

@Service("html")

public class PageSuffixServiceHtml implements PageSuffixService {
    @Override
    public String getSuffix() {
        return "html";
    }
}
