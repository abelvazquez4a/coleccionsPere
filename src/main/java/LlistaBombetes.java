import java.util.*;


public class LlistaBombetes<E extends Comparable<E>> implements Iterable <E>{
   private ArrayList<E> listaBombetas=new ArrayList<>();


    public ArrayList<E> getListaBombetas() {
        return listaBombetas;
    }

    public  void addBombeta(E b){
       try {
           comprobarDuplicat(listaBombetas,b);
           listaBombetas.add(b);
       } catch (ExceptionDuplicat exceptionDuplicat) {
           exceptionDuplicat.printStackTrace();
       }
   }
   public  void mostrarBombetes(){
       for (E bombeta:listaBombetas) {
           System.out.println(bombeta);
       }
   }
   public void ordenarBombetes(){
        Collections.sort(listaBombetas);
   }
   public void ordenarBombetesPerNom(){
       Collections.sort(listaBombetas,new Comparator<E>(){
           @Override
           public int compare(E o1, E o2) {
               return (o2.getNom().compareTo(o1.getNom()));
           }
       });
   }
   public void ordenarBombetesPerData(){
       Collections.sort(listaBombetas,new Comparator<E>(){
           @Override
           public int compare(E o1, E o2) {
               return (o2.getData().compareTo(o1.getData()));
           }
       });
   }

    public Iterator<E> iteradorPerValor(double minVal){

       return new Iterator<E>() {
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
           public E next() {
               index++;
               return listaBombetas.get((index)-1);
           }
       };
    }

    @Override
    public Iterator<E> iterator() {
        return listaBombetas.iterator();
    }
    public void comprobarDuplicat (ArrayList<E> lista, E b) throws ExceptionDuplicat{
        boolean duplicat=lista.contains(b);
        if (duplicat==true){
            throw new ExceptionDuplicat("ELEMENT DUPLICAT "+b.toString());
        }
    }
}
