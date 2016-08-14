package com.catchmycode.ezstep.services;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ping")
public class PingService {

    @RequestMapping(value = "")
    public String pingSystem() {
       return "Current time: " + ISODateTimeFormat.dateTime().print(System.currentTimeMillis());
    }
}
