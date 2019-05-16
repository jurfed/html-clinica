package calculator;

public class Calculator {
    /**
     * результат вычислений
     */
    private double result;

    public void add(final double... params) {
        for (Double param : params) {
            this.result += param;
        }
    }

    /**
     * @param params аргументы для вычитания из результата
     */
    public void minus(final double... params) {

        for (Double param : params) {
            this.result -= param;
        }
    }

    public void multiply(final double... params) {

        this.result += params[0] * params[1];

    }

    /**
     * Вычисляем деление
     * @param params взодящие авргументы
     * @throws UserException Если аргумента нет, то выкидываем исключение
     */
    public void divide(final double... params) throws UserException {
        if (params.length >1) {
            if(params[1]==0){
                throw new IllegalArgumentException("you try to div by 0");
            }
            this.result += params[0] / params[1];
        } else {
            throw new UserException("please enter 2 arguments");
        }


    }

    public void stepen(final double... params) {

        this.result += Math.pow(params[0], params[1]);

    }

    public double getResult() {
        return this.result;
    }


    public void cleanResult() {
        this.result = 0;
    }

}