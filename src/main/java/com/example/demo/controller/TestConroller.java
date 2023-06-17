package com.example.demo.controller;

import com.example.demo.dto.TestDto;
import com.example.demo.form.TestForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/test")
public class TestConroller {
    @GetMapping(value = "/get")
    public String testGet(){
        return "ok";
    }
@GetMapping(value = "/get/{param}")
    public String testGetWithParam(@PathVariable String param){
        return param;
    }
    @GetMapping(value = "/getResponse")
    public ResponseEntity<String> testResponseGet(){
        return ResponseEntity
                .internalServerError()
                .header("testHeader","abeceda")
                .body("Greska");
    }
    @GetMapping(value = "/getDto")
    public ResponseEntity<TestDto> testGetDto(){
        TestDto testDto= new TestDto();
        testDto.setName("ime");
        testDto.setDesciption("opis");
        return ResponseEntity.ok().body(testDto);
    }
    @PostMapping(value ="/post")
    public ResponseEntity<TestDto> testPostWithParam(@RequestBody @Valid TestForm testForm){
        TestDto testDto = new TestDto();
        testDto.setName(testForm.getName());
        testDto.setDesciption(testForm.getDesc());
        return ResponseEntity
                .ok()
                .body(testDto);
    }

   // http://localhost:8082/demoAppTest/swagger-ui/index.html
 }
