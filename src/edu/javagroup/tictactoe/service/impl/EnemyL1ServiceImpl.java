package edu.javagroup.tictactoe.service.impl;

import edu.javagroup.tictactoe.model.Step;
import edu.javagroup.tictactoe.service.EnemyService;
import edu.javagroup.tictactoe.service.PanelService;
import lombok.Getter;

@Getter
public class EnemyL1ServiceImpl implements EnemyService {
    public EnemyL1ServiceImpl(PanelService panelService) {
        this.panelService = panelService;
    }

    private final PanelService panelService;


    @Override
    public void setPoint() {
        while (panelService.isComplete()) {
            break;

        }
        int numberRandom1 = random(MIN, MAX);
        int numberRandom2 = random(MIN, MAX);

        if (panelService.isEmptyPoint(numberRandom1, numberRandom2)) {
            new Step(O_SYMBOL, numberRandom1, numberRandom2);
        }
    }
}



