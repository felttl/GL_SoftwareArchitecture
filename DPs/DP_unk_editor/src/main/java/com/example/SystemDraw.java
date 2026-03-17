package com.example;

import java.util.ArrayList;

class SystemDraw {
    int formSelected = -1;
    static final int WINDOW_WIDTH = 800;
    static final int WINDOW_HEIGHT = 800;
    static final int TOOLBAR_WIDTH = 64;
    ArrayList<Form> forms = new ArrayList<Form>();
    ArrayList<Form> toolbar = new ArrayList<Form>();

    public void draw() {
        for (Form f : forms)
            f.draw();
    }

    public void contextXY(int x, int y) {
        for (Form f : forms) {
            if (Math.abs(f.x() - x) < 10 && Math.abs(f.y() - y) < 10) {
                f.createEditor().runModal();
                return;
            }
        }
        System.out.println("No form at " + x + "," + y);
    }

    public void clickXY(int x, int y) {
        if (x < 0 || x > TOOLBAR_WIDTH)
            return;
        formSelected = (int)Math.floor((float)y / TOOLBAR_WIDTH);
    }

    public void addFormToToolbar(Form f) {
        toolbar.add(f);
    }

    public Form dropXY(int x, int y) {
        if (x < TOOLBAR_WIDTH || x < 0 || y < 0 || x >= WINDOW_WIDTH || y >= WINDOW_HEIGHT)
            return null;
        if (formSelected < 0 || formSelected >= toolbar.size())
            return null;
        Form f = toolbar.get(formSelected).clone();
        f.set(x, y);
        forms.add(f);
        return f;
    }

    
    public static void main(String[] args) {
        SystemDraw canvasGL = new SystemDraw();
        canvasGL.addFormToToolbar(new CircleGL(0, 0));
        canvasGL.addFormToToolbar(new RectangleGL(0, 0, 10, 10));
        FormComposite group = new FormComposite();
        group.add(new TriangleGL(40, 40));
        group.add(new RectangleGL(40, 100, 10, 10));
        canvasGL.addFormToToolbar(group);

        canvasGL.clickXY(10, 134);
        Form f = canvasGL.dropXY(80, 70);
        if (f != null) {
            f.setColor(1024);
        }
        canvasGL.draw();
        canvasGL.contextXY(80, 70);
        canvasGL.draw();
    }
}
