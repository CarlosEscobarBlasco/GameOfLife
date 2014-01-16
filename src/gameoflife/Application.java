package gameoflife;

import gameoflife.control.Control;
import gameoflife.model.Matrix;
import gameoflife.model.Cell;
import gameoflife.persistance.MatrixLoader;
import gameoflife.ui.Console.ConsoleMatrixDialog;
import gameoflife.ui.Console.ConsoleMatrixViewer;
import gameoflife.ui.MatrixDialog;
import gameoflife.ui.MatrixViewer;
import gameoflife.ui.Swing.SwingMatrixDialog;
import gameoflife.ui.Swing.SwingMatrixViewer;

public class Application {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(new Cell[35][40]);
        MatrixLoader.loadRandom(matrix);
        swing(matrix);
        //console(matrix);
    }
    
    public static void swing(Matrix matrix){
        MatrixViewer viewer = new SwingMatrixViewer(matrix);
        MatrixDialog dialog= new SwingMatrixDialog();
        Control control = new Control(matrix, viewer, dialog);
        control.execute();
    }

    private static void console(Matrix matrix) {
        MatrixViewer viewer = new ConsoleMatrixViewer(matrix);
        MatrixDialog dialog= new ConsoleMatrixDialog();
        Control control = new Control(matrix, viewer, dialog);
        control.execute();
    }
}
