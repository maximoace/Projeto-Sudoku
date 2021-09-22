import java.util.Arrays;
import java.util.Scanner;

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
        Scanner scn = new Scanner(System.in);
        int difficulty = 0;
        do {
            System.out.println("Escolha o nível de dificuldade:\n 1- Difícil\n 2- Médio\n 3- Fácil");
            difficulty = scn.nextInt();
            if(difficulty == 1 || difficulty == 2 || difficulty == 3) {
            }else {
                System.out.println("Escolha um valor válido.");
            }
        } while (difficulty == 0);
        scn.close();
        GameRules rules = new GameRules(difficulty);
        MatrixManager manager = new MatrixManager();
        int[] grid[] = manager.createValidGrid(rules.getDificulty());
        print2D(grid);
    }
}