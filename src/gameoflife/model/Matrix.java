

package gameoflife.model;


public class Matrix {

    Cell[][] matrix;
    
    public Matrix(Cell[][] matrix) {
        this.matrix=matrix;
    }
        
    private int countNeighbors(int i, int j){
        int count=0;
        if(i==0){
            if (j==0){  //esquina superior izq
                if(isRightAlive( i, j)) count++;
                if(isBotAlive( i, j)) count++;
                if(isBotRightAlive(i, j)) count++;  
            }else if(j==matrix[0].length-1){  //esquina superior derecha
                if(isLeftAlive(i, j)) count++;
                if(isBotAlive(i, j)) count++;
                if(isBotLeftAlive(i, j)) count++;
            }else{  //superior
                if(isLeftAlive(i, j)) count++;
                if(isRightAlive(i, j)) count++;
                if(isBotAlive( i, j)) count++;
                if(isBotRightAlive(i, j)) count++;
                if(isBotLeftAlive(i, j)) count++;
            }
        }else if(i==matrix.length-1){
            if (j==0){  //esquina inferior izq
                if(isRightAlive(i, j)) count++;
                if(isTopAlive(i, j)) count++;
                if(isTopRightAlive(i, j)) count++;
            }else if(j==matrix[0].length-1){  //esquina inferior der
                if(isLeftAlive(i, j)) count++;
                if(isTopAlive(i, j)) count++;
                if(isTopLeftAlive(i, j)) count++;
            }else{  //abajo
                if(isTopLeftAlive(i, j)) count++;
                if(isTopAlive(i, j)) count++;
                if(isTopRightAlive(i, j)) count++;
                if(isLeftAlive(i, j)) count++;
                if(isRightAlive(i, j)) count++;
            }

        }else if(j==0){ //columna izq
            if(isTopAlive(i, j)) count++;
            if(isTopRightAlive(i, j)) count++;
            if(isRightAlive(i, j)) count++;
            if(isBotAlive( i, j)) count++;
            if(isBotRightAlive(i, j)) count++;
        }else if(j==matrix[0].length-1){ //columna der
            if(isTopAlive(i, j)) count++;
            if(isTopLeftAlive(i, j)) count++;
            if(isLeftAlive(i, j)) count++;
            if(isBotLeftAlive(i, j)) count++;
            if(isBotAlive( i, j)) count++;
        }else{ //parte central
            if(isTopLeftAlive(i, j)) count++;
            if(isTopAlive(i, j)) count++;
            if(isTopRightAlive(i, j)) count++;
            if(isLeftAlive(i, j)) count++;
            if(isRightAlive(i, j)) count++;
            if(isBotLeftAlive(i, j)) count++;
            if(isBotAlive(i, j)) count++;
            if(isBotRightAlive(i, j)) count++;
        }
        return count;
    }
    public boolean shouldBeAlive(int i, int j){
        int count = countNeighbors(i,j);
        if (count==2 && matrix[i][j].isAlive()) return true;    //Still alive
        if (count==3)return true;   //Born
        return false;
    } 
    
    private boolean isTopLeftAlive( int i, int j){
        if(matrix[i-1][j-1].isAlive()) return true;
        return false;
    }
    
    private boolean isTopAlive( int i, int j){
        if(matrix[i-1][j].isAlive()) return true;
        return false;
    }
    
    private boolean isTopRightAlive( int i, int j){
        if(matrix[i-1][j+1].isAlive()) return true;
        return false;
    }
    
    private boolean isLeftAlive(int i, int j){
        if(matrix[i][j-1].isAlive()) return true;
        return false;
    }
    
    private boolean isRightAlive( int i, int j){
        if(matrix[i][j+1].isAlive()) return true;
        return false;
    }
    
    private boolean isBotLeftAlive( int i, int j){
        if(matrix[i+1][j-1].isAlive()) return true;
        return false;
    }
    
    private boolean isBotAlive(int i, int j){
        if(matrix[i+1][j].isAlive()) return true;
        return false;
    }
    
    private boolean isBotRightAlive( int i, int j){
        if(matrix[i+1][j+1].isAlive()) return true;
        return false;
    }
    
    public int width(){
        return matrix[0].length;
    }
    
    public int high(){
        return matrix.length;
    }
    
    public Cell getCell(int i, int j){
        return matrix[i][j];
    }
    
    public void setCell (int i, int j, boolean state){
        matrix[i][j]=new Cell(state);
    }
}
