package com.mathan.neetcode.day_02;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
            return new ArrayList<>();
        }

        // ansmap to keep track of ansValues and store keys
        Map<String, List<String>> ansMap = new HashMap<>();

        // iterate each string
        for (String s: strs) {
            //convert to chararray since string is immutable
            char[] charArray = s.toCharArray();
            //sort so that same string we can group and mutated
            Arrays.sort(charArray);
            // get the str key, use this way toChart.tostring will not work beacause it will return obj
            String key = new String(charArray);
            // if key not present execute lambda other wuse return value
            ansMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(ansMap.values());
    }
}
