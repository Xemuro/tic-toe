package pl.dreem.game.ui;

import pl.dreem.game.domain.vo.UI;

public final class GameUIFactory {

    public static GameUI getFactory(final UI ui){
        if(UI.BASIC.equals(ui)){
            return new ConsoleUI();
        }else{
            throw new UnsupportedOperationException();
        }
    }

}
