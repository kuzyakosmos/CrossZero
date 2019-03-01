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
     *
     * @return true - если заполнено, false - если еще есть свободные клетки
     */
    boolean isFull();

    /**
     * Проверка клетки
     *
     * @param num номер клетки
     * @return true если можно сходить, false - если клетка уже заполнена
     */
    boolean isCellEmpty(int num);

    /**
     * Проверка на победу
     *
     * @return true - если на данном ходе есть выигравший
     */
    //TODO можно ли добавить в интерфейс вывод на экран оповещения о победе?
    boolean isWin();
}
