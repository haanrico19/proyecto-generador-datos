# 🧮 Proyecto Generador de Datos – Java

Este proyecto fue desarrollado como parte de la asignatura **Conceptos Fundamentales de la Programación**, dictada por el profesor **Diego Roa**.  
El objetivo principal es aplicar los conceptos básicos de programación en Java para **generar, procesar y analizar datos de ventas** de forma automatizada.

---

## 📘 Descripción del proyecto

El programa genera archivos con información simulada de productos, vendedores y ventas.  
Luego, procesa esos datos para calcular:

- Ventas totales por **vendedor**  
- Ventas totales por **producto**

Finalmente, genera reportes en formato `.txt` con los resultados.

---

## 🧩 Estructura del proyecto

```
proyecto-generador-datos/
│
├── src/
│   ├── GenerateInfoFiles.java   # Genera los archivos de datos
│   ├── Main.java                # Procesa los datos y genera los reportes
│
├── data/                        # Carpeta donde se crean los archivos generados
│   ├── productos.txt
│   ├── vendedores.txt
│   ├── ventas.txt
│   ├── reporte_productos.txt
│   └── reporte_vendedores.txt
│
└── conclusion.txt               # Conclusiones del proyecto
```

---

## ⚙️ Requisitos

- Tener instalado **Java JDK 8** o superior.  
- Tener configurado el **PATH** de Java correctamente.  
- (Opcional) Usar **Visual Studio Code** o **IntelliJ IDEA** como entorno de desarrollo.

---

## ▶️ Cómo ejecutar el proyecto

### 🧠 Paso 1 – Compilar el código

Desde la terminal, entra a la carpeta `src` y compila ambos archivos:

```bash
cd src
javac *.java
```

Esto generará los archivos `.class` correspondientes.

---

### 🧾 Paso 2 – Generar los archivos de datos

Ejecuta la clase `GenerateInfoFiles` para crear la carpeta `data/` con los archivos de productos, vendedores y ventas:

```bash
java GenerateInfoFiles
```

Deberías ver un mensaje como:
```
✅ Archivos generados exitosamente en la carpeta 'data/'.
```

---

### 📊 Paso 3 – Generar los reportes de ventas

Ahora ejecuta la clase `Main`:

```bash
java Main
```

El programa leerá los datos y generará los reportes:
```
✅ Reportes generados exitosamente en la carpeta 'data/'.
```

Los resultados estarán en:
- `data/reporte_productos.txt`
- `data/reporte_vendedores.txt`

---

## 🧾 Ejemplo de salida

**reporte_vendedores.txt**
```
=== REPORTE DE VENTAS POR VENDEDOR ===
Juan Pérez: 27 productos vendidos, Total $134000
María Gómez: 32 productos vendidos, Total $152000
...
```

**reporte_productos.txt**
```
=== REPORTE DE VENTAS POR PRODUCTO ===
Café: 20 unidades vendidas, Total $85000
Azúcar: 26 unidades vendidas, Total $102000
...
```

---

## 🧩 Conclusiones

Durante este proyecto se aplicaron los conceptos de:
- Estructuración de programas en múltiples clases.
- Lectura y escritura de archivos en Java.
- Uso de estructuras de datos (`Map`, `List`) para el procesamiento de información.

El programa demuestra cómo automatizar la generación y análisis de datos de ventas, sirviendo como base para futuros sistemas de gestión.
