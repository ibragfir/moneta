package com.example.moneta.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringUtilsTest {

    @Test
    public void reverseAndLower() {
        Set<Character> specialChars = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        String word = "Ahoj, jak se máš?";
        String reversed = "?šÁm es kaj ,joha";
        Assert.assertEquals(StringUtils.reverseAndLower(word, specialChars), reversed);

        word = "Je mi fajn.";
        reversed = ".NjaF iM ej";
        Assert.assertEquals(StringUtils.reverseAndLower(word, specialChars), reversed);
    }
}
