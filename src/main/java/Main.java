import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.StartScreen;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        var view = new StartScreen();
        Scene scene = new Scene(view, 640, 480);
        stage.setTitle("Battleships build with JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}