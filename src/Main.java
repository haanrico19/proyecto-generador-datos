import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            generarReportes();
            System.out.println("✅ Reportes generados exitosamente en la carpeta 'data/'.");
        } catch (Exception e) {
            System.out.println("❌ Error al generar los reportes: " + e.getMessage());
        }
    }

    public static void generarReportes() throws IOException {
        Map<Integer, String> vendedores = leerVendedores("data/vendedores.txt");
        Map<Integer, String> productos = new HashMap<>();
        Map<Integer, Integer> precios = new HashMap<>();
        leerProductos("data/productos.txt", productos, precios);

        Map<Integer, Integer> ventasPorVendedor = new HashMap<>();
        Map<Integer, Integer> ventasPorProducto = new HashMap<>();
        Map<Integer, Double> totalPorVendedor = new HashMap<>();
        Map<Integer, Double> totalPorProducto = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/ventas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int idVendedor = Integer.parseInt(partes[0]);
                int idProducto = Integer.parseInt(partes[1]);
                int cantidad = Integer.parseInt(partes[2]);

                double total = precios.get(idProducto) * cantidad;

                ventasPorVendedor.put(idVendedor, ventasPorVendedor.getOrDefault(idVendedor, 0) + cantidad);
                totalPorVendedor.put(idVendedor, totalPorVendedor.getOrDefault(idVendedor, 0.0) + total);

                ventasPorProducto.put(idProducto, ventasPorProducto.getOrDefault(idProducto, 0) + cantidad);
                totalPorProducto.put(idProducto, totalPorProducto.getOrDefault(idProducto, 0.0) + total);
            }
        }

        try (FileWriter fw = new FileWriter("data/reporte_vendedores.txt")) {
            fw.write("=== REPORTE DE VENTAS POR VENDEDOR ===\n");
            for (int id : vendedores.keySet()) {
                fw.write(vendedores.get(id) + ": " +
                    ventasPorVendedor.getOrDefault(id, 0) + " productos vendidos, Total $" +
                    totalPorVendedor.getOrDefault(id, 0.0) + "\n");
            }
        }

        try (FileWriter fw = new FileWriter("data/reporte_productos.txt")) {
            fw.write("=== REPORTE DE VENTAS POR PRODUCTO ===\n");
            for (int id : productos.keySet()) {
                fw.write(productos.get(id) + ": " +
                    ventasPorProducto.getOrDefault(id, 0) + " unidades vendidas, Total $" +
                    totalPorProducto.getOrDefault(id, 0.0) + "\n");
            }
        }
    }

    public static Map<Integer, String> leerVendedores(String ruta) throws IOException {
        Map<Integer, String> mapa = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                mapa.put(Integer.parseInt(partes[0]), partes[1]);
            }
        }
        return mapa;
    }

    public static void leerProductos(String ruta, Map<Integer, String> productos, Map<Integer, Integer> precios) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                productos.put(Integer.parseInt(partes[0]), partes[1]);
                precios.put(Integer.parseInt(partes[0]), Integer.parseInt(partes[2]));
            }
        }
    }
}
