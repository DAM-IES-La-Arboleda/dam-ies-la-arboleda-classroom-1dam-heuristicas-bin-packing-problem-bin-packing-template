# 📦 Práctica: Optimización de Bin Packing (Heurísticas)

Bienvenido al repositorio de la práctica de **Bin Packing**. En este proyecto, te enfrentarás a uno de los problemas más icónicos de la optimización combinatoria, donde la eficiencia de tu código marcará la diferencia entre una solución mediocre y una excelente.

## 1. 🧩 El Problema: Bin Packing
El problema del empaquetado de contenedores consiste en lo siguiente:
Dado un conjunto de objetos, cada uno con un peso específico ($w_i$), y una capacidad máxima de contenedor ($C$), el objetivo es distribuir todos los objetos utilizando el **menor número de contenedores posible**.

### El Desafío Computacional
Este problema es de clase **NP-Duro (NP-Hard)**. A diferencia de problemas simples, no existe un algoritmo conocido que encuentre la solución óptima de forma rápida para grandes volúmenes de datos. Por ello, en ingeniería se utilizan **Heurísticas**: reglas o estrategias inteligentes que encuentran soluciones muy cercanas a la perfección en un tiempo de ejecución mínimo.

---

## 2. 🎯 Tu Objetivo
Tu misión es implementar una heurística eficiente en la clase:
👉 `src/solution/BaseSolver.java`

Deberás completar el método `solve`, que recibe la capacidad y la lista de pesos, y devuelve tu propuesta de distribución de contenedores.

---

## 3. 🏗️ Estructura del Proyecto
El proyecto está organizado para que te centres exclusivamente en el algoritmo:

* **`src/core/` (PROHIBIDO MODIFICAR):** Contiene la interfaz `BinPackingSolver`, el validador de integridad y el motor de evaluación. Cualquier cambio en este paquete anulará la práctica.
* **`src/solution/` (TU ZONA DE TRABAJO):** Aquí es donde ocurre la magia. Puedes implementar cualquier estrategia: desde algoritmos voraces (Greedy) hasta técnicas de búsqueda local.
* **`data/public/`:** Un conjunto de casos de prueba extraídos de la librería clásica de *Falkenauer* para que pruebes tu código en local.

---

## 📊 4. Sistema de Puntuación (Score)
Tu nota no es binaria (pasa/no pasa), sino que se basa en la **calidad de tu optimización**. El sistema calcula un **Score** comparando tu resultado con la **Cota Inferior Teórica (Lower Bound)**:

$$Score = \left( \frac{\text{Mínimo matemático de contenedores}}{\text{Contenedores usados por ti}} \right) \times 100$$

### Escala de evaluación:
* **95 - 100:** Heurística de nivel experto. Estás alcanzando el óptimo en casi todos los casos.
* **80 - 94:** Heurística sólida. Has implementado mejoras significativas sobre el algoritmo base.
* **70 - 79:** Heurística básica (ej. First Fit). Es un buen comienzo, pero hay mucho margen de mejora.
* **INVALID:** Si tu solución sobrepasa la capacidad de un bin o "pierde" objetos por el camino, tu score será **0**.

---

## 🚀 5. Cómo empezar

### Requisitos previos
* Java JDK 17 o superior instalado.

### Ejecución en local
Para probar tu algoritmo antes de subirlo a GitHub, utiliza la terminal desde la raíz del proyecto:

1.  **Compilar:**
    ```bash
    javac -d out src/core/*.java src/solution/*.java
    ```

2.  **Ejecutar Evaluación:**
    ```bash
    java -cp out core.Main data/public
    ```

---

## 🏆 6. Evaluación Automática y Leaderboard
Cada vez que hagas un `git push` a tu repositorio:
1.  **GitHub Actions** detectará el cambio y ejecutará tu código contra un set de **Tests Privados**.
2.  Podrás revisar los resultados detallados en la pestaña **Actions** de tu repositorio en GitHub.
3.  Tu mejor puntuación se verá reflejada en el **Leaderboard de la clase**. ¡Demuestra que tu algoritmo es el más eficiente!

---

## 💡 Consejos Técnicos
* **Cuidado con los decimales:** El problema utiliza pesos de tipo `double`. Asegúrate de no cometer errores de redondeo.
* **El orden importa:** Las heurísticas suelen comportarse de forma muy distinta si los datos están ordenados de mayor a menor.
* **Eficiencia:** Algunos tests contienen miles de objetos. Si tu algoritmo es $O(n^2)$ o superior, podrías exceder el tiempo de ejecución permitido.

---
*¡Buena suerte! La eficiencia de los contenedores del mundo está en tus manos.*