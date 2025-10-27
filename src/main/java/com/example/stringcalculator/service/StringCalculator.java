package com.example.stringcalculator.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.trim().isEmpty()) {
            return 0;
        }

        numbers = numbers.replace("\\n", "\n").replace("\\r", "");

        String delimiter = ",|\n"; // default delimiters

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("Invalid custom delimiter format");
            }

            String delimiterSection = numbers.substring(2, delimiterEndIndex);
            numbers = numbers.substring(delimiterEndIndex + 1);

            List<String> delimiters = new ArrayList<>();
            Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterSection);
            while (matcher.find()) {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }

            if (delimiters.isEmpty()) {
                if (delimiterSection.isEmpty()) {
                    throw new IllegalArgumentException("Custom delimiter cannot be empty");
                }
                delimiters.add(Pattern.quote(delimiterSection));
            }

            // Combine all delimiters in regex
            delimiter = String.join("|", delimiters);
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty()) continue;

            try {
                int num = Integer.parseInt(token);
                if (num < 0) {
                    negatives.add(num);
                } else if (num <= 1000) { // ✅ Ignore numbers > 1000
                    sum += num;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number: " + token);
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        return sum;
    }
}
