package blackjack;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.text.Font;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    private static Stage root;

    @Override
    public void start(Stage stage) throws IOException {
        root = stage;
        root.getIcons().add(getImage("placeholder.png"));
        titleScreen();
    }
    
    public void showScene(Scene scene, Stage stage) {
        stage.setScene(scene);
        stage.show();
    }
    public Background constructBackground(String imageName) {
        Image image = getImage(imageName);
        BackgroundImage  backImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backImage);
        return background;
    }
    public void titleScreen() {
        // for buttons + title
        VBox container = new VBox(30);
        container.setAlignment(Pos.CENTER);
        container.setBackground(constructBackground("background.png"));
        // for logo + titleText
        HBox title = new HBox();
        title.setAlignment(Pos.CENTER);
        // logo TODO: Replace placeholder
        ImageView logo = new ImageView(new Image(getImagePath("placeholder.png")));
        logo.setFitWidth(100);
        logo.setPreserveRatio(true);
        // titleText
        Text titleText = new Text("Blackjack");
        titleText.setFont(new Font(75.0));
        // play button
        Button play = new Button("Play!");
        play.setFont(new Font(20.0));
        // add children
        title.getChildren().addAll(logo, titleText);
        container.getChildren().addAll(title, play);
        // show titleScreen
        scene = new Scene(container, 1300, 700);
        showScene(scene, root);
    }
    public String getImagePath(String imageName) {
        URL image = getClass().getResource("/blackjack/"+imageName);
        return image.toString();
    }
    public Image getImage(String imageName) {
        Image image = new Image(getClass().getResource("/blackjack/" + imageName).toString());
        return image;
    }
    public static void main(String[] args) {
        launch();
    };
}