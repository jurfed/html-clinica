package lesson_13.gui;

import lesson_13.Board;
import lesson_13.GeneratorBoard;
import lesson_13.console.BaseActions;
import lesson_13.logics.SaperLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUIAction extends BaseActions implements ActionListener, MouseListener {
    private GUIBoard board;
    private SaperLogic logic;

    public GUIAction(SaperLogic logic, GUIBoard board, GeneratorBoard generatorBoard) {
        super(logic, board, generatorBoard);
        this.board = board;
        this.board.addMouseListener(this);
        this.logic = logic;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.initGame();
    }

    /**
     * ПОльзователь нажал на ячейку
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / 50;
        int y = e.getY() / 50;
        boolean suggestBomb = false;

        switch (e.getButton()) {
            case 1:
                suggestBomb = true;
                break;
            case 3:
                suggestBomb = false;
                break;
        }

        logic.suggest(x,y,suggestBomb);
        board.drawCell(x,y);

        if (this.logic.shouldBang(x, y)) {
            this.board.drawBang();
        }
        if (this.logic.finish()) {
            board.drawCongratulate();
        }
        board.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
