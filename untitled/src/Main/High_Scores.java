package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class High_Scores implements Initializable
{
    @FXML Label data;
    @FXML Label scores_data;

    /**
     * function is called when the form is loaded
     * the scores are read from the files and displayed on the screen
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            String string_data = "";
            FileReader fileReader = new FileReader("src/data/data.txt");
            int i;
            while((i=fileReader.read())!=-1)
                string_data+=(char)i;
            fileReader.close();
            //System.out.println(Arrays.toString(string_data.split(",")));
            String array[] = string_data.split(",");
            int j=0;
            String scores = "";
            String names = "";
            for (String temp: array)
            {
                if(j%2==1)
                {
                    scores+=(temp+"\n\n");
                }
                else
                {
                    names+=(temp+"\n");
                }
              //  System.out.print(++j+" "+temp+" ");
            }
            //data.setText("ashdjkash \nkj");
            data.setText(names);
            scores_data.setText(scores);
            //System.out.print(scores);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    /**
     * the function is called to go the main Selection Screen
     * @param actionEvent
     * @throws IOException
     */
    public void game_screen(ActionEvent actionEvent) throws IOException {
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
