package com.duoc.speedfast.model;

/**
 * Representa una encomienda dentro del sistema SpeedFast.
 * Valida el peso del pedido antes de asignar un repartidor.
 */

public class PedidoEncomienda extends Pedido{

    protected int pesoPedido;
    protected boolean pesoValido;
    protected String tipoVehiculo = "";

    public PedidoEncomienda (int pesoPedido, String direccionPedido, String tipoPedido){
        super(direccionPedido, tipoPedido);
        this.pesoPedido = pesoPedido;
    }

    /**
     * Verifica si el peso del pedido está dentro de los márgenes soportados por
     * los vehículos disponibles en la empresa.
     */
    public void cumpleCapacidad(){
        if (pesoPedido <= 10){
            pesoValido = true;
            tipoVehiculo = "Bicicleta/Motocicleta";
        } else if (pesoPedido > 10 && pesoPedido < 500) {
            pesoValido = true;
            tipoVehiculo = "Automovil";
        }else{
            pesoValido = false;
            System.out.println("Peso de pedido ("+pesoPedido+"Kg) es mayor a la capacidad de nuestros vehículos (500Kg).\nPrefiera otro medio de transporte, lamentamos las molestias.");
        }
    }

    @Override
    public void asignarRepartidor() {
        cumpleCapacidad();
        if (!pesoValido){
            return;
        }
        System.out.println("Su encomienda será entregada por un repartidor con " +tipoVehiculo+ " debido al peso ("+pesoPedido+"Kg)");
    }

    public void asignarRepartidor(String nombreRepartidor){
        if (!pesoValido){
            return;
        }
        System.out.println("Encomienda "+idPedido +" a cargo de " +nombreRepartidor+ ". Te avisaremos cuando llegue al destino!");
    }
}
