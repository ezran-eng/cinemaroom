package org.example;
/*
DESCRIPCION

OBJETIVOS
Lea dos números enteros positivos que representen el número de filas y asientos en cada fila e imprima la disposición de los asientos como en la primera etapa. Luego, lea dos números enteros de la entrada: un número de fila y un número de asiento en esa fila. Estos números representan las coordenadas del asiento según el cual el programa debe imprimir el precio del boleto. El precio de la entrada se determina con las mismas reglas que la etapa anterior:

Si el número total de asientos en la sala de pantalla no supera los 60, entonces el precio de cada boleto es de 10 dólares.
En una sala más grande, los boletos cuestan 10 dólares para la mitad delantera de las filas y 8 dólares para la mitad trasera. Tenga en cuenta que el número de filas puede ser impar, por ejemplo, 9 filas. En este caso, la primera mitad son las primeras 4 filas y la segunda mitad son las últimas 5 filas.
Después de eso, el programa debe imprimir todos los asientos en la sala de pantalla como se muestra en el ejemplo y marcar el asiento elegido con el Bsímbolo. Finalmente, debe imprimir el precio del boleto y detenerse. Tenga en cuenta que en este proyecto, el número de filas y asientos no será mayor a 9.

Ejemplos
El símbolo mayor que seguido de un espacio ( > ) representa la entrada del usuario. Tenga en cuenta que no es parte de la entrada.

Ejemplo 1

Enter the number of rows:
> 7
Enter the number of seats in each row:
> 8

Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S S S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S

Enter a row number:
> 3
Enter a seat number in that row:
> 6

Ticket price: $10

Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S B S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S
Ejemplo 2

Enter the number of rows:
> 8
Enter the number of seats in each row:
> 9

Cinema:
  1 2 3 4 5 6 7 8 9
1 S S S S S S S S S
2 S S S S S S S S S
3 S S S S S S S S S
4 S S S S S S S S S
5 S S S S S S S S S
6 S S S S S S S S S
7 S S S S S S S S S
8 S S S S S S S S S

Enter a row number:
> 6
Enter a seat number in that row:
> 5

Ticket price: $8

Cinema:
  1 2 3 4 5 6 7 8 9
1 S S S S S S S S S
2 S S S S S S S S S
3 S S S S S S S S S
4 S S S S S S S S S
5 S S S S S S S S S
6 S S S S B S S S S
7 S S S S S S S S S
8 S S S S S S S S S
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of rows and seats in each row
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        // Initialize the cinema array
        char[][] cinema = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = 'S';
            }
        }

        // Print the initial seating arrangement
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int j = 1; j <= seats; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }

        // Read the row and seat numbers of the chosen seat
        System.out.println("Enter a row number:");
        int chosenRow = scanner.nextInt() - 1;
        System.out.println("Enter a seat number in that row:");
        int chosenSeat = scanner.nextInt() - 1;

        // Calculate the ticket price based on the number of seats
        int totalSeats = rows * seats;
        int ticketPrice;
        if (totalSeats <= 60) {
            ticketPrice = 10;
        } else {
            int frontRows = rows / 2;
            int backRows = rows - frontRows;
            if (chosenRow < frontRows) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }

        // Update the seating arrangement with the chosen seat
        cinema[chosenRow][chosenSeat] = 'B';

        // Print the final seating arrangement and the ticket price
        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int j = 1; j <= seats; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }
}
