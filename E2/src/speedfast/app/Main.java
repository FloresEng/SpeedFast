package speedfast.app;

import speedfast.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * Clase principal del sistema SpeedFast.
 * Permite probar la creación de distintos tipos pedidos,
 * probar los métodos e interfaces.
 */

public class Main {
    public static void main(String[] args) {

        //Creación de pedidos
        Pedido p1 = new PedidoComida("si", "Juan de Barros 3664, Quinta Normal.", 6.8, "Comida");
        Pedido p2 = new PedidoEncomienda(79, "Emilio Vaisse 770, Ñuñoa.", 12, "Encomienda");
        Pedido p3 = new PedidoExpress("Ejército Libertador 282, Santiago Centro", 7.2,  "Express");
        Pedido p4 = new PedidoComida("si", "Hernando de Magallanes 723, Las Condes.", 3.1, "Comida");
        Pedido p5 = new PedidoEncomienda(133, "Fresia Oliva 46, Lo Prado", 22.3, "Encomienda");
        Pedido p6 = new PedidoExpress("Juan Bautista Pastenes 289, Melipilla",  4.7, "Express");

        //Creación de listas y asignación de repartidores
        List<Pedido> listaJ = new ArrayList<>();
        listaJ.add(p1);
        listaJ.add(p2);
        Repartidor r1 = new Repartidor("Javier", listaJ);

        List<Pedido> listaL = new ArrayList<>();
        listaL.add(p3);
        listaL.add(p5);
        Repartidor r2 = new Repartidor("Lucas", listaL);

        List<Pedido> listaG = new ArrayList<>();
        listaG.add(p4);
        listaG.add(p6);
        Repartidor r3 = new Repartidor("Gabo", listaG);

        //Ejecución concurrente
        //Tenemos 3 repartidores
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("\n[INICIANDO SISTEMA DE ENTREGAS]");
        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        executor.shutdown();

        try{
            //esperamos que todos entreguen sus pedidos antes de cerrar
            if (executor.awaitTermination(5, TimeUnit.MINUTES))
            System.out.println("\nTodas las rutas han finalizado.");
        }catch (InterruptedException e){
            System.out.println("El sistema ha sido interrumpido.");
        }

    }
}