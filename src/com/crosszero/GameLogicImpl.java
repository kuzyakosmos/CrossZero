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

        for (int i = 0; i < 9; ) {

            humanTurn();
            i++;
            if (i > 4) {
                if (isWin()) {
                    System.out.println("Поздравляю, Вы выиграли!");
                    break;
                }
            }

            if (i != 9) {
                computersTurn();
                i++;
                if (i > 5) {
                    if (isWin()) {
                        System.out.println("К сожалению, Вы проиграли!");
                        break;
                    }
                }
            }
        }
        System.out.println("Поле заполнено, а победителя по-прежнему нет. Боевая ничья!");
    }

    @Override
    public void computersTurn() {

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

        if (!validInputs.contains(num)) {
            System.out.println("Введен некорректный номер клетки. Введите число от 1 до 9 включительно.");
            humanTurn();
            return;
        }

        num--;

        if (isCellEmpty(num)) {
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
