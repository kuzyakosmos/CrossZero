package com.crosszero;

public class Field {

    String field[] = new String[9];

    public void init() {
        for (int i = 0; i < 9; i++)
            field[i] = "-";
    }

    //num - номер клетки от 1 до 9
    //value - крестик или нолик O/X (в любом регистре)
    public int setCell(int num, String value) {

//        Проверяем корректность num
        if (!(num >= 1 && num <= 9)) {
            System.out.println("Введите значание номера клетки от 1 до 9 включительно.");
            return 0;
        }

//        Изменяем num для удобства работы с массивом
        num--;

//        Проверяем корректность value
        if (!(value.equalsIgnoreCase("O") | value.equalsIgnoreCase("X"))) {
            System.out.println("Введите корректное значение значения клетки ( O или X - в любом регистре)");
            return 0;
        }

//        Проверяем, что выбранная клетка свободна для хода
        if (field[num] == "-") {
//            Если все ок - присваиваем клетке нужное значение
            field[num] = value.toUpperCase();
            return 1;
        } else {
            System.out.println("Клетка уже заполнена! Сделайте выбор еще раз.");
            return 0;
        }
    }

    public void printField() {
        System.out.println(field[0] + " " + field[1] + " " + field[2]);
        System.out.println(field[3] + " " + field[4] + " " + field[5]);
        System.out.println(field[6] + " " + field[7] + " " + field[8]);
    }
}
