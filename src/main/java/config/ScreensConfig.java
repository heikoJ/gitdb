package config;

import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import main.Controller;
import main.MainController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.net.URL;

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
      //  root.getStylesheets().add(STYLE_FILE);
      //  root.getStyleClass().add("main-window");
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

    private void setNode(Node node) {
        root.getChildren().setAll(node);
    }

    private void setNodeOnTop(Node node) {
        root.getChildren().add(node);
    }

    public void removeNode(Node node) {
        root.getChildren().remove(node);
    }

    public void loadMain() {
        setNode(getNode(mainController(), getClass().getResource("main.fxml")));
    }


    @Bean
    @Scope("prototype")
    MainController mainController() {
        return new MainController(this);
    }


    private Node getNode(final Controller control, URL location) {
        FXMLLoader loader = new FXMLLoader(location);
        loader.setControllerFactory(new Callback<Class<?>, Object>() {
            public Object call(Class<?> aClass) {
                return control;
            }
        });

        try {
            return (Node) loader.load();
        } catch (Exception e) {
            System.out.println("Error casting node");
            e.printStackTrace();
            //logger.error("Error casting node", e);
            return null;
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void update(Observable o, Object arg) {
        loadMain();
    }



}
