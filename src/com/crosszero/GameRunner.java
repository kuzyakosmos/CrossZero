package com.crosszero;

public class GameRunner {

    public static void main(String[] args) {
        Field field = new Field();
        field.init();
        field.setCell(3, "x");
        field.printField();
    }
}
