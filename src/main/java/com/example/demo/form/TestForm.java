package com.example.demo.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class TestForm {
    private String name;
    @NotBlank
    private String desc;
    @Min(value = 0)
    private Integer br;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getBr() {
        return br;
    }

    public void setBr(Integer br) {
        this.br = br;
    }

}
