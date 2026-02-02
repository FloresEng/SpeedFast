package speedfast.interfaces;

import java.util.List;

/**
 * Define el comportamiento para consultar el historial
 * de eventos asociados a un pedido.
 */

public interface Rastreable {

    /**
     * Retorna el historial de eventos del pedido
     * @return lista de mensajes que representan el hostial de pedido.
     */
    List<String> verHistorial();
}
