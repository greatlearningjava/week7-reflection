package com.greatlearning;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MainMenu {

    private ReflectionAPI javaClass;
    private FileMgmt fileMgmt;

    public MainMenu(){
        fileMgmt = new FileMgmt();
    }
    public static void main(String[] args) throws ClassNotFoundException {
        new MainMenu().processMainOptions();
    }

    private void processMainOptions() {
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
                javaClass = new ReflectionAPI(className);
                System.out.println("Methods details are: ");
                Method[] methods = javaClass.getAllMethods();
                int op = nextStep();
                if(op == 1){
                    fileMgmt.storeToFile(methods);
                }else if(op==2){
                    fileMgmt.readFromStoredLocation();
                }
                System.out.println("Files read from stored location: ");
                fileMgmt.readFromStoredLocation();
                break;
            case 2:
                javaClass = new ReflectionAPI(className);
                System.out.println("Class details are: ");
                System.out.println(javaClass.getClaas());
                nextStep();
                break;
            case 3:
                javaClass = new ReflectionAPI(className);
                System.out.println("Subclasses details are: ");
                javaClass.getSubClasses();
                nextStep();
                break;
            case 4:
                javaClass = new ReflectionAPI(className);
                System.out.println("Parent details are: ");
                Class clas = javaClass.getParentClass();
                op = nextStep();
                if(op == 1){
                    fileMgmt.storeToFile(clas);
                }else if(op==2){
                    fileMgmt.readFromStoredLocation();
                }
                nextStep();
                break;
            case 5:
                javaClass = new ReflectionAPI(className);
                System.out.println("Constructors details are: ");
                Constructor<?>[] constructors = javaClass.getAllConstructorDetails();
                op = nextStep();
                if(op == 1){
                    fileMgmt.storeToFile(constructors);
                }else if(op==2){
                    fileMgmt.readFromStoredLocation();
                }
                System.out.println("Files read from stored location: ");
                fileMgmt.readFromStoredLocation();
                break;
            case 6:
                javaClass = new ReflectionAPI(className);
                System.out.println("Data members are: ");
                Field[] fields = javaClass.getAllDataMembers();
                op = nextStep();
                if(op == 1){
                    fileMgmt.storeToFile(fields);
                }else if(op==2){
                    fileMgmt.readFromStoredLocation();
                }
                System.out.println("Files read from stored location: ");
                fileMgmt.readFromStoredLocation();
                break;
            default:
                System.out.println("Invalid option ");
                nextStep();
                break;


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
                processMainOptions();
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

