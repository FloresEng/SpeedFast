package com.duoc.speedfast.model;

import com.duoc.speedfast.interfaces.Cancelable;
import com.duoc.speedfast.interfaces.Despachable;
import com.duoc.speedfast.interfaces.Rastreable;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una encomienda dentro del sistema SpeedFast.
 * Valida el peso del pedido antes de asignar un repartidor.
 */

public class PedidoEncomienda extends Pedido implements Cancelable, Despachable, Rastreable {

    protected int pesoPedido;
    protected String tipoVehiculo = "";
    protected double tiempoEntrega = 0;
    private List<String> log = new ArrayList<>();

    /**
     * Crea una encomienda.
     * @param pesoPedido para validar si cumple con el peso.
     * @param direccionEntrega
     * @param distanciaKm
     * @param tipoPedido
     */
    public PedidoEncomienda (int pesoPedido, String direccionEntrega, double distanciaKm, String tipoPedido){
        super(direccionEntrega, distanciaKm, tipoPedido);
        this.pesoPedido = pesoPedido;
        log.add("Encomienda "+idPedido+" registrada en el sistema.");
    }

    /**
     * Verifica si el peso del pedido está dentro de los márgenes soportados por
     * los vehículos disponibles en la empresa.
     * Se cambia retorno a boolean para que no falle sin importar a qué metodo se llame primero.
    */
    public boolean cumpleCapacidad(){

        if (pesoPedido <= 10){
            tipoVehiculo = "Bicicleta/Motocicleta";
            return true;
        }else if (pesoPedido > 10 && pesoPedido <= 200){
            tipoVehiculo = "Automóvil";
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean sePuedeProcesar() {
        if (!cumpleCapacidad()){
            System.out.println("ERROR: El peso de encomienda ("+pesoPedido+"Kg) excede el límite de peso permitido (200Kg).");
            log.add("Encomienda rechazada por exceso de peso.");
            return false;
        }
        return true;
    }

    @Override
    public double calcularTiempoEntrega() {
        tiempoEntrega = 20 + (1.5 * distanciaKm);
        //se aproxima hacia arriba para tener mayor margen de entrega y no caer en incumplimiento
        tiempoEntrega = (int) Math.ceil(tiempoEntrega);
        return tiempoEntrega;
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tiempo de entrega estimado: "+tiempoEntrega+" minutos.");
    }

    @Override
    public void cancelar() {

        if (!cumpleCapacidad()){
            log.add("Encomienda " + idPedido + " es cancelada por no cumplir con el peso permitido.");

        } else{
            log.add("Se intenta cancelar encomienda "+idPedido+" por solicitud del usuario.");
        }
    }

    @Override
    public void despachar(boolean listo) {
        if (!cumpleCapacidad()) {
            log.add("ERROR: Imposible despachar encomienda " + idPedido + " ya que supera el peso permitido ("+pesoPedido+"Kg)");
            return;
        }
            if (!listo){
                log.add("Encomienda "+idPedido+" aún no está lista para ser despachada.");

            }else{
                log.add("Encomienda "+idPedido+" se encuentra en camino a "+direccionEntrega);
        }

    }
    @Override
    public void asignarRepartidor() {
        if (cumpleCapacidad()){
            System.out.println("Su encomienda será entregada por un repartidor con " +tipoVehiculo+ " debido al peso ("+pesoPedido+"Kg)");
        }else{
            System.out.println("ERROR: No se puede asignar repartidor ya que la encomienda supera capacidad de nuestra flota");
        }

    }
    @Override
    public void asignarRepartidor(String nombreRepartidor){
        if (!cumpleCapacidad()){
            return;
        }
        System.out.println("Encomienda "+idPedido +" a cargo de " +nombreRepartidor+ ". ¡Te avisaremos cuando llegue al destino!");
    }

    @Override
    public List<String> verHistorial() {
        return new ArrayList<>(log);
    }
}
