package pl.dreem.game.domain.vo;

public enum Setup {

    BASIC(UI.BASIC, CoordinatesInput.BASIC);

    private UI gameUI;
    private CoordinatesInput inputMapper;

    Setup(final UI gameUI, final CoordinatesInput inputMapper) {
        this.gameUI = gameUI;
        this.inputMapper = inputMapper;
    }

    public UI getGameUI() {
        return gameUI;
    }

    public CoordinatesInput getInputMapper() {
        return inputMapper;
    }
}
