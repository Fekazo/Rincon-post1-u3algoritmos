# Rincon-post1-u3algoritmos
Checkpoint 3 — Benchmark ejecutado y analizado
El comando mvn clean package && java -jar target/benchmarks.jar se ejecutó sin errores y produjo la siguiente tabla de resultados (modo average time, µs/op):
Método	       n	      Tiempo promedio (µs)
Memoización	   10	      0.024
Memoización	   20	      0.046
Memoización	   30	      0.069
Memoización	   35	      0.085
Recursivo      10	      0.143
Recursivo	     20	      18.070
Recursivo	     30	      2251.253
Recursivo	     35	      24908.092
Tabulación	   10	      0.003
Tabulación	   20	      0.003
Tabulación	   30	      0.004
Tabulación	   35	      0.005




Análisis correlacionado con la complejidad teórica
Las tres implementaciones presentan comportamientos claramente diferenciados y consistentes con sus complejidades teóricas.
La variante recursiva ingenua muestra un crecimiento extremadamente acelerado. El tiempo pasa de 0.143 µs en n=10 a 24,908 µs en n=35. Entre n=30 y n=35 el tiempo se multiplica aproximadamente por 11, lo que refleja el comportamiento exponencial esperado de complejidad Θ(2^n). Este crecimiento se debe a que cada llamada genera dos subllamadas sin reutilización de resultados, produciendo un árbol de llamadas de tamaño exponencial.
La variante con memoización presenta crecimiento suave y prácticamente lineal. Los tiempos pasan de 0.024 µs en n=10 a 0.085 µs en n=35. El incremento es proporcional al tamaño de entrada, consistente con complejidad Θ(n). La mejora frente a la versión recursiva se debe a que cada subproblema se resuelve una única vez y se almacena en memoria.
La variante con tabulación bottom-up muestra también comportamiento lineal, pero con constantes significativamente menores. El tiempo crece de 0.003 µs a 0.005 µs entre n=10 y n=35, prácticamente constante en esta escala. Esto confirma su complejidad Θ(n) y además evidencia menor overhead que la versión memoizada, ya que evita recursión y estructuras auxiliares adicionales.

Confirmación del patrón esperado
Los resultados experimentales validan exactamente el patrón teórico esperado:
	La versión recursiva crece exponencialmente.
	Las versiones memoizada y tabulada crecen linealmente.
	La versión tabulada es la más eficiente en la práctica debido a menor overhead constante y uso de espacio O(1).
La diferencia entre recursivo y las otras variantes no es simplemente constante, sino de orden de crecimiento. Para n=35, la versión recursiva es aproximadamente:
                                            24908/0.085≈293,000
0.08524908≈293,000
veces más lenta que la versión memoizada.
Esto demuestra empíricamente cómo un algoritmo con peor complejidad asintótica se vuelve impracticable incluso para tamaños moderados de entrada.



Conclusión
El benchmark confirma la relación directa entre complejidad teórica y comportamiento empírico. La versión recursiva ingenua presenta crecimiento exponencial y rápidamente se vuelve inviable. Las versiones memoizada y tabulada presentan crecimiento lineal, siendo la tabulación la más eficiente debido a menores constantes ocultas y menor uso de memoria auxiliar.
Estos resultados evidencian la importancia de analizar tanto la complejidad asintótica como el comportamiento real medido experimentalmente.
