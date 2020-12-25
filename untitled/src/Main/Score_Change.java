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

public class Score_Change
{
    @FXML TextField score_1;
    @FXML TextField score_2;
   // Game_Screen game_screen = new Game_Screen();

    /**
     * set the scores of the players
     */
    public void setGame_screen()
    {
        Game_Screen.player_one_score = Integer.parseInt(score_1.getText());
        Game_Screen.player_two_score = Integer.parseInt(score_2.getText());
    }

    /**
     * increase the scores of player one
     * @param actionEvent
     */
    public void increase_score_1(ActionEvent actionEvent)
    {
        if(Integer.parseInt(score_1.getText())<1000)
        score_1.setText(String.valueOf(Integer.parseInt(score_1.getText())+10));

    }


    /**
     * decrease the scores of player one
     * @param actionEvent
     */
    public void decrease_score_1(ActionEvent actionEvent)
    {

        if(Integer.parseInt(score_1.getText())>0)
            score_1.setText(String.valueOf(Integer.parseInt(score_1.getText())-10));
    }

    /**
     * increase the scores of player two
     * @param actionEvent
     */
    public void increase_score_2(ActionEvent actionEvent)
    {
        if(Integer.parseInt(score_2.getText())<1000)
            score_2.setText(String.valueOf(Integer.parseInt(score_2.getText())+10));
    }

    /**
     * decrease the scores of player two
     * @param actionEvent
     */
    public void decrease_score_2(ActionEvent actionEvent)
    {
        if(Integer.parseInt(score_2.getText())>0)
            score_2.setText(String.valueOf(Integer.parseInt(score_2.getText())-10));
    }

    /**
     * returns the selection screen
     * @param actionEvent
     * @throws IOException
     */
    public void back_to_screen(ActionEvent actionEvent) throws IOException
    {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("Selection_Screen.fxml").openStream());
        //root.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
