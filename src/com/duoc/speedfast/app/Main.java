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

        Pedido n1 = new PedidoComida("si", "Juan de Barros 3664, Quinta Normal.", 3.6, "Comida");

        Pedido n2 = new PedidoEncomienda(120, "Fresia Oliva 780, Lo Prado.", 5.9, "Encomienda");

        Pedido n3 = new PedidoExpress(60, "Martinez de Rosas 2428, Quinta Normal.", 8, "Express");

        //impresión utilizando polimorfismo
        Pedido[] pedidos = {n1, n2, n3};

        for (Pedido p : pedidos){
            p.calcularTiempoEntrega();
            p.mostrarResumen();
            p.asignarRepartidor();
        }


    }
}