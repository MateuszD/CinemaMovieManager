package cinema.view;

import cinema.presenter.CinemaProjectPresenter;
import hibernateUtil.HibernateUtil;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class MainWindowApp extends Application {

    public static void main(String[] args) {
        launch();
    }


    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/FXML/CinemaMainWindowFXML.fxml"));

        AnchorPane mainAnchorPane = loader.load();

        Scene scene = new Scene(mainAnchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Obsługa bazy filmów kina");

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                HibernateUtil.closeSession();
            }
        });
        primaryStage.show();
    }
}
