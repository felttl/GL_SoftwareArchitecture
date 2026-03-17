package com.example;

import java.util.Scanner;

class RectangleFormEditor extends GenericFormEditor {
    private RectangleGL form;

    public RectangleFormEditor(RectangleGL form) {
        super(form);
        this.form = form;
    }

    public void runModal() {
        super.runModal();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Width: ");
            int width = scanner.nextInt();
            System.out.print("Enter Height: ");
            int height = scanner.nextInt();
            form.setWH(width, height);
        } catch (Exception e) {
            System.out.println("Invalid input, keeping old values.");
        }

        System.out.println("Form updated to " + form.x() + "," + form.y() + " with color " + form.getColor());
    }
}
