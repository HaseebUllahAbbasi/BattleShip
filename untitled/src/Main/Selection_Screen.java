package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Selection_Screen
{
    @FXML TextField rows;
    @FXML TextField columns;

    /**
     * increase the rows
     * @param actionEvent
     */
    public void increase_rows(ActionEvent actionEvent)
    {
        int row = (Integer.parseInt(rows.getText())+1);
        if(row<10)
            rows.setText(String.valueOf(row));
    }

    /**
     * decrease  the rows
     * @param actionEvent
     */
    public void decrease_rows(ActionEvent actionEvent)
    {
        int row = (Integer.parseInt(rows.getText())-1);
        if(row>0)
            rows.setText(String.valueOf(row));

    }


    /**
     * increase  the columns
     * @param actionEvent
     */
    public void increase_col(ActionEvent actionEvent)
    {
        int col = (Integer.parseInt(columns.getText())+1);
        if(col<10)
            columns.setText(String.valueOf(col));
    }

    /**
     * decrease  the columns
     * @param actionEvent
     */
    public void decrease_col(ActionEvent actionEvent)
    {
        int col = (Integer.parseInt(columns.getText())-1);
        if(col>0)
            columns.setText(String.valueOf(col));

    }

    /**
     * loads the game screen
     * @param actionEvent
     * @throws IOException
     */
    public void game_screen(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("Game_Screen.fxml").openStream());
        //root.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * exits the game screen
     * @param actionEvent
     */
    public void exit_game(ActionEvent actionEvent)
    {
        System.exit(1);
    }

    /**
     * loads the high score screen
     * @param actionEvent
     * @throws IOException
     */
    public void high_scores(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("High_Scores.fxml").openStream());
        //root.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * loads the score changing screen
     * @param actionEvent
     * @throws IOException
     */

    public void change_scores(ActionEvent actionEvent) throws IOException
    {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("scores_change.fxml").openStream());
        //root.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * lads the selecting placement screen
     * @param actionEvent
     * @throws IOException
     */
    public void chose_placement(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("Chose_Ship_Placement.fxml").openStream());
        //root.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    /**
     * loads the rules screen
     * @param actionEvent
     * @throws IOException
     */
    public void rules(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("Rules.fxml").openStream());
        //root.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
