package com.example.demo.service.implemenacija;

import com.example.demo.service.PageSuffixService;
import org.springframework.stereotype.Service;

@Service("xhtml")
public class PageSuffixServiceXhtml implements PageSuffixService {
    @Override
    public String getSuffix() {
        return "xhtml";
    }
}
