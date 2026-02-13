## RA2.c - Interacción por voz

La interacción por voz es una de las modalidades más potentes de las Interfaces Naturales de Usuario (NUI), ya que permite la transferencia de información compleja mediante el lenguaje natural, eliminando la barrera física del teclado. En **Urbis Cádiz**, esta tecnología es vital para cumplir con los estándares de accesibilidad universal.

---

### ¿Qué es la Interacción por Voz?

Se basa en la tecnología **Speech-to-Text (STT)**, que utiliza algoritmos de procesamiento de señales y redes neuronales para transcribir ondas sonoras en texto alfanumérico. A diferencia de las interfaces gráficas tradicionales, la voz permite una interacción de "manos libres", lo que resulta fundamental en entornos de movilidad urbana donde el usuario puede estar caminando o tener limitaciones motrices.

---

### ¿Cómo funciona en Urbis Cádiz?

La aplicación utiliza el motor de reconocimiento de voz nativo de Android (**Google Voice Services**). El flujo técnico se resume en los siguientes pasos:

1. **Activación:** El usuario pulsa un icono de micrófono situado en el formulario de reporte.
2. **Captura:** Se lanza un `Intent` de reconocimiento (`RecognizerIntent`) que abre un asistente de escucha. El sistema aísla la voz del ruido ambiental de la calle.
3. **Procesamiento:** El audio se procesa localmente (o mediante servicios en la nube de Google) para identificar palabras y estructuras gramaticales.
4. **Inserción:** El texto resultante se vuelca automáticamente en el campo de descripción de la incidencia, permitiendo al usuario revisar y editar antes de enviar.



---

### Ubicación y Uso en la App

La interacción por voz está integrada estratégicamente en la **Pantalla de Reporte de Incidencias** (`AddIncidenciaScreen`):

* **Campo de Descripción:** Es el lugar principal de uso. Reportar una barrera arquitectónica puede requerir una explicación detallada (ej: *"Rampa con pendiente excesiva y pavimento resbaladizo cerca de la farmacia"*). Dictar este texto es mucho más rápido y natural que escribirlo mientras se está en la calle.
* **Accesibilidad para el Administrador:** El gestor municipal también puede utilizar el dictado para añadir notas de voz en la resolución de los informes, agilizando la gestión burocrática desde el trabajo de campo.

---

### Justificación de su Inclusión

1. **Inclusividad:** Fundamental para usuarios con diversidad funcional visual o motriz.
2. **Contexto de Uso:** Urbis es una app de "uso en exteriores". El dictado por voz minimiza el tiempo que el usuario pasa mirando la pantalla, aumentando su seguridad al caminar.
3. **Eficiencia:** Reduce drásticamente el tiempo de creación de un reporte, fomentando que los ciudadanos envíen más incidencias al simplificar el proceso.
