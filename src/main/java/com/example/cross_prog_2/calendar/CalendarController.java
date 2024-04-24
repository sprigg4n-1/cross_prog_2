package com.example.cross_prog_2.calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
    @GetMapping
    public String calendar() {
        return "calendar/list";
    }
}
