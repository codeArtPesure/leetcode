package com.dengzhili.Introduction;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
         HashMap map=new HashMap();
         map.put("1","3");
        System.out.println(map.get("1"));
        map.putIfAbsent("2","2");
        System.out.println(map.get("2"));
        map.put("1","5");
        System.out.println(map.get("1"));
    }
    
}
