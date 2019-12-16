import java.time.LocalDate;

public class Bombeta implements Comparable<Bombeta> {
    private String nombre;
    private int valor;
    private LocalDate data;


    @Override
    public int hashCode() {
        return this.nombre.hashCode()*this.valor*this.data.hashCode();
    }

    public boolean esIgual (Bombeta b){
        boolean esIgual=false;
        if (this.hashCode()==b.hashCode()){
            esIgual=equals(b);
        }
        return esIgual;
    }

    @Override
    public boolean equals(Object o) {
        Bombeta b = (Bombeta)o;
        //el equals mirara si tienen el mismo nombre, el mismo valor y la misma data para decir que son iguales, si alguno de los valores no coincide, dará false, y por lo tanto
        // dirá que son diferentes.
        if (b.getNombre().equals(nombre)&&b.getValor()==valor&&b.getData().equals(data)) return true;
        else return false;
    }

    public Bombeta(int valor, String nombre, LocalDate data) {
        this.data=data;
        this.nombre=nombre;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Bombeta{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }

    @Override
    public int compareTo(Bombeta o) {
        int resultado = 0;
        if (this.valor<o.valor) resultado=1;
        else if (this.valor>o.valor)resultado=-1;
        return resultado;
    }
}
