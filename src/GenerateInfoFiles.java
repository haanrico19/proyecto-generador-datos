import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    public static void main(String[] args) {
        try {
            generarArchivos();
            System.out.println("✅ Archivos generados exitosamente en la carpeta 'data/'.");
        } catch (Exception e) {
            System.out.println("❌ Error al generar los archivos: " + e.getMessage());
        }
    }

    public static void generarArchivos() throws IOException {
        Random random = new Random();

        // Crear carpeta de datos si no existe
        java.io.File carpeta = new java.io.File("data");
        if (!carpeta.exists()) carpeta.mkdir();

        // ==== PRODUCTOS ====
        String[] nombresProductos = {
            "Café", "Azúcar", "Leche", "Pan", "Queso",
            "Arroz", "Aceite", "Huevos", "Jabón", "Harina"
        };

        try (FileWriter fw = new FileWriter("data/productos.txt")) {
            for (int i = 0; i < nombresProductos.length; i++) {
                int precio = 1000 + random.nextInt(9000);
                fw.write((i + 1) + "," + nombresProductos[i] + "," + precio + "\n");
            }
        }

        // ==== VENDEDORES ====
        String[] nombresVendedores = {
            "Juan Pérez", "María Gómez", "Pedro Ruiz", "Ana Torres", "Luis Rodríguez"
        };

        try (FileWriter fw = new FileWriter("data/vendedores.txt")) {
            for (int i = 0; i < nombresVendedores.length; i++) {
                fw.write((i + 1) + "," + nombresVendedores[i] + "\n");
            }
        }

        // ==== VENTAS ====
        try (FileWriter fw = new FileWriter("data/ventas.txt")) {
            for (int i = 0; i < 50; i++) {
                int idVendedor = 1 + random.nextInt(nombresVendedores.length);
                int idProducto = 1 + random.nextInt(nombresProductos.length);
                int cantidad = 1 + random.nextInt(10);
                fw.write(idVendedor + "," + idProducto + "," + cantidad + "\n");
            }
        }
    }
}
