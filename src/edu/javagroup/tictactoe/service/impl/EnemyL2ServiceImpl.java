package edu.javagroup.tictactoe.service.impl;

import edu.javagroup.tictactoe.constant.Constants;
import edu.javagroup.tictactoe.model.Panel;
import edu.javagroup.tictactoe.model.Step;
import edu.javagroup.tictactoe.service.EnemyService;
import edu.javagroup.tictactoe.service.PanelService;

public class EnemyL2ServiceImpl extends EnemyL1ServiceImpl implements EnemyService{

   public EnemyL2ServiceImpl(PanelService panelService) {
        super(panelService);
    }


    @Override
    public void setPoint() {
        if (setCenterPoint()) {
            return;
        }
        if (blockWin()) {
            super.setPoint();
        }
    }


    public boolean setCenterPoint() {
        Panel panel = getPanelService().panel();
        char[][] grid = panel.getPanels();
        int centr = grid.length / 2;
        if (grid[centr][centr] == Constants.EMPTY_POINT) {
            getPanelService().setPoint(new Step(O_SYMBOL, centr, centr));
            return true;
        }
        return false;
    }

    public boolean blockWin() {
        int number = random(1, 4);
        switch (number) {
            case 1:
                return checkVertical() && checkHorizontal() && checkDiagonalLin();
            case 2:
                return checkVertical() && checkHorizontal() && checkDiagonalWin();
            case 3:
                return checkVertical() && checkDiagonalLin() && checkDiagonalWin();
            case 4:
                return checkHorizontal() && checkDiagonalLin() && checkDiagonalWin();
            default:
                return checkVertical() && checkHorizontal() && checkDiagonalLin() && checkDiagonalWin();
        }
    }

    public boolean checkVertical() {
        return checkVertical(O_SYMBOL, X_SYMBOL);
    }

    public boolean checkVertical(char symbolO, char symbolX) {
        Panel panel = getPanelService().panel();
        char[][] grid = panel.getPanels();
        for (int i = 0; i < grid.length; i++) {
            if (getPanelService().checkByVertical(i, symbolO) == 2 && getPanelService().checkByVertical(i, symbolX) == 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (getPanelService().isEmptyPoint(i, j) == true) {
                        getPanelService().setPoint(new Step(symbolO, i, j));
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkHorizontal() {
        return checkHorizontal(X_SYMBOL, O_SYMBOL);
    }

    public boolean checkHorizontal(char sympolO, char symbolX) {
        Panel panel = getPanelService().panel();
        char[][] grid = panel.getPanels();
        for (int i = 0; i < grid.length; i++) {
            if (getPanelService().checkByHorizontal(i, sympolO) == 2 && getPanelService().checkByVertical(i, symbolX) == 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (getPanelService().isEmptyPoint(i, j)) {
                        getPanelService().setPoint(new Step(sympolO, i, j));
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkDiagonalLin() {
        return checkDiagonalLin(O_SYMBOL, X_SYMBOL);
    }

    public boolean checkDiagonalLin(char symbolO, char symbolX) {
        Panel panel = getPanelService().panel();
        char[][] grid = panel.getPanels();
        if (getPanelService().checkByDiagonalLin(symbolO) == 2 && getPanelService().checkByDiagonalLin(symbolX) == 0) {
            for (int i = 0; i < grid.length; i++) {
                if (getPanelService().isEmptyPoint(i, i)) {
                    getPanelService().setPoint(new Step(symbolO, i, i));
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkDiagonalWin() {
        return checkDiagonalWin(O_SYMBOL, X_SYMBOL);

    }

    public boolean checkDiagonalWin(char symbolO, char symbolX) {
        Panel panel = getPanelService().panel();
        char[][] grid = panel.getPanels();
        if (getPanelService().checkByDiagonalWin(symbolO) == 2 && getPanelService().checkByDiagonalWin(symbolX) == 0) {
            for (int i = 0; i < grid.length; i++) {
                if (getPanelService().isEmptyPoint(i, i)) {
                    getPanelService().setPoint(new Step(symbolO, i, i));
                    return false;
                }
            }
        }
        return true;
    }
}






