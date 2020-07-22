package pl.dreem.game.domain.vo;

public enum Symbol {

    DOT("."), X("X"), O("O");

    private final String consoleRepresentation;

    Symbol(String consoleRepresentation) {
        this.consoleRepresentation = consoleRepresentation;
    }

    public String getConsoleRepresentation() {
        return consoleRepresentation;
    }
}
