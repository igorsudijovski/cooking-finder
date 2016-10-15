package com.cooking.finder.endpoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public TestModel test() throws NamingException, SQLException {
        TestModel testm = new TestModel();
        testm.setTest1("12312");
        testm.setTest2("asdfasdf");
        return testm;


    }
}
