package Ships;

import com.sun.deploy.security.SelectableSecurityManager;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        /*
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                //System.out.print(""+i+":"+j+"\t\t");
                System.out.println((new Random()).nextInt(7)%5);
                //System.out.println("button_"+i+"_"+j+" = button_structure_1["+i+"]["+j+"].button;");
                //System.out.println("button_structure_1["+i+"]["+j+"].set_button(button_"+i+"_"+j+");");
            }
            System.out.println();
        }

         */
        /*
        int input;
        String data = "";
        FileReader fileReader = new FileReader("src/input/input_1.txt");
        int number = 0;
        int i=0;
        while ( (input=fileReader.read()) != -1)
        {
            if(i++==0)
                number = input-48;
            else
                data+= (char)input;
        }
        System.out.print(number);
        System.out.println();
        String[] array = (data.split(";"));
        for(int h=0; h< array.length; h++)
        {
            System.out.println(h+" "+array[h]+" ");
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

             */

        int input = 0;
        String data = "";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/input/input_1.txt");
        } catch (FileNotFoundException e)
        {
            //alert = new Alert(Alert.AlertType.ERROR, "Player 1 has won", ButtonType.OK);
            //alert.showAndWait();
        }
        int number = 0;
        int i=0;

        while (true)
        {
            assert fileReader != null;
            try {
                if (!((input=fileReader.read()) != -1)) break;
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            if(i++==0)
                number = input-48;
            else
                data+= (char)input;
        }
        System.out.print(number);
        System.out.println();
        String[] array = (data.split(";"));
        for(int h=0; h< array.length; h++)
        {
            System.out.println(h+" "+array[h]+" ");
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

    }


}
