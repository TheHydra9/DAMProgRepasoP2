/**
 * Código creado por Discord: Hydra#0998.
 * Puedes preguntar cualquier duda a mi discord.
 * La finalidad de este código es el repaso de los temas 6-9 de la asignatura de Programación DAM.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame {

    private static Almazara clientesAlmazara = new Almazara(2.5); // Crear una instancia de Almazara

    public Main() {
        setTitle("Almazara App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("---- MENÚ ----");
            System.out.println("1. Nuevo");
            System.out.println("2. Registrar Entrega");
            System.out.println("3. Mostrar cliente");
            System.out.println("4. Generar factura");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearNuevoCliente();
                    break;
                case 2:
                    registrarEntrega();
                    break;
                case 3:
                    mostrarCliente();
                    break;
                case 4:
                    generarFactura();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }

    private static void crearNuevoCliente() {
        Scanner scanner = new Scanner(System.in);
        int tipoCliente;

        System.out.println("---- Nuevo Cliente ----");
        System.out.println("Seleccione el tipo de cliente:");
        System.out.println("1. Persona");
        System.out.println("2. Empresa");
        System.out.print("Ingrese una opción: ");
        tipoCliente = scanner.nextInt();

        if (tipoCliente == 1) {
            crearNuevaPersona();
        } else if (tipoCliente == 2) {
            crearNuevaEmpresa();
        } else {
            System.out.println("Opción inválida. No se pudo crear el cliente.");
        }
    }

    private static void crearNuevaPersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Nueva Persona ----");

        System.out.print("Ingrese el NIF: ");
        String nif = scanner.nextLine();

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese los apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el IRPF: ");
        double irpf = scanner.nextDouble();

        Persona persona = new Persona(clientesAlmazara.getClientesAlmazara().size() + 1, nif, nombre, apellidos, direccion, irpf);
        clientesAlmazara.agregarCliente(persona);

        System.out.println("Persona creada y agregada a la Almazara.");
    }

    private static void crearNuevaEmpresa() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Nueva Empresa ----");
        System.out.print("Ingrese el número de cliente: ");
        int numeroCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el CIF: ");
        String cif = scanner.nextLine();

        System.out.print("Ingrese la denominación: ");
        String denominacion = scanner.nextLine();

        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el IVA: ");
        double iva = scanner.nextDouble();

        Empresa empresa = new Empresa(numeroCliente, cif, denominacion, direccion, iva);
        clientesAlmazara.agregarCliente(empresa);

        System.out.println("Empresa creada y agregada a la Almazara.");
    }

    private static void registrarEntrega() {

        Main main = new Main();
        main.setVisible(true);
        System.out.println("---- Registrar Entrega ----");

        String numeroClienteString = JOptionPane.showInputDialog(null, "Ingrese el número de cliente:", "Registrar Entrega", JOptionPane.QUESTION_MESSAGE);
        int numeroCliente = Integer.parseInt(numeroClienteString);

        Cliente cliente = clientesAlmazara.buscarCliente(numeroCliente);

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String kilosAceitunaString = JOptionPane.showInputDialog(null, "Ingrese los kilos de aceituna:", "Registrar Entrega", JOptionPane.QUESTION_MESSAGE);
            double kilosAceituna = Double.parseDouble(kilosAceitunaString);

            String rendimientoString = JOptionPane.showInputDialog(null, "Ingrese el rendimiento:", "Registrar Entrega", JOptionPane.QUESTION_MESSAGE);
            double rendimiento = Double.parseDouble(rendimientoString);

            Entrega entrega = new Entrega(clientesAlmazara.getNumeroEntregas(), kilosAceituna, rendimiento);
            cliente.agregarEntrega(entrega);

            JOptionPane.showMessageDialog(null, "Entrega registrada exitosamente.", "Registrar Entrega", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void mostrarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Mostrar Cliente ----");
        System.out.print("Ingrese el número de cliente: ");
        int numeroCliente = scanner.nextInt();

        Cliente cliente = clientesAlmazara.buscarCliente(numeroCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
        } else {
            String clienteData = cliente.toString();
            guardarClienteEnArchivo(clienteData);
        }
    }

    private static void guardarClienteEnArchivo(String clienteData) {
        File file = new File("ClienteData.log");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, file.exists()))) {
            if (!file.exists()) {
                file.createNewFile();
            }
            writer.write(clienteData);
            writer.newLine();
            System.out.println("Datos del cliente guardados en el archivo ClienteData.log.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos del cliente en el archivo.");
        }

    }

    private static void generarFactura() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Generar Factura ----");
        System.out.print("Ingrese el número de cliente: ");
        int numeroCliente = scanner.nextInt();

        Cliente cliente = clientesAlmazara.buscarCliente(numeroCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
        } else {
            double precioLitroAceite = 2.5; // Precio ficticio del litro de aceite
            double cantidadPagar = cliente.generarFactura(precioLitroAceite);
            System.out.println("Cantidad a pagar: " + cantidadPagar);

            guardarClienteEnBaseDeDatos(cliente, cantidadPagar);
        }
    }

    private static void guardarClienteEnBaseDeDatos(Cliente cliente, double cantidadPagar) {
        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/almazara"; // Reemplaza "almazara" con el nombre de tu base de datos
        String usuario = "usuario"; // Reemplaza "usuario" con tu nombre de usuario de MySQL
        String contraseña = "password"; // Reemplaza "password" con tu contraseña de MySQL

        // Consulta SQL para crear la tabla "facturacion" si no existe
        String crearTabla = "CREATE TABLE IF NOT EXISTS facturacion (numero_cliente INT, cantidad_pagar DOUBLE)";

        // Consulta SQL para insertar los datos del cliente y su facturación
        String insertarDatos = "INSERT INTO facturacion (numero_cliente, cantidad_pagar) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña); PreparedStatement stmtCrearTabla = conn.prepareStatement(crearTabla); PreparedStatement stmtInsertarDatos = conn.prepareStatement(insertarDatos)) {
            // Crear la tabla "facturacion" si no existe
            stmtCrearTabla.executeUpdate();

            // Establecer los parámetros de la consulta para insertar los datos del cliente y su facturación
            stmtInsertarDatos.setInt(1, cliente.getNumeroCliente());
            stmtInsertarDatos.setDouble(2, cantidadPagar);

            // Ejecutar la consulta para insertar los datos del cliente y su facturación
            stmtInsertarDatos.executeUpdate();

            System.out.println("Datos del cliente guardados en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos del cliente en la base de datos: " + e.getMessage());
        }
    }
}
