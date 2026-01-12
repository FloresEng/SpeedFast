package com.duoc.speedfast.model;

/**
 * Representa un pedido express dentro del sistema SpeedFast.
 * Prioriza el tiempo de entrega, asignando el repartidor más cercano.
 */

public class PedidoExpress extends Pedido{

    protected int tiempoPedido;

    public PedidoExpress(int tiempoPedido, String direccionPedido, String tipoPedido){
        super(direccionPedido, tipoPedido);
        this.tiempoPedido = tiempoPedido;
    }
    //sobreescritura
    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido "+ idPedido +" con entrega en "+tiempoPedido+" min. Buscando a repartidor más cercano...");
    }
    //sobrecarga
    public void asignarRepartidor(String nombreRepartidor){
        System.out.println("Pedido Express asignado a "+nombreRepartidor+". Nos vemos en pronto!");
    }

}
