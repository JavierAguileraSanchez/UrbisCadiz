# 🗺️ Manual de Usuario: Urbis Cádiz

Guía oficial para el uso de la aplicación de reporte de barreras arquitectónicas **Urbis Cádiz**.

---

## 1. Acceso al Sistema
La aplicación requiere una autenticación previa para acceder al entorno de gestión urbana.

* **Inicio de Sesión:** Introduce tus credenciales para acceder al mapa.
* **Control de Roles:** La aplicación verifica internamente tu perfil consultando el campo `role` en la colección `usuarios` de la base de datos. Esto asegura que cada perfil tenga acceso a las funciones que le corresponden según su nivel de permisos (Usuario o Administrador).

---

## 2. Visualización del Mapa
Una vez dentro, se presenta el callejero de la ciudad con los puntos de incidencia ya registrados.

* **Exploración:** Puedes moverte por el mapa de Cádiz para localizar los marcadores existentes.
* **Consulta:** Al pulsar sobre un marcador, la aplicación despliega la información asociada a ese punto: título de la incidencia, descripción y la imagen adjunta.

---

## 3. Registro de una Nueva Incidencia
El proceso de reporte está diseñado para ser rápido y directo mediante el uso de herramientas de interacción natural:

1.  **Marcar Ubicación:** Localiza el punto exacto en el mapa y realiza una **pulsación larga** (Long Click). Este gesto captura las coordenadas automáticamente.
2.  **Descripción por Voz:** En el formulario, utiliza el botón del micrófono para dictar la descripción de la barrera detectada. El sistema convertirá tus palabras en texto automáticamente.
3.  **Adjuntar Imagen:** Selecciona desde la galería de tu dispositivo la fotografía que servirá como evidencia visual del reporte.
4.  **Envío a la Nube:** Al confirmar, la incidencia se guarda en Firebase y el marcador se actualiza en el mapa global.

---

## 4. Requisitos de Uso
Para que la aplicación funcione correctamente, asegúrate de:
* Tener conexión activa a **Internet** (Datos o Wi-Fi) para sincronizar con la base de datos.
* Tener activado el **GPS** del dispositivo para la correcta visualización del mapa.
* Permitir el acceso al **almacenamiento** para poder adjuntar las imágenes de las incidencias.
