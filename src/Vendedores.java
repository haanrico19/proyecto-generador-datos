public class Vendedores {
    public static void main(String[] args) {
        String[] nombresVendedores = {"ALEJANDRA", "JOSE CAMILO"};
        String[] apellidosVendedores = {"PEREZ PULIDO", "AGUILAR CASTILLO", "PUENTES HERNANDEZ"};
        String[] tipoDocumentos = {"CC", "CC", "CC"};
        String[] numeroDocumentos = {"1030692024", "1015045823", "1012526428"};

        int[] idsProductos = {101, 102, 103};
        int[][] cantidadesProductos = { {32,28,15}, {5,15,9}, {20,2,3} };
        double[] preciosProductos = {32000000, 42000000, 56000000};
        String[] nombresProductos = {"MOTO", "CARRO", "VEHICULO"};

        double[] ventasTotalesPorVendedor = new double[nombresVendedores.length];

        for (int i = 0; i < nombresVendedores.length; i++) {
            for (int j = 0; j < nombresProductos.length; j++) {
                ventasTotalesPorVendedor[i] += cantidadesProductos[i][j] * preciosProductos[j];
            }
        }

        int indiceVendedorMasVentas = 0;
        for (int i = 1; i < ventasTotalesPorVendedor.length; i++) {
            if (ventasTotalesPorVendedor[i] > ventasTotalesPorVendedor[indiceVendedorMasVentas]) {
                indiceVendedorMasVentas = i;
            }
        }

        System.out.println("El vendedor que recaudó más dinero es:");
        System.out.println("Nombre: " + nombresVendedores[indiceVendedorMasVentas]);
        System.out.println("Apellido: " + apellidosVendedores[indiceVendedorMasVentas]);
        System.out.println("Tipo de Documento: " + tipoDocumentos[indiceVendedorMasVentas]);
        System.out.println("Número de Documento: " + numeroDocumentos[indiceVendedorMasVentas]);
        System.out.println("Total Recaudado: " + ventasTotalesPorVendedor[indiceVendedorMasVentas]);
    }
}
