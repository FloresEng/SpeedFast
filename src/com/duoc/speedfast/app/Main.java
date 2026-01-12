package com.duoc.speedfast.app;

import com.duoc.speedfast.model.Pedido;
import com.duoc.speedfast.model.PedidoComida;
import com.duoc.speedfast.model.PedidoEncomienda;
import com.duoc.speedfast.model.PedidoExpress;

/**
 * Clase principal del sistema SpeedFast.
 * Permite probar la creación de distintos tipos pedidos
 * y asignar repartidores.
 */

public class Main {
    public static void main(String[] args) {

        Pedido n1 = new PedidoComida("si", "Juan de Barros 3664, Quinta Normal.", "Comida");

        System.out.println("\n--- Pedido de Comida de SpeedFast ---");
        n1.asignarRepartidor();
        n1.asignarRepartidor("Javier Flores");

        Pedido n2 = new PedidoEncomienda(550,"Emilio Vaisse 770, Ñuñoa.", "encomienda");
        System.out.println("\n--- Encomienda de SpeedFast ---");
        n2.asignarRepartidor();

        Pedido n4 = new PedidoEncomienda(8, "Fresia Oliva 780, Lo Prado.", "Encomienda");
        System.out.println("\n--- Encomienda de SpeedFast ---");
        n4.asignarRepartidor();
        n4.asignarRepartidor("Mirsa Castillo");

        Pedido n3 = new PedidoExpress(60, "Martinez de Rosas 2428, Quinta Normal.", "Express");
        System.out.println("\n--- Pedido Express de SpeedFast ---");
        n3.asignarRepartidor();
        n3.asignarRepartidor("Yasmina Soriano");
    }
}