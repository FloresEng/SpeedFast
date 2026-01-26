package com.duoc.speedfast.interfaces;

/**
 * Define el comportamiento de despacho de un pedido.
 */
public interface Despachable {

    /**
     * Ejecuta despacho del pedido según su estado
     * @param listo indica si el pedido se encuentra listo para ser enviado
     */
    void despachar(boolean listo);
}
