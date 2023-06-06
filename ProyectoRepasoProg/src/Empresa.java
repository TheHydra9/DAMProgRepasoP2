
/**
 *
 * @author Hydra
 */
public class Empresa extends Cliente {
    private String CIF;
    private String denominacion;
    private String direccion;
    private double IVA;

    public Empresa(int numeroCliente, String CIF, String denominacion, String direccion, double IVA) {
        super(numeroCliente);
        this.CIF = CIF;
        this.denominacion = denominacion;
        this.direccion = direccion;
        this.IVA = IVA;
    }

    // Getter y setter del CIF
    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    // Getter y setter de la denominación
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    // Getter y setter de la dirección
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Getter y setter del IVA
    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    // Implementación del método abstracto generarFactura
    @Override
    public double generarFactura(double precioLitroAceite) {
        double totalEntregas = 0.0;

        for (Entrega entrega : entregas) {
            totalEntregas += entrega.calcularLitrosAceite();
        }

        double cantidadIVA = totalEntregas * IVA;
        double totalPagar = totalEntregas + cantidadIVA;

        return totalPagar;
    }

    // Método toString para imprimir la información de la empresa
    @Override
    public String toString() {
        return "Empresa [Número de cliente=" + getNumeroCliente() + ", CIF=" + CIF + ", Denominación=" + denominacion +
                ", Dirección=" + direccion + ", IVA=" + IVA + ", Entregas=" + getEntregas() + "]";
    }
}
