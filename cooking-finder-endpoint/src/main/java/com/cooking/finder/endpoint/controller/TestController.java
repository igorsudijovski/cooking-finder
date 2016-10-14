package com.cooking.finder.endpoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Igor on 14.10.2016.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test2")
    @ResponseBody
    public TestModel test() {
        TestModel testm = new TestModel();
        testm.setTest1("12312");
        testm.setTest2("asdfasdf");
        return testm;
    }
}
