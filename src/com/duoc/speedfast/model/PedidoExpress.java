package com.duoc.speedfast.model;

/**
 * Representa un pedido express dentro del sistema SpeedFast.
 * Prioriza el tiempo de entrega, asignando el repartidor más cercano.
 */

public class PedidoExpress extends Pedido{

    protected int tiempoSolicitado;
    protected double tiempoEntrega;

    public PedidoExpress(int tiempoSolicitado, String direccionPedido, double distanciaKm, String tipoPedido){
        super(direccionPedido, distanciaKm, tipoPedido);
        this.tiempoSolicitado = tiempoSolicitado;
    }
    //sobreescritura
    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido "+ idPedido +" con solicitud de entrega en "+tiempoSolicitado+" min. Buscando a repartidor más cercano...");
    }
    //sobrecarga
    public void asignarRepartidor(String nombreRepartidor){
        System.out.println("Pedido Express asignado a "+nombreRepartidor+". Nos vemos en pronto!");
    }

    @Override
    public double calcularTiempoEntrega() {
        if (distanciaKm > 5){
            tiempoEntrega = 15;
        }else{
            tiempoEntrega = 10;
        }
        return tiempoEntrega;
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tiempo de entrega estimado: "+tiempoEntrega+" minutos.");
    }
}
