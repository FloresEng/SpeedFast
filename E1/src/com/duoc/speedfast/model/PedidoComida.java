package com.duoc.speedfast.model;

import com.duoc.speedfast.interfaces.Cancelable;
import com.duoc.speedfast.interfaces.Despachable;
import com.duoc.speedfast.interfaces.Rastreable;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un pedido de comida dentro del sistema SpeedFast.
 * Requiere que el repartidor cuente con mochila térmica.
 */

public class PedidoComida extends Pedido implements Cancelable, Despachable, Rastreable {

    protected String mochilaTermica;
    protected double tiempoEntrega = 0;
    private List<String> log = new ArrayList<>();

    /**
     * Crea un pedido de comida
     * @param mochilaTermica indica si el repartidor cuenta con mochila térmica o no.
     * @param direccionEntrega
     * @param distanciaKm
     * @param tipoPedido
     */
    public PedidoComida (String mochilaTermica, String direccionEntrega, double distanciaKm, String tipoPedido){
        super(direccionEntrega, distanciaKm, tipoPedido);
        this.mochilaTermica = mochilaTermica;
        log.add("Pedido "+idPedido+" registrado en el sistema.");
    }

    /**
     * Valida que repartidor cuenta con mochila térmica o no.
     */
    public boolean tieneMochilaTermica(){
        return mochilaTermica.equalsIgnoreCase("si");
    }

    @Override
    public boolean sePuedeProcesar() {
        if (!tieneMochilaTermica()){
            System.out.println("ERROR: No contamos con repartidores con mochila térmica en estos momentos.");
            log.add("Pedido rechazado por no satisfacer necesidad de mochila térmica");
            return false;
        }
        return true;
    }

    //sobreescritura
    @Override
    public void asignarRepartidor() {
        System.out.println("Repartidor asignado correctamente. Su pedido "+ idPedido +" está siendo retirado.");
    }
    //sobrecarga
    @Override
    public void asignarRepartidor(String nombreRepartidor){
        System.out.println(nombreRepartidor + " se encargará de su pedido. ¡Nos vemos pronto!");
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

    @Override
    public void cancelar() {
        if (!tieneMochilaTermica()){
            log.add("Pedido "+idPedido+" cancelado por no contar con mochila térmica");
        }else{
            log.add("Usuario solicita cancelar pedido "+idPedido+" por error en el pedido.");
        }

    }

    @Override
    public void despachar(boolean listo) {
        if (!tieneMochilaTermica()){
            log.add("ERROR: No podemos realizar envío de pedido "+idPedido+" sin mochila térmica");
            return;
        }
        if (!listo){
            log.add("Nuestro repartidor está retirando tu pedido...¡En cuanto lo reciba partimos!");
        }else{
            log.add("¿Tienes hambre? El pedido va en camino a "+direccionEntrega);
        }
    }

    @Override
    public List<String> verHistorial() {
        return new ArrayList<>(log);
    }
}
