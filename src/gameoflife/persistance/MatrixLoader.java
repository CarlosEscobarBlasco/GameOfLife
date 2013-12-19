package gameoflife.persistance;

import gameoflife.model.Matrix;

public class MatrixLoader {

    public static Matrix loadRandom(Matrix matrix) {
        for (int i = 0; i < matrix.high(); i++) {
            for (int j = 0; j < matrix.width(); j++) {
                matrix.setCell(i, j, (Math.random() < 0.5 ? true : false));
            }
        }
        return matrix;
    }

    public static Matrix loadZigZag(Matrix matrix) {
        for (int i = 0; i < matrix.high(); i++) {
            for (int j = 0; j < matrix.width(); j++) {
                matrix.setCell(i, j, (j + i) % 2 == 0 ? true : false);
            }
        }
        return matrix;
    }

    public static Matrix loadGlider(Matrix matrix) {
        matrix.setCell(matrix.high() - 1, matrix.width() - 2, true);
        matrix.setCell(matrix.high() - 2, matrix.width() - 3, true);
        matrix.setCell(matrix.high() - 3, matrix.width() - 3, true);
        matrix.setCell(matrix.high() - 3, matrix.width() - 2, true);
        matrix.setCell(matrix.high() - 3, matrix.width() - 1, true);
        return matrix;
    }

    public static Matrix loadBlock(Matrix matrix) {
        MatrixLoader.loadBlank(matrix);
        matrix.setCell(0, 0, true);
        matrix.setCell(0, 1, true);
        matrix.setCell(1, 0, true);
        matrix.setCell(1, 1, true);
        return matrix;
    }

    public static Matrix loadBlank(Matrix matrix) {
        for (int i = 0; i < matrix.high(); i++) {
            for (int j = 0; j < matrix.width(); j++) {
                matrix.setCell(i, j, false);
            }
        }
        return matrix;
    }
}
