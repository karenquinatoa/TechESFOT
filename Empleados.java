package TechESFOT;

public class Empleados {
    private String codigo;
    private String nombre;
    private String apellido;
    private String cargo;
    private double sueldoBase;

    public Empleados(String codigo, String nombre, String apellido, String cargo, double sueldoBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.sueldoBase = sueldoBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public double sueldoCompleto() {
        return sueldoBase;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + " " + apellido + ", Cargo: " + cargo + ", Sueldo total: $" + String.format("%.2f", sueldoCompleto());
    }
}