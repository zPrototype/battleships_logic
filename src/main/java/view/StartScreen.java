package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;

public class StartScreen extends HBox {


    public StartScreen() {

        var btnLocalGame = new Button("Local Game");
        var btnNetworkGame = new Button("Network Game");

        var spcBetweenButtons = new Separator();
        spcBetweenButtons.setMinWidth(50);
        spcBetweenButtons.setMinWidth(50);
        spcBetweenButtons.setOpacity(0);

        this.getChildren().addAll(
                btnLocalGame,
                spcBetweenButtons,
                btnNetworkGame
        );
        this.setAlignment(Pos.CENTER);

    }
}
