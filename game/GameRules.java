package game;

/**
 * GameRules
 */
public class GameRules {
    /** 
     * Nessa classe que deve ficar as regras de jogo
     * Se necessário, pode se criar outra classe só para lidar com os inputs
     */

    static final int CELLS = 81;
    static final int HARD = CELLS-10;
    static final int MEDIUM = CELLS-20;
    static final int EASY = CELLS-25;
    private int difficulty;

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
    }

    public int getDificulty() {
        return this.difficulty;
    }

    public void startGame() {
        
    }
}