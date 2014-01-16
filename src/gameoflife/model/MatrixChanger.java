package gameoflife.model;

public class MatrixChanger {

    public static void change(Matrix matrix) {
        changeNextState(matrix);
        refresh(matrix);
    }

    private static void changeNextState(Matrix matrix) {
        for (int i = 0; i < matrix.high(); i++) {
            for (int j = 0; j < matrix.width(); j++) {
                matrix.getCell(i, j).setNextState(matrix.shouldBeAlive(i, j) ? true : false);
            }
        }
    }

    private static void refresh(Matrix matrix) {
        for (int i = 0; i < matrix.high(); i++) {
            for (int j = 0; j < matrix.width(); j++) {
                matrix.getCell(i, j).setPreviusState(matrix.getCell(i, j).isAlive() && matrix.getCell(i, j).isNextState() == false ? true : false);
                matrix.getCell(i, j).setAlive(matrix.getCell(i, j).isNextState() ? true : false);
            }
        }
    }
}
