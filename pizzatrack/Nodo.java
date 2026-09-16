package pizzatrack;

/* Guardamos la pizza y el enlace al nodo anterior de la pila. */
class Nodo {
    Pizza pizza;
    Nodo siguiente;

    Nodo(Pizza pizza, Nodo siguiente) {
        this.pizza = pizza;
        this.siguiente = siguiente;
    }
}

