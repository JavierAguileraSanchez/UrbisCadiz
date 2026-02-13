## RA8 - Plan de Pruebas y Control de Calidad

Este documento recoge la estrategia de validación de **Urbis Cádiz**, asegurando que el sistema de reporte y la gestión de roles en Firebase funcionan según los requisitos técnicos.

---

### RA8.a Estrategia de Pruebas

Se ha optado por una estrategia de pruebas funcional y de caja negra. El objetivo es verificar que la comunicación entre el frontend (Android) y el backend (Firebase) sea consistente. 

**Criterios de éxito:**
1. Los reportes deben incluir coordenadas GPS exactas obtenidas mediante NUI.
2. Los usuarios solo deben acceder a las funciones permitidas por su campo `role`.
3. La interfaz debe responder en menos de 2 segundos ante la carga de datos.

---

### RA8.b Pruebas de Integración

Se ha verificado el flujo de datos completo entre módulos:
- **Flujo:** Login -> Consulta de `role` -> Interacción con Mapa -> Envío a Firestore -> Notificación de éxito.
- **Resultado:** El sistema integra correctamente el reconocimiento de voz de Google con la persistencia en la nube. Los datos introducidos por voz se almacenan como cadenas de texto íntegras en la colección de incidencias.

---

### RA8.c Pruebas de Regresión

Para asegurar la estabilidad, se han realizado pruebas tras cada modificación en la estructura de la colección `usuarios`.
- **Verificación:** Se ha comprobado que al añadir nuevas capacidades de reporte, el sistema de login y la visualización de marcadores antiguos en el mapa de Cádiz no se ven alterados. La app mantiene la retrocompatibilidad con los datos ya existentes en Firebase.

---

### RA8.d Pruebas de Volumen y Estrés

Se ha evaluado la respuesta del SDK de Google Maps ante la carga masiva de incidencias.
- **Prueba:** Visualización de más de 100 marcadores simultáneos en una zona reducida de la ciudad.
- **Resultado:** La aplicación gestiona la memoria de forma eficiente. El tiempo de respuesta en la carga inicial se mantiene por debajo de los 1.5 segundos, garantizando una navegación fluida por el mapa.

---

### RA8.e Pruebas de Seguridad

El pilar de seguridad de Urbis Cádiz reside en la gestión de roles.
- **Control de Acceso:** Se ha validado que el código bloquea las funciones de edición y borrado si el campo `role` del usuario es distinto de "admin".
- **Integridad:** Las reglas de seguridad de Firebase (Security Rules) han sido testeadas para impedir que un usuario autenticado pueda borrar documentos que no le pertenecen.

---

### RA8.g Documentación y Matriz de Resultados

Para una trazabilidad profesional, se adjunta la tabla de resultados de la última batería de pruebas realizada:

| ID | Caso de Prueba | Resultado Esperado | Estado |
| :--- | :--- | :--- | :--- |
| **01** | Login de Usuario | Acceso al mapa según `role` | **ÉXITO** |
| **02** | Long Click en Mapa | Captura automática de latitud/longitud | **ÉXITO** |
| **03** | Dictado por Voz | Transcripción de audio a texto en formulario | **ÉXITO** |
| **04** | Carga de Imagen | Almacenamiento correcto en el reporte | **ÉXITO** |
| **05** | Filtro Admin | Visibilidad de botones Aprobar/Rechazar | **ÉXITO** |

**Conclusión:** La aplicación cumple con el 100% de los requisitos críticos definidos en la estrategia de pruebas, mostrando una arquitectura estable y segura para su despliegue.
