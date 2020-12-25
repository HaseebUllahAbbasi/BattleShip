package Main;

import Ships.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;

/**
 * This Class is used to store the data for a button
 * it contains the sate of button if button is clicked or not
 * each button has any kind of ship or null state means water
 *  it checks whether the button is empty or not
 *  if not empty then destroy the part of the ship
 */

public class Button_Structure
{

    boolean touchable = true;
    Button button;
    Ship ship;
    boolean contains_ship = false;

    /**
     * it take the ship type and assign to the local to achieve functionality like
     * to destroy the part of the ship
     * @param ship
     * ship can be destroyer, submarine, battleship or carrier.
     */
    public void set_ship(Ship ship)
    {
        this.ship = ship;
    }

    /**
     * this function returns the state of the ship as assigned earlier or empty
     * @return
     */
    public boolean check()
    {
        if(ship==null)
            return false;
        return true;
    }
    void set_button(Button button)
    {
        this.button = button;
    }

    @Override
    public String toString() {
        return "Button_Structure{" +
                "touchable=" + touchable +
                ", contains_ship=" + contains_ship +
                '}'+" "+ship;
    }

    /**
     * this take button as input which is pressed and then destroy the part of the ship if not destroyed earlier
     * if destroyed then sets the color of the button according to the ship
     * @param button_1
     *
     * @return
     *returns true if changes are made otherwise false
     */
    public boolean destroy(Button button_1)
    {

        if(touchable)
        {
            touchable = false;
            if(ship.decrease_size())
            {
                if(ship instanceof Carrier)
                {
                    button_1.setStyle("-fx-background-color: pink");
                    button_1.setTextFill(Paint.valueOf("0xFAAFBE"));
                }
                if(ship instanceof BattleShip)
                {
                    button_1.setStyle("-fx-background-color: lightgreen");
                    button_1.setTextFill(Paint.valueOf("0x90ee90"));

                }
                if(ship instanceof SubMarine)
                {
                    button_1.setStyle("-fx-background-color: yellow");
                    button_1.setTextFill(Paint.valueOf("0xFFFF00"));

                }
                if(ship instanceof Destroyer)
                {
                    button_1.setStyle("-fx-background-color: white");
                    button_1.setTextFill(Paint.valueOf("0xFFFFFF"));
                }
                return true;
            }
        }
        return false;
    }
}
