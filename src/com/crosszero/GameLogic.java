package com.crosszero;

public interface GameLogic {

    /**
     * Начинает игру
     */
    void start();

    /**
     * Ход компьютера
     */
    void computersTurn();

    /**
     * Ход человека
     */
    void humanTurn();

    /**
     * Вывод поля на экран
     */
    void printField();

    /**
     * Проверка поля на наличие свободных клеток
     * @return true - если заполнено, false - если еще есть свободные клетки
     */
    boolean isFull();

    /**
     * Проверка на победу
     * @return true - если на данном ходе есть выигравший
     */
    //TODO можно ли добавить в интерфейс вывод на экран оповещения о победе?
    boolean isWin();
}
