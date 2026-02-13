## RA2.d - Interacción por gesto

En el desarrollo de **Urbis Cádiz**, la interacción por gesto es el pilar que permite transformar una pantalla plana en una herramienta de precisión geográfica. Los gestos NUI permiten una navegación fluida que minimiza la fricción entre la intención del usuario y la acción del sistema.

---

### Tipos de gestos explicados

La aplicación basa su usabilidad en la interpretación de eventos táctiles complejos procesados por el motor de gestos de Android:

1. **Long Click (Pulsación Prolongada):** - Es el gesto principal para el reporte de incidencias. 
   - **Explicación:** Al mantener la presión sobre un punto del mapa, se activa un evento de captura de coordenadas (`LatLng`). Este gesto es mucho más "natural" que escribir una dirección manual, ya que permite al usuario señalar directamente el bache o la barrera que tiene frente a él.
   
2. **Pinch-to-Zoom (Gesto de Pinza):** - Utilizado para la escala del mapa.
   - **Explicación:** Mediante la detección de dos puntos de contacto simultáneos y el cálculo de la distancia relativa entre ellos, el sistema ajusta el nivel de zoom. Es un gesto NUI universal que no requiere aprendizaje previo.

3. **Drag and Drop (Arrastrar y Soltar):** - Implementado en la exploración de la lista de administración y el movimiento del mapa.
   - **Explicación:** Permite el desplazamiento del visor de cámara del mapa siguiendo el movimiento del dedo del usuario en tiempo real (seguimiento de baja latencia).

---

### Justificación Técnica

Para que estos gestos sean efectivos en **Urbis Cádiz**, se ha tenido que gestionar la jerarquía de eventos táctiles. Por ejemplo:
- Se ha bloqueado el gesto de "swipe" lateral del Menú (Drawer) mientras el usuario interactúa con el mapa. Esto evita que, al intentar desplazar el mapa, se abra accidentalmente el menú lateral, mejorando la **usabilidad (RA4)**.



---

### Beneficios NUI

- **Reducción de carga cognitiva:** El usuario no tiene que buscar botones de "Añadir marcador"; simplemente interactúa con el espacio geográfico.
- **Precisión:** Permite una localización exacta de las barreras arquitectónicas que el GPS, por sí solo (debido al margen de error de ~5 metros), no siempre puede garantizar.
- **Inmediatez:** La transición entre ver un problema y empezar a reportarlo se reduce a un solo gesto físico.
