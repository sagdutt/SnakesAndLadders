package com.sagnik.model;

public class Ladder {

    private Integer id;
    private Cell topCell;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cell getTopCell() {
        return topCell;
    }

    public void setTopCell(Cell topCell) {
        this.topCell = topCell;
    }

    public Ladder(Integer id, Cell topCell) {
        this.id = id;
        this.topCell = topCell;
    }
}
