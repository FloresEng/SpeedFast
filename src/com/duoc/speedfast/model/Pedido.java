package com.duoc.speedfast.model;

import java.util.UUID;

/**
 * Clase abstracta que representa un pedido genérico dentro del sistema SpeedFast.
 * Cada pedido genera de manera automática un identificador único mediante {@link java.util.UUID}.
 *
 */
public abstract class Pedido {

   protected UUID idPedido;
   protected String direccionEntrega;
   protected String tipoPedido;


    public Pedido(String direccionEntrega, String tipoPedido){
        this.idPedido = UUID.randomUUID();
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }

    /**
     * Asigna un repartidor al pedido según las necesidades específicas de cada tipo de pedido
     */
    public abstract void asignarRepartidor();

    /**
     * Asigna un repartidor al pedido indicando específicamente su nombre.
     * @param nombreRepartidor
     */
    public abstract void asignarRepartidor(String nombreRepartidor);

}
