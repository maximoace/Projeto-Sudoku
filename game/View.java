package game;

import java.util.ArrayList;
import java.util.List;

import utils.ConsoleColors;

public class View {
    private int[] initial_grid[];

    public View(int[] initial_grid[]) {
        this.initial_grid = initial_grid;
    }

    public void printGrid(int[] grid[]) {
        String print = "";
        String line = "";
        String separator = "";
        List<String> list = new ArrayList<String>();

        List<String> size_list = new ArrayList<String>();
        String size_line = "";

        for (int row=0; row < grid.length; row++) {
            size_list.clear();
            list.clear();
            for(int column=0; column < grid[row].length; column++) {
                size_list.add(Integer.toString(grid[row][column]));
                list.add(formatCell(grid, row, column));
            }
            line = "";
            line = "| " + String.join(" | ", list) + " |\n";
            if (row == 0) {
                size_line = "| " + String.join(" | ", size_list) + " |\n";
                separator = verticalLine(size_line.length()) + "\n";
                print += separator;
            }
            print += line;
            print += separator;

        }

        System.out.println(print);
    }

    public String verticalLine(int size) {
        String separator = "";
        for(int i=1;i<size;i++) {
            separator += "-";
        }
        return separator;
    }

    public String formatCell(int[] grid[], int row, int column) {
        if (grid[row][column] == 0) {
            return " ";
        } else if (grid[row][column] == this.initial_grid[row][column]) {
            return ConsoleColors.BLUE + Integer.toString(grid[row][column]) + ConsoleColors.RESET;
        } else {
            return Integer.toString(grid[row][column]);
        }
    }
}
