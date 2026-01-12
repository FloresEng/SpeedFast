# Proyecto SpeedFast - Evaluación Formativa 1 S1

## Autor del Proyecto
- **Nombre:** Javier Flores Soriano.
- **Sección:** 003A
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## Descripción del Proyecto
El proyecto SpeedFast es una aplicación Java que permite crear distintos tipos de pedidos (comida, encomienda o express) y asignarles un repartidor que cumpla con las necesidades del pedido. Utiliza programación orientada a objetos, herencia, polimorfismo, sobreescritura y sobrecarga.

## Estructura del Proyecto

```plaintext
📁src/
 └──  📁com.duoc
       ├──  📁model
       │     ├── Pedido.java
       │     ├── PedidoComida.java
       │     ├── PedidoEncomienda.java
       │     └── PedidoExpress.java
       └──  📁app
             └── Main.java
      
````

### **Model**
- **Pedido**: Superclase abstraca que permite crear un pedido genérico con identificador único.

- **PedidoComida**: Subclase que extiende Pedido. Permite crear un pedido de comida y asignarle un repartidor que cuente con mochila térmica.

- **PedidoEncomienda**: Subclase que extiende Pedido. Permite crear una encomienda y asignarle un repartidor que cuente con un vehiculo capaz que transportar el peso del pedido.

- **PedidoExpress**: Subclase que extiende Pedido. Permite crear un pedido rápido que prioriza el tiempo de entrega. Asigna al repartidor más cerca disponible.

### **UI**
**Main**
Ejecutable que permite crear las instancias de distintos pedidos y asignarles un repartidos correspondiente a las necesidades del pedido.

## 🖥 Ejemplo de salida por Interfaz Grafica

<img width="949" height="428" alt="imagen" src="https://github.com/user-attachments/assets/4f7fa08d-db5a-4737-adeb-c01c63ea9e00" />

## Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:
   
```bash
git clone https://github.com/FloresEng/SpeedFast.git
```
2. Abre el proyecto en IntelliJ IDEA.

3. Verifica que los archivos `.txt` estén correctamente ubicados.

4. Ejecuta el archivo `Main.java` desde el paquete `App`.

5. Sigue las instrucciones en consola o en la interfaz gráfica (si corresponde).


---

**Repositorio GitHub:** \[https://github.com/FloresEng/SpeedFast.git]
**Fecha de entrega:** \[12/01/2026]

---




