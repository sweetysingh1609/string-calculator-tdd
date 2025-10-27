package com.example.stringcalculator.controller;

import com.example.stringcalculator.service.StringCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow frontend access
public class CalculatorController {

    @Autowired
    private StringCalculator calculator;

    @PostMapping("/add")
    public int addNumbers(@RequestBody Map<String, String> request) {
        String numbers = request.get("numbers");
        return calculator.add(numbers);
    }
}
