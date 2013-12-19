package gameoflife;

import gameoflife.control.Control;
import gameoflife.model.Matrix;
import gameoflife.model.Cell;
import gameoflife.persistance.MatrixLoader;
import gameoflife.ui.MatrixViewer;
import gameoflife.ui.SwingMatrixViewer;

public class GameOfLife {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(new Cell[35][40]);
        matrix = MatrixLoader.loadRandom(matrix);
        MatrixViewer viewer = new SwingMatrixViewer(matrix);
        Control control = new Control(matrix, viewer);
        control.execute();
    }
}
