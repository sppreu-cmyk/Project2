package edu.javagroup.tictactoe.service.impl;

import edu.javagroup.tictactoe.service.EnemyService;
import edu.javagroup.tictactoe.service.PanelService;

public class EnemyL3ServiceImpl extends EnemyL2ServiceImpl {
    public EnemyL3ServiceImpl(PanelService panelService) {
        super(panelService);
    }

    @Override
    public void setPoint() {
        if (!steap()) {
            return;
        }
        super.setPoint();
    }

    public boolean steap() {
        if (getPanelService().isEmptyPoint(1,1)){
            setCenterPoint();
            return false;
        }
        return blockWin();
    }

    public boolean blockWin() {
        return checkDiagonalLin(O_SYMBOL, X_SYMBOL)
                || checkDiagonalLin(X_SYMBOL, O_SYMBOL)
                || checkDiagonalWin(O_SYMBOL, X_SYMBOL)
                || checkDiagonalWin(X_SYMBOL, O_SYMBOL)
                || checkVertical(O_SYMBOL, X_SYMBOL)
                || checkVertical(X_SYMBOL, O_SYMBOL)
                || checkHorizontal(O_SYMBOL, X_SYMBOL)
                || checkHorizontal(X_SYMBOL, O_SYMBOL);
    }
}
