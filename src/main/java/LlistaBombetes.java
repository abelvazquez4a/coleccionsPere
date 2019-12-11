import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


public class LlistaBombetes implements Iterable <Bombeta>{
   private ArrayList<Bombeta> listaBombetas=new ArrayList<>();


    public ArrayList<Bombeta> getListaBombetas() {
        return listaBombetas;
    }

    public  void addBombeta(Bombeta b){
       try {
           ExceptionDuplicat.comprobarDuplicat(listaBombetas,b);
           listaBombetas.add(b);
       } catch (ExceptionDuplicat exceptionDuplicat) {
           exceptionDuplicat.printStackTrace();
       }
   }
   public  void mostrarBombetes(){
       for (Bombeta bombeta:listaBombetas) {
           System.out.println(bombeta);
       }
   }
   public void ordenarBombetes(){
       Collections.sort(listaBombetas);
   }
   public void ordenarBombetesPerNom(){
       Collections.sort(listaBombetas,new AlfabeticComparator());
   }
   public void ordenarBombetesPerData(){
       Collections.sort(listaBombetas,new Comparator<Bombeta>(){
           @Override
           public int compare(Bombeta o1, Bombeta o2) {
               return (o2.getData().compareTo(o1.getData()));
           }
       });
   }

    public Iterator<Bombeta> iteradorPerValor(double minVal){

       return new Iterator<Bombeta>() {
           int index=0;
           @Override
           public boolean hasNext() {
               boolean trobat=false;
               while (index<listaBombetas.size()&&!trobat){
                  if (listaBombetas.get(index).getValor()>=minVal)trobat=true;
                  else index++;
                  }
               return trobat;
               }
           @Override
           public Bombeta next() {
               index++;
               return listaBombetas.get((index)-1);
           }
       };
    }

    @Override
    public Iterator<Bombeta> iterator() {
        return listaBombetas.iterator();
    }

}
