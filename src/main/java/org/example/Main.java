package org.example;
/*
¡Buen trabajo! ¡A nuestros amigos realmente les gustó tu programa! Ahora quieren expandir su cine y agregar salas de proyección con más asientos. Sin embargo, esto es costoso, por lo que quieren asegurarse de que valga la pena. Ayúdalos a calcular la ganancia de todas las entradas vendidas según el número de asientos disponibles.

Objetivos:
En esta etapa, debes leer dos números enteros positivos de la entrada: el número de filas y el número de asientos en cada fila. El precio de la entrada se determina según las siguientes reglas:
Si el número total de asientos en la sala no es superior a 60, entonces el precio de cada entrada es de 10 dólares.
En una sala más grande, las entradas cuestan 10 dólares para la mitad delantera de las filas y 8 dólares para la mitad trasera. Ten en cuenta que el número de filas puede ser impar, por ejemplo, 9 filas. En este caso, la primera mitad son las primeras 4 filas y la segunda mitad son las otras 5 filas.
Calcula la ganancia de las entradas vendidas según el número de asientos y muestra el resultado como se muestra en los ejemplos a continuación. Después de eso, tu programa debe detenerse. Ten en cuenta que en este proyecto, el número de filas y asientos no será mayor que 9.

Ejemplos
El símbolo mayor que seguido de un espacio (> ) representa la entrada del usuario. Ten en cuenta que no forma parte de la entrada.
Ejemplo 1

Introduce el número de filas:
4
Introduce el número de asientos en cada fila:
5
Ingresos totales:
$200

Ejemplo 2
Introduce el número de filas:
8
Introduce el número de asientos en cada fila:
9
Ingresos totales:
$648

Ejemplo 3
Introduce el número de filas:
9
Introduce el número de asientos en cada fila:
7
Ingresos totales:
$560
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número de filas:");
        int rows = scanner.nextInt();
        System.out.println("Introduce el número de asientos en cada fila:");
        int seats = scanner.nextInt();
        int totalSeats = rows * seats;
        System.out.println("Ingresos totales:");
        if (totalSeats <= 60) {
            System.out.println("$" + totalSeats * 10);
        } else {
            int frontRows = rows / 2;
            int backRows = rows - frontRows;
            System.out.println("$" + (frontRows * seats * 10 + backRows * seats * 8));
        }
        

    }
}