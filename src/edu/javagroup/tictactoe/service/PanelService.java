package edu.javagroup.tictactoe.service;

import edu.javagroup.tictactoe.constant.Constants;
import edu.javagroup.tictactoe.model.Panel;
import edu.javagroup.tictactoe.model.Step;


public record PanelService(Panel panel) {

    private void setPoint(Step step) {
        char[][] grid = panel.getPanels();
        if (grid[step.vertical()][step.horizontal()] == Constants.EMPTY_POINT) {
            grid[step.vertical()][step.horizontal()] = step.symbol();
        }
    }

    boolean isEmptyPoint(int coordinateVertical, int coordinateHorizontal) {
        char[][] grid = panel.getPanels();
        if (grid[coordinateVertical][coordinateHorizontal] == Constants.EMPTY_POINT) {
            return true;
        } else {
            return false;
        }
    }

    boolean isComplete() {
        char[][] grid = panel.getPanels();
        int count = 0;
        return true;
    }
}



