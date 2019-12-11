import java.util.Comparator;

public class AlfabeticComparator implements Comparator <Bombeta> {
    @Override
    public int compare(Bombeta o1, Bombeta o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
