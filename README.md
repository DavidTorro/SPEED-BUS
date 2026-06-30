# 🚌 Proyecto: Simulación del autobús de la película *Speed (1994)*

**Autor:** David Torró Bautista  

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

### 🔧 Versiones del programa

- **Bus / Speed:** versión base que simula la aceleración y el frenado del autobús en un bucle infinito.  
  Utiliza sincronización mediante los métodos `wait()` y `notifyAll()` para alternar correctamente entre hilos.

- **Bus2 / Speed2:** versión extendida que añade un sistema de “explosiones”.  
  Si el autobús llega o supera los **80 km/h** o llega o baja de **50 km/h**, se imprime `BOOM!!!`, el hilo se interrumpe
  y el programa vuelve automáticamente al menú principal.

---

## ✅ Requisitos

- Java 17 o superior (JDK)
- (Opcional) IDE: IntelliJ IDEA / VS Code / Eclipse

---

## 🗂️ Estructura del proyecto
```
SPEED-BUS/
├── src/
│   ├── Main.java
│   └── Models/
│       ├── Bus.java
│       ├── Speed.java
│       ├── Bus2.java
│       └── Speed2.java
├── bin/                 
├── README.md
└── .gitignore
```

---

## 🔁 Clonación y ejecución rápida
Para probar el proyecto en tu PC, sigue estos pasos:

#### 1️⃣ Clona este repositorio en tu equipo
```
git clone https://github.com/DavidTorro/SPEED-BUS
```

#### 2️⃣ Entra en la carpeta del proyecto
```
cd SPEED-BUS
```

#### 3️⃣ Compila todas las clases Java (desde la raíz del proyecto)
```
javac -d bin src/Main.java src/Models/*.java
```

#### 4️⃣ Ejecuta el programa principal
```
java -cp bin Main
```

---

## 💡 Ejemplo de ejecución esperada

#### 1️⃣ Opción del loop infinito (para paralo pulsar Ctrl + C)

```text
***INICIO DEL PROGRAMA***

----- SPEED - BUS -----
1. Iniciar simulacion (loop infinito)
2. Iniciar simulacion (con explosiones)
3. Salir
Seleccione una opcion: 
2

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

#### 2️⃣ Opción de acelerar con explosiones (EXTRA)

```text
***INICIO DEL PROGRAMA***

----- SPEED - BUS -----
1. Iniciar simulacion (loop infinito)
2. Iniciar simulacion (con explosiones)
3. Salir
Seleccione una opcion: 
2

Iniciando simulacion con posibles explosiones...
Que quieres probar, acelerar o frenar?
acelerar
Acelero 1km/h. Ahora vamos a: 51km/h.
Acelero 3km/h. Ahora vamos a: 54km/h.
Acelero 5km/h. Ahora vamos a: 59km/h.
Acelero 3km/h. Ahora vamos a: 62km/h.
Acelero 4km/h. Ahora vamos a: 66km/h.
Acelero 9km/h. Ahora vamos a: 75km/h.
Acelero 5km/h. Ahora vamos a: 80km/h.
BOOM!!!

Simulacion terminada. Volviendo al menu...

----- SPEED - BUS -----
1. Iniciar simulacion (loop infinito)
2. Iniciar simulacion (con explosiones)
3. Salir
Seleccione una opcion: 
3
Saliendo del programa...

***FINAL DEL PROGRAMA***
```

#### 3️⃣ Opción de frenar con explosiones (EXTRA)

```text
***INICIO DEL PROGRAMA***

----- SPEED - BUS -----
1. Iniciar simulacion (loop infinito)
2. Iniciar simulacion (con explosiones)
3. Salir
Seleccione una opcion: 
2

Iniciando simulacion con posibles explosiones...
Que quieres probar, acelerar o frenar?
frenar
Freno 7km/h. Ahora vamos a: 73km/h.
Freno 3km/h. Ahora vamos a: 70km/h.
Freno 6km/h. Ahora vamos a: 64km/h.
Freno 4km/h. Ahora vamos a: 60km/h.
Freno 9km/h. Ahora vamos a: 51km/h.
Freno 1km/h. Ahora vamos a: 50km/h.
BOOM!!!

Simulacion terminada. Volviendo al menu...

----- SPEED - BUS -----
1. Iniciar simulacion (loop infinito)
2. Iniciar simulacion (con explosiones)
3. Salir
Seleccione una opcion: 
3
Saliendo del programa...

***FINAL DEL PROGRAMA***
```

#### 3️⃣ Salir del programa

```text
***INICIO DEL PROGRAMA***

----- SPEED - BUS -----
1. Iniciar simulacion (loop infinito)
2. Iniciar simulacion (con explosiones)
3. Salir
Seleccione una opcion: 
3
Saliendo del programa...

***FINAL DEL PROGRAMA***
```

---

## 🧩 Notas técnicas

- Se deben usar los métodos `wait()` y `notify()` para la sincronización entre hilos.  
- La velocidad debe mantenerse siempre entre **50 y 80 km/h**.  
- El incremento o decremento debe ser **aleatorio entre 1 y 10 km/h**.  
- El programa debe incluir una **pausa de 1 segundo** entre cada cambio de velocidad.  

---

## 📜 Licencia

Proyecto académico para uso educativo. © 2025 David Torró Bautista.

---
💬 *Inspirado en la película **Speed (1994)**. Proyecto desarrollado por David Torró Bautista (2º DAM, IES l'Estació Ontinyent) bajo la supervisión del profesor Antoni Giménez Rodríguez.*
