package com.sagnik.model;

public class Snake {

    private Integer id;
    private Cell tailCell;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cell getTailCell() {
        return tailCell;
    }

    public void setTailCell(Cell tailCell) {
        this.tailCell = tailCell;
    }

    public Snake(Integer id, Cell tailCell) {
        this.id = id;
        this.tailCell = tailCell;
    }
}
