import java.io.*;
import java.util.*;

public class GenerateInfoFilesV2 {

    private static final Random random = new Random();

    public static void main(String[] args) {
        try {
            int productsCount = 15;
            int salesmenCount = 8;
            int salesPerSalesman = 25;
            generateTestFiles(productsCount, salesmenCount, salesPerSalesman);
            System.out.println("Todos los archivos fueron generados exitosamente!");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void generateTestFiles(int productsCount, int salesmenCount, int salesPerSalesman) throws IOException {
        List<Product> products = createProductsFile(productsCount);
        List<Salesman> salesmen = createSalesManInfoFile(salesmenCount);
        for (Salesman salesman : salesmen) {
            createSalesMenFile(salesPerSalesman, salesman, products);
        }
    }

    public static void createSalesMenFile(int randomSalesCount, Salesman salesman, List<Product> products) throws IOException {
        String filename = String.format("ventas_%s_%d.txt", salesman.getLastName().toLowerCase(), salesman.getDocNumber());
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(salesman.getDocType() + ";" + salesman.getDocNumber());
            for (int i = 0; i < randomSalesCount; i++) {
                Product product = products.get(random.nextInt(products.size()));
                int quantity = 1 + random.nextInt(15);
                writer.println(product.getId() + ";" + quantity);
            }
        }
    }

    public static List<Product> createProductsFile(int productsCount) throws IOException {
        List<Product> products = new ArrayList<>();
        String[] productCategories = {"Electrónico", "Oficina", "Hogar", "Tecnología"};
        String[] productBrands = {"Samsung", "Apple", "LG", "Sony", "HP", "Dell"};
        try (PrintWriter writer = new PrintWriter(new FileWriter("productos.txt"))) {
            for (int i = 1; i <= productsCount; i++) {
                String category = productCategories[random.nextInt(productCategories.length)];
                String brand = productBrands[random.nextInt(productBrands.length)];
                String productName = brand + " " + category + " " + i;
                double price = 100 + random.nextDouble() * 900;
                Product product = new Product(i, productName, price);
                products.add(product);
                writer.println(i + ";" + productName + ";" + String.format("%.2f", price));
            }
        }
        return products;
    }

    public static List<Salesman> createSalesManInfoFile(int salesmanCount) throws IOException {
        List<Salesman> salesmen = new ArrayList<>();
        String[] firstNames = {"Andrés", "Beatriz", "Camilo", "Diana", "Esteban", "Fernanda", "Gabriel", "Helena"};
        String[] lastNames = {"Ramírez", "Vargas", "Silva", "Mendoza", "Ortega", "Navarro", "Rojas", "Castro"};
        String[] docTypes = {"CC", "CE", "TI", "PP"};
        try (PrintWriter writer = new PrintWriter(new FileWriter("informacion_vendedores.txt"))) {
            for (int i = 1; i <= salesmanCount; i++) {
                String docType = docTypes[random.nextInt(docTypes.length)];
                long docNumber = 1000000000L + i;
                String firstName = firstNames[random.nextInt(firstNames.length)];
                String lastName = lastNames[random.nextInt(lastNames.length)];
                Salesman salesman = new Salesman(docType, docNumber, firstName, lastName);
                salesmen.add(salesman);
                writer.println(docType + ";" + docNumber + ";" + firstName + ";" + lastName);
            }
        }
        return salesmen;
    }

    static class Product {
        private int id;
        private String name;
        private double price;
        public Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
    }

    static class Salesman {
        private String docType;
        private long docNumber;
        private String firstName;
        private String lastName;
        public Salesman(String docType, long docNumber, String firstName, String lastName) {
            this.docType = docType;
            this.docNumber = docNumber;
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public String getDocType() { return docType; }
        public long getDocNumber() { return docNumber; }
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
    }
}
