package game;

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
    static final int EASY = FIELDS-30;
    private int difficulty;
    private MatrixManager manager;
    private View viewer;
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
    }

    public int getDificulty() {
        return this.difficulty;
    }

    public void startGame(MatrixManager manager) {
        this.manager = manager;
        this.grid = this.manager.createValidGrid(difficulty);
        this.viewer = new View(grid);
        viewer.printGrid(grid);
        

    }
}