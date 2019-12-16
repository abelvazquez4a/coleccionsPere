import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class GestorColeccionablesAmbSegells {
    public static void main(String[] args) {
        ContenidorCollecionables contenidorCollecionables = new ContenidorCollecionables();
        ArrayList<Segell> arraySegells= new ArrayList<>();
        //La bombeta wellinton la añadiremos dos veces para comprobar que controlamos correctamente los duplicados.
        Segell wellinton = new Segell(10,"Wellinton", LocalDate.of(2019,1,5));
        Segell antonio = new Segell(500,"Antonio", LocalDate.of(2020,1,5));
        Segell ana = new Segell(200,"Ana", LocalDate.of(2013,3,23));
        //probando la funcion "esIgual".
        System.out.println(wellinton.esIgual(new Segell(10,"Wellinton", LocalDate.of(2019,1,5))));
        arraySegells= contenidorCollecionables.getListaColeccionables();
        //La añadimos por primera vez.
        contenidorCollecionables.addColeccionable(wellinton);
        //la volvemos a añadir, aquí tiene que petar.
        contenidorCollecionables.addColeccionable(wellinton);
        //como hemos sobreescrito el equals, comprobaremos si los valores son iguales para identificar si son iguales, en este caso lo serán y por lo tanto saltará nuestra excepción.
        contenidorCollecionables.addColeccionable(new Segell (10,"Wellinton", LocalDate.of(2019,1,5)));
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
        Iterator iteratorLlistaSegells = contenidorCollecionables.iterator();
        System.out.println("\n Con hasNext()");
        while (iteratorLlistaSegells.hasNext()){
            System.out.println(iteratorLlistaSegells.next());
        }
        System.out.println("\n Con For-each");
        iteratorLlistaSegells= contenidorCollecionables.iterator();
        for (Object b: contenidorCollecionables
        ) {
            System.out.println(iteratorLlistaSegells.next());
        }
        System.out.println("\n Iterador per valor\n");
        Iterator<Bombeta> iteradorPerValorMin = contenidorCollecionables.iteradorPerValor(500.0);
        while (iteradorPerValorMin.hasNext()){
            System.out.println(iteradorPerValorMin.next());
        }
        Segell segellForaDelArray = new Segell (500,"SegellPerdud", LocalDate.of(2030,10,5));
        System.out.println("\n Probando index of\n");
        System.out.println(arraySegells.indexOf(antonio));
        System.out.println(arraySegells.indexOf(wellinton));
        System.out.println(arraySegells.indexOf(ana));
        System.out.println(arraySegells.indexOf(new Segell(10,"Wellinton", LocalDate.of(2019,1,5))));
        System.out.println(arraySegells.indexOf(segellForaDelArray));
        //Utiliza equals y no hashcode ya que no se fija en si tienen el mismo hash si no los mismos valores.
        //Hemos definido una bombeta con los mismos valores que otra que ya teniamos en el arrayList y ha dado un resultado positivo.
        //Si utilizara hashcode daría un resultado negativo ya que estos dos elementos no tienen el mismo hash.
    }
}
