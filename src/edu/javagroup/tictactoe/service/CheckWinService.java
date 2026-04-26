package edu.javagroup.tictactoe.service;

public class CheckWinService {

    private final PanelService panelService;


    public CheckWinService(PanelService panelService) {
        this.panelService = panelService;
    }

    public boolean checkWin(char symbol) {
//        return checkByVertical || checkByHorizontal || checkByDiagonals;
        return false;
    }

    public boolean checkByVertical(char symbol) {

        for (int i = 0; i < 3; i++) {
            if (panelService.checkByVertical(i, symbol) == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean checkByHorizontal(char symbol) {

        for (int i = 0; i < 3; i++) {
            if (panelService.checkByHorizontal(i, symbol) == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean checkByDiagonals(char symbol) {
        if (panelService.checkByDiagonalWin(symbol) == 3 || panelService.checkByDiagonalLin(symbol) == 3) {
            return true;
        }
        return false;
    }

}



