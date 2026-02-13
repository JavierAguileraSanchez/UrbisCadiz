## Guías de Ayuda al Usuario

---

### RA6.a Identificación de sistemas de generación de ayudas

Los sistemas de ayuda en **Urbis Cádiz** buscan asistir al ciudadano y al administrador de forma clara, fomentando la autonomía y reduciendo la curva de aprendizaje en el reporte de barreras arquitectónicas. Se han planificado e implementado:
- **Ayudas contextuales:** Micro-descripciones en los campos de texto del formulario de reporte (ej. *Tooltips* que explican qué tipo de foto es mejor para validar un bache).
- **Mensajes de validación:** Indicaciones precisas en tiempo real que guían al usuario si olvida adjuntar la ubicación GPS o si la descripción es demasiado breve para ser procesada.

---

### RA6.b Generación de ayudas en formatos habituales

Se ofrecen ayudas en distintos formatos para garantizar la accesibilidad universal:
- **Pop-ups informativos:** Cuadros de diálogo que aparecen la primera vez que se usa la Interacción por Voz o el mapa.
- **Documentación Markdown:** Guías técnicas y de usuario presentes en este repositorio para consulta externa.
- **Tutorial en vídeo:** Un recurso audiovisual donde se muestra el flujo completo: desde que se detecta una deficiencia en la calle hasta que el administrador la marca como "En reparación".

---

### RA6.c Generación de ayudas sensibles al contexto

La ayuda se integra de forma dinámica para no saturar al usuario:
- **Información específica por rol:** El ciudadano solo ve ayudas sobre cómo reportar, mientras que el administrador ve ayudas sobre cómo gestionar la base de datos de la colección `usuarios` y el campo `role`.
- **Alertas adaptativas:** Los mensajes de error se adaptan a la acción: si falla la conexión con **Firebase**, el mensaje explica cómo guardar el reporte localmente para reintentarlo después.



---

### RA6.d Documentación de la estructura de la información persistente

Se documenta la estructura de los datos para garantizar la transparencia y facilitar el mantenimiento:
- **Colección Firestore (Incidencias):** Descripción de cada documento, incluyendo tipos de datos (GeoPoint, String, Timestamp) y ejemplos de objetos almacenados.
- **Colección Usuarios:** Documentación del esquema que define los permisos (rol de usuario vs. rol de administrador).
- **Preferencias locales:** Explicación de cómo se almacenan mediante `DataStore` las configuraciones del usuario, como el modo oscuro o el radio de avisos de incidencias cercanas.

---

### RA6.f Manual técnico de instalación y configuración

Se incluye un manual profesional para que otros desarrolladores puedan replicar el entorno de Urbis Cádiz:
- **Requisitos del sistema:** Versión de Android mínima y dependencias de Google Play Services para los mapas.
- **Integración con Firebase:** Pasos para vincular el archivo `google-services.json` y configurar las reglas de seguridad de la base de datos.
- **Estructura de paquetes:** Explicación de la arquitectura (Data, Domain, UI) para facilitar la escalabilidad del código.



---

### RA6.g Confección de tutoriales

Se han diseñado recursos didácticos para asegurar que cualquier ciudadano pueda usar la herramienta:
- **Guía de bienvenida (Onboarding):** Un carrusel de imágenes al inicio de la app que explica los 3 pasos clave: Ubicar, Fotografiar y Describir.
- **Tutorial de Interacción NUI:** Instrucciones sobre cómo usar el *Long Click* en el mapa y el dictado por voz para reportar sin usar el teclado.
- **Casos de uso:** Ejemplos prácticos de cómo un reporte bien documentado acelera la resolución de problemas por parte del Ayuntamiento.

---

Este enfoque asegura que **Urbis Cádiz** no sea solo una herramienta funcional, sino también accesible y fácil de mantener, cumpliendo con los estándares de calidad de software exigidos.
