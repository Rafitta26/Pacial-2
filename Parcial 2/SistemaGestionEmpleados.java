import java.util.Scanner; 

public class SistemaGestionEmpleados {

    /**
     * Aplicación principal que usa la clase Empleados para gestionar la plantilla.
     * La lógica de gestión (array, altas, aumento y listado) se ha movido a la clase Empleados.
     */
    public static void main(String[] args) {
        Empleados empleados = new Empleados(Constantes.CAPACIDAD_DEFAULT);

        // Dar de alta los tres empleados usando los cargos definidos en Cargos (se pasa label si Empleado usa String)
        empleados.darAlta(new Empleado("Juan", Cargos.DESARROLLADOR.getLabel(), 50000));
        empleados.darAlta(new Empleado("María", Cargos.DISEÑADORA.getLabel(), 45000));
        empleados.darAlta(new Empleado("Pedro", Cargos.GERENTE.getLabel(), 60000));

        Scanner scanner = new Scanner(System.in);
        System.out.print(Constantes.PROMPT_PORCENTAJE);
        double porcentaje = scanner.nextDouble();

        empleados.aumentarSalario(porcentaje);
        empleados.mostrarListado();

        scanner.close();
    }
}

/**
 * Gestión de la colección de empleados.
 * Contiene el array 'lista' (no 'empleados') y métodos para alta, aumento y listado.
 */
class Empleados {
    public Empleado[] lista;

    public Empleados(int capacidad) {
        this.lista = new Empleado[capacidad];
    }

    /**
     * Da de alta un empleado en la primera posición libre.
     * @param e empleado a añadir
     * @return true si se añadió, false si no hay espacio
     */
    public boolean darAlta(Empleado e) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = e;
                return true;
            }
        }
        return false;
    }

    /**
     * Aumenta el salario de todos los empleados no nulos en el porcentaje indicado.
     * @param porcentaje porcentaje (ej. 10 para 10%)
     */
    public void aumentarSalario(double porcentaje) {
        for (Empleado emp : lista) {
            if (emp != null) {
                double nuevoSalario = emp.getSalario() * (1 + porcentaje / 100.0);
                emp.setSalario(nuevoSalario);
            }
        }
    }

    /**
     * Muestra por consola el listado de empleados.
     */
    public void mostrarListado() {
        System.out.println(Constantes.LISTA_EMPLEADOS);
        for (Empleado emp : lista) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }
}

/**
 * Enum con los cargos profesionales válidos.
 */
enum Cargos {
    DESARROLLADOR("Desarrollador"),
    DISEÑADORA("Diseñadora"),
    GERENTE("Gerente");

    private final String label;
    Cargos(String label) { this.label = label; }
    public String getLabel() { return label; }

    public static Cargos fromLabel(String label) {
        if (label == null) return null;
        for (Cargos c : values()) {
            if (c.label.equalsIgnoreCase(label.trim())) return c;
        }
        return null;
    }
}

/**
 * Constantes con textos y números usados en la aplicación para evitar magic strings/numbers.
 */
final class Constantes {
    private Constantes() {}

    public static final int CAPACIDAD_DEFAULT = 3;
    public static final String PROMPT_PORCENTAJE = "Introduzca el porcentaje de aumento de salario: ";
    public static final String LISTA_EMPLEADOS = "Lista de empleados:";
}
