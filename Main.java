import java.util.Scanner;

import game.*;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        /* 
         * Esta é a classe main, que vai iniciar o jogo,
         * deve estar o mais limpo possível
         */

        Scanner scn = new Scanner(System.in);
        int difficulty = 0;
        do {
            System.out.println("Escolha o nível de dificuldade:\n 1 - Difícil\n 2 - Médio\n 3 - Fácil");
            difficulty = scn.nextInt();
            if(difficulty == 1 || difficulty == 2 || difficulty == 3) {
            }else {
                System.out.println("Escolha um valor válido.");
                difficulty = 0;
            }
        } while (difficulty == 0);
        scn.close();
        GameRules rules = new GameRules(difficulty);
        MatrixManager manager = new MatrixManager();
        rules.startGame(manager);
    }
}