import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(this.getClass().getResource("./view/UpdateForm.fxml"));
        Scene loginScene = new Scene(parent);

        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Customer's Update Form");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}