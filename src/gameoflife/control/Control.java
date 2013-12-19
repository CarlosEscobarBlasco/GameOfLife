package gameoflife.control;

import gameoflife.model.Matrix;
import gameoflife.ui.MatrixViewer;

public class Control {

    Matrix matrix;
    MatrixViewer viewer;

    public Control(Matrix matrix, MatrixViewer viewer) {
        this.matrix = matrix;
        this.viewer = viewer;
    }

    public void execute() {
        while (true) {
            viewer.show(matrix);
        }
    }
}
