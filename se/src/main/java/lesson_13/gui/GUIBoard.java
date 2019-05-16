package lesson_13.gui;

import lesson_13.Board;
import lesson_13.Cell;

import javax.swing.*;
import java.awt.*;

public class GUIBoard extends JPanel implements Board {

    public static final int PADDING = 50;

    public Cell<Graphics>[][] cells;

    boolean drawCell = false;

    boolean bang = false;
    boolean congratulation = false;

    int cellX = 0;
    int cellY = 0;


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Font font = new Font("Serif", Font.BOLD, 30);
        graphics.setFont(font);

        if (this.cells != null) {
            for (int x = 0; x != cells.length; x++) {
                for (int y = 0; y != cells[0].length; y++) {
                    graphics.setColor(Color.BLACK);
                    cells[x][y].draw(graphics, bang);
                    font = new Font("Serif", Font.BOLD, 10);
                    if (bang) {//реальное значение
                        if (cells[x][y].isBomb()) {
                            graphics.fillRect(x * PADDING, y * PADDING, PADDING, PADDING);
                            font = new Font("Serif", Font.BOLD, 40);
                            graphics.setColor(Color.RED);
                            graphics.setFont(font);
                            graphics.drawString("*", x * PADDING + PADDING / 2, y * PADDING + PADDING / 2);
                            graphics.drawString("YOU LOOSE", 50, 200);
//                paint. print("[*] ");
                        } else {
                            graphics.setColor(Color.BLACK);
                            graphics.drawRect(x * PADDING, y * PADDING, PADDING, PADDING);
                            graphics.setColor(Color.BLACK);
                            graphics.setFont(font);
                            graphics.drawString("[ ]", x * PADDING + PADDING / 2, y * PADDING + PADDING / 2);
//                paint.print("[ ] ");
                        }
                    } else {//предположение пользователя
                        if (cells[x][y].isSuggestBomb()) {
                            graphics.setColor(Color.RED);
                            graphics.fillRect(x * PADDING, y * PADDING, PADDING, PADDING);
                            graphics.setColor(Color.BLACK);
                            graphics.setFont(font);
                            graphics.drawString("?", x * PADDING +PADDING/2, y * PADDING + PADDING/2);
//                paint.print("[?] ");
                        } else if (cells[x][y].isSuggestEmpty()) {
                            graphics.setColor(Color.GREEN);
                            graphics.fillRect(x * PADDING, y * PADDING, PADDING, PADDING);
                            graphics.setColor(Color.BLACK);
                            graphics.setFont(font);
                            graphics.drawString(" [ ]", x * PADDING+PADDING/2, y * PADDING + PADDING/2);
//                paint.print("[ ] ");
                        } else {
                            graphics.setColor(Color.BLACK);
                            graphics.drawRect(x * PADDING, y * PADDING, PADDING, PADDING);
                            graphics.setFont(font);
                            graphics.setColor(Color.BLACK);
                            graphics.drawString("[X]", x * PADDING+PADDING/2, y * PADDING + PADDING/2);
//                paint.print("[X] ");//если ничего еще не предположил
                        }
                    }

                }
            }


            if (congratulation) {
                font = new Font("Serif", Font.BOLD, 30);
                graphics.setFont(font);
                graphics.drawString("CONGRATULATION!!!!!!!", 50, 200);
            }

        }
    }


    @Override
    public void drawBoard(Cell[][] cells) {
        congratulation = false;
        this.cells = cells;
        bang = false;
        this.repaint();
    }

    @Override
    public void drawCell(int x, int y) {
        bang = false;
        drawCell = true;
        cellX = x;
        cellY = y;

        this.repaint();
    }

    @Override
    public void drawBang() {
        bang = true;
        congratulation=false;
        this.repaint();
    }

    @Override
    public void drawCongratulate() {
        congratulation = true;
        this.repaint();
    }
}
