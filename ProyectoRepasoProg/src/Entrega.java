/**
 *
 * @author Hydra
 */
public class Entrega {
    private int numeroEntrega;
    private double kilosAceituna;
    private double rendimiento;

    public Entrega(int numeroEntrega, double kilosAceituna, double rendimiento) {
        this.numeroEntrega = numeroEntrega;
        this.kilosAceituna = kilosAceituna;
        this.rendimiento = rendimiento;
    }

    // Getters y setters
    public int getNumeroEntrega() {
        return numeroEntrega;
    }

    public void setNumeroEntrega(int numeroEntrega) {
        this.numeroEntrega = numeroEntrega;
    }

    public double getKilosAceituna() {
        return kilosAceituna;
    }

    public void setKilosAceituna(double kilosAceituna) {
        this.kilosAceituna = kilosAceituna;
    }

    public double getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(double rendimiento) {
        this.rendimiento = rendimiento;
    }

    // Método para calcular los litros de aceite generados
    public double calcularLitrosAceite() {
        return kilosAceituna * rendimiento;
    }

    // Método toString para imprimir la información de la entrega
    @Override
    public String toString() {
        return "Entrega [Número de entrega=" + numeroEntrega + ", Kilos de aceituna=" + kilosAceituna +
                ", Rendimiento=" + rendimiento + "]";
    }
}
