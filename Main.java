package TechESFOT;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Empleados> empleados = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENÚ DE EMPLEADOS ---");
            System.out.println("1. Registrar empleado tiempo completo");
            System.out.println("2. Registrar empleado medio tiempo");
            System.out.println("3. Mostrar empleados registrados");
            System.out.println("4. Mostrar estadísticas");
            System.out.println("5. Salir");
            System.out.print("Ingrese opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) {
                System.out.print("Código: ");
                String codigo = sc.nextLine();
                if (buscarEmpleado(empleados, codigo) != null) {
                    System.out.println("El código " + codigo + " ya está registrado.");
                    continue;
                }
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Cargo: ");
                String cargo = sc.nextLine();
                System.out.print("Sueldo base: ");
                double sueldo = Double.parseDouble(sc.nextLine());
                if (sueldo < 0) {
                    System.out.println("El sueldo no puede ser negativo.");
                    continue;
                }
                System.out.print("Bono: ");
                double bono = Double.parseDouble(sc.nextLine());
                if (bono < 0) {
                    System.out.println("El bono no puede ser negativo.");
                    continue;
                }

                empleados.add(new TiempoCompleto(codigo, nombre, apellido, cargo, sueldo, bono));
                System.out.println("Empleado tiempo completo registrado exitosamente.");

            } else if (opcion == 2) {
                System.out.print("Código: ");
                String codigo = sc.nextLine();
                if (buscarEmpleado(empleados, codigo) != null) {
                    System.out.println("El código " + codigo + " ya está registrado.");
                    continue;
                }
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Cargo: ");
                String cargo = sc.nextLine();
                System.out.print("Horas trabajadas: ");
                int horas = Integer.parseInt(sc.nextLine());
                if (horas < 0) {
                    System.out.println("Las horas no pueden ser negativas.");
                    continue;
                }
                System.out.print("Pago por hora: ");
                double pago = Double.parseDouble(sc.nextLine());
                if (pago < 0) {
                    System.out.println("El pago no puede ser negativo.");
                    continue;
                }

                empleados.add(new MedioTiempo(codigo, nombre, apellido, cargo, horas, pago));
                System.out.println("Empleado medio tiempo registrado exitosamente.");

            } else if (opcion == 3) {
                if (empleados.isEmpty()) {
                    System.out.println("No hay empleados registrados.");
                    continue;
                }
                System.out.println("\n--- LISTA DE EMPLEADOS REGISTRADOS ---");
                for (Empleados e : empleados) {
                    System.out.println(e);
                }

            } else if (opcion == 4) {
                if (empleados.isEmpty()) {
                    System.out.println("No hay empleados registrados.");
                    continue;
                }

                Empleados mayor = empleados.get(0);
                double suma = 0;
                for (Empleados e : empleados) {
                    suma += e.sueldoCompleto();
                    if (e.sueldoCompleto() > mayor.sueldoCompleto()) {
                        mayor = e;
                    }
                }

                System.out.println("El empleado con mayor sueldo es: " + mayor.getNombre() + " " + mayor.getApellido() + " ($" + String.format("%.2f", mayor.sueldoCompleto()) + ")");
                System.out.printf("El promedio salarial entre todos los empleados es: $%.2f%n", (suma / empleados.size()));

            } else if (opcion == 5) {
                System.out.println("Hasta luego.");
                break;

            } else {
                System.out.println("Opción incorrecta, intente de nuevo.");
            }
        }
    }

    private static Empleados buscarEmpleado(ArrayList<Empleados> lista, String codigo) {
        for (Empleados e : lista) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                return e;
            }
        }
        return null;
    }
}