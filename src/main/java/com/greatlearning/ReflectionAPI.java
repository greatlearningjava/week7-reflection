package com.greatlearning;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

public class ReflectionAPI {
    private Class claas;

    public ReflectionAPI(String className) {
        try {
            claas = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class<?> getClaas() {
        return claas;
    }


    public Constructor<?>[] getAllConstructorDetails() {
        Constructor<?>[] constructors = claas.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
        if(constructors.length == 0){
            System.out.println("no constructors for this class - " + claas);
        }
        return constructors;
    }

    public Method[] getAllMethods() {
        Method[] methods = claas.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
        if(methods.length == 0){
            System.out.println("no methods for this class - " + claas);
        }
        return methods;
    }

    public Set<Class<?>> getSubClasses() {
        Reflections reflections = new Reflections();
        Set<Class<?>> classSet = reflections.getSubTypesOf(claas);
        classSet.stream().forEach(System.out::println);
        if(classSet.size() == 0){
            System.out.println("no subclasses for this class - " + claas);
        }
        return classSet;
    }


    public Class getParentClass() {
        Class cl = claas.getSuperclass();
        System.out.println(cl);
        return cl;
    }

    public Field[] getAllDataMembers() {
        Field[] fields = claas.getDeclaredFields();
        Arrays.stream(fields).forEach(System.out::println);
        return fields;
    }
}
