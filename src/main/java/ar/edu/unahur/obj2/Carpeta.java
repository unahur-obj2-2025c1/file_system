package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carpeta implements IElemento {

    private List<IElemento> elementos = new ArrayList<>();
    private String nombre;

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    public Carpeta(String nombre, List<IElemento> elementos) {
        this.nombre = nombre;
        this.elementos = elementos;
    }

    public void agregarElemento(IElemento elemento) {
        this.elementos.add(elemento);
    }

    public void clear() {
        elementos.clear();
    }

    public String nombre() {
        return this.nombre;
    }

    @Override
    public Integer tamanio() {
        return elementos.stream().mapToInt(IElemento::tamanio).sum();
    }

    @Override
    public void mostrar(Integer identacion) {
        System.out.println(" ".repeat(identacion) + "└ " + this.nombre() + " ( " + this.tamanio() + "-Bytes )");
        elementos.stream().forEach(e -> e.mostrar(identacion + 3));
    }

    @Override
    public IElemento archivoMasPesado() {
        return elementos.stream()
                .map(IElemento::archivoMasPesado) // para cada elemento pedimos su archivo más pesado
                .max(Comparator.comparingInt(IElemento::tamanio)) // buscamos el más pesado de todos
                .orElse(null); // si no hay ninguno, devolvemos null
    }

}
