package lesson_13.gui;

import lesson_13.Cell;

import java.awt.*;

public class GUICell implements Cell<Graphics> {
    private boolean bomb;
    private boolean suggestBomd = false;
    private boolean suggestEmpty = false;

    public GUICell(boolean bomb) {
        this.bomb = bomb;
    }

    @Override
    public boolean isBomb() {
        return bomb;
    }

    @Override
    public boolean isSuggestBomb() {
        return suggestBomd;
    }

    @Override
    public boolean isSuggestEmpty() {
        return suggestEmpty;
    }

    @Override
    public void suggestEmpty() {
        suggestEmpty = true;
        suggestBomd = false;
    }

    @Override
    public void suggestBomb() {
        suggestBomd = true;
        suggestEmpty = false;
    }

    @Override
    public void draw(Graphics paint, boolean real) {

    }
}
