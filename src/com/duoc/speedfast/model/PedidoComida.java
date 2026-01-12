package com.duoc.speedfast.model;

/**
 * Representa un pedido de comida dentro del sistema SpeedFast.
 * Valida si el repartidor cuenta con mochila térmica antes de asignarlo.
 */

public class PedidoComida extends Pedido{

    protected String mochilaTermica;


    public PedidoComida (String mochilaTermica, String direccionEntrega, String tipoPedido){
        super(direccionEntrega, tipoPedido);
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
}
