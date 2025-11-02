# 🚌 Proyecto: Simulación del autobús de la película *Speed (1994)*

**Autor:** David Torró Bautista  
**Curso:** 2º de DAM  
**Asignatura:** Programación de Servicios y Procesos  
**Profesor:** Antoni Giménez Rodríguez  
**Fecha:** Octubre de 2025  

---

## 🧭 Descripción del proyecto

El objetivo de este programa en Java es simular el funcionamiento del autobús de la película *Speed (1994)*, en la cual el vehículo debe circular entre 50 y 80 km/h.  
Si la velocidad baja de 50 km/h o supera los 80 km/h, explotará una bomba instalada en el autobús.

---

## ⚙️ Enunciado

El programa en Java utilizará un objeto **Autobús**, que tendrá una matrícula y una velocidad inicial de **50 km/h**.  
Este autobús será el **objeto compartido** por varios hilos de ejecución pertenecientes a la clase **Speed**, que modificarán su velocidad con un número aleatorio entre **1 y 10 km/h**.

La clase **Speed** comenzará **acelerando** el autobús (que parte de una velocidad inicial de 50 km/h) poco a poco hasta llegar a un máximo de **80 km/h**.  
Cuando alcance ese límite, comenzará a **frenar** de forma progresiva hasta volver a los **50 km/h**, momento en el que volverá a acelerar... y así cíclicamente.

En la práctica, el programa se convertirá en un **bucle infinito**, en el cual se esperará **1 segundo entre cada aceleración o frenada**, para observar con más claridad cómo avanza el autobús.

Para que el programa funcione correctamente, los hilos de tipo **Speed** deben “comunicarse” entre sí mediante **wait()** y **notify()**.  
Es decir, cuando un hilo está esperando para **acelerar**, notificará al hilo encargado de **frenar**, y viceversa, para que se alternen en el control de la velocidad.

Se recomienda tener las siguientes clases:
- `Main.java`
- `Bus.java`
- `Speed.java`

---

## 💡 Ejemplo de ejecución esperada

```text
Acelero 10Km./h. Ahora vamos a 60Km./h
Acelero 3Km./h. Ahora vamos a 63Km./h
Acelero 7Km./h. Ahora vamos a 70Km./h
Acelero 4Km./h. Ahora vamos a 74Km./h
Freno 9Km./h. Ahora vamos a 65Km./h
Freno 7Km./h. Ahora vamos a 58Km./h
Acelero 5Km./h. Ahora vamos a 63Km./h
Acelero 4Km./h. Ahora vamos a 67Km./h
Acelero 3Km./h. Ahora vamos a 70Km./h
Freno 8Km./h. Ahora vamos a 62Km./h
Acelero 9Km./h. Ahora vamos a 71Km./h
Freno 10Km./h. Ahora vamos a 61Km./h
Freno 8Km./h. Ahora vamos a 53Km./h
Acelero 8Km./h. Ahora vamos a 61Km./h
```

---

## 🧩 Notas técnicas

- Se deben usar los métodos `wait()` y `notify()` para la sincronización entre hilos.  
- La velocidad debe mantenerse siempre entre **50 y 80 km/h**.  
- El incremento o decremento debe ser **aleatorio entre 1 y 10 km/h**.  
- El programa debe incluir una **pausa de 1 segundo** entre cada cambio de velocidad.  

---
