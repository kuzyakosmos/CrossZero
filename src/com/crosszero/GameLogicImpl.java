package com.crosszero;

import java.util.Scanner;

public class GameLogicImpl implements GameLogic {

    Field field = new Field();

    @Override
    public void start() {
        printField();
        do {
            humanTurn();
            if (isFull() == false)
                computersTurn();
        } while (isFull() == false);

        if (isFull())
            System.out.println("Поле заполнено. Боевая ничья!");

    }

    @Override
    public void computersTurn() {

//        Генерим случайное число [1;9]
        int num = 0 + (int) (Math.random() * 8);

        if (isCellEmpty(num)) {
            System.out.println("Ход компьютера");
            String[] cells = field.getField();
            cells[num] = "O";
            field.setField(cells);
            printField();
        } else {
            computersTurn();
        }
    }

    public void humanTurn() {

        System.out.println("Ваш ход");

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

//        Проверяем корректность num
        if (!(num >= 1 && num <= 9)) {
            System.out.println("Введен некорректный номер клетки. Введите число от 1 до 9 включительно.");
            humanTurn();
        }

//        Изменяем num для удобства работы с массивом
        num--;

//        Проверяем, что выбранная клетка свободна для хода
        if (isCellEmpty(num)) {

//            Если все ок - присваиваем клетке нужное значение
            String[] cells = field.getField();
            cells[num] = "X";
            field.setField(cells);
            printField();
            //TODO почему отсюда опять залезает в if???

        } else {
            System.out.println("Клетка уже заполнена! Сделайте выбор еще раз.");
            humanTurn();
        }
    }

    @Override
    public void printField() {

        final String[] fieldForPrint;
        fieldForPrint = field.getField();

        System.out.println(" _____");
        System.out.println("|" + fieldForPrint[0] + " " + fieldForPrint[1] + " " + fieldForPrint[2] + "|");
        System.out.println("|" + fieldForPrint[3] + " " + fieldForPrint[4] + " " + fieldForPrint[5] + "|");
        System.out.println("|" + fieldForPrint[6] + " " + fieldForPrint[7] + " " + fieldForPrint[8] + "|");
        System.out.println(" ‾‾‾‾‾");
        System.out.println();
    }

    @Override
    public boolean isFull() {
        for (int i = 0; i < 9; i++) {
            if (field.getField()[i] == "*")
                return false;
        }
        return true;
    }

    @Override
    public boolean isCellEmpty(int num) {
        if (field.getField()[num] == "*") {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isWin() {
        return false;
    }
}
