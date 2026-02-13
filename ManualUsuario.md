# 🗺️ Manual de Usuario: Urbis Cádiz

Esta guía detalla las funciones de la aplicación **Urbis Cádiz** según el perfil de acceso del usuario, permitiendo la colaboración ciudadana y la gestión técnica de la accesibilidad urbana.

---

## 1. Acceso y Roles de Usuario
El acceso a la plataforma está protegido por un sistema de login. Al iniciar sesión, la aplicación consulta la colección `usuarios` en Firebase para verificar el campo `role`:

* **Perfil Usuario:** Permisos para navegar por el mapa y registrar nuevos reportes.
* **Perfil Administrador:** Permisos adicionales para la validación y limpieza del mapa de incidencias.

---

## 2. Funciones para el Ciudadano (Rol: Usuario)
El objetivo principal de este perfil es identificar y señalizar barreras arquitectónicas en la ciudad.

### Cómo crear un Reporte:
1.  **Ubicación en el Mapa:** Busca el lugar del desperfecto y realiza una **pulsación larga** (Long Click) sobre el mapa para fijar las coordenadas.
2.  **Descripción por Voz:** Pulsa el icono del micrófono en el formulario para dictar el problema. El sistema transcribirá tus palabras automáticamente al campo de texto.
3.  **Adjuntar Imagen:** Selecciona desde la galería de tu terminal una fotografía que sirva como evidencia del reporte.
4.  **Sincronización:** Al pulsar enviar, los datos se suben a la base de datos para su posterior revisión.

---

## 3. Funciones de Gestión (Rol: Administrador)
El administrador es el encargado de filtrar la información que se muestra en el mapa global para asegurar la calidad de los datos.

* **Revisión de Incidencias:** El administrador tiene acceso a los reportes entrantes para verificar su veracidad.
* **Aprobar Incidencia:** Si el reporte es correcto y la imagen corresponde con la descripción, el administrador puede **aprobar** la incidencia para que sea visible para todos los usuarios en el mapa de Cádiz.
* **Rechazar Incidencia:** En caso de reportes duplicados, falsos o con información irrelevante, el administrador tiene la potestad de **rechazar** la incidencia, eliminándola del flujo de visualización pública.

---

## 4. Visualización General del Mapa
Independientemente del rol, los usuarios pueden:
* Explorar el callejero de Cádiz.
* Pulsar sobre los marcadores existentes para consultar el título, la descripción y la imagen de las barreras ya validadas por el equipo de administración.

---

## 5. Requisitos del Sistema
Para garantizar la estabilidad de la aplicación:
* **Internet:** Necesario para el intercambio de datos con Firebase.
* **GPS:** Imprescindible para el centrado del mapa y la geolocalización de incidencias.
* **Permisos:** Se requiere acceso al almacenamiento (para adjuntar fotos) y al micrófono (para el dictado por voz).
