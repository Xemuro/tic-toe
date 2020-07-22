package pl.dreem.game.domain.vo;

public enum Player {

    FIRST(Symbol.O, true),
    SECOND(Symbol.X, false);

    private final Symbol symbol;
    private final boolean first;

    Player(final Symbol symbol, final boolean first) {
        this.symbol = symbol;
        this.first = first;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public boolean isFirst() {
        return first;
    }
}
