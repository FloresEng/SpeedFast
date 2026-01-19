package com.duoc.speedfast.model;

/**
 * Representa una encomienda dentro del sistema SpeedFast.
 * Valida el peso del pedido antes de asignar un repartidor.
 */

public class PedidoEncomienda extends Pedido{

    protected int pesoPedido;
    protected String tipoVehiculo = "";
    protected double tiempoEntrega = 0;

    public PedidoEncomienda (int pesoPedido, String direccionPedido, double distanciaKm, String tipoPedido){
        super(direccionPedido, distanciaKm, tipoPedido);
        this.pesoPedido = pesoPedido;
    }

    /**
     * Verifica si el peso del pedido está dentro de los márgenes soportados por
     * los vehículos disponibles en la empresa.
     * Se cambia método a boolean para que no falle sin importar a qué método se llame primero
    */
    public boolean cumpleCapacidad(){

        if (pesoPedido <= 10){
            tipoVehiculo = "Bicicleta/Motocicleta";
            return true;
        }else if (pesoPedido > 10 && pesoPedido < 200){
            tipoVehiculo = "Automóvil";
            return true;
        }else{
            System.out.println("Peso de pedido ("+pesoPedido+"Kg) es mayor a la capacidad de nuestros vehículos (200Kg).\nPrefiera otro medio de transporte, lamentamos las molestias.");
            return false;
        }
    }

    @Override
    public void asignarRepartidor() {
        if (!cumpleCapacidad()){
            return;
        }
        System.out.println("Su encomienda será entregada por un repartidor con " +tipoVehiculo+ " debido al peso ("+pesoPedido+"Kg)");
    }

    public void asignarRepartidor(String nombreRepartidor){
        if (!cumpleCapacidad()){
            return;
        }
        System.out.println("Encomienda "+idPedido +" a cargo de " +nombreRepartidor+ ". Te avisaremos cuando llegue al destino!");
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
}
