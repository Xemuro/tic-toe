package pl.dreem.game.mock;

import pl.dreem.game.domain.exception.InvalidInputException;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.Coordinates;
import pl.dreem.game.domain.vo.MoveResult;
import pl.dreem.game.domain.vo.Player;
import pl.dreem.game.ui.GameUI;

import java.util.ArrayList;
import java.util.List;

public final class GameUIMock implements GameUI {

    private List<BoardCoordinates> makeMoveHandler = new ArrayList<BoardCoordinates>();

    @Override
    public void initNewGame() {

    }

    @Override
    public void makeMove(Player symbol, BoardCoordinates position) {
        makeMoveHandler.add(position);
    }

    @Override
    public Coordinates readNextMove() {
        try {
            return Coordinates.fromKeyBoardInput("A1");
        } catch (InvalidInputException e) {
            throw new RuntimeException("Broken mock");
        }
    }

    @Override
    public void displayResult(Player player, MoveResult result) {

    }

    public List<BoardCoordinates> getMakeMoveHandler() {
        return makeMoveHandler;
    }
}
