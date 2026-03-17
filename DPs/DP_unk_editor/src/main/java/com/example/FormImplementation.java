package com.example;

abstract class FormImplementation {
    abstract void draw_impl(Form f);

    public static FormImplementation getInsance() {
        if (_instance == null)
            FormImplementation._instance = new FormTxtImplementation();
        return FormImplementation._instance;
    }

    public static void setInstance(FormImplementation impl) {
        FormImplementation._instance = impl;
    }

    private static FormImplementation _instance = null;
}
