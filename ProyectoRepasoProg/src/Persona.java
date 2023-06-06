/**
 *
 * @author Hydra
 */
public class Persona extends Cliente {
    private String NIF;
    private String nombre;
    private String apellidos;
    private String direccion;
    private double IRPF;

    public Persona(int numeroCliente, String NIF, String nombre, String apellidos, String direccion, double IRPF) {
        super(numeroCliente);
        this.NIF = NIF;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.IRPF = IRPF;
    }

    // Getter y setter del NIF
    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    // Getter y setter del nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter de los apellidos
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Getter y setter de la dirección
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Getter y setter del IRPF
    public double getIRPF() {
        return IRPF;
    }

    public void setIRPF(double IRPF) {
        this.IRPF = IRPF;
    }

    // Implementación del método abstracto generarFactura
    @Override
   public double generarFactura(double precioLitroAceite) {
        double totalEntregas = 0.0;
        
        for (Entrega entrega : entregas) {
            totalEntregas += entrega.calcularLitrosAceite();
        }

        double cantidadIRPF = totalEntregas * IRPF;
        double totalPagar = totalEntregas - cantidadIRPF;

        return totalPagar;
    }

    // Método toString para imprimir la información de la persona
    @Override
    public String toString() {
        return "Persona [Número de cliente=" + getNumeroCliente() + ", NIF=" + NIF + ", Nombre=" + nombre +
                ", Apellidos=" + apellidos + ", Dirección=" + direccion + ", IRPF=" + IRPF +
                ", Entregas=" + getEntregas() + "]";
    }
}
