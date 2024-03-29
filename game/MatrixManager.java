package game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MatrixManager {

    int[] grid[];
    int sqrt;

    public int[][] createValidGrid(int delete_count) {
        this.grid = new int[9][9];
        Double sqrtd = Math.sqrt(this.grid.length);
        this.sqrt = sqrtd.intValue();

        fillDiagonal();
        fillRemaining();
        removeValues(delete_count);

        return this.grid;
    }

    //Preenche os quadrantes diagonais da matriz
    public void fillDiagonal() {
        for (int i=0; i<this.grid.length; i=i+sqrt) {
            fillCoreQuadrant(i, i);
        }
    }

    //Preenche todos os quadrantes não diagonais da matrizs
    public void fillRemaining() {
        for (int row=0; row<this.grid.length; row=row+sqrt) {
            for (int column=0; column<this.grid[row].length; column=column+sqrt) {
                if (row == column) {
                    continue;
                }
                fillQuadrant(row, column);
            }
        }
    }

    //Preenche o quadrante diagonal especificado com valores aleatórios
    public void fillCoreQuadrant(int row, int column) {
        for (int i = row; i < row + this.sqrt; i++) {
            for (int j = column; j < column + this.sqrt; j++) {
                List<Integer> valid_numbers = this.getNumbers();
                removeInvalid(getQuadrant(this.grid, row, column), valid_numbers);
                removeInvalid(getRow(grid, i), valid_numbers);
                removeInvalid(getColumn(grid, j), valid_numbers);

                this.grid[i][j] = getRandomElement(valid_numbers);

            }
        }
    }

    public void fillQuadrant(int row, int column) {
        for (int i = row; i < row + this.sqrt; i++) {
            for (int j = column; j < column + this.sqrt; j++) {
                List<Integer> valid_numbers = this.getNumbers();
                removeInvalid(getQuadrant(this.grid, row, column), valid_numbers);
                removeInvalid(getRow(grid, i), valid_numbers);
                removeInvalid(getColumn(grid, j), valid_numbers);

                if (valid_numbers.isEmpty()) {
                    this.grid[i][j] = 0;
                } else {
                    this.grid[i][j] = valid_numbers.get(0);
                }
                

            }
        }
    }
    
    //Seleciona um índice aleatório e obtém o item da lista apartir dele
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

    //Recebe o índice da linha e itera as colunas para obter todos os valores
    //da linha
    public List<Integer> getRow(int[][] grid, int row_index) {
        List<Integer> row = new ArrayList<Integer>();

        for (int column = 0; column < grid[row_index].length; column ++) {
            row.add(grid[row_index][column]);
        }
        return row;
    }

    //Obtém todos os valores já existentes no quadrante
    public List<Integer> getQuadrant(int[][] grid, int row, int column) {
        List<Integer> quadrant = new ArrayList<Integer>();

        for (int i = row; i < row + this.sqrt; i++) {
            for (int j = column; j < column + this.sqrt ; j++) {
                if (grid[i][j] != 0){
                quadrant.add(grid[i][j]);
                }
            }
        }
        return quadrant;
    }

    //Remove da lista de números válidos valores já utilizados
    public void removeInvalid(List<Integer> grid_items, List<Integer> valid_numbers) {
        for (Integer item : grid_items) {
            valid_numbers.remove(item);
        }
    }

    //Cria uma lista com valores de 1 a 9
    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i=1; i < 10; i++)  {
            numbers.add(i);
        }
        return numbers;
    }

    //Cria uma lista com os índices da grade
    public List<Integer> getIndex() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i=0; i < this.grid.length; i++)  {
            numbers.add(i);
        }
        return numbers;
    }

    //Remove uma determinada quantidade de valores da grade
    public void removeValues(int delete_count) {
        while(getEmpty() < delete_count) {
            int x = this.getRandomElement(getIndex());
            int y = this.getRandomElement(getIndex());
            this.grid[x][y] = 0;
        };
    }

    //Retorna a quantidade de casas com valor 0
    public int getEmpty() {
        int count = 0;
        for (int row = 0; row < this.grid.length; row++) {
            for (int column = 0; column < this.grid[row].length; column ++) {
                if (grid[row][column] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isFilled() {
        for (int row=0; row<this.grid.length; row++) {
            for (int column=0; column<this.grid.length; column++) {
                if (this.grid[row][column] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid() {
        for (int row=0; row<this.grid.length; row++) {
            if (hasDuplicate(getRow(grid, row)))
                return false;
        }
        for (int column=0; column<this.grid[0].length; column++) {
            if (hasDuplicate(getColumn(grid, column)))
                return false;
        }
        for (int row=0; row<this.grid.length; row=row+sqrt) {
            for (int column=0; column<this.grid[row].length; column=column+sqrt) {
                if (hasDuplicate(getQuadrant(this.grid, row, column)))
                    return false;
            }
        }
        return true;
    }

    public boolean hasDuplicate(List<Integer> list) {
        Set<Integer> filter = new HashSet<Integer>(list);
        if(filter.size() < list.size()){
            return true;
        }
        return false;
    }
}
