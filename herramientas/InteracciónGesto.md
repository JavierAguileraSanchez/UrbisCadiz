## RA2.d - Interacción por gesto

La interacción por gesto consiste en controlar la aplicación mediante movimientos físicos, eliminando la necesidad de navegar por menús complejos o buscar botones específicos. Estos gestos pueden ser táctiles, como deslizamientos o pulsaciones largas sobre la pantalla, o espaciales, donde se involucran movimientos en el aire captados por la cámara o sensores. En una aplicación de gestión urbana, el uso de gestos permite una interacción más directa con el entorno digital de la ciudad.

---

### Implementación en Urbis Cádiz

Para este proyecto, se han definido soluciones realistas y funcionales que mejoran la experiencia de reporte:

- **Gestos táctiles de precisión (Long Click):** El gesto principal de la aplicación es la pulsación prolongada sobre el mapa. En lugar de rellenar formularios de dirección, el usuario mantiene el dedo sobre el punto exacto de la barrera arquitectónica. Esto dispara un evento que captura las coordenadas `LatLng`, haciendo la interfaz mucho más ágil y precisa que cualquier método de entrada convencional.
- **Gestos de navegación espacial:** Utilizando el **Pinch-to-zoom** y el **Drag-to-pan**, el usuario manipula el modelo de la ciudad de forma natural. Además, se plantea teóricamente el uso de gestos en el aire mediante la cámara y `MediaPipe` para que, mientras el usuario está frente a una incidencia (quizás con las manos ocupadas o con guantes en invierno), pueda realizar un gesto de "Ok" con la mano para confirmar el envío de una foto sin tocar la pantalla.



---

### Justificación Técnica y de Usabilidad

La inclusión de estas funciones responde a necesidades de **precisión geográfica y eficiencia en exteriores**:

1. **Contexto Urbano:** En una ciudad con mucha luz solar, los botones pequeños pueden ser difíciles de ver. Un gesto de pulsación larga en el mapa es una acción robusta que no requiere una precisión visual extrema por parte del usuario.
2. **Seguridad y Comodidad:** Al permitir que un simple gesto inicie el reporte, se mejora la experiencia del usuario, permitiéndole mantener la atención en su entorno mientras camina. Esto reduce el riesgo de distracciones peligrosas en la vía pública.
3. **Optimización del Flujo:** El uso de gestos táctiles integrados en el mapa (como deslizar para rotar la vista) permite que el ciudadano explore los puntos negros de accesibilidad de forma intuitiva, emulando la forma en que exploramos físicamente el espacio.

---

### Control de Conflictos (RA4.i)

Como parte del diseño de usabilidad, se ha implementado una lógica de bloqueo de gestos: cuando el usuario está interactuando con el mapa, el sistema deshabilita el gesto lateral para abrir el menú (Navigation Drawer). Esto evita "falsos positivos", asegurando que el movimiento del dedo siempre se interprete como una intención de navegación cartográfica y no como un error de interfaz.
