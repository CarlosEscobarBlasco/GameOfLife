package gameoflife.model;

public class Cell {

    private boolean alive;
    private boolean nextState;

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

    @Override
    public String toString() {
        return alive ? "[#]" : "[ ]";
    }
}
