package lesson_13;

import lesson_13.console.BaseActions;
import lesson_13.console.ConsoleBoard;
import lesson_13.console.ConsoleCell;
import lesson_13.logics.Easy;
import org.junit.Test;

public class BaseActionTest {
    final BaseActions actions = new BaseActions(new Easy(), new ConsoleBoard(), new GeneratorBoard() {
        @Override
        public Cell[][] generate() {
            return new Cell[][]{
                    {new ConsoleCell(true), new ConsoleCell(false)},
                    {new ConsoleCell(true), new ConsoleCell(false)}
            };
        }
    });

    @Test
    public void sucessGame(){
        actions.initGame();
        actions.select(0,0,true);
        actions.select(1,0,true);
        actions.select(0,1,false);
        actions.select(1,1,false);
    }

    @Test
    public void failureGame(){
        actions.initGame();
        actions.select(0,0,true);
        actions.select(1,0,false);

    }
}
