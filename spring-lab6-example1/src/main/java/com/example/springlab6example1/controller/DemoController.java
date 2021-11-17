package com.example.springlab6example1.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
//    @ResponseBody
    public String hello() {
        return "Hello";
    }

    @GetMapping(path = "/hello/{name}")
    public String helloName(@PathVariable("name") String user) {
        return "Hello " + user + "!";
    }

    @GetMapping("/hello-params")
    public String helloParams(@RequestParam String firstName, @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }

    @GetMapping("/hello-params-optional")
    public String helloParamsOptional(@RequestParam String firstName, @RequestParam(required = false, defaultValue = "unknown") String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }

    @GetMapping(path = {"/hello-optional/{name}", "/hello-optional"})
    public String helloNameOptional(@PathVariable(value = "name", required = false) String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/hello-map-headers")
    public Map<String, String> helloMapHeaders(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @GetMapping("/hello-map-params")
    public Map<String, String> helloMapParams(@RequestParam Map<String, String> headers) {
        return headers;
    }

    @GetMapping("/hello-all/{name}")
    public String getAll(@PathVariable("name") String name,
                         @RequestParam(value = "varsta") Integer age,
                         @RequestHeader(value = "city") String address) {
        return "Hello " + name + ". You're " + age + " years old and you live in " + address;
    }

    @GetMapping("/status")
    public void statusChange(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
    }

    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPdf() {
        return new byte[10];
    }
}
