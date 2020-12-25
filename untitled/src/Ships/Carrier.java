package Ships;

public class Carrier implements Ship
{
    public int size = 5;

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
        return "Carrier{" +
                "size=" + size +
                '}';
    }
}
