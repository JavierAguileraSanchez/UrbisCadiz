# Urbis Cádiz - Gestión de Accesibilidad Urbana

---

## Descripción

**Urbis Cádiz** es una aplicación diseñada con el framework **Jetpack Compose** que actúa como una plataforma colaborativa para mejorar la movilidad urbana. A diferencia de otras aplicaciones de mapas, Urbis permite a los usuarios reportar barreras arquitectónicas y problemas de accesibilidad en tiempo real mediante herramientas de interacción natural (NUI), facilitando que los gestores municipales identifiquen y resuelvan puntos críticos en la ciudad.


---

## Motivación

La movilidad es un derecho fundamental, pero para muchas personas con diversidad funcional, las ciudades están llenas de obstáculos invisibles: rampas mal diseñadas, baches o falta de señalización. A menudo, el problema no es solo la barrera física, sino la falta de un canal directo y eficiente para comunicar estos incidentes.

**Urbis Cádiz** nace para resolver esto. Permite que cualquier ciudadano, mediante herramientas intuitivas como el dictado por voz y la geolocalización, reporte una incidencia. Esto no solo ayuda a otros usuarios a planificar sus rutas, sino que ofrece a los administradores una herramienta de gestión profesional para priorizar reparaciones y hacer de Cádiz una ciudad para todos, transformando la queja pasiva en acción colaborativa.

---

## Estructura del proyecto

Para organizar las clases y funciones siguiendo principios de **Clean Architecture**, he decidido seguir esta estructura de paquetes:

- [`Directorio Data`](app/src/main/java/com/example/urbis/data): Actúa como la capa de infraestructura. Conoce detalles técnicos de **Firebase** y formatos de datos.
  - [`Carpeta Model`](app/src/main/java/com/example/urbis/data/model): Define las entidades base como `Incidencia.kt` y `Usuario.kt`.
  - [`Carpeta Repository`](app/src/main/java/com/example/urbis/data/repository): Implementa la lógica de acceso a datos, gestionando el CRUD en **Firestore** y la subida de medios a **Cloud Storage**.
- [`Directorio Domain`](app/src/main/java/com/example/urbis/domain): Contiene las interfaces y reglas de negocio puras, desacoplando la lógica de la implementación técnica.
- [`Directorio UI`](app/src/main/java/com/example/urbis/ui): Encargado de la presentación e interacción.
  - [`Carpeta Components`](app/src/main/java/com/example/urbis/ui/components): Contiene componentes reutilizables como `UrbisPrimaryButton` y `UrbisIncidenciaCard` para mantener la coherencia visual.
  - [`Carpeta Navigation`](app/src/main/java/com/example/urbis/ui/navigation): Define el `NavHost`, las rutas y el flujo entre pantallas mediante una arquitectura de navegación moderna.
  - [`Carpeta Screens`](app/src/main/java/com/example/urbis/ui/screens): Alberga las pantallas principales junto a sus estados de interfaz.
  - [`Carpeta Theme`](app/src/main/java/com/example/urbis/ui/theme): Gestiona la identidad visual (colores, tipografía y formas) basada en Material 3.
  - [`Carpeta ViewModel`](app/src/main/java/com/example/urbis/ui/viewmodel): Controladores de estado que coordinan la lógica necesaria para que la interfaz reaccione a los cambios de datos en tiempo real.
---

## Flujo del programa

1. **Autenticación:** El usuario se registra o loguea mediante [`LoginScreen`](app/src/main/java/com/example/urbis/ui/screens/auth/LoginScreen.kt). El sistema verifica su rol (`user` o `admin`) en Firestore.
2. **Exploración:** Se accede a la [`MapScreen`](app/src/main/java/com/example/urbis/ui/screens/MapScreen.kt). El ciudadano ve marcadores de incidencias ya aprobadas.
3. **Reporte NUI:** - Mediante un **gesto de pulsación larga** en el mapa, se activa el formulario de creación.
   - El usuario rellena los datos pudiendo usar el **dictado por voz** para la descripción.
   - Se adjunta una imagen que se procesa y sube a Firebase.
4. **Gestión Administrativa:** Si el usuario tiene el rol de administrador, puede acceder a la [`AdminListScreen`](app/src/main/java/com/example/urbis/ui/screens/AdminListScreen.kt).
   - El administrador revisa la lista de reportes "pendientes".
   - Puede **aprobar** (haciéndola pública) o **rechazar/eliminar** la incidencia (borrándola de la base de datos).
5. **Navegación:** En cualquier momento, el usuario puede usar el **Navigation Drawer** (menú lateral) para moverse entre el mapa, la gestión o cerrar sesión.

---

## Características Principales

`Urbis Cádiz` destaca por funcionalidades avanzadas que fomentan la participación ciudadana:

- **Mapa en Tiempo Real:** Visualización dinámica de marcadores que se actualizan sin recargar la app gracias a los `Flows` de Kotlin conectados a Firestore.
- **Interacción Natural (RA2):** Implementación de reconocimiento de voz para facilitar el reporte a personas con dificultades motrices, cumpliendo con estándares de accesibilidad NUI.
- **Gestión de Evidencias:** Sistema de subida de imágenes vinculado a cada reporte para que el administrador tenga pruebas visuales de la barrera arquitectónica.
- **Filtro de Seguridad:** Lógica de administración que permite mantener la base de datos libre de reportes falsos o duplicados mediante un sistema de validación humana.

---

## Justificación de Diseño y Usabilidad

El diseño se centra en la **eficacia y la reducción de la carga cognitiva**. Se han aplicado principios de Material Design 3 para ofrecer una interfaz limpia donde el mapa es el protagonista.

### Consideraciones de usabilidad
- **Control de Gestos:** Se ha bloqueado el gesto de apertura del Drawer en la pantalla del mapa para evitar conflictos con la navegación táctil del usuario (**RA4.i**).
- **Consistencia Visual:** Uso de botones con colores semánticos (Rojo para acciones destructivas como rechazar, Azul para acciones primarias).
- **Feedback:** Indicadores de progreso asíncronos para informar al usuario de que su reporte se está enviando correctamente.

### Consideraciones de accesibilidad
- **Interacción por Voz:** Característica clave para usuarios que no pueden interactuar fácilmente con el teclado.
- **Contraste Elevado:** Paleta de colores optimizada para ser legible en exteriores bajo la luz del sol.
- **Estructura Clara:** Uso de tarjetas (`Cards`) para separar visualmente cada incidencia y sus acciones asociadas.

---

## Herramientas y librerías

### Herramientas NUI

- Acerca de las herramientas de componentes usadas: [`Herramientas Usadas`](herramientas/HerramientasUsadas.md)
- Acerca del `RA2.a Herramientas NUI`: [`Herramientas NUI`](herramientas/HerramientasNUI.md)
- Acerca del `RA2.b Diseño teórico NUI`: [`Diseño NUI`](herramientas/DiseñoNUI.md)
- Acerca del `RA2.c Interacción por voz`: [`Interacción por voz`](herramientas/InteracciónVoz.md)
- Acerca del `RA2.d Interacción por gesto`: [`Interacción por gesto`](herramientas/InteracciónGesto.md)
- Acerca del `RA2.e Detección facial/corporal`: [`Detección facial o corporal`](herramientas/DetecciónCorporal.md)
- Acerca del `RA2.f Realidad aumentada`: [`Realidad Aumentada`](herramientas/RealidadAumentada.md)

### Informes

En Urbis Cádiz, la transformación de reportes individuales en datos colectivos permite generar informes de puntos negros de accesibilidad en la ciudad.
- [`Herramientas para generar informes`](herramientas/HerramientasInformes.md)

### Guías de ayuda

Estrategias para garantizar una experiencia accesible y profesional para ciudadanos y gestores.
- [`Guías de ayuda`](GuiaAyuda.md)

---

## Empaquetado de la aplicación

Planificación de la distribución, firma digital y construcción del paquete para su instalación en dispositivos Android.
- [`Empaquetado de la Aplicación`](Empaquetado.md)

---

## Manual de usuario de la aplicación

Documento clave para entender los flujos de reporte y las herramientas de administración.
- [`Manual`](ManualUsuario.md)

---

## Pruebas avanzadas

Análisis de rendimiento, seguridad de las reglas de Firebase y pruebas de estrés de carga de marcadores.
- [`Pruebas Avanzadas`](PruebasAvanzadas.md)

---

## Vídeo de explicación y de uso

Tutorial visual para resolver dudas sobre el uso de la interfaz y las herramientas NUI.

- [`Vídeo Tutorial`](https://drive.google.com/file/d/1t3YqziA5TgV1LtBkHJcCq3_YOMf4wpTA/view?usp=sharing)
