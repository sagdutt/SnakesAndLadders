package com.sagnik.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Cell> cells;

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public Board(int rows, int columns){
        cells = new ArrayList<>(rows*columns);
        for(int row=0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                Cell cell = new Cell(row, column);
                cells.add(cell);
            }
        }
    }
}
