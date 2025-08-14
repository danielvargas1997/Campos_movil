# Campos_movil

Aplicación Android (Kotlin) que permite encontrar generadores de un campo finito (en este caso, del grupo multiplicativo de un campo finito GF(p), donde *p* es un número primo).

## 📱 Descripción
Esta app permite:
- Ingresar un número primo `p`.
- Calcular todos los generadores (elementos primitivos) del grupo de unidades del campo finito GF(p).
- Mostrar los resultados en pantalla.

Es ideal para fines educativos en álgebra y teoría de números.

## 🛠 Tecnologías usadas
- **Lenguaje:** Kotlin
- **Entorno:** Android Studio
- **Diseño UI:** XML (layout básico con `EditText`, `Button` y `TextView`)

## 📂 Estructura principal del código
- **MainActivity.kt**: Lógica de la aplicación.
  - Lectura de entrada del usuario.
  - Verificación de que el número sea primo.
  - Cálculo de generadores usando teoría de grupos.
- **activity_main.xml**: Interfaz gráfica.
  - Campo de texto para el número primo.
  - Botón para calcular.
  - Área de texto para mostrar resultados.

## 🚀 Cómo ejecutar
1. Clona el repositorio:
   ```bash
   git clone https://github.com/danielvargas1997/Campos_movil.git
