import java.util.*;


public class ContenidorCollecionables<E extends Comparable<E>& InterfaceDataAlfabetic> implements Iterable <E>{
   private ArrayList<E> listaColeccionables =new ArrayList<>();


    public ArrayList<E> getListaColeccionables() {
        return listaColeccionables;
    }

    public  void addColeccionable(E b){
       try {
           comprobarDuplicat(listaColeccionables,b);
           listaColeccionables.add(b);
       } catch (ExceptionDuplicat exceptionDuplicat) {
           exceptionDuplicat.printStackTrace();
       }
   }
   public  void mostrarColeccionables(){
       for (E bombeta: listaColeccionables) {
           System.out.println(bombeta);
       }
   }
   public void ordenarColeccionables(){
        Collections.sort(listaColeccionables);
   }
   public void ordenarColeccionablesPerNom(){
       Collections.sort(listaColeccionables,new Comparator<E>(){
           @Override
           public int compare(E o1, E o2) {
               return (o2.getGenericAlfabetic().compareTo(o1.getGenericAlfabetic()));
           }
       });
   }
   public void ordenarColeccionablesPerData(){
       Collections.sort(listaColeccionables,new Comparator<E>(){
           @Override
           public int compare(E o1, E o2) {
               return (o2.getGenericData().compareTo(o1.getGenericData()));
           }
       });
   }

    public Iterator<E> iteradorPerValor(double minVal){

       return new Iterator<E>() {
           int index=0;
           @Override
           public boolean hasNext() {
               boolean trobat=false;
               while (index< listaColeccionables.size()&&!trobat){
                  if (listaColeccionables.get(index).getGenericValor()>=minVal)trobat=true;
                  else index++;
                  }
               return trobat;
               }
           @Override
           public E next() {
               index++;
               return listaColeccionables.get((index)-1);
           }
       };
    }

    @Override
    public Iterator<E> iterator() {
        return listaColeccionables.iterator();
    }
    public void comprobarDuplicat (ArrayList<E> lista, E b) throws ExceptionDuplicat{
        boolean duplicat=lista.contains(b);
        if (duplicat==true){
            throw new ExceptionDuplicat("ELEMENT DUPLICAT "+b.toString());
        }
    }
}
