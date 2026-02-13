## Estrategia de Compilación y Lanzamiento

Para que **Urbis Cádiz** pase de ser un proyecto de desarrollo a una herramienta funcional en los dispositivos de los ciudadanos, se ha diseñado un flujo de trabajo centrado en la seguridad del código y la optimización del rendimiento.

---

### Gestión del Paquete de Distribución (RA7.a, RA7.c)

La construcción de la aplicación se realiza mediante el motor de automatización **Gradle**. En lugar de un APK tradicional, se ha optado por el formato **Android App Bundle (.aab)**. 

* **Eficiencia en la entrega:** Este sistema permite que la plataforma de distribución genere archivos de instalación dinámicos. De este modo, el terminal del usuario solo descarga los recursos (imágenes, librerías) compatibles con su arquitectura, lo que optimiza el almacenamiento.
* **Entorno de generación:** Todo el proceso se centraliza en las *Build Variants* de Android Studio, utilizando la variante de "Release" para asegurar que el código esté minificado y los recursos innecesarios hayan sido eliminados mediante técnicas de *shrinking*.

---

### Identidad y Personalización (RA7.b)

El instalador ha sido configurado para transmitir confianza al usuario desde el primer contacto:

- **Branding y Estética:** Se ha integrado un *launcher icon* adaptativo que cumple con las guías de Material Design 3, facilitando su integración visual en cualquier capa de personalización de Android.
- **Control de Versiones:** Se utiliza un sistema de versionado incremental. El `versionCode` actúa como identificador interno para la gestión de actualizaciones, mientras que el `versionName` ofrece transparencia al ciudadano sobre las mejoras de accesibilidad introducidas en cada revisión.

---

### Integración de Tecnologías de Terceros (RA7.d)

El ecosistema de la aplicación se apoya en librerías externas que garantizan un acabado profesional y una funcionalidad robusta:

1. **Firebase Core & Firestore:** Motor encargado de la sincronización de las barreras arquitectónicas en tiempo real.
2. **Play Services Maps:** Proporciona la infraestructura cartográfica necesaria para el reporte geográfico preciso.
3. **iText / PDFBox-Android:** Herramientas seleccionadas para que la administración pueda transformar los datos digitales en documentos PDF oficiales para su archivo físico o firma.

---

### Garantía de Integridad y Seguridad (RA7.e)

Un pilar fundamental para la distribución es la **Firma Digital**. Se ha creado un certificado de seguridad único (*Keystore*) que vincula legalmente el software con su desarrollador.

- **Protección contra Alteraciones:** Esta firma evita que terceros puedan suplantar la aplicación con versiones maliciosas. Sin la clave privada original, es técnicamente imposible sobreescribir la app en el dispositivo del usuario, lo que garantiza que los reportes ciudadanos viajen siempre por un canal verificado y sin manipulaciones externas.

---

### Experiencia de Instalación y Ciclo de Vida (RA7.f, RA7.g)

Se ha buscado una experiencia de "configuración cero":

- **Instalación Directa:** La aplicación es totalmente autónoma tras su descarga. No requiere que el usuario realice ajustes técnicos manuales; los permisos críticos, como la ubicación, se gestionan de forma contextual y transparente durante la primera interacción con el mapa.
- **Borrado Limpio:** Si el usuario decide eliminar la app, el sistema operativo ejecuta un proceso de limpieza que elimina la caché, los datos de usuario y detiene cualquier escucha de base de datos activa, respetando la privacidad y la limpieza del sistema de archivos del terminal.

---

### Canales de Difusión (RA7.h)

Se han establecido dos vías diferenciadas para hacer llegar la herramienta a sus destinatarios:

- **Canal de Producción:** Publicación en tiendas oficiales para el acceso masivo de la ciudadanía de Cádiz.
- **Canal de Testing:** Distribución controlada de archivos firmados para usuarios específicos que validan la usabilidad (betatesters) y para el equipo técnico municipal antes de cada despliegue oficial.
