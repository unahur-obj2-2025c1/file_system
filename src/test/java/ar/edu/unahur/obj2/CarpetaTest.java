package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CarpetaTest {
    private Carpeta carpeta = new Carpeta("Carpeta");
    private Archivo img = new Archivo("imagen", "jpg", 250);
    private Archivo txt = new Archivo("texto", "txt", 50);
    private Carpeta root = new Carpeta("root", new ArrayList<IElemento>(Arrays.asList(img, txt)));

    @Test
    void dadaUnaCarpetaVaciaSuTamanioDebeSerCero() {
        assertEquals(0, carpeta.tamanio());
    }

    @Test
    void dadaUnaCarpetaConArchivosSuTamanioDebeIgualALaSumatorioDelTamanioDelLosArchivos() {
        assertEquals(300, root.tamanio());
    }

    @Test
    void dadaUnaCarpetaConArchivosYSubCarpetasSuTamanioDebeIgualALaSumatorioDelTamanioDelLosArchivosYSubcarpetas() {
        carpeta.agregarElemento(new Archivo("audio", "mp3", 250));
        root.agregarElemento(carpeta);
        assertEquals(550, root.tamanio());
    }
}
