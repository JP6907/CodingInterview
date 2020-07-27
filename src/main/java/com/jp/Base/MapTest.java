package com.jp.Base;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author zjp
 * @createTime 2020/7/26 8:55
 **/
public class MapTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.merge("a", 2, (oldValue, newValue) -> oldValue + newValue);
        System.out.println(map.get("a"));

        map.compute("a", (key, value) -> {
            if(value == null){
                value = 1;
            } else {
                value += 1;
            }
            return value;
        });
        System.out.println(map.get("a"));
    }
}
