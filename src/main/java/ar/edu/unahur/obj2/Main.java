package ar.edu.unahur.obj2;

public class Main {
    public static void main(String[] args) {
        Carpeta carpetaAN1 = new Carpeta("Carpeta A Nivel 1");
        Carpeta carpetaBN1 = new Carpeta("Carpeta B Nivel 1");
        Carpeta carpetaAN2 = new Carpeta("Carpeta A Nivel 2");
        Carpeta root = new Carpeta("root");

        Archivo file1 = new Archivo("Dibujo-A", "jpg", 250);
        Archivo file2 = new Archivo("Notas", "txt", 50);
        Archivo file3 = new Archivo("Rock", "mp3", 300);
        Archivo file4 = new Archivo("Imagen-A", "jpg", 240);
        Archivo file5 = new Archivo("Posticks", "txt", 50);
        Archivo file6 = new Archivo("Video-Parte-I", "mp4", 600);
        Archivo file7 = new Archivo("Video-Parte-II", "mp4", 680);
        Archivo file8 = new Archivo("Rap", "mp3", 300);
        Archivo file9 = new Archivo("Notas Rapidas", "txt", 120);

        carpetaAN2.agregarElemento(file9);
        carpetaAN2.agregarElemento(file8);
        carpetaBN1.agregarElemento(file7);
        carpetaBN1.agregarElemento(carpetaAN2);
        carpetaBN1.agregarElemento(file6);
        carpetaBN1.agregarElemento(file5);
        carpetaAN1.agregarElemento(file4);
        carpetaAN1.agregarElemento(file3);
        root.agregarElemento(file2);
        root.agregarElemento(file1);
        root.agregarElemento(carpetaAN1);
        root.agregarElemento(carpetaBN1);

        FileSystem fs = new FileSystem();
        fs.agrearElemento(root);
        fs.listar();
    }
}