package com.example;

abstract class FormAbstract implements Form {
    private int _color;
    private int x, y;

    public void draw() {
        FormImplementation.getInsance().draw_impl(this);
    }

    public FormAbstract set(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public FormAbstract(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public FormAbstract setColor(int color) {
        _color = color;
        return this;
    }

    public FormAbstract clone() {
        try {
            return (FormAbstract) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public int getColor() {
        return _color;
    }

    public FormEditor createEditor() {
        return new GenericFormEditor(this);
    }
}
