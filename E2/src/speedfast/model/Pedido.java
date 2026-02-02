package speedfast.model;

import speedfast.interfaces.Cancelable;
import speedfast.interfaces.Despachable;
import speedfast.interfaces.Rastreable;

import java.util.UUID;

/**
 * Clase abstracta que representa un pedido genérico dentro del sistema SpeedFast.
 * Cada pedido genera de manera automática un identificador único mediante {@link UUID}.
 * Define el flujo general de procesamiento mediante el patron Template Method.
 *
 */
public abstract class Pedido implements Despachable, Cancelable, Rastreable {

   protected UUID idPedido;
   protected String direccionEntrega;
   protected double distanciaKm;
   protected String tipoPedido;

    /**
     * Crea un pedido con los datos básicos requeridos.
     * @param direccionEntrega dirección destino del pedido.
     * @param distanciaKm distancia del lugar de retiro al lugar de entrega.
     * @param tipoPedido tipo de pedido.
     */


    public Pedido(String direccionEntrega, double distanciaKm, String tipoPedido){
        this.idPedido = UUID.randomUUID();
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.tipoPedido = tipoPedido;
    }

    /**
     * Procesa el pedido siguiendo un flujo común de validación.
     * Cálculo de tiempo, resumen y asignación de repartidor.
     */
    public final void procesarPedido(){

        if (!sePuedeProcesar()){
            System.out.println("Lamentamos las molestias.");
            return;
        }
        calcularTiempoEntrega();
        mostrarResumen();
    }

    /**
     * Verifica si el pedido cumple con los requisitos para ser procesado.
     * @return true si puede ser procesado, false en caso contrario.
     */
    public boolean sePuedeProcesar(){
        return true;
    }

    /**
     * Muestra resumen del pedido por consola.
     */
    public void mostrarResumen(){
        System.out.println("\nResumen de Pedido\n"+"Tipo de pedido: "+tipoPedido.toUpperCase()+"\nID pedido: "+idPedido+
        "\nDirección de entrega: "+direccionEntrega
        +"\nDistancia: "+distanciaKm+"KM.");
    }

    /**
     * Calcula el tiempo estimado de entrega del pedido.
     * @return tiempoEntrega en minutos.
     */
    public abstract double calcularTiempoEntrega();
}
