package lesson_13.console;

import lesson_13.Board;
import lesson_13.Cell;
import lesson_13.GeneratorBoard;
import lesson_13.UserAction;
import lesson_13.logics.*;

public class BaseActions implements UserAction {
    private final GeneratorBoard generatorBoard;
    private final Board board;
    private final SaperLogic logic;

    public BaseActions(SaperLogic logic, Board board, GeneratorBoard generatorBoard) {
        this.generatorBoard = generatorBoard;
        this.board = board;
        this.logic = logic;
    }

    @Override
    public void initGame() {
        final Cell[][] cells = generatorBoard.generate();
        this.board.drawBoard(cells);
        this.logic.LoadBoard(cells);
    }

    /*
    Действия пользователя
     */
    @Override
    public void select(int x, int y, boolean bomb) {
        this.logic.suggest(x, y, bomb);
        board.drawCell(x, y);
        if (this.logic.shouldBang(x, y)) {
            this.board.drawBang();
        }
        if (this.logic.finish()) {
            board.drawCongratulate();
        }
    }
}
