package pizzatrack;

/** Coordina las pilas de pedidos activos y pedidos deshechos. */
public class GestionPedidos {
    private final Pila pedidosActivos = new Pila();
    private final Pila pedidosDeshechos = new Pila();

    /** Registra una pizza y comienza una nueva rama del historial. */
    public void registrar(Pizza pizza) {
        pedidosActivos.push(pizza);
        // Un registro nuevo invalida los redo anteriores, como en un editor.
        pedidosDeshechos.clear();
    }

    /** Mueve el pedido activo mas reciente a la pila secundaria. */
    public Pizza deshacer() {
        Pizza pizza = pedidosActivos.pop();
        if (pizza != null) {
            pedidosDeshechos.push(pizza);
        }
        return pizza;
    }

    /** Recupera el pedido deshecho mas reciente y lo vuelve a activar. */
    public Pizza rehacer() {
        Pizza pizza = pedidosDeshechos.pop();
        if (pizza != null) {
            pedidosActivos.push(pizza);
        }
        return pizza;
    }

    public Pizza pedidoActual() {
        return pedidosActivos.peek();
    }

    public boolean hayPedidosActivos() {
        return !pedidosActivos.isEmpty();
    }

    public boolean hayPedidosDeshechos() {
        return !pedidosDeshechos.isEmpty();
    }

    public int cantidadPedidosActivos() {
        return pedidosActivos.size();
    }
}

