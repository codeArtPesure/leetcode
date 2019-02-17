package com.dengzhili.Introduction;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Integer> set=new LinkedHashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        int b=3;
//        Arrays.sort();
        set.add(12);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
//        LinkedHashSet
    }
    
}
