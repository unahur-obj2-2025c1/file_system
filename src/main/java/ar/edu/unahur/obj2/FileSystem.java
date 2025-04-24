package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FileSystem {

    private List<IElemento> elementos = new ArrayList<>();

    public void agrearElemento(IElemento elemento) {
        elementos.add(elemento);
    }

    public void listar() {
        AtomicInteger index = new AtomicInteger(0);
        elementos.stream().forEach(e -> {
            e.mostrar(index.getAndIncrement());
        });
    }

    public Integer tamanio() {
        return elementos.stream()
                .mapToInt(IElemento::tamanio)
                .max().orElse(0);
    }

    public IElemento archivoMasPesado() {
        return elementos.stream()
                .map(IElemento::archivoMasPesado) // cada elemento devuelve su archivo más pesado
                .max(Comparator.comparingInt(IElemento::tamanio))
                .orElse(null);
    }

}
