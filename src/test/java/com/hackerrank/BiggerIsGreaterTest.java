package com.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Created by piyush_sagar on 10/22/19.
 */
public class BiggerIsGreaterTest {

    @Test
    public void testBiggerIsGreater() {
        String no = "no answer";
        Map<String, String> map = new HashMap<>();
        map.put("ab", "ba");
        map.put("bb", no);
        map.put("hefg", "hegf");
        map.put("dhck", "dhkc");
        map.put("dkhc", "hcdk");

        map.forEach( (k,v) -> {
            String res = BiggerIsGreater.biggerIsGreater(k);
            Assert.assertEquals(v, res);
        });
    }

    @Test
    public void testBiggerIsGreaterFromFile() throws IOException {
        String inFile = "src/test/resources/BiggerIsGreaterInput.txt";
        String outFile = "src/test/resources/BiggerIsGreaterOutput.txt";

        List<String> input = Files.lines(Paths.get(inFile)).collect(Collectors.toList());
        List<String> output = Files.lines(Paths.get(outFile)).collect(Collectors.toList());

        for (int i=0; i<input.size(); i++) {
            String in = input.get(i);
            String expected = output.get(i);
            String res = BiggerIsGreater.biggerIsGreater(in);
            if (!expected.equals(res)) {
                System.out.println("Input : " + in);
                System.out.println("Not equal at record : " + i+1);
            }
            Assert.assertEquals(expected, res);
        }
    }
}
