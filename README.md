# App SpeedFast - ES1 DOO II

## Autor del Proyecto
- **Nombre:** Javier Flores Soriano
- **Sección:** 003A
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## Descrpicón del Proyecto
Aplicación Java oriendata a objetos que simula la creación de distintos tipo de pedidos (Comida, Encomienda y Express) y sus distintos comportamientos según los requisitos que cumplen.
El proyecto fue desarrollado aplicando principios de POO, poliformismo, herencia, arreglos e interfaces.

## Funcionalidades Principales
- Creación de pedidos (Comida, Encomienda y Express).
- Comportamiento diferenciado.
- Historial de pedido único.

---

🛠️ Tecnologías utilizadas

- Java SE.
- POO.
- Colecciones.
- Interfaces.
- Javadoc.

## 📂 Estructura del proyecto

```plaintext
src
├── app
│   └── Main.java
├── model
│   ├── Pedido.java
│   ├── PedidoComida.java
│   ├── PedidoEncomienda.java
│   └── PedidoExpress.java
└── interfaces
     ├── Cancelable.java
     ├── Despachable.java
     └── Rastreable.java

````
### **Model**
- **Pedido** superclase abstracta que implementa interfaces Cancelable, Despachable y Rastreable, y de la cual heredan:
  - *PedidoComida*
  - *PedidoEncomienda*
  - *PedidoExpress*

Todas las clases hijas implementan las interfaces para definir los comportamientos.

### **Interfaces**
- *Cancelable*
- *Despachable*
- *Rastreable*

### **App**
*Main* ejecutable que permite probar los distintos tipos de pedidos e imprimir sus comportamientos.

 ## 🖥 Ejemplo de salida por Consola
<img width="966" height="437" alt="imagen" src="https://github.com/user-attachments/assets/12cfd0b2-4426-45d6-831e-eafe9f2cc25e" />
<img width="1007" height="313" alt="imagen" src="https://github.com/user-attachments/assets/96e9f875-20f8-4fa3-8f89-2718997ea97b" />

## Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:
   
```bash
git clone https://github.com/FloresEng/SpeedFast.git
```
2. Abre el proyecto en IntelliJ IDEA.

3. Verifica que los archivos `.txt` estén correctamente ubicados.

4. Ejecuta el archivo `Main.java` desde el paquete `app`.

5. Sigue las instrucciones en consola.


---

**Repositorio GitHub:** \[https://github.com/FloresEng/SpeedFast.git]
**Fecha de entrega:** \[26/01/2026]
