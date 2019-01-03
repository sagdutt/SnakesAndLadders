package com.sagnik.model;

public class Player {

    private int id;
    private int currentCell;
    private Integer initialRoll;

    public Player(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(int currentCell) {
        this.currentCell = currentCell;
    }

    public Integer getInitialRoll() {
        return initialRoll;
    }

    public void setInitialRoll(Integer initialRoll) {
        this.initialRoll = initialRoll;
    }
}
