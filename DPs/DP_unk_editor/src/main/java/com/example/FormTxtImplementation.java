package com.example;

class FormTxtImplementation extends FormImplementation {
    public void draw_impl(Form f) {
        System.out.println("Drawing form " + f.getClass().getSimpleName() + " at " + f.x() + "," + f.y() + " with color " + f.getColor());
    }
}
