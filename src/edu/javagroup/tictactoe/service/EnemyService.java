package edu.javagroup.tictactoe.service;

public interface EnemyService {
    int MIN = 0;
    int MAX = 2;
    char X_SYMBOL = 'X';
    char O_SYMBOL = 'O';

    void setPoint();

    default int random(int min, int max) {
        return (int)(Math.random() * (MAX - MIN + 1)) + MIN;
    }
}
