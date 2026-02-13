## Herramientas de Informes

Para la generación de informes en una aplicación orientada a la gestión de accesibilidad urbana, como `Urbis Cádiz`, se plantea una solución profesional basada en una arquitectura limpia y centrada en la experiencia del usuario (UX), donde los informes se generan a partir de los datos almacenados en **Firebase** y se integran de forma coherente dentro de la aplicación para facilitar la toma de decisiones por parte de los administradores y gestores municipales.

---

### Estructura del informe

Cada informe de accesibilidad presentaría una estructura clara y profesional, compuesta por los siguientes apartados:
- **Resumen general:** Recuento total de incidencias reportadas, aprobadas y eliminadas en el periodo analizado.
- **Gráficos de estado:** Distribución porcentual de las incidencias según su tipo (rampas, baches, señalización).
- **Mapa de calor (Heatmap):** Visualización de las zonas de la ciudad con mayor acumulación de barreras arquitectónicas.
- **Sección de gestión:** Tiempo medio de respuesta desde el reporte ciudadano hasta la validación administrativa.

Esta organización permitiría a los gestores municipales interpretar fácilmente los puntos críticos de la ciudad sin necesidad de analizar datos en bruto, ayudando a priorizar las obras públicas.

---

### Fuentes de datos y generación de informes

Los informes se generarían a partir de la colección `incidencias` almacenada en **Firebase Firestore**. Estos datos se procesarían en segundo plano mediante `Corrutinas` y `Flows` para evitar bloqueos en la interfaz y garantizar un rendimiento óptimo de la aplicación. A partir de esta información en la nube, se construirían informes en tiempo real, útiles y bien integrados dentro del flujo de trabajo del administrador.

---

### Filtros de información

La aplicación permitiría aplicar filtros sobre los datos presentados en los informes, como:
- **Rango de fechas:** Para analizar la evolución de la accesibilidad mes a mes.
- **Tipo de barrera:** Centrarse únicamente en una categoría específica (ej. accesibilidad motriz).
- **Barrio o Distrito:** Filtrar los reportes según la zona geográfica de Cádiz.

Estos filtros estarían explicados y definidos, permitiendo al administrador centrarse únicamente en la información relevante para la planificación urbana actual.

---

### Valores calculados y estadísticas

Los informes incluirían distintos valores calculados que aportan información útil al gestor municipal:
- **Índice de Gravedad:** Calculado según el número de reportes ciudadanos sobre un mismo punto.
- **Volumen de participación:** Número de usuarios activos reportando incidencias por semana.
- **Tasa de resolución:** Porcentaje de incidencias que han pasado de estado "pendiente" a "aprobada" o reparada.



---

### Representación gráfica de los datos

Para la visualización de la información se utilizaría la librería `MPAndroidChart`, que emplea:
- **Gráficas de líneas:** Para representar la tendencia de nuevos reportes a lo largo del tiempo.
- **Gráficas de barras:** Para comparar el volumen de incidencias entre distintas categorías o barrios.
Los gráficos estarían correctamente integrados en la aplicación y permiten la interacción del usuario para consultar detalles concretos de cada fecha o sector.

---

### Exportación y generación de documentos

Como funcionalidad adicional de uso profesional, la aplicación permitiría la generación de informes en formato **PDF** mediante la librería `iText`. Estos documentos incluirían los resúmenes, gráficos y estadísticas más relevantes, permitiendo al gestor compartir el estado de la ciudad con otros departamentos o almacenarlo fuera de la aplicación. Por último, se ofrecería la exportación de datos en formato **CSV**, facilitando su análisis en herramientas externas como `Excel` o sistemas de información geográfica (**GIS**).

---

### Integración y enfoque profesional

Toda la funcionalidad de informes estaría completamente integrada dentro de la aplicación y seguiría los principios de **arquitectura limpia**, separando la lógica de procesamiento de Firebase de la interfaz de usuario en Compose. De este modo, los informes de `Urbis Cádiz` no se limitan a mostrar datos en bruto, sino que proporcionan resúmenes visuales claros que ayudan a evaluar de forma objetiva las necesidades de accesibilidad de la ciudad.
