package lesson_13.console;

import lesson_13.Cell;

import java.io.PrintStream;

public class ConsoleCell implements Cell<PrintStream> {
    private boolean bomb;
    private boolean suggestBomd = false;
    private boolean suggestEmpty = false;

    public ConsoleCell(boolean bomb) {
        this.bomb = bomb;
    }

    @Override
    public boolean isBomb() {
        return this.bomb;
    }

    @Override
    public boolean isSuggestBomb() {
        return this.suggestBomd;
    }

    @Override
    public boolean isSuggestEmpty() {
        return this.suggestEmpty;
    }

    @Override
    public void suggestEmpty() {
        this.suggestEmpty = true;
    }

    @Override
    public void suggestBomb() {
        this.suggestBomd = true;
    }

    @Override
    public void draw(PrintStream paint, boolean real) {
        if (real) {//реальное значение
            if (this.isBomb()) {
                paint.print("[*] ");
            } else {
                paint.print("[ ] ");
            }
        } else {//предположение пользователя
            if (this.suggestBomd) {
                paint.print("[?] ");
            } else if (this.suggestEmpty) {
                paint.print("[ ] ");
            } else {
                paint.print("[X] ");//если ничего еще не предположил
            }
        }
    }


}
