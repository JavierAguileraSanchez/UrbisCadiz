## Diseño Conceptual NUI en Urbis Cádiz

El diseño de **Urbis Cádiz** no se concibe como una aplicación estática, sino como una interfaz dinámica que busca reducir la fricción entre el ciudadano y el reporte urbano. A continuación, se detalla la propuesta teórica de integración de las herramientas NUI para mejorar la usabilidad y la eficiencia del sistema.

---

### 1. Implementación de Interacción por Voz (STT)
La entrada de datos mediante voz es la implementación más plausible y necesaria para garantizar la accesibilidad universal en el proyecto.

- **Aplicación Práctica:** Integración de un asistente de dictado en el formulario de reporte de incidencias. El usuario, en lugar de escribir en un teclado virtual (propenso a errores en exteriores o con luz solar), activa el micrófono para describir el desperfecto.
- **Beneficio NUI:** Permite que ciudadanos con movilidad reducida en las manos o personas mayores puedan contribuir al mapa urbano con el mismo nivel de detalle que cualquier otro usuario, cumpliendo con el principio de inclusividad.

---

### 2. Geolocalización Mediante Gestos Espaciales
Sustituir la introducción manual de direcciones por una interacción directa sobre el modelo digital de la ciudad.

- **Aplicación Práctica:** Uso del gesto `Long Click` (pulsación prolongada) sobre la cartografía de Google Maps. Al detectar la presión sostenida, la aplicación realiza una correspondencia entre las coordenadas de la pantalla y las coordenadas geográficas reales.
- **Beneficio NUI:** Elimina la carga cognitiva de tener que conocer el nombre de la calle o el número exacto. El usuario simplemente "señala" el punto donde se encuentra la barrera arquitectónica, logrando una precisión que el GPS por sí solo a veces no alcanza debido al margen de error.

---

### 3. Visualización con Conciencia de Orientación (Sensores)
Aprovechar el hardware del dispositivo para que la interfaz se adapte a la postura física del usuario.

- **Aplicación Práctica:** Uso de la **fusión de sensores** (acelerómetro y magnetómetro) para activar el modo de "Brújula Activa". Al levantar el teléfono, el mapa rota automáticamente para coincidir con el campo visual del usuario.
- **Beneficio NUI:** Facilita la orientación espacial del ciudadano. Si un usuario busca una incidencia reportada para verificar si ha sido arreglada, la aplicación le indica la dirección exacta simplemente orientando el dispositivo hacia la calle correspondiente.

---

### 4. Análisis Visual de Incidencias (Computer Vision)
Uso teórico de herramientas como ML Kit para asistir al usuario durante la captura de la fotografía.

- **Aplicación Práctica:** Implementación de un modelo de **detección de objetos** en tiempo real mediante la cámara. Al apuntar a una barrera, la app podría reconocer patrones (ej. "escalón detectado" o "acera estrecha") y sugerir automáticamente la categoría de la incidencia.
- **Beneficio NUI:** Actúa como un filtro de calidad previo al envío. Ayuda al usuario a encuadrar correctamente la evidencia visual y categorizar el reporte de forma automática, ahorrando tiempo y mejorando la base de datos para el administrador.

---

### 5. Realidad Aumentada para Gestión de Campo (ARCore)
Propuesta de uso para los gestores municipales o administradores que deben acudir a revisar los reportes.

- **Aplicación Práctica:** Visualización de "anclas" digitales sobre la vista de cámara. El gestor, al llegar a una zona con múltiples reportes, puede mirar a través del dispositivo y ver iconos flotando exactamente sobre los puntos negros reportados.
- **Beneficio NUI:** Facilita la localización de baches o problemas de señalización que han sido reportados pero que, a simple vista o en un plano 2D, pueden ser difíciles de identificar en entornos urbanos densos.

---

### Conclusión del Diseño
El enfoque NUI de **Urbis Cádiz** se basa en convertir el dispositivo móvil en un sensor inteligente que entiende tanto al usuario (voz y gestos) como al entorno (ubicación y visión), creando una herramienta de gestión urbana orgánica y eficiente.
