// ===============================================================
// Archivo: GenerateInfoFiles.java
// Proyecto: Generador de Datos
// Autor: Andres Rivas
// Materia: Conceptos Fundamentales de la Programación
// Descripción:
//   Esta clase contiene los métodos necesarios para generar
//   archivos de texto con información simulada sobre:
//   - Productos
//   - Vendedores
//   - Ventas
//   También genera reportes básicos en base a los datos creados.
// ===============================================================

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    // Instancia del generador aleatorio
    private Random random = new Random();

    // ===============================================================
    // Método: generarProductos
    // Descripción:
    //   Crea un archivo "productos.txt" con una lista de 10 productos.
    // ===============================================================
    public void generarProductos() {
        String[] nombres = {
            "Laptop", "Mouse", "Teclado", "Monitor", "Impresora",
            "Auriculares", "Micrófono", "Tablet", "Smartphone", "Webcam"
        };

        try (FileWriter writer = new FileWriter("data/productos.txt")) {
            writer.write("ID\tNombre\t\tPrecio\n");
            writer.write("-----------------------------------\n");

            for (int i = 0; i < nombres.length; i++) {
                int id = i + 1;
                double precio = 50 + (500 * random.nextDouble());
                writer.write(id + "\t" + nombres[i] + "\t\t$" + String.format("%.2f", precio) + "\n");
            }

            System.out.println("✅ Archivo 'productos.txt' generado correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al generar el archivo de productos: " + e.getMessage());
        }
    }

    // ===============================================================
    // Método: generarVendedores
    // Descripción:
    //   Crea un archivo "vendedores.txt" con 10 vendedores ficticios.
    // ===============================================================
    public void generarVendedores() {
        String[] nombres = {
            "Carlos Pérez", "María Gómez", "José Ramírez", "Lucía Torres", "Andrés Rivera",
            "Elena Díaz", "Pablo López", "Camila Herrera", "Sofía Castro", "David Ruiz"
        };

        try (FileWriter writer = new FileWriter("data/vendedores.txt")) {
            writer.write("ID\tNombre\t\tVentas Totales\n");
            writer.write("-----------------------------------\n");

            for (int i = 0; i < nombres.length; i++) {
                int id = i + 1;
                int ventasTotales = random.nextInt(100);
                writer.write(id + "\t" + nombres[i] + "\t\t" + ventasTotales + "\n");
            }

            System.out.println("✅ Archivo 'vendedores.txt' generado correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al generar el archivo de vendedores: " + e.getMessage());
        }
    }

    // ===============================================================
    // Método: generarVentas
    // Descripción:
    //   Crea un archivo "ventas.txt" con ventas aleatorias
    //   asociando productos y vendedores.
    // ===============================================================
    public void generarVentas() {
        try (FileWriter writer = new FileWriter("data/ventas.txt")) {
            writer.write("ID Venta\tID Producto\tID Vendedor\tMonto\n");
            writer.write("------------------------------------------------------\n");

            for (int i = 0; i < 20; i++) {
                int idVenta = i + 1;
                int idProducto = random.nextInt(10) + 1;
                int idVendedor = random.nextInt(10) + 1;
                double monto = 100 + (1000 * random.nextDouble());
                writer.write(idVenta + "\t" + idProducto + "\t\t" + idVendedor + "\t\t$" + String.format("%.2f", monto) + "\n");
            }

            System.out.println("✅ Archivo 'ventas.txt' generado correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al generar el archivo de ventas: " + e.getMessage());
        }
    }

    // ===============================================================
    // Método: generarReportes
    // Descripción:
    //   Crea reportes básicos en base a los archivos de datos generados.
    // ===============================================================
    public void generarReportes() {
        try (FileWriter writer = new FileWriter("data/reporte_productos.txt")) {
            writer.write("REPORTE DE PRODUCTOS\n");
            writer.write("=====================\n");
            writer.write("Este archivo contiene el listado general de productos generados.\n\n");
            writer.write("Total de productos: 10\n");
        } catch (IOException e) {
            System.out.println("❌ Error al generar 'reporte_productos.txt': " + e.getMessage());
        }

        try (FileWriter writer = new FileWriter("data/reporte_vendedores.txt")) {
            writer.write("REPORTE DE VENDEDORES\n");
            writer.write("======================\n");
            writer.write("Este archivo contiene el listado general de vendedores generados.\n\n");
            writer.write("Total de vendedores: 10\n");
        } catch (IOException e) {
            System.out.println("❌ Error al generar 'reporte_vendedores.txt': " + e.getMessage());
        }

        System.out.println("✅ Archivos de reporte generados correctamente.");
    }
}
