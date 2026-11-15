package TechESFOT;

public class MedioTiempo extends Empleados {

    private int horasTrabajadas;
    private double pagoPorHora;

    public MedioTiempo(String codigo, String nombre, String apellido, String cargo, int horasTrabajadas, double pagoPorHora) {
        super(codigo, nombre, apellido, cargo, 0);
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getPagoPorHora() {
        return pagoPorHora;
    }

    @Override
    public double sueldoCompleto() {
        return horasTrabajadas * pagoPorHora;
    }

    @Override
    public String toString() {
        return "[Medio Tiempo] " + super.toString() + ", Horas: " + horasTrabajadas + ", Pago/Hora: $" + String.format("%.2f", pagoPorHora);
    }
}