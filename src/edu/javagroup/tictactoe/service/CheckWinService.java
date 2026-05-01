package edu.javagroup.tictactoe.service;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class CheckWinService {

    private final PanelService panelService;

    public boolean checkWin(char symbol) {
        return checkByVertical(symbol) || checkByHorizontal(symbol) || checkByDiagonals(symbol);

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



