package pizzatrack;

/* Pila manual usando una lista enlazada simple para gestionar las pizzas. */
public class Pila {
    private Nodo tope;
    private int tamanio;

    /* Inserta una pizza en el tope y actualiza el enlace principal. */
    public void push(Pizza pizza) {
        if (pizza == null) {
            throw new IllegalArgumentException("No se puede apilar una pizza nula.");
        }

        // El nuevo nodo queda adelante y conserva el antiguo tope como siguiente.
        tope = new Nodo(pizza, tope);
        tamanio++;
    }

    /* Retira y devuelve la pizza que ocupa el tope. */
    public Pizza pop() {
        if (isEmpty()) {
            return null;
        }

        Pizza pizza = tope.pizza;
        // Avanzar el tope desconecta el nodo retirado de la lista ligada.
        tope = tope.siguiente;
        tamanio--;
        return pizza;
    }

    /* Consulta el tope sin modificar la lista. */
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.pizza;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public int size() {
        return tamanio;
    }

    /* Elimina todos los nodos de la pila. */
    public void clear() {
        tope = null;
        tamanio = 0;
    }
}