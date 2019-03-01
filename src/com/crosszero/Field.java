package com.crosszero;

import java.util.Arrays;

class Field {

    private String field[] = new String[9];

    Field() {
        Arrays.fill(field, "*");
    }

    public String[] getField() {
        return field;
    }

    public String getCell(int num) {
        return field[num];
    }

    public void setCell(int num, String cell) {
        this.field[num] = cell;
    }
}
