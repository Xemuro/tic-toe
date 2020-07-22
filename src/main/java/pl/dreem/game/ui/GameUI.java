package pl.dreem.game.ui;

import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.Coordinates;
import pl.dreem.game.domain.vo.MoveResult;
import pl.dreem.game.domain.vo.Player;

public interface GameUI {

    void initNewGame();

    void makeMove(Player symbol, BoardCoordinates position);

    Coordinates readNextMove();

    void displayResult(Player player, MoveResult result);
}
