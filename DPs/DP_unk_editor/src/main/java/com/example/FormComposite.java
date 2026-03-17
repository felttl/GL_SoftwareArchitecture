package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class FormComposite implements Form, Iterable<Form> {
    private ArrayList<Form> forms = new ArrayList<Form>();
    private Set<Form> formsSet = new HashSet<Form>();

    public FormComposite clone() {
        try {
            FormComposite g = (FormComposite) super.clone();
            g.forms = new ArrayList<Form>();
            g.formsSet = new HashSet<Form>();
            for (Form f : forms) {
                Form clonedForm = f.clone();
                g.forms.add(clonedForm);
                g.formsSet.add(clonedForm);
            }
            return g;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    FormComposite() {
    }

    public Iterator<Form> iterator() {
        return forms.iterator();
    }

    public void add(Form f) {
        if (formsSet.contains(f))
            return;
        forms.add(f);
        formsSet.add(f);
    }

    public void remove(Form f) {
        if (!formsSet.contains(f))
            return;
        forms.remove(f);
        formsSet.remove(f);
    }

    public void draw() {
        for (Form f : forms)
            f.draw();
    }

    @Override
    public Form setColor(int color) {
        for (Form f : forms)
            f.setColor(color);
        return this;
    }

    @Override
    public Form set(int x, int y) {
        int dx = x - x();
        int dy = y - y();
        for (Form f : forms) {
            f.set(f.x() + dx, f.y() + dy);
        }
        return this;
    }

    @Override
    public int x() {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (Form f : forms) {
            int fx = f.x();
            if (fx < minX)
                minX = fx;
            if (fx > maxX)
                maxX = fx;
        }
        return (minX + maxX) / 2;
    }

    @Override
    public int y() {
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (Form f : forms) {
            int fy = f.y();
            if (fy < minY)
                minY = fy;
            if (fy > maxY)
                maxY = fy;
        }
        return (minY + maxY) / 2;
    }

    @Override
    public int getColor() {
        if (forms.isEmpty()) {
            return 0;
        }
        return forms.get(0).getColor();
    }

    @Override
    public FormEditor createEditor() {
        return new GroupFormEditor(this);
    }
}
