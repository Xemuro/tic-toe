package pl.dreem.game;

import pl.dreem.game.core.GameCore;

public class ApplicationMain {
    public static void main(String[] args) {
        final GameCore gameCore = GameCore.initBasicGame();
        gameCore.initGame();
        gameCore.startGame();
    }
}
