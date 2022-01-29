package com.greatlearning;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReflectionDemo {

    private KnowYourJavaClass javaClass;

    public static void main(String[] args) throws ClassNotFoundException {
        new ReflectionDemo().processMainMenu();
    }

    private void processMainMenu() {
        System.out.println("Please enter the class name: ");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.next();
        System.out.println(className);
        System.out.println("Select the menu option ");
        System.out.println("1. Methods ");
        System.out.println("2. Class ");
        System.out.println("3. Subclasses ");
        System.out.println("4. Parent classes ");
        System.out.println("5. Constructors ");
        System.out.println("6. Data members ");

        int option = scanner.nextInt();
        processUserInput(option, className);
    }

    private void processUserInput(int option, String className) {
        switch (option) {
            case 1:
                javaClass = new KnowYourJavaClass(className);
                System.out.println("Methods details are: ");
                javaClass.getAllMethods();
                nextStep();
                break;
            case 2:
                javaClass = new KnowYourJavaClass(className);
                System.out.println("Class details are: ");
                System.out.println(javaClass.getClaas());
                nextStep();
                break;
            case 3:
                javaClass = new KnowYourJavaClass(className);
                System.out.println("Subclasses details are: ");
                javaClass.getSubClasses();
                nextStep();
                break;
            case 4:
                javaClass = new KnowYourJavaClass(className);
                System.out.println("Parent details are: ");
                Class clas = javaClass.getParentClass();
                int op = nextStep();
                if(op == 1){
                    storeToFile(clas);
                }else if(op==2){
                    readFromStore();
                }
                break;
            case 5:
                javaClass = new KnowYourJavaClass(className);
                System.out.println("Constructors details are: ");
                javaClass.getAllConstructorDetails();
                nextStep();
                break;
            case 6:
                javaClass = new KnowYourJavaClass(className);
                System.out.println("Data members are: ");
                nextStep();
                break;
            default:
                System.out.println("Invalid option ");
                nextStep();
                break;


        }
    }

    private void readFromStore() {
        try(Stream<Path> paths = Files.walk(Paths.get("src/main/resources/store/"))){
            paths.filter(Files::isRegularFile)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void storeToFile(Class clas) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/main/resources/store/" + clas.getSimpleName() + ".txt"))) {
            writer.write(clas.getName());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int nextStep() {
        System.out.println("Do you want to see any other further information - ");
        System.out.println(" press 'yes' to recheck the menu and 'no' if you want to continue");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        switch (option) {
            case "yes":
                System.out.println("1. Store information into file");
                System.out.println("2. To see all previous file created");
                System.out.println("3. Exit without storing");
                int choice = scanner.nextInt();
                return choice;
            case "no":
                processMainMenu();
                break;
            default:
                System.out.println("Invalid option, so exiting from application");
                break;

        }
        return  -1;
    }

    private void processSubMenu(int option) {
        switch (option) {
            case 1:
                System.out.println(" to do -  storing file info ");
                break;
            case 2:
                System.out.println("to do - see all previous file created ");
                break;
            case 3:
                System.out.println("Exiting ");
                break;
            default:
                System.out.println("Invalid option ");
                break;


        }
    }
}

