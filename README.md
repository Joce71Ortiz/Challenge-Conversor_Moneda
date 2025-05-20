# Challenge-Conversor_Moneda

![Java Logo](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Maven Build](https://img.shields.io/badge/Build-Maven-orange?style=for-the-badge&logo=apache-maven&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue.svg)

Un programa de consola en Java que permite realizar conversiones de diferentes monedas utilizando tasas de cambio actualizadas a través de una API externa.

## 🚀 Funcionalidades

* **Conversión entre monedas predefinidas:** Dólar a Peso Argentino, Peso Argentino a Dólar, Dólar a Real Brasileño, Real Brasileño a Dólar, Dólar a Peso Colombiano, y Peso Colombiano a Dólar.
* **Conversión personalizada:** Posibilidad de ingresar cualquier par de monedas soportadas por la API (ej. USD a MXN, EUR a JPY).
* **Tasas de cambio actualizadas:** Obtiene las tasas de conversión en tiempo real de una API externa.
* **Manejo de errores:** Gestión de entradas inválidas del usuario y errores de la API.
* **Interfaz de consola sencilla:** Fácil de usar a través de un menú interactivo.

## 🛠️ Tecnologías Utilizadas

* **Java 11+:** Lenguaje de programación.
* **Maven:** Herramienta de automatización de construcción y gestión de dependencias. (Si usas Maven, si no, puedes omitirlo o cambiarlo por "JDK").
* **Google GSON:** Librería para la serialización/deserialización de objetos Java a JSON y viceversa.
* **`java.net.http.HttpClient`:** Cliente HTTP para realizar solicitudes a la API.
* **ExchangeRate-API:** API externa para obtener las tasas de cambio.

## 📄 Estructura del Proyecto

* `Principal.java`: Contiene el método `main` y la lógica principal del menú de usuario.
* `ConversorMoneda.java`: Maneja la lógica de la conversión de monedas y la interacción con el usuario para la cantidad a convertir.
* `ConsultarMonedasDeCambio.java`: Se encarga de realizar las solicitudes HTTP a la API de tasas de cambio.
* `Moneda.java`: Un `record` (clase de datos inmutable) que representa la estructura de la respuesta JSON de la API.

## ⚙️ Cómo Ejecutar el Proyecto

### Requisitos

* [Java Development Kit (JDK) 11 o superior](https://www.oracle.com/java/technologies/downloads/) instalado.
* [Maven](https://maven.apache.org/download.cgi) instalado (si estás usando Maven para gestionar dependencias).

### Configuración de la API Key

1.  Obtén una API Key gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/).
2.  Abre el archivo `ConsultarMonedasDeCambio.java`.
3.  Reemplaza `"YOUR_API_KEY_HERE"` con tu API Key obtenida:
    ```java
    private static final String API_KEY = "3712e8f20c8c2c9948d88984"; // Reemplaza con tu API Key
    ```

### Ejecución (con Maven)

1.  **Clona el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/nombre-de-tu-repo.git](https://github.com/tu-usuario/nombre-de-tu-repo.git)
    cd nombre-de-tu-repo
    ```
2.  **Compila el proyecto:**
    ```bash
    mvn clean install
    ```
3.  **Ejecuta el programa:**
    ```bash
    mvn exec:java -Dexec.mainClass="Principal"
    ```

### Ejecución (sin Maven - Compilación manual)

1.  **Clona el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/nombre-de-tu-repo.git](https://github.com/tu-usuario/nombre-de-tu-repo.git)
    cd nombre-de-tu-repo
    ```
2.  **Descarga las librerías necesarias:**
    * **Google Gson:** Descarga el JAR desde [Maven Central](https://mvnrepository.com/artifact/com.google.code.gson/gson). Colócalo en una carpeta `lib` dentro de tu proyecto.
3.  **Compila los archivos Java:**
    Abre tu terminal en la raíz del proyecto y ejecuta:
    ```bash
    javac -d out -cp "lib/*" src/main/java/*.java
    ```
    (Asegúrate de que `lib` sea la ruta a tu carpeta con el JAR de Gson).
4.  **Ejecuta la aplicación:**
    ```bash
    java -cp "out:lib/*" Principal
    ```
    (En Windows, usa `;` en lugar de `:` para el classpath: `java -cp "out;lib/*" Principal`)

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si quieres mejorar este proyecto, por favor sigue estos pasos:

1.  Haz un "fork" de este repositorio.
2.  Crea una nueva rama (`git checkout -b feature/nombre-de-la-feature`).
3.  Realiza tus cambios y haz "commit" (`git commit -m 'feat: Añade nueva funcionalidad'`).
4.  Haz "push" a la rama (`git push origin feature/nombre-de-la-feature`).
5.  Abre un "Pull Request".
