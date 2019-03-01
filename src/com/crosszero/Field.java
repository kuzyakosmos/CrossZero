package com.crosszero;

import java.util.Arrays;

class Field {

    Field() {
        Arrays.fill(field, "-");
    }

    private String field[] = new String[9];

    public void printField() {
        System.out.println(field[0] + " " + field[1] + " " + field[2]);
        System.out.println(field[3] + " " + field[4] + " " + field[5]);
        System.out.println(field[6] + " " + field[7] + " " + field[8]);
    }

    public String[] getField() {
        return field;
    }

    public void setField(String[] field) {
        this.field = field;
    }

    public void setCell(int num, String value) {
        field[num] = value;
    }

}
