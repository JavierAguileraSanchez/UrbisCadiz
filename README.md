# Urbis Cádiz - Movilidad y Accesibilidad Universal 

**Urbis Cádiz** es una aplicación nativa para Android diseñada para identificar y reportar barreras arquitectónicas en la ciudad de Cádiz. El objetivo principal es mejorar la calidad de vida de las personas con movilidad reducida mediante el mapeo colaborativo de obstáculos urbanos.

---

##  Propósito del Proyecto
La aplicación permite a los ciudadanos actuar como "sensores de accesibilidad". Al identificar un problema (rampa rota, acera bloqueada, ascensor averiado), el usuario puede geolocalizarlo y subir una evidencia fotográfica para que los gestores municipales puedan priorizar su reparación.

##  Características Principales
- **Mapa en Tiempo Real:** Visualización de incidencias mediante Google Maps SDK.
- **Reporte Multimedia:** Captura y subida de imágenes a la nube (Firebase Storage).
- **Gestión por Roles:** - **Explorador:** Ciudadano que reporta barreras.
  - **Gestor:** Administrador que valida y aprueba los reportes.
- **Navegación Inteligente:** Filtro por coordenadas para localizar incidencias exactas.

##  Stack Tecnológico
- **Lenguaje:** [Kotlin](https://kotlinlang.org/)
- **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3)
- **Backend:** [Firebase](https://firebase.google.com/) (Auth, Firestore, Storage)
- **Mapas:** Google Maps SDK for Android
- **Carga de Imágenes:** Coil

##  Arquitectura
El proyecto sigue el patrón arquitectónico **MVVM (Model-View-ViewModel)** y los principios de **Clean Architecture**, garantizando un código mantenible, testable y escalable.



##  Instalación y Despliegue
1. **Clonar el repo:**
   ```bash
   git clone [https://github.com/tu-usuario/urbis-cadiz.git](https://github.com/JavierAguileraSanchez/urbis-cadiz.git)
