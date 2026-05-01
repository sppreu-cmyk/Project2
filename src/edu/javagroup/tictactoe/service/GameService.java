package edu.javagroup.tictactoe.service;

import edu.javagroup.tictactoe.model.Step;
import edu.javagroup.tictactoe.service.PanelService;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class GameService {

    private PanelService panelService;
    private EnemyService enemyService;
    private CheckWinService checkWinService;

    public void setPoint(Step step) {
        panelService.setPoint(step);
        enemyService.setPoint();
    }

    public boolean isEmptyPoint(int coordinateVertical, int coordinateHorizontal) {
        return panelService.isEmptyPoint(coordinateVertical,coordinateHorizontal);
    }

    public boolean checkWin(char symbol) {
        return checkWinService.checkWin(symbol);
    }
    public boolean isComplete(){
        return panelService.isComplete();
    }
}

