# 💱 Conversor de Monedas - Proyecto Java

[![Java](https://img.shields.io/badge/Java-11-blue?logo=java)](https://www.java.com/)
[![Gson](https://img.shields.io/badge/Gson-2.10-orange?logo=google)](https://github.com/google/gson)
[![License](https://img.shields.io/badge/License-Free-green)]()

**Autor:** Alex Gonzalez

---

## 📖 Descripción

Proyecto en Java que permite **convertir monedas** usando la API de [ExchangeRate-API](https://www.exchangerate-api.com/).

* Convierte monedas populares y personalizadas.
* Guarda un historial en formato **JSON** (`historial_consultas.json`).
* Maneja errores de API y entradas inválidas de usuario.

---

## 💡 Características

* Conversión entre monedas populares y personalizadas.
* Validación de entradas numéricas.
* Historial de conversiones en JSON con formato legible.
* Código modular:

| Clase                    | Función                       |
| ------------------------ | ----------------------------- |
| `Principal.java`         | Menú y flujo principal        |
| `CalculaConversion.java` | Lógica de conversión          |
| `ConsultaAPI.java`       | Consulta a la API externa     |
| `GeneraArchivos.java`    | Guardado de historial en JSON |

---

## 🔑 Requisitos

* **Java 11** o superior
* **Librería Gson**: [Gson GitHub](https://github.com/google/gson)
* **API Key** de [ExchangeRate-API](https://www.exchangerate-api.com/)

> ⚠️ No compartas tu API Key públicamente.

---

## ⚙️ Instalación y Ejecución

1. Clona o descarga el repositorio.
2. Abre el proyecto en tu IDE favorito o terminal.
3. Agrega `gson-<version>.jar` al classpath.
4. Configura tu API Key en `ConsultaAPI.java`:

```java
private static final String API_KEY = "TU_API_KEY_AQUI";
```

5. Ejecuta `Principal.java` y sigue el menú.

---

## 📝 Uso

### Menú principal

| Opción | Conversión           |
| ------ | -------------------- |
| 1      | ARS → USD            |
| 2      | ARS → EUR            |
| 3      | ARS → BRL            |
| 4      | USD → ARS            |
| 5      | EUR → ARS            |
| 6      | BRL → ARS            |
| 7      | Moneda personalizada |
| 8      | Salir                |

### Ejemplo de conversión

```
Ingrese la opción: 1
Ingrese el valor que deseas convertir:
100
ARS 100.00 equivale a USD 1.05
Historial guardado en 'historial_consultas.json'
```

---

## 🗂 Historial de conversiones

El historial se guarda automáticamente en **JSON**:

```json
[
  "16-08-2025 18:20:00 - ARS 100.00 equivale a USD 1.05",
  "16-08-2025 18:25:30 - USD 50.00 equivale a ARS 5020.00"
]
```

---

## 🌐 Secciones plegables

<details>
<summary>📌 Monedas disponibles (ISO 4217)</summary>

* ARS → Peso Argentino
* USD → Dólar Estadounidense
* EUR → Euro
* BRL → Real Brasileño
* Y muchas más personalizables usando código ISO 4217.

</details>

<details>
<summary>💻 Ejemplo de flujo completo</summary>

```
Menú principal:
1) ARS -> USD
2) ARS -> EUR
3) ARS -> BRL
4) USD -> ARS
5) EUR -> ARS
6) BRL -> ARS
7) Otra opción
8) Salir

Opción: 7
Moneda base: GBP
Moneda objetivo: USD
Cantidad: 50
GBP 50.00 equivale a USD 61.75
```

</details>

---

## ⚠️ Notas importantes

* Usar **códigos de moneda válidos (ISO 4217)**.
* La API puede limitar solicitudes gratuitas; revisa tu plan.
* Proyecto educativo; uso comercial no permitido sin autorización.

---

## 🏷 Licencia

Uso libre y educativo.


## Instalación y Ejecución

1. Clonar o descargar este repositorio.
2. Abrir el proyecto en un IDE compatible con Java (IntelliJ, Eclipse, NetBeans) o usar terminal.
3. Agregar la librería Gson al proyecto.
4. Abrir `ConsultaAPI.java` y reemplazar la constante `API_KEY` con tu clave válida de ExchangeRate-API:

```java
private static final String API_KEY = "TU_API_KEY_AQUI";
