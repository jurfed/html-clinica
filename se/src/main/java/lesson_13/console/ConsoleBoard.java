package lesson_13.console;

import lesson_13.Board;
import lesson_13.Cell;

/**
 * реализация доски
 */
public class ConsoleBoard implements Board {

    /**
     * поле, кот содержит нашу карту
     */
    private Cell[][] cells;

    @Override
    public void drawBoard(Cell[][] cells) {
        this.cells = cells;
        this.redraw(false);
    }

    @Override
    public void drawCell(int x, int y) {
        System.out.println("******** SELECT **********");
        this.redraw(false);
    }

    @Override
    public void drawBang() {
        System.out.println("************ BANG *************");
        this.redraw(true);
    }

    @Override
    public void drawCongratulate() {
        System.out.println("******** CONGRATULATION ******************");
    }

    /**
     * вспомогательный метод, кот рисует нашу ячейку
     * @param real
     */
    private void redraw(boolean real) {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.draw(System.out, real);
            }
            System.out.println();
        }
        System.out.println();
    }
}
