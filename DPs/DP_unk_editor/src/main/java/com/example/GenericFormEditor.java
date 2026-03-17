package com.example;

import java.util.Scanner;

class GenericFormEditor implements FormEditor {
    private FormAbstract form;

    public GenericFormEditor(FormAbstract form) {
        this.form = form;
    }

    public void runModal() {
        System.out.println("Editing form at " + form.x() + "," + form.y() + " with color " + form.getColor());
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter new color: ");
            int color = scanner.nextInt();
            form.setColor(color);
            System.out.print("Enter X: ");
            int x = scanner.nextInt();
            System.out.print("Enter Y: ");
            int y = scanner.nextInt();
            form.set(x, y);
            scanner.close();
        } catch (Exception e) {
            System.out.println("Invalid input, keeping old values.");
        }
        System.out.println("Form updated to " + form.x() + "," + form.y() + " with color " + form.getColor());
    }
}
