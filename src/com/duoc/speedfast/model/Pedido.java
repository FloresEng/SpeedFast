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
   protected double distanciaKm;
   protected String tipoPedido;


    public Pedido(String direccionEntrega, double distanciaKm, String tipoPedido){
        this.idPedido = UUID.randomUUID();
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
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

    /**
     * Método para imprimir un resumen del pedido
     */
    public void mostrarResumen(){
        System.out.println("\nResumen de Pedido");
        System.out.println("ID pedido: "+idPedido
        +"\nTipo de pedido: "+tipoPedido
        +"\nDirección de entrega: "+direccionEntrega
        +"\nDistancia: "+distanciaKm+"KM.");
    }

    /**
     * método para calcular el tiempo estimado de entrega
     * @return tiempoEntrega
     */
    public abstract double calcularTiempoEntrega();
}
