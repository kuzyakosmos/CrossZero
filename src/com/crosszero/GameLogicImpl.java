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
                if (checkWin("X")) {
                    System.out.println("Поздравляю, Вы выиграли!");
                    return;
                }
            }

            if (i != 9) {
                computersTurn();
                i++;
                if (i > 5) {
                    if (checkWin("O")) {
                        System.out.println("К сожалению, Вы проиграли!");
                        return;
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

    @Override
    public void humanTurn() {

        System.out.println("Ваш ход");

        int num = scanner.nextInt();

        if (!validInputs.contains(num)) {
            System.out.println("Введен некорректный номер клетки. Введите число от 1 до 9 включительно.");
            humanTurn();
            return; //TODO ПАЧИМУ??77
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
    public boolean checkWin(String symb) {
        if (checkDiagonal(symb) || checkLanes(symb)) return true;
        return false;
    }

    @Override
    public boolean checkDiagonal(String symb) {

        boolean toright, toleft;
        toright = true;
        toleft = true;

        for (int num = 0; num < 9; num += 4) {
            toright = toright & (field.getCell(num) == symb);
        }

        for (int num = 2; num < 7; num += 2) {
            toleft = toleft & (field.getCell(num) == symb);
        }

        if (toright || toleft) return true;

        return false;
    }

    @Override
    public boolean checkLanes(String symb) {

        for (int num = 1; num < 8; num += 3) {
            if ((field.getCell(num - 1) == symb) & (field.getCell(num) == symb) & (field.getCell(num + 1) == symb))
                return true;
        }

        for (int num = 3; num < 6; num++) {
            if ((field.getCell(num - 3) == symb) & (field.getCell(num) == symb) & (field.getCell(num + 3) == symb))
                return true;
        }

        return false;
    }
}
