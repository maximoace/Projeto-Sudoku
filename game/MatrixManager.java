package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixManager {

    public int[][] createValidGrid(int[][] grid){
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                List<Integer> valid_numbers = new ArrayList<Integer>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7); add(8);add(9);}};

                removeInvalid(getColumn(grid, column), valid_numbers);
                removeInvalid(getRow(grid, row), valid_numbers);
                removeInvalid(getQuadrant(grid, row, column), valid_numbers);

                int number = getRandomElement(valid_numbers);
                if(number!=0){
                    grid[row][column] = number;
                }
            }
        }
        return grid;
    }
    
    //Seleciona um índice aleatório e obtém o item da lista do índice 
    public int getRandomElement(List<Integer> list) {
        Random rand = new Random();
        if(!list.isEmpty()) {
            return list.get(rand.nextInt(list.size()));
        }
        return 0;
    }

    //Recebe o índice da coluna e itera as linhas para obter todos os valores
    //da coluna
    public List<Integer> getColumn(int[][] grid, int column_index) {
        List<Integer> column = new ArrayList<Integer>();
        for(int row = 0; row < grid.length; row++) {
            column.add(grid[row][column_index]);
        }
        return column;
    }

    public List<Integer> getRow(int[][] grid, int row_index) {
        List<Integer> row = new ArrayList<Integer>();

        for (int column = 0; column < grid[row_index].length; column ++) {
            row.add(grid[row_index][column]);
        }
        return row;
    }

    public List<Integer> getQuadrant(int[][] grid, int row_index, int column_index) {
        List<Integer> quadrant = new ArrayList<Integer>();
        int first_row_index = firstQuadrantIndex(row_index);
        int first_column_index = firstQuadrantIndex(column_index);

        for (int row = first_row_index; row <= first_row_index + 2; row++) {
            for (int column = first_column_index; column <= first_column_index + 2; column++) {
                quadrant.add(grid[row][column]);
            }
        }
        return quadrant;
    }

    public int firstQuadrantIndex(int index) {
        int first_index = -1;

        if (index%3 == 2) {
            first_index = index -2;
        }else if (index%3 == 1) {
            first_index = index -1;
        }else if (index == 0 || index%3 == 0) {
            first_index = index;
        }
        return first_index;
    }

    public void removeInvalid(List<Integer> grid_items, List<Integer> valid_numbers) {
        for (Integer item : grid_items) {
            valid_numbers.remove(item);
        }
    }
}
