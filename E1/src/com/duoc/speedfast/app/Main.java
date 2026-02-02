package com.duoc.speedfast.app;

import com.duoc.speedfast.model.Pedido;
import com.duoc.speedfast.model.PedidoComida;
import com.duoc.speedfast.model.PedidoEncomienda;
import com.duoc.speedfast.model.PedidoExpress;


/**
 * Clase principal del sistema SpeedFast.
 * Permite probar la creación de distintos tipos pedidos,
 * probar los métodos e interfaces.
 */

public class Main {
    public static void main(String[] args) {

        //Instancia de pedidos que cumplen los requisitos
        Pedido comida1 = new PedidoComida("si", "Juan de Barros 3664, Quinta Normal.", 3.6, "Comida");
        Pedido encomienda1 = new PedidoEncomienda(45, "Fresia Oliva 780, Lo Prado.", 5.9, "Encomienda");
        Pedido express1 = new PedidoExpress("Compañía de Jesús 2428, Santiago Centro.", 8, "Express");

        System.out.println("\n==== PEDIDOS QUE CUMPLEN REQUISITOS DE ENVÍO ====");

        //Template Method
        System.out.println("\n--- PROCESANDO PEDIDOS ---");
        comida1.procesarPedido();
        //Asignación manual de repartidor (Sobrecarga)
        comida1.asignarRepartidor("Javier");
        encomienda1.procesarPedido();
        //Asignación manual de repartidor (Sobrecarga)
        encomienda1.asignarRepartidor("Gabo");
        express1.procesarPedido();
        //Asignación manual de repartidor (Sobrecarga)
        express1.asignarRepartidor("Lucas");

        //Uso de interfaces
        System.out.println("\n--- ESTADO DE PEDIDOS ---\n");
        comida1.despachar(true);
        comida1.cancelar();
        comida1.verHistorial().forEach(System.out::println);
        System.out.println();

        encomienda1.despachar(false);
        encomienda1.cancelar();
        encomienda1.verHistorial().forEach(System.out::println);
        System.out.println();

        express1.despachar(true);
        express1.cancelar();
        express1.verHistorial().forEach(System.out::println);

        System.out.println("\n==== PEDIDOS QUE NO CUMPLEN REQUISITOS DE ENVÍO ====");

        Pedido comida2 = new PedidoComida("no", "Juan de Barros 3664, Quinta Normal.", 3.6, "Comida");
        Pedido encomienda2 = new PedidoEncomienda(356, "Emilio Vaisse 770, Ñuñoa", 6.3, "Encomienda");
        Pedido express2 = new PedidoExpress("Compañía de Jesús 672, Santiago Centro", 12, "Express");

        //Template Method y uso de interfaces
        System.out.println("\n--- PROCESANDO Y ESTADO DE PEDIDOS ---\n");
        System.out.println("Pedido de Comida:");
        comida2.procesarPedido();
        comida2.despachar(true);
        comida2.verHistorial().forEach(System.out::println);
        System.out.println();

        System.out.println("Pedido de Encomienda:");
        encomienda2.procesarPedido();
        encomienda2.despachar(true);
        encomienda2.verHistorial().forEach(System.out::println);
        System.out.println();

        System.out.println("Pedido Express:");
        express2.procesarPedido();
        express2.despachar(true);
        express2.verHistorial().forEach(System.out::println);

    }
}