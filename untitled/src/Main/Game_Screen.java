package Main;

import Ships.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Game_Screen implements Initializable
{
    @FXML Label label_score_2;
    @FXML Label label_score_1;
    Alert alert;
    Random random = new Random();
    int button_clicked = 0;

    static boolean random_data = true;
    @FXML Button button_0_0;
    @FXML Button button_0_1;
    @FXML Button button_0_2;
    @FXML Button button_0_3;
    @FXML Button button_0_4;
    @FXML Button button_0_5;
    @FXML Button button_0_6;
    @FXML Button button_0_7;
    @FXML Button button_1_0;
    @FXML Button button_1_1;
    @FXML Button button_1_2;
    @FXML Button button_1_3;
    @FXML Button button_1_4;
    @FXML Button button_1_5;
    @FXML Button button_1_6;
    @FXML Button button_1_7;
    @FXML Button button_2_0;
    @FXML Button button_2_1;
    @FXML Button button_2_2;
    @FXML Button button_2_3;
    @FXML Button button_2_4;
    @FXML Button button_2_5;
    @FXML Button button_2_6;
    @FXML Button button_2_7;
    @FXML Button button_3_0;
    @FXML Button button_3_1;
    @FXML Button button_3_2;
    @FXML Button button_3_3;
    @FXML Button button_3_4;
    @FXML Button button_3_5;
    @FXML Button button_3_6;
    @FXML Button button_3_7;
    @FXML Button button_4_0;
    @FXML Button button_4_1;
    @FXML Button button_4_2;
    @FXML Button button_4_3;
    @FXML Button button_4_4;
    @FXML Button button_4_5;
    @FXML Button button_4_6;
    @FXML Button button_4_7;
    @FXML Button button_5_0;
    @FXML Button button_5_1;
    @FXML Button button_5_2;
    @FXML Button button_5_3;
    @FXML Button button_5_4;
    @FXML Button button_5_5;
    @FXML Button button_5_6;
    @FXML Button button_5_7;
    @FXML Button button_6_0;
    @FXML Button button_6_1;
    @FXML Button button_6_2;
    @FXML Button button_6_3;
    @FXML Button button_6_4;
    @FXML Button button_6_5;
    @FXML Button button_6_6;
    @FXML Button button_6_7;
    @FXML Button button_7_0;
    @FXML Button button_7_1;
    @FXML Button button_7_2;
    @FXML Button button_7_3;
    @FXML Button button_7_4;
    @FXML Button button_7_5;
    @FXML Button button_7_6;
    @FXML Button button_7_7;
    /**
     * These are arrays , both arrays are for different players to store and analyze data
     */
    Button_Structure[][] button_structure_1 = new Button_Structure[8][8];
    Button_Structure[][] button_structure_2 = new Button_Structure[8][8];
    @FXML Label player_status;
    boolean player_one = true;
    static int player_one_score = 100;
    static int player_two_score = 100;

    /**
     * quit_game function quit the game and returns to Selection Screen
     * @param actionEvent
     * @throws IOException
     */
    public void quit_game(ActionEvent actionEvent) throws IOException
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
    static int  score_1 = 0;
    static int score_2 = 0;
    int destroyed_points_1=0;
    int destroyed_points_2=0;

    /**
     * initialize function is called when the form is loaded
     * this function initializes the 64 buttons properties for each player
     * then checks the placing of ships if random the calls the random functions or using filing
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        for (int i=0; i<8; i++)
        {
            for (int j=0; j<8; j++)
            {
                button_structure_1[i][j] = new Button_Structure();
            }
        }
        for (int i=0; i<8; i++)
        {
            for (int j=0; j<8; j++)
            {
                button_structure_2[i][j] = new Button_Structure();
            }
        }
        if(random_data)
        {
            /**
             * Ships are placed randomly
             */
            create_carriers(button_structure_1);
            create_carriers(button_structure_2);
            create_battleship(button_structure_1);
            create_battleship(button_structure_2);
            create_submarine(button_structure_1);
            create_submarine(button_structure_2);
            create_destroyer(button_structure_1);
            create_destroyer(button_structure_2);
        }
        else
        {
            /**
             * Ships are placed using filing
             */
            int input = 0;
            String data = "";
            FileReader fileReader = null;
            try {
                fileReader = new FileReader("src/input/input_1.txt");
            } catch (FileNotFoundException e)
            {
                alert = new Alert(Alert.AlertType.ERROR, "Error in File Reading", ButtonType.OK);
                alert.showAndWait();
                return;
            }
            int number = 0;
            int i=0;

            while (true)
            {
                assert fileReader != null;
                try {
                    if (!((input=fileReader.read()) != -1)) break;
                } catch (IOException exception) {
                    alert = new Alert(Alert.AlertType.ERROR, "Error in File Reading", ButtonType.OK);
                    alert.showAndWait();
                    return;
                }
                if(i++==0)
                    number = input-48;
                else
                    data+= (char)input;
            }
        //    System.out.print(number);
          //  System.out.println();
            String[] array = (data.split(";"));
            for(int h=0; h< array.length; h++)
            {
               // System.out.println(h+" "+array[h]+" ");
            }

            String[] carrier_1 = array[1].split("\\*");
            String[] carrier_2 = array[2].split("\\*");
            String[] carrier_3 = array[3].split("\\*");
            String[] carrier_4 = array[4].split("\\*");
            String[] carrier_5 = array[5].split("\\*");

            String[] battleship_1 = array[6].split("\\*");
            String[] battleship_2 = array[7].split("\\*");
            String[] battleship_3 = array[8].split("\\*");
            String[] battleship_4 = array[9].split("\\*");

            String[]  subMarine_1 = array[10].split("\\*");
            String[] subMarine_2 = array[11].split("\\*");
            String[] subMarine_3 = array[12].split("\\*");

            String[]  destroyer_1 = array[13].split("\\*");
            String[] destroyer_2 = array[14].split("\\*");


            create_carriers(button_structure_1,carrier_1,carrier_2,carrier_3,carrier_4,carrier_5);
            create_submarine(button_structure_1,subMarine_1,subMarine_2,subMarine_3);
            create_battleship(button_structure_1,battleship_1,battleship_2,battleship_3,battleship_4);
            create_destroyer(button_structure_1,destroyer_1,destroyer_2);

            input = 0;
            data = "";
            fileReader = null;
            try {
                fileReader = new FileReader("src/input/input_1.txt");
            } catch (FileNotFoundException e)
            {
                alert = new Alert(Alert.AlertType.ERROR, "Error in File Reading", ButtonType.OK);
                alert.showAndWait();
                return;
            }
             number = 0;
             i=0;

            while (true)
            {
                assert fileReader != null;
                try {
                    if (!((input=fileReader.read()) != -1)) break;
                } catch (IOException exception) {
                    alert = new Alert(Alert.AlertType.ERROR, "Error in File Reading", ButtonType.OK);
                    alert.showAndWait();
                    return;
                }
                if(i++==0)
                    number = input-48;
                else
                    data+= (char)input;
            }
          //  System.out.print(number);
            //System.out.println();
            array = (data.split(";"));
            for(int h=0; h< array.length; h++)
            {
           //    System.out.println(h+" "+array[h]+" ");
            }

             carrier_1 = array[1].split("\\*");
             carrier_2 = array[2].split("\\*");
             carrier_3 = array[3].split("\\*");
             carrier_4 = array[4].split("\\*");
             carrier_5 = array[5].split("\\*");

             battleship_1 = array[6].split("\\*");
             battleship_2 = array[7].split("\\*");
             battleship_3 = array[8].split("\\*");
             battleship_4 = array[9].split("\\*");

             subMarine_1 = array[10].split("\\*");
             subMarine_2 = array[11].split("\\*");
             subMarine_3 = array[12].split("\\*");

              destroyer_1 = array[13].split("\\*");
             destroyer_2 = array[14].split("\\*");

            create_carriers(button_structure_2,carrier_1,carrier_2,carrier_3,carrier_4,carrier_5);
            create_submarine(button_structure_2,subMarine_1,subMarine_2,subMarine_3);
            create_battleship(button_structure_2,battleship_1,battleship_2,battleship_3,battleship_4);
            create_destroyer(button_structure_2,destroyer_1,destroyer_2);

        }
        button_structure_2[0][0].set_button(button_0_0);
        button_structure_2[0][1].set_button(button_0_1);
        button_structure_2[0][2].set_button(button_0_2);
        button_structure_2[0][3].set_button(button_0_3);
        button_structure_2[0][4].set_button(button_0_4);
        button_structure_2[0][5].set_button(button_0_5);
        button_structure_2[0][6].set_button(button_0_6);
        button_structure_2[0][7].set_button(button_0_7);

        button_structure_2[1][0].set_button(button_1_0);
        button_structure_2[1][1].set_button(button_1_1);
        button_structure_2[1][2].set_button(button_1_2);
        button_structure_2[1][3].set_button(button_1_3);
        button_structure_2[1][4].set_button(button_1_4);
        button_structure_2[1][5].set_button(button_1_5);
        button_structure_2[1][6].set_button(button_1_6);
        button_structure_2[1][7].set_button(button_1_7);

        button_structure_2[2][0].set_button(button_2_0);
        button_structure_2[2][1].set_button(button_2_1);
        button_structure_2[2][2].set_button(button_2_2);
        button_structure_2[2][3].set_button(button_2_3);
        button_structure_2[2][4].set_button(button_2_4);
        button_structure_2[2][5].set_button(button_2_5);
        button_structure_2[2][6].set_button(button_2_6);
        button_structure_2[2][7].set_button(button_2_7);

        button_structure_2[3][0].set_button(button_3_0);
        button_structure_2[3][1].set_button(button_3_1);
        button_structure_2[3][2].set_button(button_3_2);
        button_structure_2[3][3].set_button(button_3_3);
        button_structure_2[3][4].set_button(button_3_4);
        button_structure_2[3][5].set_button(button_3_5);
        button_structure_2[3][6].set_button(button_3_6);
        button_structure_2[3][7].set_button(button_3_7);

        button_structure_2[4][0].set_button(button_4_0);
        button_structure_2[4][1].set_button(button_4_1);
        button_structure_2[4][2].set_button(button_4_2);
        button_structure_2[4][3].set_button(button_4_3);
        button_structure_2[4][4].set_button(button_4_4);
        button_structure_2[4][5].set_button(button_4_5);
        button_structure_2[4][6].set_button(button_4_6);
        button_structure_2[4][7].set_button(button_4_7);

        button_structure_2[5][0].set_button(button_5_0);
        button_structure_2[5][1].set_button(button_5_1);
        button_structure_2[5][2].set_button(button_5_2);
        button_structure_2[5][3].set_button(button_5_3);
        button_structure_2[5][4].set_button(button_5_4);
        button_structure_2[5][5].set_button(button_5_5);
        button_structure_2[5][6].set_button(button_5_6);
        button_structure_2[5][7].set_button(button_5_7);

        button_structure_2[6][0].set_button(button_6_0);
        button_structure_2[6][1].set_button(button_6_1);
        button_structure_2[6][2].set_button(button_6_2);
        button_structure_2[6][3].set_button(button_6_3);
        button_structure_2[6][4].set_button(button_6_4);
        button_structure_2[6][5].set_button(button_6_5);
        button_structure_2[6][6].set_button(button_6_6);
        button_structure_2[6][7].set_button(button_6_7);

        button_structure_2[7][0].set_button(button_7_0);
        button_structure_2[7][1].set_button(button_7_1);
        button_structure_2[7][2].set_button(button_7_2);
        button_structure_2[7][3].set_button(button_7_3);
        button_structure_2[7][4].set_button(button_7_4);
        button_structure_2[7][5].set_button(button_7_5);
        button_structure_2[7][6].set_button(button_7_6);
        button_structure_2[7][7].set_button(button_7_7);

        button_structure_1[0][0].set_button(button_0_0);
        button_structure_1[0][1].set_button(button_0_1);
        button_structure_1[0][2].set_button(button_0_2);
        button_structure_1[0][3].set_button(button_0_3);
        button_structure_1[0][4].set_button(button_0_4);
        button_structure_1[0][5].set_button(button_0_5);
        button_structure_1[0][6].set_button(button_0_6);
        button_structure_1[0][7].set_button(button_0_7);

        button_structure_1[1][0].set_button(button_1_0);
        button_structure_1[1][1].set_button(button_1_1);
        button_structure_1[1][2].set_button(button_1_2);
        button_structure_1[1][3].set_button(button_1_3);
        button_structure_1[1][4].set_button(button_1_4);
        button_structure_1[1][5].set_button(button_1_5);
        button_structure_1[1][6].set_button(button_1_6);
        button_structure_1[1][7].set_button(button_1_7);

        button_structure_1[2][0].set_button(button_2_0);
        button_structure_1[2][1].set_button(button_2_1);
        button_structure_1[2][2].set_button(button_2_2);
        button_structure_1[2][3].set_button(button_2_3);
        button_structure_1[2][4].set_button(button_2_4);
        button_structure_1[2][5].set_button(button_2_5);
        button_structure_1[2][6].set_button(button_2_6);
        button_structure_1[2][7].set_button(button_2_7);

        button_structure_1[3][0].set_button(button_3_0);
        button_structure_1[3][1].set_button(button_3_1);
        button_structure_1[3][2].set_button(button_3_2);
        button_structure_1[3][3].set_button(button_3_3);
        button_structure_1[3][4].set_button(button_3_4);
        button_structure_1[3][5].set_button(button_3_5);
        button_structure_1[3][6].set_button(button_3_6);
        button_structure_1[3][7].set_button(button_3_7);

        button_structure_1[4][0].set_button(button_4_0);
        button_structure_1[4][1].set_button(button_4_1);
        button_structure_1[4][2].set_button(button_4_2);
        button_structure_1[4][3].set_button(button_4_3);
        button_structure_1[4][4].set_button(button_4_4);
        button_structure_1[4][5].set_button(button_4_5);
        button_structure_1[4][6].set_button(button_4_6);
        button_structure_1[4][7].set_button(button_4_7);

        button_structure_1[5][0].set_button(button_5_0);
        button_structure_1[5][1].set_button(button_5_1);
        button_structure_1[5][2].set_button(button_5_2);
        button_structure_1[5][3].set_button(button_5_3);
        button_structure_1[5][4].set_button(button_5_4);
        button_structure_1[5][5].set_button(button_5_5);
        button_structure_1[5][6].set_button(button_5_6);
        button_structure_1[5][7].set_button(button_5_7);

        button_structure_1[6][0].set_button(button_6_0);
        button_structure_1[6][1].set_button(button_6_1);
        button_structure_1[6][2].set_button(button_6_2);
        button_structure_1[6][3].set_button(button_6_3);
        button_structure_1[6][4].set_button(button_6_4);
        button_structure_1[6][5].set_button(button_6_5);
        button_structure_1[6][6].set_button(button_6_6);
        button_structure_1[6][7].set_button(button_6_7);

        button_structure_1[7][0].set_button(button_7_0);
        button_structure_1[7][1].set_button(button_7_1);
        button_structure_1[7][2].set_button(button_7_2);
        button_structure_1[7][3].set_button(button_7_3);
        button_structure_1[7][4].set_button(button_7_4);
        button_structure_1[7][5].set_button(button_7_5);
        button_structure_1[7][6].set_button(button_7_6);
        button_structure_1[7][7].set_button(button_7_7);
    }

    /**
     * creates destroyer for the provided player after checking
     * @param array
     * array : structure for a player 1 or 2
     * @param paths
     *  paths : where to place the ships
     */
    private void create_destroyer(Button_Structure[][] array, String[]... paths)
    {
        Ship ship = new Destroyer();
        for(String[] path : paths)
        {
            array[Integer.parseInt(path[0])-1][path[1].charAt(0)-48-1].set_ship(ship);
        }
    }

    /**
     * creates battleship for the provided player after checking
     * @param array
     * array : structure for a player 1 or 2
     * @param paths
     *  paths : where to place the ships
     */
    private void create_battleship(Button_Structure[][] array, String[]... paths)
    {
        Ship ship = new BattleShip();
        for(String[] path : paths)
        {
            array[Integer.parseInt(path[0])-1][path[1].charAt(0)-48-1].set_ship(ship);
        }
    }

    /**
     * creates submarine for the provided player after checking
     * @param array
     * array : structure for a player 1 or 2
     * @param paths
     *  paths : where to place the ships
     */
    private void create_submarine(Button_Structure[][] array,String[]... paths)
    {
        Ship ship = new SubMarine();
        for(String[] path : paths)
        {
            array[Integer.parseInt(path[0])-1][path[1].charAt(0)-48-1].set_ship(ship);
        }
    }

    /**
     * creates carrier for the provided player
     * @param array
     * array : structure for a player 1 or 2
     * @param paths
     *  paths : where to place the ships
     */
    void create_carriers(Button_Structure[][] array,String[]... paths)
    {
        Ship ship = new Carrier();
        for(String[] path : paths)
        {
            array[Integer.parseInt(path[0])-1][path[1].charAt(0)-48-1].set_ship(ship);
        }
    }

    /**
     * creates carrier for the provided player randomly
     * @param array
     * array : structure for a player 1 or 2
     */
    private void create_destroyer(Button_Structure[][] array)
    {

        Ship carrier_1 = new SubMarine();
        int ship_no_row = random.nextInt(7)%7;
        int ship_no_col = random.nextInt(7)%7;
        if(random.nextBoolean())
        {
            if(!check_carrier_row(array,ship_no_row,ship_no_col,2) && !check_battleship_row(array,ship_no_row,ship_no_col,2) && !check_submarine_col(array,ship_no_row,ship_no_col,2))
                for(int i=ship_no_col; i<ship_no_col+2; i++)
                {
                    array[ship_no_row][i].set_ship(carrier_1);
            //        System.out.println("submarine "+array[ship_no_row][i]+ "["+ship_no_row+"]["+i+"]");
                }
            else
                create_submarine(array);
        }
        else
        {
            if(!check_carrier_col(array,ship_no_row,ship_no_col,2) && !check_battleship_col(array,ship_no_row,ship_no_col,2) && !check_submarine_row(array,ship_no_row,ship_no_col,2))
                for(int i=ship_no_row; i<ship_no_row+2; i++)
                {
                    array[i][ship_no_col].set_ship(carrier_1);
              //      System.out.println("submarine "+array[i][ship_no_col]+ "["+i+"]["+ship_no_col+"]");
                }
            else
                create_submarine(array);
        }
    }

    /**
     * take the array and checks whether there is no submarine ahead
     * @param array
     * @param ship_no_row
     * @param ship_no_col
     * @param size
     * @return
     */
    private boolean check_submarine_row(Button_Structure[][] array, int ship_no_row, int ship_no_col, int size)
    {
        for(int i=ship_no_row; i<ship_no_row+size; i++)
        {
            if(array[i][ship_no_col].check())
                return true;
        }
        return false;

    }


    /**
     * take the array and checks whether there is no submarine ahead
     * @param array
     * @param ship_no_row
     * @param ship_no_col
     * @param size
     * @return
     */
    private boolean check_submarine_col(Button_Structure[][] array, int ship_no_row, int ship_no_col, int size)
    {
        for(int i=ship_no_col; i<ship_no_col+size; i++)
        {
            if(array[ship_no_row][i].check())
                return true;
        }
        return false;
    }

    /**
     * take the array and place the submarine in the array randomly
     * @param array
     */
    private void create_submarine(Button_Structure[][] array)
    {
        Ship carrier_1 = new SubMarine();
        int ship_no_row = random.nextInt(7)%6;
        int ship_no_col = random.nextInt(7)%6;
        if(random.nextBoolean())
        {
            if(!check_carrier_row(array,ship_no_row,ship_no_col,3) && !check_battleship_row(array,ship_no_row,ship_no_col,3) )
                for(int i=ship_no_col; i<ship_no_col+3; i++)
                {
                    array[ship_no_row][i].set_ship(carrier_1);
              //      System.out.println("submarine "+array[ship_no_row][i]+ "["+ship_no_row+"]["+i+"]");
                }
            else
                create_submarine(array);
        }
        else
        {
            if(!check_carrier_col(array,ship_no_row,ship_no_col,3) && !check_battleship_col(array,ship_no_row,ship_no_col,3))
                for(int i=ship_no_row; i<ship_no_row+3; i++)
                {
                    array[i][ship_no_col].set_ship(carrier_1);
                //    System.out.println("submarine "+array[i][ship_no_col]+ "["+i+"]["+ship_no_col+"]");
                }
            else
                create_submarine(array);
        }
    }

    /**
     * take the array and check the next is not battleship
     * @param array
     * @param ship_no_row
     * @param ship_no_col
     * @param size
     * @return
     */
    private boolean check_battleship_col(Button_Structure[][] array, int ship_no_row, int ship_no_col,int size)
    {
        for(int i=ship_no_row; i<ship_no_row+size; i++)
        {
            if(array[i][ship_no_col].check())
                return true;
        }
        return false;
    }

    /**
     * take the array and check the next is not battleship
     * @param array
     * @param ship_no_row
     * @param ship_no_col
     * @param size
     * @return
     */
    private boolean check_battleship_row(Button_Structure[][] array, int ship_no_row, int ship_no_col,int size)
    {
        for(int i=ship_no_col; i<ship_no_col+size; i++)
        {
            if(array[ship_no_row][i].check())
                return true;
        }
        return false;
    }

    /**
     * takes the array and place battleship randomly
     * @param array
     */
    private void create_battleship(Button_Structure[][] array)
    {
        Ship carrier_1 = new BattleShip();
        int ship_no_row = random.nextInt(7)%5;
        int ship_no_col = random.nextInt(7)%5;
        if(random.nextBoolean())
        {
            if(!check_carrier_row(array,ship_no_row,ship_no_col,4))
                for(int i=ship_no_col; i<ship_no_col+4; i++)
                {
                    array[ship_no_row][i].set_ship(carrier_1);
                 //   System.out.println("battle_ship "+array[ship_no_row][i]+ "["+ship_no_row+"]["+i+"]");
                }
            else
                create_battleship(array);
        }
        else
        {
            if(!check_carrier_col(array,ship_no_row,ship_no_col,4))
                for(int i=ship_no_row; i<ship_no_row+4; i++)
                {
                    array[i][ship_no_col].set_ship(carrier_1);
                   // System.out.println("battle_ship "+array[i][ship_no_col]+ "["+i+"]["+ship_no_col+"]");
                }
            else
                create_battleship(array);
        }
    }

    /**
     * checks the array whether the next is carrier  or not
     * @param array
     * @param ship_no_row
     * @param ship_no_col
     * @param size
     * @return
     */
    private boolean check_carrier_col(Button_Structure[][] array, int ship_no_row, int ship_no_col,int size)
    {
        for(int i=ship_no_row; i<ship_no_row+size; i++)
        {
            if(array[i][ship_no_col].check())
                return true;
        }
        return false;
    }

    /**
     * checks the array whether the next is carrier  or not
     * @param array
     * @param ship_no_row
     * @param ship_no_col
     * @param size
     * @return
     */
    private boolean check_carrier_row(Button_Structure[][] array, int ship_no_row, int ship_no_col,int size)
    {
        for(int i=ship_no_col; i<ship_no_col+size; i++)
        {
            if(array[ship_no_row][i].check())
                return true;
        }
        return false;
    }

    /**
     * takes the array and place carrier randomly
     * @param array
     */
    private void create_carriers(Button_Structure array[][])
    {
        Ship carrier_1 = new Carrier();
        int ship_no_row = random.nextInt(7)%5;
        int ship_no_col = random.nextInt(7)%5;
        if(random.nextBoolean())
            for(int i=ship_no_col; i<ship_no_col+4; i++)
            {
                array[ship_no_row][i].set_ship(carrier_1);
               // System.out.println("carrier "+array[ship_no_row][i]+ "["+ship_no_row+"]["+i+"]");
            }
        else
            for(int i=ship_no_row; i<ship_no_row+4; i++)
            {
                array[i][ship_no_col].set_ship(carrier_1);
                //System.out.println("carrier "+array[i][ship_no_col]+ "["+i+"]["+ship_no_col+"]");
            }
    }

    /**
     * action is triggered whenever button is pressed
     * @param actionEvent
     * @throws IOException
     */
    public void perform_action(ActionEvent actionEvent) throws IOException {
        Button btn =((Button)actionEvent.getSource());
       // System.out.print(btn.getTextFill());
        String[] array = btn.getText().split(" ");
        if(player_one && btn.getStyle().contains("-fx-background-color: silver") && !btn.getStyle().contains("-fx-background-color: lightblue") && !btn.getStyle().contains("-fx-background-color: pink") )
        {
            player_one = false;
            if(button_structure_1[Integer.parseInt(array[0])][Integer.parseInt(array[1])].check())
            {
                if(button_structure_1[Integer.parseInt(array[0])][Integer.parseInt(array[1])].destroy(btn))
                {
                    button_clicked++;
                    score_1+= player_one_score;
                    label_score_1.setText(String.valueOf(score_1));
                    destroyed_points_1++;
                    button_structure_1[Integer.parseInt(array[0])][Integer.parseInt(array[1])].set_button(btn);
                    if(destroyed_points_1==14)
                    {
                        alert = new Alert(Alert.AlertType.INFORMATION, "Player 1 has won", ButtonType.OK);
                        alert.showAndWait();

                        try {
                            FileWriter fileWriter = new FileWriter("src/data/data.txt");
                            fileWriter.append("player_1,"+score_1+",\n");
                            fileWriter.close();

                            alert = new Alert(Alert.AlertType.CONFIRMATION,"The Game is Ended",ButtonType.FINISH);
                            alert.showAndWait();
                            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
                            Stage primaryStage = new Stage();
                            FXMLLoader loader = new FXMLLoader();
                            Pane root = loader.load(getClass().getResource("Selection_Screen.fxml").openStream());
                            //root.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
                            Scene scene = new Scene(root);
                            primaryStage.setTitle("Game");
                            primaryStage.setScene(scene);
                            primaryStage.show();

                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
            else
            {
                btn.setStyle("-fx-background-color: lightblue");
                btn.setTextFill(Paint.valueOf("0xADD8E6"));
                button_clicked++;
            }
            player_status.setText("Player 2");
            set_first_plater_button();
            load_second_player_buttons();
            if(button_clicked==64)
                draw_game(actionEvent);
        }
        else if(btn.getStyle().contains("-fx-background-color: silver") && !player_one && !btn.getStyle().contains("-fx-background-color: lightblue") && !btn.getStyle().contains("-fx-background-color: pink") )
        {
            player_one = true;
            if(button_structure_2[Integer.parseInt(array[0])][Integer.parseInt(array[1])].check())
            {
                if(button_structure_2[Integer.parseInt(array[0])][Integer.parseInt(array[1])].destroy(btn))
                {
                    button_clicked++;
                    score_2+= player_two_score;
                    label_score_2.setText(String.valueOf(score_2));
                    button_structure_2[Integer.parseInt(array[0])][Integer.parseInt(array[1])].set_button(btn);
                    destroyed_points_2++;
                    if(destroyed_points_2==14)
                    {
                        alert = new Alert(Alert.AlertType.INFORMATION, "Player 2 has won", ButtonType.OK);
                        alert.showAndWait();

                        try {
                            FileWriter fileWriter = new FileWriter("src/data/data.txt");
                            fileWriter.append("player_2,"+score_2+",\n");
                            fileWriter.close();

                            alert = new Alert(Alert.AlertType.CONFIRMATION,"The Game is Ended",ButtonType.FINISH);
                            alert.showAndWait();
                            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
                            Stage primaryStage = new Stage();
                            FXMLLoader loader = new FXMLLoader();
                            Pane root = loader.load(getClass().getResource("Selection_Screen.fxml").openStream());
                            //root.getStylesheets().add(getClass().getResource("dashboard.css").toExternalForm());
                            Scene scene = new Scene(root);
                            primaryStage.setTitle("Game");
                            primaryStage.setScene(scene);
                            primaryStage.show();

                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
            else
            {
                btn.setStyle("-fx-background-color: lightblue");
                btn.setTextFill(Paint.valueOf("0xADD8E6"));
                button_clicked++;
            }
            player_status.setText("Player 1");
            set_second_plater_button();
            load_first_player_buttons();
            if(button_clicked==64)
                draw_game(actionEvent);

        }
    }

    /**
     *funtion is called when all the buttons are pressed and no one wins, then considered draw
     * @param actionEvent
     * @throws IOException
     */
    private void draw_game(ActionEvent actionEvent) throws IOException
    {
        alert = new Alert(Alert.AlertType.CONFIRMATION,"The Game is Draw",ButtonType.FINISH);
        alert.showAndWait();
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

    /**
     * set the buttons for the second player
     */
    private void set_second_plater_button()
    {
        button_structure_2[0][0].set_button(button_0_0);
        button_structure_2[0][1].set_button(button_0_1);
        button_structure_2[0][2].set_button(button_0_2);
        button_structure_2[0][3].set_button(button_0_3);
        button_structure_2[0][4].set_button(button_0_4);
        button_structure_2[0][5].set_button(button_0_5);
        button_structure_2[0][6].set_button(button_0_6);
        button_structure_2[0][7].set_button(button_0_7);

        button_structure_2[1][0].set_button(button_1_0);
        button_structure_2[1][1].set_button(button_1_1);
        button_structure_2[1][2].set_button(button_1_2);
        button_structure_2[1][3].set_button(button_1_3);
        button_structure_2[1][4].set_button(button_1_4);
        button_structure_2[1][5].set_button(button_1_5);
        button_structure_2[1][6].set_button(button_1_6);
        button_structure_2[1][7].set_button(button_1_7);

        button_structure_2[2][0].set_button(button_2_0);
        button_structure_2[2][1].set_button(button_2_1);
        button_structure_2[2][2].set_button(button_2_2);
        button_structure_2[2][3].set_button(button_2_3);
        button_structure_2[2][4].set_button(button_2_4);
        button_structure_2[2][5].set_button(button_2_5);
        button_structure_2[2][6].set_button(button_2_6);
        button_structure_2[2][7].set_button(button_2_7);

        button_structure_2[3][0].set_button(button_3_0);
        button_structure_2[3][1].set_button(button_3_1);
        button_structure_2[3][2].set_button(button_3_2);
        button_structure_2[3][3].set_button(button_3_3);
        button_structure_2[3][4].set_button(button_3_4);
        button_structure_2[3][5].set_button(button_3_5);
        button_structure_2[3][6].set_button(button_3_6);
        button_structure_2[3][7].set_button(button_3_7);

        button_structure_2[4][0].set_button(button_4_0);
        button_structure_2[4][1].set_button(button_4_1);
        button_structure_2[4][2].set_button(button_4_2);
        button_structure_2[4][3].set_button(button_4_3);
        button_structure_2[4][4].set_button(button_4_4);
        button_structure_2[4][5].set_button(button_4_5);
        button_structure_2[4][6].set_button(button_4_6);
        button_structure_2[4][7].set_button(button_4_7);

        button_structure_2[5][0].set_button(button_5_0);
        button_structure_2[5][1].set_button(button_5_1);
        button_structure_2[5][2].set_button(button_5_2);
        button_structure_2[5][3].set_button(button_5_3);
        button_structure_2[5][4].set_button(button_5_4);
        button_structure_2[5][5].set_button(button_5_5);
        button_structure_2[5][6].set_button(button_5_6);
        button_structure_2[5][7].set_button(button_5_7);

        button_structure_2[6][0].set_button(button_6_0);
        button_structure_2[6][1].set_button(button_6_1);
        button_structure_2[6][2].set_button(button_6_2);
        button_structure_2[6][3].set_button(button_6_3);
        button_structure_2[6][4].set_button(button_6_4);
        button_structure_2[6][5].set_button(button_6_5);
        button_structure_2[6][6].set_button(button_6_6);
        button_structure_2[6][7].set_button(button_6_7);

        button_structure_2[7][0].set_button(button_7_0);
        button_structure_2[7][1].set_button(button_7_1);
        button_structure_2[7][2].set_button(button_7_2);
        button_structure_2[7][3].set_button(button_7_3);
        button_structure_2[7][4].set_button(button_7_4);
        button_structure_2[7][5].set_button(button_7_5);
        button_structure_2[7][6].set_button(button_7_6);
        button_structure_2[7][7].set_button(button_7_7);

    }

    /**
     * set the buttons for the first player
     */
    private void set_first_plater_button()
    {
        button_structure_1[0][0].set_button(button_0_0);
        button_structure_1[0][1].set_button(button_0_1);
        button_structure_1[0][2].set_button(button_0_2);
        button_structure_1[0][3].set_button(button_0_3);
        button_structure_1[0][4].set_button(button_0_4);
        button_structure_1[0][5].set_button(button_0_5);
        button_structure_1[0][6].set_button(button_0_6);
        button_structure_1[0][7].set_button(button_0_7);

        button_structure_1[1][0].set_button(button_1_0);
        button_structure_1[1][1].set_button(button_1_1);
        button_structure_1[1][2].set_button(button_1_2);
        button_structure_1[1][3].set_button(button_1_3);
        button_structure_1[1][4].set_button(button_1_4);
        button_structure_1[1][5].set_button(button_1_5);
        button_structure_1[1][6].set_button(button_1_6);
        button_structure_1[1][7].set_button(button_1_7);

        button_structure_1[2][0].set_button(button_2_0);
        button_structure_1[2][1].set_button(button_2_1);
        button_structure_1[2][2].set_button(button_2_2);
        button_structure_1[2][3].set_button(button_2_3);
        button_structure_1[2][4].set_button(button_2_4);
        button_structure_1[2][5].set_button(button_2_5);
        button_structure_1[2][6].set_button(button_2_6);
        button_structure_1[2][7].set_button(button_2_7);

        button_structure_1[3][0].set_button(button_3_0);
        button_structure_1[3][1].set_button(button_3_1);
        button_structure_1[3][2].set_button(button_3_2);
        button_structure_1[3][3].set_button(button_3_3);
        button_structure_1[3][4].set_button(button_3_4);
        button_structure_1[3][5].set_button(button_3_5);
        button_structure_1[3][6].set_button(button_3_6);
        button_structure_1[3][7].set_button(button_3_7);

        button_structure_1[4][0].set_button(button_4_0);
        button_structure_1[4][1].set_button(button_4_1);
        button_structure_1[4][2].set_button(button_4_2);
        button_structure_1[4][3].set_button(button_4_3);
        button_structure_1[4][4].set_button(button_4_4);
        button_structure_1[4][5].set_button(button_4_5);
        button_structure_1[4][6].set_button(button_4_6);
        button_structure_1[4][7].set_button(button_4_7);

        button_structure_1[5][0].set_button(button_5_0);
        button_structure_1[5][1].set_button(button_5_1);
        button_structure_1[5][2].set_button(button_5_2);
        button_structure_1[5][3].set_button(button_5_3);
        button_structure_1[5][4].set_button(button_5_4);
        button_structure_1[5][5].set_button(button_5_5);
        button_structure_1[5][6].set_button(button_5_6);
        button_structure_1[5][7].set_button(button_5_7);

        button_structure_1[6][0].set_button(button_6_0);
        button_structure_1[6][1].set_button(button_6_1);
        button_structure_1[6][2].set_button(button_6_2);
        button_structure_1[6][3].set_button(button_6_3);
        button_structure_1[6][4].set_button(button_6_4);
        button_structure_1[6][5].set_button(button_6_5);
        button_structure_1[6][6].set_button(button_6_6);
        button_structure_1[6][7].set_button(button_6_7);

        button_structure_1[7][0].set_button(button_7_0);
        button_structure_1[7][1].set_button(button_7_1);
        button_structure_1[7][2].set_button(button_7_2);
        button_structure_1[7][3].set_button(button_7_3);
        button_structure_1[7][4].set_button(button_7_4);
        button_structure_1[7][5].set_button(button_7_5);
        button_structure_1[7][6].set_button(button_7_6);
        button_structure_1[7][7].set_button(button_7_7);
    }

    /**
     * loads the buttons of the first player
     */
    private void load_first_player_buttons()
    {
        button_0_0 = button_structure_1[0][0].button;
        button_0_1 = button_structure_1[0][1].button;
        button_0_2 = button_structure_1[0][2].button;
        button_0_3 = button_structure_1[0][3].button;
        button_0_4 = button_structure_1[0][4].button;
        button_0_5 = button_structure_1[0][5].button;
        button_0_6 = button_structure_1[0][6].button;
        button_0_7 = button_structure_1[0][7].button;

        button_1_0 = button_structure_1[1][0].button;
        button_1_1 = button_structure_1[1][1].button;
        button_1_2 = button_structure_1[1][2].button;
        button_1_3 = button_structure_1[1][3].button;
        button_1_4 = button_structure_1[1][4].button;
        button_1_5 = button_structure_1[1][5].button;
        button_1_6 = button_structure_1[1][6].button;
        button_1_7 = button_structure_1[1][7].button;

        button_2_0 = button_structure_1[2][0].button;
        button_2_1 = button_structure_1[2][1].button;
        button_2_2 = button_structure_1[2][2].button;
        button_2_3 = button_structure_1[2][3].button;
        button_2_4 = button_structure_1[2][4].button;
        button_2_5 = button_structure_1[2][5].button;
        button_2_6 = button_structure_1[2][6].button;
        button_2_7 = button_structure_1[2][7].button;

        button_3_0 = button_structure_1[3][0].button;
        button_3_1 = button_structure_1[3][1].button;
        button_3_2 = button_structure_1[3][2].button;
        button_3_3 = button_structure_1[3][3].button;
        button_3_4 = button_structure_1[3][4].button;
        button_3_5 = button_structure_1[3][5].button;
        button_3_6 = button_structure_1[3][6].button;
        button_3_7 = button_structure_1[3][7].button;

        button_4_0 = button_structure_1[4][0].button;
        button_4_1 = button_structure_1[4][1].button;
        button_4_2 = button_structure_1[4][2].button;
        button_4_3 = button_structure_1[4][3].button;
        button_4_4 = button_structure_1[4][4].button;
        button_4_5 = button_structure_1[4][5].button;
        button_4_6 = button_structure_1[4][6].button;
        button_4_7 = button_structure_1[4][7].button;

        button_5_0 = button_structure_1[5][0].button;
        button_5_1 = button_structure_1[5][1].button;
        button_5_2 = button_structure_1[5][2].button;
        button_5_3 = button_structure_1[5][3].button;
        button_5_4 = button_structure_1[5][4].button;
        button_5_5 = button_structure_1[5][5].button;
        button_5_6 = button_structure_1[5][6].button;
        button_5_7 = button_structure_1[5][7].button;

        button_6_0 = button_structure_1[6][0].button;
        button_6_1 = button_structure_1[6][1].button;
        button_6_2 = button_structure_1[6][2].button;
        button_6_3 = button_structure_1[6][3].button;
        button_6_4 = button_structure_1[6][4].button;
        button_6_5 = button_structure_1[6][5].button;
        button_6_6 = button_structure_1[6][6].button;
        button_6_7 = button_structure_1[6][7].button;

        button_7_0 = button_structure_1[7][0].button;
        button_7_1 = button_structure_1[7][1].button;
        button_7_2 = button_structure_1[7][2].button;
        button_7_3 = button_structure_1[7][3].button;
        button_7_4 = button_structure_1[7][4].button;
        button_7_5 = button_structure_1[7][5].button;
        button_7_6 = button_structure_1[7][6].button;
        button_7_7 = button_structure_1[7][7].button;
    }

    /**
     * loads the buttons of the sceond player
     */
    private void load_second_player_buttons()
    {
        button_0_0 = button_structure_2[0][0].button;
        button_0_1 = button_structure_2[0][1].button;
        button_0_2 = button_structure_2[0][2].button;
        button_0_3 = button_structure_2[0][3].button;
        button_0_4 = button_structure_2[0][4].button;
        button_0_5 = button_structure_2[0][5].button;
        button_0_6 = button_structure_2[0][6].button;
        button_0_7 = button_structure_2[0][7].button;

        button_1_0 = button_structure_2[1][0].button;
        button_1_1 = button_structure_2[1][1].button;
        button_1_2 = button_structure_2[1][2].button;
        button_1_3 = button_structure_2[1][3].button;
        button_1_4 = button_structure_2[1][4].button;
        button_1_5 = button_structure_2[1][5].button;
        button_1_6 = button_structure_2[1][6].button;
        button_1_7 = button_structure_2[1][7].button;

        button_2_0 = button_structure_2[2][0].button;
        button_2_1 = button_structure_2[2][1].button;
        button_2_2 = button_structure_2[2][2].button;
        button_2_3 = button_structure_2[2][3].button;
        button_2_4 = button_structure_2[2][4].button;
        button_2_5 = button_structure_2[2][5].button;
        button_2_6 = button_structure_2[2][6].button;
        button_2_7 = button_structure_2[2][7].button;

        button_3_0 = button_structure_2[3][0].button;
        button_3_1 = button_structure_2[3][1].button;
        button_3_2 = button_structure_2[3][2].button;
        button_3_3 = button_structure_2[3][3].button;
        button_3_4 = button_structure_2[3][4].button;
        button_3_5 = button_structure_2[3][5].button;
        button_3_6 = button_structure_2[3][6].button;
        button_3_7 = button_structure_2[3][7].button;

        button_4_0 = button_structure_2[4][0].button;
        button_4_1 = button_structure_2[4][1].button;
        button_4_2 = button_structure_2[4][2].button;
        button_4_3 = button_structure_2[4][3].button;
        button_4_4 = button_structure_2[4][4].button;
        button_4_5 = button_structure_2[4][5].button;
        button_4_6 = button_structure_2[4][6].button;
        button_4_7 = button_structure_2[4][7].button;

        button_5_0 = button_structure_2[5][0].button;
        button_5_1 = button_structure_2[5][1].button;
        button_5_2 = button_structure_2[5][2].button;
        button_5_3 = button_structure_2[5][3].button;
        button_5_4 = button_structure_2[5][4].button;
        button_5_5 = button_structure_2[5][5].button;
        button_5_6 = button_structure_2[5][6].button;
        button_5_7 = button_structure_2[5][7].button;

        button_6_0 = button_structure_2[6][0].button;
        button_6_1 = button_structure_2[6][1].button;
        button_6_2 = button_structure_2[6][2].button;
        button_6_3 = button_structure_2[6][3].button;
        button_6_4 = button_structure_2[6][4].button;
        button_6_5 = button_structure_2[6][5].button;
        button_6_6 = button_structure_2[6][6].button;
        button_6_7 = button_structure_2[6][7].button;

        button_7_0 = button_structure_2[7][0].button;
        button_7_1 = button_structure_2[7][1].button;
        button_7_2 = button_structure_2[7][2].button;
        button_7_3 = button_structure_2[7][3].button;
        button_7_4 = button_structure_2[7][4].button;
        button_7_5 = button_structure_2[7][5].button;
        button_7_6 = button_structure_2[7][6].button;
        button_7_7 = button_structure_2[7][7].button;
    }


    /**
     * function  brings the screen of the high scores
     * @param actionEvent
     * @throws IOException
     */
    public void show_scores(ActionEvent actionEvent) throws IOException
    {
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
}
