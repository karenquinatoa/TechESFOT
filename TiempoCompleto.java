package TechESFOT;

public class TiempoCompleto extends Empleados {
    private double bono;

    public TiempoCompleto(String codigo, String nombre, String apellido, String cargo, double sueldoBase, double bono) {
        super(codigo, nombre, apellido, cargo, sueldoBase);
        this.bono = bono;
    }

    public double getBono() {
        return bono;
    }

    @Override
    public double sueldoCompleto() {
        return super.sueldoCompleto() + bono;
    }

    @Override
    public String toString() {
        return "[Tiempo Completo] " + super.toString() + ", Bono: $" + String.format("%.2f", bono);
    }
}