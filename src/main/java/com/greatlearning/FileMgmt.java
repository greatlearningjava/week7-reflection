package com.greatlearning;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileMgmt {

    public void readFromStoredLocation() {
        try(Stream<Path> paths = Files.walk(Paths.get("src/main/resources/store/"))){
            paths.filter(Files::isRegularFile)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeToFile(Class clas) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/main/resources/store/" + clas.getSimpleName() + ".txt"))) {
            writer.write(clas.getName());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeToFile(Constructor<?>[] constructors) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/main/resources/store/constructors.txt" ))) {
            for(Constructor constructor : constructors){
                writer.write(constructor.toString());
                writer.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeToFile(Method[] methods) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/main/resources/store/methods.txt" ))) {
            for(Method method : methods){
                writer.write(method.toString());
                writer.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeToFile(Field[] fields) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/main/resources/store/fields.txt" ))) {
            for(Field f : fields){
                writer.write(f.toString());
                writer.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
