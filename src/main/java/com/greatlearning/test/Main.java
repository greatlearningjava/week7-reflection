package com.greatlearning.test;

import org.reflections.Reflections;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        KnowYourJavaClass obj = new KnowYourJavaClass("java.lang.Class");
//        obj.getSubClassess();

        Reflections reflections = new Reflections();
        //   reflections.getSubTypesOf(claas.getClass());
        Set<Class<? extends List>> subTypeSet = reflections.getSubTypesOf(List.class);
        System.out.println(subTypeSet.size());
        subTypeSet.stream().forEach(System.out::println);
    }
}
