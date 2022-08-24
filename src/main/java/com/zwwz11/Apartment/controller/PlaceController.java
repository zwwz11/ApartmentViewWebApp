package com.zwwz11.Apartment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/place")
public class PlaceController {

    @GetMapping("/busan")
    public String busan() {
        return "/place/busan";
    }

    @GetMapping("/busan/{LAWD_CD}")
    public String busanDistricts(@PathVariable String LAWD_CD, Model model) {

        return "";
    }

}
