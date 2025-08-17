# Conversor de Monedas - Proyecto Java

**Autor:** Alex Gonzalez

---

## Descripción

Proyecto de conversor de monedas desarrollado en Java.  
Permite convertir entre diferentes monedas utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com/).  

Guarda un historial de conversiones en formato JSON (`historial_consultas.json`) para revisiones posteriores.

---

## Características

- Conversión entre monedas populares:
  - Peso Argentino (ARS)
  - Dólar Estadounidense (USD)
  - Euro (EUR)
  - Real Brasileño (BRL)
- Conversión personalizada entre cualquier código de moneda válido (ISO 4217).
- Validación de entradas numéricas.
- Historial de conversiones guardado automáticamente en JSON.
- Manejo de errores de la API, incluyendo códigos 400 y problemas de conexión.
- Código modular:
  - `Principal.java` → Menú y flujo principal.
  - `CalculaConversion.java` → Lógica de conversión.
  - `ConsultaAPI.java` → Consulta a la API externa.
  - `GeneraArchivos.java` → Guardado de historial en JSON.

---

## Requisitos

- Java 11 o superior (por uso de `HttpClient`).
- Biblioteca **Gson** para manejo de JSON:
  - [Gson GitHub](https://github.com/google/gson)  
  - Incluir `gson-<version>.jar` en el classpath.

---

## Instalación y Ejecución

1. Clonar o descargar este repositorio.
2. Abrir el proyecto en un IDE compatible con Java (IntelliJ, Eclipse, NetBeans) o usar terminal.
3. Agregar la librería Gson al proyecto.
4. Abrir `ConsultaAPI.java` y reemplazar la constante `API_KEY` con tu clave válida de ExchangeRate-API:

```java
private static final String API_KEY = "TU_API_KEY_AQUI";
