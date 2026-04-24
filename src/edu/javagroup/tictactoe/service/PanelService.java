package edu.javagroup.tictactoe.service;

import edu.javagroup.tictactoe.model.Panel;
import edu.javagroup.tictactoe.model.Step;
import edu.javagroup.tictactoe.constant.Constants;


public record PanelService(Panel panel) {

    private void setPoint(Step step) {
        char[][] grid = panel.getPanels();
        if (grid[step.vertical()][step.horizontal()] == Constants.EMPTY_POINT) {
            grid[step.vertical()][step.horizontal()] = step.symbol();
        }
    }
}

