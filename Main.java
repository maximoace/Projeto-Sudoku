import java.util.Arrays;

import game.*;
/**
 * Main
 */
public class Main {

    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)
 
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

    public static void main(String[] args) {
        /* 
         * Esta é a classe main, que vai iniciar o jogo,
         * deve estar o mais limpo possível
         */
        int[][] grid = new int[9][9];
        MatrixManager manager = new MatrixManager();
        manager.createValidGrid(grid);
        print2D(grid);

    }
}