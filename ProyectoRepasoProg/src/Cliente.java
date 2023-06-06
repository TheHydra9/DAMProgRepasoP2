
/**
 *
 * @author Hydra
 */
import java.util.ArrayList;

public abstract class Cliente {
    private int numeroCliente;
    protected ArrayList<Entrega> entregas;

    public Cliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
        this.entregas = new ArrayList<>();
    }

    // Getter y setter del número de cliente
    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    // Getter y setter de las entregas realizadas por el cliente
    public ArrayList<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(ArrayList<Entrega> entregas) {
        this.entregas = entregas;
    }

    // Método para agregar una entrega a la lista de entregas del cliente
    public void agregarEntrega(Entrega entrega) {
        entregas.add(entrega);
    }

    // Método abstracto para generar la factura
    public abstract double generarFactura(double precioLitroAceite);

    // Método toString para imprimir la información del cliente
    @Override
    public String toString() {
        return "Cliente [Número de cliente=" + numeroCliente + ", Entregas=" + entregas + "]";
    }
    
    
}
