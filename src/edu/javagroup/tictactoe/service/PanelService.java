package edu.javagroup.tictactoe.service;

import edu.javagroup.tictactoe.constant.Constants;
import edu.javagroup.tictactoe.model.Panel;
import edu.javagroup.tictactoe.model.Step;


public record PanelService(Panel panel) {

    public void setPoint(Step step) {
        char[][] grid = panel.getPanels();
        if (grid[step.vertical()][step.horizontal()] == Constants.EMPTY_POINT) {
            grid[step.vertical()][step.horizontal()] = step.symbol();
        }
    }

    public boolean isEmptyPoint(int coordinateVertical, int coordinateHorizontal) {
        char[][] grid = panel.getPanels();
        if (grid[coordinateVertical][coordinateHorizontal] == Constants.EMPTY_POINT) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isComplete() {
        if (countMarked() == 9) {
            return true;
        }
        return false;
    }

    public int countMarked() {
        char[][] grid = panel.getPanels();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != Constants.EMPTY_POINT) {
                    count++;
                }
            }
        }
        return count;
    }

    public int checkByVertical(int numberVertical, char symbol) {
        char[][] grid = panel.getPanels();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][numberVertical] == (symbol)) {
                count++;
            }
        }
        return count;
    }

    public int checkByHorizontal(int numberHorizontal, char symbol) {
        char[][] grid = panel.getPanels();
        int count = 0;
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[numberHorizontal][i] == (symbol)) {
                count++;
            }
        }
        return count;
    }

    public int checkByDiagonalLin(char symbol) {
        char[][] grid = panel.getPanels();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid.length - 1 - i] == (symbol)) {
                count++;
            }
        }
        return count;

    }


    public int checkByDiagonalWin(char symbol) {
        char[][] grid = panel.getPanels();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] == (symbol)) {
                count++;
            }
        }
        return count;

    }
}










