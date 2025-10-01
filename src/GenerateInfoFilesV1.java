import java.io.*;
import java.util.*;

public class GenerateInfoFilesV1 {

    private static final String[] FIRST_NAMES = {"Carlos", "Ana", "Luis", "Maria", "Pedro", "Laura", "Juan", "Sofia"};
    private static final String[] LAST_NAMES = {"Gomez", "Rodriguez", "Lopez", "Martinez", "Garcia", "Perez", "Sanchez"};
    private static final String[] PRODUCT_NAMES = {"Laptop", "Mouse", "Teclado", "Monitor", "Impresora", "Tablet", "Smartphone"};
    private static final String[] DOC_TYPES = {"CC", "CE", "TI", "PP"};

    public static void main(String[] args) {
        try {
            // Generar archivos de prueba
            createProductsFile(10);
            createSalesManInfoFile(5);

            // Generar archivos de ventas para cada vendedor
            for (int i = 1; i <= 5; i++) {
                String name = "Vendedor" + i;
                long id = 1000000000L + i;
                createSalesMenFile(20, name, id);
            }

            System.out.println("Archivos generados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al generar archivos: " + e.getMessage());
        }
    }

    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        String filename = "sales_" + name + "_" + id + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("CC;" + id);
            Random random = new Random();
            for (int i = 0; i < randomSalesCount; i++) {
                int productId = random.nextInt(10) + 1;
                int quantity = random.nextInt(10) + 1;
                writer.println(productId + ";" + quantity);
            }
        }
    }

    public static void createProductsFile(int productsCount) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("products.txt"))) {
            Random random = new Random();
            for (int i = 1; i <= productsCount; i++) {
                String productName = PRODUCT_NAMES[random.nextInt(PRODUCT_NAMES.length)];
                double price = 50 + random.nextDouble() * 950;
                writer.println(i + ";" + productName + ";" + String.format("%.2f", price));
            }
        }
    }

    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("salesmen_info.txt"))) {
            Random random = new Random();
            for (int i = 1; i <= salesmanCount; i++) {
                String docType = DOC_TYPES[random.nextInt(DOC_TYPES.length)];
                long docNumber = 1000000000L + i;
                String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
                String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
                writer.println(docType + ";" + docNumber + ";" + firstName + ";" + lastName);
            }
        }
    }
}
