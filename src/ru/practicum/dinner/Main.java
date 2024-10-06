package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;


    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);


        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addNewDish(dishType, dishName);
        // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        ArrayList<String > dishesType = new ArrayList<>();
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos;
        while (true) {
            if (scanner.hasNextInt()) {
                numberOfCombos = scanner.nextInt();
                if (numberOfCombos  > 0)
                    break;
                System.out.println("Введите положительное целое число больше нуля");
                scanner.nextLine();

            }else {
                System.out.println("Введите положительное целое число.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {

            if (dc.checkType(nextItem))
                dishesType.add(nextItem);
            nextItem = scanner.nextLine();
        }

        if (dishesType.isEmpty()){
            System.out.println("Список тип блюд пустой.");
            return;
        }
        dc.generateCombination(dishesType, numberOfCombos);
        // сгенерируйте комбинации блюд и выведите на экран

    }
}
