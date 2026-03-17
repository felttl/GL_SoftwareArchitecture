package com.example;

class ReadOnlyFormProxy implements Form {
    private Form form;

    public ReadOnlyFormProxy(Form form) {
        this.form = form;
    }

    @Override
    public void draw() {
        form.draw();
    }

    @Override
    public Form setColor(int color) {
        throw new UnsupportedOperationException("ReadOnlyFormProxy cannot be modified");
    }

    @Override
    public Form set(int x, int y) {
        throw new UnsupportedOperationException("ReadOnlyForm cannot be modified");
    }

    @Override
    public int x() {
        return form.x();
    }

    @Override
    public int y() {
        return form.y();
    }

    @Override
    public int getColor() {
        return form.getColor();
    }

    @Override
    public Form clone() {
        return new ReadOnlyFormProxy(form.clone());
    }

    @Override
    public FormEditor createEditor() {
        throw new UnsupportedOperationException("ReadOnlyForm cannot be edited");
    }
}
