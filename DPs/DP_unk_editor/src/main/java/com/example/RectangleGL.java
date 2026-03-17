package com.example;

class RectangleGL extends FormAbstract {

    private int width = 0, height = 0;

    public RectangleGL clone() {
        return (RectangleGL) super.clone();
    }

    RectangleGL(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public RectangleGL setWH(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public FormEditor createEditor() {
        return new RectangleFormEditor(this);
    }
}
