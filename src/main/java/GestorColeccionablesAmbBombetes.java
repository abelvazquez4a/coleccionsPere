import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class GestorColeccionablesAmbBombetes {
    public static void main(String[] args) {
        ContenidorCollecionables contenidorCollecionables = new ContenidorCollecionables();
        ArrayList<Bombeta>arrayBombetes= new ArrayList<>();
        //La bombeta wellinton la añadiremos dos veces para comprobar que controlamos correctamente los duplicados.
        Bombeta wellinton = new Bombeta(10,"Wellinton", LocalDate.of(2019,1,5));
        Bombeta antonio = new Bombeta(500,"Antonio", LocalDate.of(2020,1,5));
        Bombeta ana = new Bombeta(200,"Ana", LocalDate.of(2013,3,23));
        //probando la funcion "esIgual".
        System.out.println(wellinton.esIgual(new Bombeta(10,"Wellinton", LocalDate.of(2019,1,5))));
        arrayBombetes= contenidorCollecionables.getListaColeccionables();
        //La añadimos por primera vez.
        contenidorCollecionables.addColeccionable(wellinton);
        //la volvemos a añadir, aquí tiene que petar.
        contenidorCollecionables.addColeccionable(wellinton);
        //como hemos sobreescrito el equals, comprobaremos si los valores son iguales para identificar si son iguales, en este caso lo serán y por lo tanto saltará nuestra excepción.
        contenidorCollecionables.addColeccionable(new Bombeta (10,"Wellinton", LocalDate.of(2019,1,5)));
        contenidorCollecionables.addColeccionable(antonio);
        contenidorCollecionables.addColeccionable(ana);
        System.out.println("\nArray original\n");
        contenidorCollecionables.mostrarColeccionables();
        contenidorCollecionables.ordenarColeccionables();
        System.out.println("\nDespués de ordenar por valor\n");
        contenidorCollecionables.mostrarColeccionables();
        System.out.println("\nDespués de ordenar alfabéticamente\n");
        contenidorCollecionables.ordenarColeccionablesPerNom();
        contenidorCollecionables.mostrarColeccionables();
        System.out.println("\nDespués de ordenar por fecha\n");
        contenidorCollecionables.ordenarColeccionablesPerData();
        contenidorCollecionables.mostrarColeccionables();
        System.out.println("\n Probando iterator\n");
        Iterator iteratorLlistaBombetes = contenidorCollecionables.iterator();
        System.out.println("\n Con hasNext()");
        while (iteratorLlistaBombetes.hasNext()){
            System.out.println(iteratorLlistaBombetes.next());
        }
        System.out.println("\n Con For-each");
        iteratorLlistaBombetes= contenidorCollecionables.iterator();
        for (Object b: contenidorCollecionables
             ) {
            System.out.println(iteratorLlistaBombetes.next());
        }
        System.out.println("\n Iterador per valor\n");
        Iterator<Bombeta> iteradorPerValorMin = contenidorCollecionables.iteradorPerValor(500.0);
        while (iteradorPerValorMin.hasNext()){
            System.out.println(iteradorPerValorMin.next());
        }
        Bombeta bombetaForaDelArray = new Bombeta (500,"bombetaPerduda", LocalDate.of(2030,10,5));
        System.out.println("\n Probando index of\n");
        System.out.println(arrayBombetes.indexOf(antonio));
        System.out.println(arrayBombetes.indexOf(wellinton));
        System.out.println(arrayBombetes.indexOf(ana));
        System.out.println(arrayBombetes.indexOf(new Bombeta(10,"Wellinton", LocalDate.of(2019,1,5))));
        System.out.println(arrayBombetes.indexOf(bombetaForaDelArray));
        //Utiliza equals y no hashcode ya que no se fija en si tienen el mismo hash si no los mismos valores.
        //Hemos definido una bombeta con los mismos valores que otra que ya teniamos en el arrayList y ha dado un resultado positivo.
        //Si utilizara hashcode daría un resultado negativo ya que estos dos elementos no tienen el mismo hash.
    }
}
