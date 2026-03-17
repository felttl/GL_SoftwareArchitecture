package com.example;

class FormHtmlImplementation extends FormImplementation {
    public void draw_impl(Form f) {
        System.out.println("<html><body>Drawing form " + f.getClass().getSimpleName()
                + " at " + f.x() + "," + f.y() + " with color " + f.getColor()
                + "</body></html>");
    }
}
