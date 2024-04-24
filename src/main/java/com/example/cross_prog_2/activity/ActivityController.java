package com.example.cross_prog_2.activity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/activity")
public class ActivityController {
    @GetMapping
    public String activity() {
        return "activity/list";
    }
}
