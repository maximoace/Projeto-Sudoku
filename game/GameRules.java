package game;

import java.util.Scanner;

/**
 * GameRules
 */
public class GameRules {
    /** 
     * Nessa classe que deve ficar as regras de jogo
     * Se necessário, pode se criar outra classe só para lidar com os inputs
     */

    static final int FIELDS = 81;
    static final int HARD = FIELDS-17;
    static final int MEDIUM = FIELDS-25;
    static final int EASY = FIELDS-40;
    private int difficulty;
    private Scanner scn;
    private MatrixManager manager;
    private View viewer;
    private int[] initial_grid[];
    private int[] grid[];

    public GameRules(int difficulty) {
        if (difficulty==1) {
            this.difficulty = HARD;
        }
        if (difficulty==2) {
            this.difficulty = MEDIUM;
        }
        if (difficulty==3) {
            this.difficulty = EASY;
        }
        scn = new Scanner(System.in);
    }

    public int getDificulty() {
        return this.difficulty;
    }

    public void startGame(MatrixManager manager) {
        this.manager = manager;
        this.grid = this.manager.createValidGrid(difficulty);
        saveInitialGrid();
        this.viewer = new View(initial_grid);
        

        while(!this.manager.isFilled() && !this.manager.isValid()) {
            viewer.printGrid(grid);
            getEntry();
        }
        System.out.println("Parabéns, você ganhou! Deseja jogar de novo? 1 - Sim, 2 - Não");
        if (this.scn.nextInt() == 1) {
            this.startGame(manager);
        }
    }

    //
    public void getEntry() {
        String input = "";
        boolean placed = false;

        while (!placed) {
            System.out.println("Informe a posição e o número: linha,coluna número (índice inicial: 0)");
            input = scn.nextLine();
            String[] values =  input.split(",| ");
            int row = Integer.parseInt(values[0]);
            int column = Integer.parseInt(values[1]);
            int value = Integer.parseInt(values[2]);
            if (row >= this.grid.length || column >= this.grid[row].length){
                System.out.println("Posição invalida");
                continue;
            }
            else if(this.grid[row][column] == this.initial_grid[row][column] && this.grid[row][column] != 0) {
                System.out.println("Não é possível alterar os valores gerados do tabuleiro");
                continue;
            }
            this.grid[row][column] = value;
            placed = true;
        }
        
    }

    public void saveInitialGrid() {
        this.initial_grid = new int[this.grid.length][this.grid[0].length];
        for (int row=0; row<this.grid.length; row++) {
            for(int column=0; column<this.grid.length; column++) {
                this.initial_grid[row][column] = this.grid[row][column];
            }
        }
    }

    public void closeScanner() {
        scn.close();
    }
}