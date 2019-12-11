import java.util.ArrayList;

public class ExceptionDuplicat extends Exception {
    public ExceptionDuplicat(String msg){
        super(msg);
    }
    static void comprobarDuplicat (ArrayList<Bombeta> lista, Bombeta b) throws ExceptionDuplicat{
        boolean duplicat=lista.contains(b);
        if (duplicat==true){
            throw new ExceptionDuplicat("ELEMENT DUPLICAT "+b.toString());
        }
    }
}
