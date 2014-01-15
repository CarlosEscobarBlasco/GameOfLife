package gameoflife.model;

public class Cell {

    private boolean alive;
    private boolean nextState;
    private boolean previusState;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setNextState(boolean nextStat) {
        this.nextState = nextStat;
    }

    public boolean isNextState() {
        return nextState;
    }

    public boolean isPreviusState() {
        return previusState;
    }

    public void setPreviusState(boolean previusState) {
        this.previusState = previusState;
    }
    

    @Override
    public String toString() {
        if(previusState) return "[·]";
        return alive ? "[#]" : "[ ]";
    }
}
