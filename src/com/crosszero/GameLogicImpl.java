package com.crosszero;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLogicImpl implements GameLogic {

    Field field;
    Scanner scanner;
    ArrayList<Integer> validInputs;

    public GameLogicImpl() {

        validInputs = new ArrayList<>();
        field = new Field();
        scanner = new Scanner(System.in);

        for (int i = 1; i < 10; i++)
            validInputs.add(i);
    }

    @Override
    public void start() {
        printField();

        for (int i = 0; i < 9;) {
            humanTurn();
            i++;
            if (i != 9)
                computersTurn();
                i++;
        }
        System.out.println("Поле заполнено, а победителя по-прежнему нет. Боевая ничья!");
    }

    @Override
    public void computersTurn() {

//        Генерим случайное число [0;8]
        int num = (int) (Math.random() * 8);

        if (isCellEmpty(num)) {
            System.out.println("Ход компьютера");
            field.setCell(num, "O");
            printField();
        } else {
            computersTurn();
        }
    }

    public void humanTurn() {

        System.out.println("Ваш ход");

        int num = scanner.nextInt();

//        Проверяем корректность num
        if (!validInputs.contains(num)) {
            System.out.println("Введен некорректный номер клетки. Введите число от 1 до 9 включительно.");
            humanTurn();
        }

//        Изменяем num для удобства работы с массивом
        num--;

//        Проверяем, что выбранная клетка свободна для хода
        if (isCellEmpty(num)) {

//            Если все ок - присваиваем клетке нужное значение
            field.setCell(num, "X");
            printField();
            //TODO почему отсюда опять залезает в if???

        } else {
            System.out.println("Клетка уже заполнена! Сделайте выбор еще раз.");
            humanTurn();
        }
    }

    @Override
    public void printField() {

//        final String[] field.getCell();
//        field.getCell() = field.getField();

        System.out.println(" _____");
        System.out.println("|" + field.getCell(0) + " " + field.getCell(1) + " " + field.getCell(2) + "|");
        System.out.println("|" + field.getCell(3) + " " + field.getCell(4) + " " + field.getCell(5) + "|");
        System.out.println("|" + field.getCell(6) + " " + field.getCell(7) + " " + field.getCell(8) + "|");
        System.out.println(" ‾‾‾‾‾");
        System.out.println();
    }

    @Override
    public boolean isCellEmpty(int num) {
        return field.getField()[num].equals("*");
    }

    @Override
    public boolean isWin() {
        return false;
    }
}
