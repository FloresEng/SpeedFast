package com.duoc.speedfast.model;

/**
 * Representa un pedido de comida dentro del sistema SpeedFast.
 * Valida si el repartidor cuenta con mochila térmica antes de asignarlo.
 */

public class PedidoComida extends Pedido{

    protected String mochilaTermica;
    protected double tiempoEntrega = 0;


    public PedidoComida (String mochilaTermica, String direccionEntrega, double distanciaKm, String tipoPedido){
        super(direccionEntrega, distanciaKm, tipoPedido);
        this.mochilaTermica = mochilaTermica;
    }

    /**
     * Verifica si repartidor cuenta con mochila térmica o no.
     */
    public void tieneMochilaTermica(){
        if (mochilaTermica.equalsIgnoreCase("si")){
            System.out.println("\nVerificando si repartidor cuenta con mochila térmica para su pedido...");
        }else{
            System.out.println("\nRepartidor no cuenta con mochila térmica para su pedido. Buscando a otro...");
        }
    }
    //sobreescritura
    @Override
    public void asignarRepartidor() {
        tieneMochilaTermica();
        System.out.println("Repartidor asignado correctamente. Su pedido "+ idPedido +" está en camino!");
    }
    //sobrecarga
    public void asignarRepartidor(String nombreRepartidor){
        System.out.println("\nPrepara la mesa! " + nombreRepartidor + " lleva su comida lista para servir.");
    }

    @Override
    public double calcularTiempoEntrega() {
        tiempoEntrega = 15 + (2 * distanciaKm);
        //se aproxima hacia arriba para tener mayor margen de entrega y no caer en incumplimiento
        tiempoEntrega = (int) Math.ceil(tiempoEntrega);
        return tiempoEntrega;
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: "+tiempoEntrega+" minutos.");
    }
}
