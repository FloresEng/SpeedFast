package speedfast.interfaces;

/**
 * Define el comportamiento para cancelar un pedido.
 */
public interface Cancelable {

    /**
     * Cancela el pedido según su estado actual
     */
    void cancelar();
}
