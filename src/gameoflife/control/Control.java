package gameoflife.control;

import gameoflife.model.Matrix;
import gameoflife.ui.MatrixDialog;
import gameoflife.ui.MatrixViewer;

public class Control {

    Matrix matrix;
    MatrixViewer viewer;
    MatrixDialog dialog;

    public Control(Matrix matrix, MatrixViewer viewer, MatrixDialog dialog) {
        this.matrix = matrix;
        this.viewer = viewer;
        this.dialog = dialog;
    }

    public void execute() {
        dialog.show();
        while (true) {
            viewer.show(matrix);
        }
    }
}
