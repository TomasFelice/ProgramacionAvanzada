# Consigna
Sea una matriz de enteros de tamaño n x n. Ésta representa una imagen, y se pide rotarla 90 grados en sentido horario.
Se debe rotar la imagen en su lugar, lo que significa que se debe modificar directamente la matriz de entrada.
NO asignar otra matriz 2D y realizar la rotación.

### Ejemplo 1
##### Entrada:
```
1 2 3
4 5 6
7 8 9
```
##### Salida:
```
7 4 1
8 5 2
9 6 3
```
### Ejemplo 2
##### Entrada:
```
5  1  9 11
2  4  8 10
13  3  6  7
15 14 12 16
```
##### Salida:
```
15 13  2  5
14  3  4  1
12  6  8  9
16  7 10 11
```
## Restricciones
```
n == imagen.length == imagen[i].length
1 <= n <= 20
-1000 <= imagen[i][j] <= 1000
```
## Prototipo sugerido
`public static void rotar90(int[][] imagen)`