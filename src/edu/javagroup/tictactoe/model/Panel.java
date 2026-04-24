package edu.javagroup.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Panel {

    private final char[][] panels = new char[3][3];

}
