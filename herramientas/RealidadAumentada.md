## RA2.f - Realidad Aumentada

La Realidad Aumentada (AR) es una tecnología que permite superponer elementos digitales, como modelos 3D, indicadores o textos informativos, sobre la visión del mundo real a través de la pantalla del dispositivo. A diferencia de la realidad virtual, la AR no aísla al usuario, sino que enriquece su entorno físico con capas de datos virtuales en tiempo real. Para lograrlo, se utilizan motores como `ARCore`, que detectan superficies y la profundidad del entorno para que los objetos digitales parezcan estar físicamente presentes en la calle.

---

### Propuesta de Integración en Urbis Cádiz

Si se integrara esta tecnología en el proyecto, la propuesta principal sería un **Visualizador de Incidencias en Tiempo Real**. 

Al caminar por la ciudad, el usuario o el gestor municipal podría activar el "Modo AR". Utilizando la cámara y el GPS, la aplicación detectaría el suelo y la perspectiva de la calle, proyectando iconos o modelos 3D directamente sobre los puntos donde se han reportado incidencias:

- **Visualización de Reportes Invisibles:** Un bache o una rampa mal ejecutada podrían marcarse con un holograma de advertencia que flota sobre la ubicación exacta. 
- **Perspectiva 360°:** A diferencia de un mapa 2D que requiere interpretación, la Realidad Aumentada permite al usuario ver la distancia y posición real de los obstáculos simplemente moviendo el teléfono a su alrededor. Esto es fundamental para que los operarios municipales identifiquen rápidamente la avería sin necesidad de leer coordenadas complejas.



---

### Justificación de la Propuesta

La justificación de esta herramienta se basa en la **eficiencia logística y la concienciación ciudadana**:

1. **Localización de Precisión:** Muchas veces, una descripción de texto o una foto no bastan para encontrar una incidencia en una calle larga. La Realidad Aumentada guía al gestor hasta el punto exacto mediante señales visuales integradas en el paisaje urbano.
2. **Impacto Visual:** Para los ciudadanos, ver "físicamente" el volumen de incidencias de su barrio mediante realidad aumentada genera una mayor conciencia sobre los problemas de accesibilidad que a veces pasan desapercibidos en el día a día.
3. **Seguridad en la Reparación:** Los operarios podrían visualizar infraestructuras ocultas (como tuberías o cables bajo un bache) antes de intervenir, proyectando planos técnicos sobre el suelo mediante AR para evitar daños colaterales durante las obras de mejora de accesibilidad.



---

### Control de Movimiento y Estabilidad

Para que esta propuesta sea viable, el sistema utiliza la tecnología **SLAM** (*Simultaneous Localization and Mapping*). Esto asegura que, aunque el usuario camine o mueva el dispositivo bruscamente, el marcador de la incidencia permanezca "anclado" a sus coordenadas reales de Cádiz, evitando el desplazamiento errático de la información visual y garantizando una experiencia de usuario sólida y profesional.
