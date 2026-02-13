## Herramientas de Informes

Para la gestión eficiente de la accesibilidad en una aplicación de participación ciudadana como **Urbis Cádiz**, se plantea una solución profesional basada en una arquitectura limpia. Los informes se generan a partir de los datos recolectados en el entorno urbano, proporcionando una visión analítica tanto para los ciudadanos como para los gestores municipales.

---

### Estructura del informe

Cada informe técnico presentaría una estructura clara y profesional, compuesta por los siguientes apartados:
- **Resumen ejecutivo:** Conteo total de incidencias reportadas, validadas y subsanadas en el periodo seleccionado.
- **Gráficos de tipología:** Distribución de barreras arquitectónicas por categorías (rampas, aceras, iluminación, señales).
- **Tablas de métricas:** Valores calculados sobre tiempos de respuesta y densidad de problemas por barrio.
- **Sección de puntos críticos:** Identificación de las zonas con mayor acumulación de reportes pendientes.

Esta organización permite a los técnicos municipales priorizar las intervenciones urbanas basándose en datos objetivos y no en suposiciones.

---

### Fuentes de datos y generación de informes

Los informes se nutren de la colección `incidencias` almacenada en **Firebase Firestore**. El procesamiento de estos datos se realiza de forma asíncrona mediante `Corrutinas` de Kotlin y `Flows`, lo que garantiza que la generación de estadísticas complejas no bloquee la interfaz de usuario. Este enfoque permite que los informes se mantengan actualizados en tiempo real a medida que los ciudadanos suben nuevos reportes desde la calle.

---

### Filtros de información

La aplicación permite diseccionar la realidad urbana mediante filtros avanzados aplicados sobre el conjunto de datos:
- **Rango temporal:** Para evaluar la evolución de la accesibilidad mes a mes o tras una campaña de obras.
- **Estado de gestión:** Filtrar por incidencias "Pendientes", "En revisión" o "Solucionadas".
- **Filtro geográfico:** Analizar distritos específicos de Cádiz para comparar el nivel de accesibilidad entre diferentes zonas.

---

### Valores calculados y estadísticas

Más allá de mostrar datos brutos, el sistema genera indicadores clave de rendimiento (KPIs):
- **Índice de Gravedad:** Valor calculado basado en el número de usuarios distintos que reportan un mismo problema.
- **Tasa de Resolución:** Porcentaje de éxito en la reparación de barreras arquitectónicas.
- **Medias de latencia:** Tiempo promedio transcurrido desde el reporte ciudadano hasta la validación administrativa.

---

### Representación gráfica de los datos

Para la visualización de la información se utiliza la librería `MPAndroidChart`, integrando:
- **Gráficas de líneas:** Para representar la tendencia de nuevos reportes a lo largo del año.
- **Gráficas de barras:** Para comparar visualmente el volumen de incidencias entre distintas categorías de accesibilidad.
- **Gráficas circulares:** Para visualizar el porcentaje de incidencias resueltas frente a las activas.



---

### Exportación y generación de documentos

Como funcionalidad de grado profesional, la aplicación permite la generación de documentos oficiales en formato **PDF** mediante la librería `iText`. 
- **Uso administrativo:** Estos PDFs sirven como actas de inspección que los operarios pueden llevar en sus dispositivos o imprimir.
- **Interoperabilidad:** Se ofrece la exportación de datos en formato **CSV**, facilitando que la información de Urbis Cádiz pueda ser analizada en herramientas externas de administración pública o sistemas de información geográfica (GIS).

---

### Integración y enfoque profesional

La funcionalidad de informes está completamente integrada en el módulo de administración de la aplicación. Siguiendo los principios de **Clean Architecture**, se separa la lógica de obtención de datos de Firebase de la lógica de presentación. De este modo, Urbis Cádiz se transforma en una herramienta de Business Intelligence para la ciudad, proporcionando resúmenes visuales que facilitan la toma de decisiones para lograr una ciudad sin barreras.
