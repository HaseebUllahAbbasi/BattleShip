package Ships;

public class BattleShip implements Ship
{
     int size = 4;

    @Override
    public int get_size() {
        return size;
    }

    @Override
    public boolean decrease_size() {
        if(size>0)
        {
            size--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BattleShip{" +
                "size=" + size +
                '}';
    }
}
