package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu ;
    Random random;

    public DinnerConstructor() {
        this.menu = new HashMap<>()
        {{
            // если хотите дефолтный Мапу раскоментируйте
//            put("Первое", new ArrayList<>(Arrays.asList("Борщ", "Куриный суп", "Харчо")));
//            put("Второе", new ArrayList<>(Arrays.asList("Котлеты с пюре", "Рыба с рисом", "Куринная печень с булгуром")));
//            put("Третье", new ArrayList<>(Arrays.asList("Чай", "Кофе", "Морс")));
        }};
        random = new Random();
    }


    public void addNewDish(String dishType, String dishName) {
        if (!menu.containsKey(dishType)){
            menu.put(dishType, new ArrayList<String>());
            System.out.println("Добавлен новый тип блюда " + dishType+ ".");
        }

        menu.get(dishType).add(dishName);
        System.out.println("Блюдо " + dishName + " было добавено.");
    }

    public boolean checkType(String dishType) {
        if (!menu.containsKey(dishType)){
            System.out.println("Такого типа блюда нет пожалйста выбирете из списка :");
            printTypeMenu();
            return false;
        }
        return true;
    }

    public void printTypeMenu(){
        boolean toggle = true;
        for (String type : menu.keySet()) {
            if (toggle)
                System.out.print(type + " ".repeat(8));
            else
                System.out.println(type);
            toggle= !toggle;
        }
        if (!toggle)
            System.out.println();
        //Почему то не работает с System.lineSeparator()
    }

    public void generateCombination(ArrayList<String> dishesType, int numberOfCombos) {
        ArrayList<String> generationCombination ;
        for (int i = 0; i < numberOfCombos; i++) {

            generationCombination = new ArrayList<>();
            for (String type : dishesType) {
                generationCombination.add(menu.get(type).get(random.nextInt(menu.get(type).size())));
            }
            System.out.println(generationCombination);
        }
    }
}
