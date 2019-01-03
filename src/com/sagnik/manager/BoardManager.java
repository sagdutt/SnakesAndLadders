package com.sagnik.manager;

import com.sagnik.model.*;

import java.util.Random;

public class BoardManager {

    private Board board;

    public BoardManager(int rows, int columns, int snakes, int ladders){
        board = new Board(rows, columns);

        Random random = new Random();

        //Adding snakes to the board
        while(snakes-- > 0){
            int snakeLength =  random.nextInt(5);
            int tailCellIdx = random.nextInt(board.getCells().size()-snakeLength-1);
            //Overflow check
            if(tailCellIdx+snakeLength > board.getCells().size()-1){
                int diff = tailCellIdx+snakeLength - (board.getCells().size()-1);
                tailCellIdx -= diff;
            }
            Cell tailCell = board.getCells().get(tailCellIdx);
            Snake snake = new Snake(snakes, tailCell);
            while(snakeLength-- >= 0){
                Cell cell = board.getCells().get(tailCellIdx+snakeLength);
                cell.setSnake(snake);
            }
        }

        //Adding ladders to the board
        while (ladders-- > 0){
            int ladderLength =  random.nextInt(5);
            int topCellIdx = random.nextInt(board.getCells().size()-ladderLength-1);
            int ladderBottom = topCellIdx - ladderLength;
            //underflow check
            if(ladderBottom < 0){
                topCellIdx += Math.abs(ladderBottom);
            }
            Cell topCell = board.getCells().get(topCellIdx);
            Ladder ladder = new Ladder(ladders, topCell);
            for(int i = topCellIdx - ladderLength; i<=topCellIdx; i++){
                Cell cell = board.getCells().get(i);
                cell.setLadder(ladder);
            }
        }
    }

    public boolean hasSnake(int cellIndex){
        return board.getCells().get(cellIndex).getSnake() != null;
    }

    public int getSnakeTail(int cellIndex){
        Cell tailCell = board.getCells().get(cellIndex).getSnake().getTailCell();
        return board.getCells().indexOf(tailCell);
    }

    public boolean hasLadder(int cellIndex){
        return board.getCells().get(cellIndex).getLadder() != null;
    }

    public int getLadderTop(int cellIndex){
        Cell topCell = board.getCells().get(cellIndex).getLadder().getTopCell();
        return board.getCells().indexOf(topCell);
    }

    public boolean isFinalCell(int cellIndex){
        if(cellIndex >= board.getCells().size()-1)
            return true;
        return false;
    }

    public int getFinalCellIndex(){
        return board.getCells().size()-1;
    }

    public Cell getCell(int cellIndex){
        return cellIndex <= board.getCells().size()-1 ? board.getCells().get(cellIndex) : board.getCells().get(board.getCells().size()-1);
    }
}
