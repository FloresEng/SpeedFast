package speedfast.model;

import java.util.List;
import java.util.Random;

/**
 * Clase que representa un repartidor dentro del sistema de SpeedFast.
 * Implementa interfaz Runnable para que funcione de manera concurrente con varios repartidores.
 */

public class Repartidor implements Runnable{

    private String nombre;
    private List<Pedido> pedidos;
    private Random random = new Random();

    public Repartidor(String nombre, List<Pedido> pedidos){
        this.nombre = nombre;
        this.pedidos = pedidos;
    }

    /**
     * Metodo que permite que cada repartidor trabaje de manera independiente
     */
    @Override
    public void run() {

        System.out.println("\nPedidos a repartir de ["+nombre+"]"+pedidos.size());

        for (Pedido pedido : pedidos){
            try{
                System.out.println("\nProcesando pedido "+pedido.idPedido+"...");
                pedido.procesarPedido();

                System.out.println("\n["+nombre+"] Se encuentra en camino a "+pedido.direccionEntrega);

                int tiempoViaje = random.nextInt(3000) + 1000;
                Thread.sleep(tiempoViaje);

                pedido.despachar(true);
                System.out.println("\n¡Ding Dong! ["+nombre+"] Entregó el pedido "+pedido.idPedido+" en "+pedido.direccionEntrega);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("\nEntrega de ["+nombre+"] interrumpida por inconvenientes en el camino.");
                break;
            }
        }
        System.out.println("\n["+nombre+"] Ha finalizado sus entregas.");
    }

}
