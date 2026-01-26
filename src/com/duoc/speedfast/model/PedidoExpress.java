package com.duoc.speedfast.model;

import com.duoc.speedfast.interfaces.Cancelable;
import com.duoc.speedfast.interfaces.Despachable;
import com.duoc.speedfast.interfaces.Rastreable;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un pedido express dentro del sistema SpeedFast.
 * Valida que la distancia no supere el máximo para ser considerado express.
 */

public class PedidoExpress extends Pedido implements Cancelable, Despachable, Rastreable {

    protected double tiempoEntrega = 0;
    private List<String> log = new ArrayList<>();

    /**
     * Crea un pedido express.
     * @param direccionPedido
     * @param distanciaKm
     * @param tipoPedido
     */
    public PedidoExpress(String direccionPedido, double distanciaKm, String tipoPedido){
        super(direccionPedido, distanciaKm, tipoPedido);
        log.add("Pedido Express "+idPedido+" registrado correctamente en el sistema.");
    }
    //sobreescritura
    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido "+ idPedido +" con distancia de entrega de "+distanciaKm+"Km. Buscando a repartidor más cercano...");
    }
    //sobrecarga
    public void asignarRepartidor(String nombreRepartidor){
        System.out.println("Pedido Express asignado a "+nombreRepartidor+". ¡Nos vemos en pronto!");
    }

    /**
     * Valida que distanciaKm no supere el límite para ser aceptado como express.
     * @return true si cumple con el requisito, false de lo contrario.
     */
    public boolean limiteDistancia(){
        if (distanciaKm > 10){
            return false;
        }
        return true;
    }

    @Override
    public boolean sePuedeProcesar() {
        if (!limiteDistancia()){
            System.out.println("ERROR: Distancia de pedido supera el límite para ser considerado express ("+distanciaKm+"Km). Prefiera otro método de envío.");
            log.add("Pedido express cancelado, eliminando registro...");
            return false;
        }
        return true;
    }

    @Override
    public double calcularTiempoEntrega() {
        if (distanciaKm <= 5){
            tiempoEntrega = 10;
        }else if (distanciaKm > 5 && distanciaKm <= 10){
            tiempoEntrega = 15;
        }
        return tiempoEntrega;
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tiempo de entrega estimado: "+tiempoEntrega+" minutos.");
    }

    @Override
    public void cancelar() {
        if (!limiteDistancia()){
            log.add("Pedido "+idPedido+" cancelado por superar distancia permitida para ser express ("+distanciaKm+").");
        }else{
            log.add("Usuario solicita cancelar pedido "+idPedido+" por error de solicitud.");
        }
    }

    @Override
    public void despachar(boolean listo) {
        if (!limiteDistancia()){
            log.add("ERROR: Se cancela pedido "+idPedido+" debido a distancia no permitida.");
            return;
        }
        if (!listo){
            log.add("Estamos preparando tu pedido express. ¡Nos vemos en nada!");
        }else{
            log.add("¡Como el Rayo Mcqueen! Vamos en camino a "+direccionEntrega);
        }
    }

    @Override
    public List<String> verHistorial() {
        return new ArrayList<>(log);
    }
}
