package com.example;

interface Form extends Cloneable {
    void draw();

    Form setColor(int color);

    Form set(int x, int y);

    int x();

    int y();

    int getColor();

    Form clone();

    FormEditor createEditor();
}
