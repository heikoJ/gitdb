package config;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Created by heiko on 14.12.14.
 */
@Configuration
@Lazy
public class ScreensConfig {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    public static final String STYLE_FILE = "main.css";

    private Stage stage;
    private Scene scene;
    private StackPane root;

    public void setPrimaryStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

    public void showMainScreen() {
        root = new StackPane();
        root.getStylesheets().add(STYLE_FILE);
        root.getStyleClass().add("main-window");
        stage.setTitle("SpringFX");
        scene = new Scene(root,WIDTH,HEIGHT);
        stage.setScene(scene);
        stage.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        stage.show();
    }

    void loadFirst() {
        setNode(getNode(firstPresentation(), getClass().getResource("First.fxml")));
    }

    @Bean
    @Scope("prototype")
    FirstPresentation firstPresentation() {
        return new FirstPresentation(this);
    }



}
