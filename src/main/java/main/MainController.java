package main;

import config.ScreensConfig;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import model.GitObject;

/**
 * Created by heiko on 15.12.14.
 */
public class MainController extends Controller {

    public MainController(ScreensConfig screens) {
        super(screens);
    }

    @FXML
    TextArea txaText;

    @FXML
    ComboBox<String> cbGitRepositoryPath;

    @FXML
    ComboBox<String> cbDatabaseConnection;

    @FXML
    TableView<GitObject> tvDatabaseObjects;

    @FXML
    void initialize() {


        final ObservableList<GitObject> data = FXCollections.observableArrayList(
            new GitObject("V_XY_TEST","/test/cv_xy_test","VIEW"),
            new GitObject(null,"/test/cv_abc_test","VIEW")
        );

        tvDatabaseObjects.getColumns().get(0).setCellValueFactory(
                new PropertyValueFactory<>("databaseObject")
        );

        tvDatabaseObjects.getColumns().get(1).setCellValueFactory(
                new PropertyValueFactory<>("localPath")
        );

        tvDatabaseObjects.setItems(data);


    }

}
