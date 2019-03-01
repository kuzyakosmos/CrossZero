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
     * Проверка клетки
     *
     * @param num номер клетки
     * @return true если можно сходить, false - если клетка уже заполнена
     */
    boolean isCellEmpty(int num);

    /**
     * Проверка на победу
     *
     * @param symb - для какого игрока проверяем
     * @return true - если на данном ходе есть выигравший
     */
    //TODO можно ли добавить в интерфейс вывод на экран оповещения о победе?
    boolean checkWin(String symb);

    /**
     * Проверка диагонали
     *
     * @param symb - для какого игрока проверяем
     * @return true если победа, false - нет
     */
    boolean checkDiagonal(String symb);

    /**
     * Проверка прямых линий
     *
     * @param symb - для какого игрока проверяем
     * @return true если победа, false - нет
     */
    boolean checkLanes(String symb);
}
