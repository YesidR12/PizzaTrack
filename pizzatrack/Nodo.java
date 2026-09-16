package pizzatrack;

/** Nodo enlazado que guarda una pizza y apunta al nodo anterior de la pila. */
class Nodo {
    Pizza pizza;
    Nodo siguiente;

    Nodo(Pizza pizza, Nodo siguiente) {
        this.pizza = pizza;
        this.siguiente = siguiente;
    }
}

