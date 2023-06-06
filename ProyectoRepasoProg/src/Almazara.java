
/**
 *
 * @author Hydra
 */
import java.util.HashSet;

public class Almazara {

    private HashSet<Cliente> clientesAlmazara;
    private double precioLitroAceite;
    private int numeroEntregas;

    public Almazara(double precioLitroAceite) {
        this.clientesAlmazara = new HashSet<>();
        this.precioLitroAceite = precioLitroAceite;
        this.numeroEntregas = 0;
    }

    // Getter y setter del precio del litro de aceite
    public double getPrecioLitroAceite() {
        return precioLitroAceite;
    }

    public void setPrecioLitroAceite(double precioLitroAceite) {
        this.precioLitroAceite = precioLitroAceite;
    }

    // Getter y setter del número de entregas
    public int getNumeroEntregas() {
        return numeroEntregas;
    }

    public void setNumeroEntregas(int numeroEntregas) {
        this.numeroEntregas = numeroEntregas;
    }

    // Método para agregar un cliente a la estructura de almacenamiento
    public void agregarCliente(Cliente cliente) {
        clientesAlmazara.add(cliente);
    }

    public HashSet<Cliente> getClientesAlmazara() {
        return clientesAlmazara;
    }

    // Método para buscar un cliente por número de cliente
    public Cliente buscarCliente(int numeroCliente) {
        for (Cliente cliente : clientesAlmazara) {
            if (cliente.getNumeroCliente() == numeroCliente) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente, se retorna null
    }

    // Método toString para imprimir la información de la almazara
    @Override
    public String toString() {
        return "Almazara [Clientes=" + clientesAlmazara + ", Precio del litro de aceite=" + precioLitroAceite
                + ", Número de entregas=" + numeroEntregas + "]";
    }
}
