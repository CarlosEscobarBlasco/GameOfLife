

package gameoflife.ui;

import gameoflife.model.MatrixChanger;
import gameoflife.model.Matrix;


public class ConsoleMatrixViewer implements MatrixViewer{
 
    public ConsoleMatrixViewer(Matrix matrix) {
    }
    
    @Override
    public void show(Matrix matrix){
        for (int n = 1; n < 20+1; n++) {
            System.out.println("\n Iteracion nº: "+n);
            ConsoleMatrixViewer.printMatrix(matrix);
            MatrixChanger.change(matrix);
        }
    }
    
    private static void printMatrix(Matrix matrix){
        for (int i = 0; i < matrix.high(); i++) {
            for (int j = 0; j < matrix.width(); j++) {
                System.out.print(matrix.getCell(i, j)+" ");
                if (j==matrix.width()-1) System.out.println("");
            }
        }
    }

}
