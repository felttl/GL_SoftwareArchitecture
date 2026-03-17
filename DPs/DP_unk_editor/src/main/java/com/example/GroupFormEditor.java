package com.example;

import java.util.Scanner;

class GroupFormEditor implements FormEditor {
    private FormComposite form;

    public GroupFormEditor(FormComposite form) {
        this.form = form;
    }

    public void runModal() {
        System.out.println("Editing form at " + form.x() + "," + form.y() + " with color " + form.getColor());
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter id of form to detele : ");
            int id = scanner.nextInt();
            for (Form f : form) {
                if (--id == 0) {
                    form.remove(f);
                    break;
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Invalid input, keeping old values.");
        }
        System.out.println("Form updated to " + form.x() + "," + form.y() + " with color " + form.getColor());
    }
}
