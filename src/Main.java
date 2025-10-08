// ===============================================================
// Archivo: Main.java
// Proyecto: Generador de Datos
// Autor: Andres Rivas
// Materia: Conceptos Fundamentales de la Programación
// Descripción:
//   Clase principal que ejecuta el programa. 
//   Se encarga de invocar los métodos que generan los archivos
//   de productos, vendedores, ventas y reportes.
// ===============================================================

public class Main {

    public static void main(String[] args) {
        // Mostrar encabezado en consola
        System.out.println("==========================================");
        System.out.println("   PROYECTO: GENERADOR DE DATOS - JAVA   ");
        System.out.println("==========================================\n");

        // Crear instancia de la clase GenerateInfoFiles
        // para acceder a sus métodos
        GenerateInfoFiles generador = new GenerateInfoFiles();

        // Llamada a los métodos para generar los archivos de datos
        System.out.println("Generando archivos de información...\n");
        generador.generarProductos();
        generador.generarVendedores();
        generador.generarVentas();
        generador.generarReportes();

        // Confirmación final en consola
        System.out.println("\n✅ Archivos generados correctamente en la carpeta 'data'.");
        System.out.println("📄 Revisa los archivos 'productos.txt', 'vendedores.txt', 'ventas.txt'");
        System.out.println("   y los reportes generados dentro de la carpeta 'data'.");
    }
}
