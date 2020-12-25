package Ships;

public class SubMarine implements Ship
{
    int size = 3;

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
        return "SubMarine{" +
                "size=" + size +
                '}';
    }
}
