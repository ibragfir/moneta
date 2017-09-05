package com.example.moneta;

import com.example.moneta.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

@RestController
@RequestMapping("reverse")
public class ReverseWordController {
    private final Set<Character> upperChars;


    public ReverseWordController(@Value("${specialChars}") String upperChars) {
        this.upperChars = new HashSet<>(upperChars.length());
        IntStream.range(0, upperChars.length()).forEach(i -> this.upperChars.add(upperChars.charAt(i)));
    }

    @GetMapping
    public String reverseWord(@RequestParam(value = "word", defaultValue = "") String word) {
        return StringUtils.reverseAndLower(word, this.upperChars);
    }

}
