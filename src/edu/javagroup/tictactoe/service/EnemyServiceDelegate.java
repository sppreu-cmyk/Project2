package edu.javagroup.tictactoe.service;
import lombok.AllArgsConstructor;


@AllArgsConstructor

public class EnemyServiceDelegate implements EnemyService {
    private final EnemyService enemyService;

    @Override
    public void setPoint() {
    }

    @Override
    public int random(int min, int max) {
        return EnemyService.super.random(min, max);
    }

}
