package gameoflife.control;

import gameoflife.model.Matrix;
import gameoflife.ui.MatrixViewer;
import gameoflife.ui.SwingMatrixDialog;

public class Control {

    Matrix matrix;
    MatrixViewer viewer;

    public Control(Matrix matrix, MatrixViewer viewer) {
        this.matrix = matrix;
        this.viewer = viewer;
    }

    public void execute() {
        SwingMatrixDialog dialog= new SwingMatrixDialog();
        dialog.show();
        while (true) {
            viewer.show(matrix);
        }
    }
}
