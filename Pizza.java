package PizzaTrack;

/** Representa un pedido de pizza con exactamente tres ingredientes. */
public class Pizza {
    private final String nombre;
    private final String[] ingredientes;

    public Pizza(String nombre, String[] ingredientes) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la pizza no puede estar vacio.");
        }
        for (int i = 0; i < nombre.length(); i++) {
            if (Character.isDigit(nombre.charAt(i))) {
                throw new IllegalArgumentException("El nombre de la pizza no puede contener numeros.");
            }
        }
        if (ingredientes == null || ingredientes.length != 3) {
            throw new IllegalArgumentException("La pizza debe tener exactamente 3 ingredientes.");
        }
        for (String ingrediente : ingredientes) {
            if (ingrediente == null || ingrediente.trim().isEmpty()) {
                throw new IllegalArgumentException("Los tres ingredientes deben tener contenido.");
            }
        }

        this.nombre = nombre.trim();
        this.ingredientes = new String[ingredientes.length];
        for (int i = 0; i < ingredientes.length; i++) {
            this.ingredientes[i] = ingredientes[i].trim();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        String[] copia = new String[ingredientes.length];
        for (int i = 0; i < ingredientes.length; i++) {
            copia[i] = ingredientes[i];
        }
        return copia;
    }

    @Override
    public String toString() {
        return nombre + " [" + ingredientes[0] + ", " + ingredientes[1] + ", " + ingredientes[2] + "]";
    }

}



