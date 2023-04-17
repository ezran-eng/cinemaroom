package org.example;
/*
¡El menú, por favor!
5 / 5 Requisitos previos
Declaración de cambio
Declarar un método
El método principal
Descomposición funcional
Matrices como parámetros
Descripción
El teatro se está volviendo popular y los clientes comenzaron a quejarse de que no es práctico que el programa se detenga después de comprar un boleto. Agreguemos un menú que les permitirá comprar boletos y mostrar el estado actual de la disposición de los asientos cuando sea necesario.

Objetivos
Al principio, su programa debe leer dos números enteros positivos que representen el número de filas y asientos en cada fila. Luego, debe imprimir un menú con los siguientes tres elementos:

Show the seatsdebe imprimir la disposición actual de los asientos. Los asientos vacíos deben estar marcados con un Ssímbolo y los asientos ocupados están marcados con un Bsímbolo.
Buy a ticketdebe leer las coordenadas del asiento desde la entrada e imprimir el precio del boleto como en la etapa anterior. Después de eso, el asiento elegido debe marcarse con una Bcuando Show the seatsse llama el elemento.
Exitdebe detener el programa.
Ejemplo
El símbolo mayor que seguido de un espacio ( > ) representa la entrada del usuario. Tenga en cuenta que no es parte de la entrada.

Enter the number of rows:
> 7
Enter the number of seats in each row:
> 7

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S S S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 4
Enter a seat number in that row:
> 5
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 6
Enter a seat number in that row:
> 6
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S B S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 0
*/

import java.util.Scanner;

public class Main {
    static int rows;
    static int seats;
    static char[][] seating;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();

        seating = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                seating[i][j] = 'S';
            }
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n0. Exit");
            switch (scanner.nextInt()) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    showSeats();
                    break;
                case 2:
                    buyTicket(scanner);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    public static void showSeats() {
        System.out.println("\nCinema:");
        System.out.print(" ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(seating[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void buyTicket(Scanner scanner) {
        int row;
        int seat;
        boolean valid = false;
        while (!valid) {
            System.out.println("\nEnter a row number:");
            row = scanner.nextInt() - 1;
            System.out.println("Enter a seat number in that row:");
            seat = scanner.nextInt() - 1;
            if (row >= 0 && row < rows && seat >= 0 && seat < seats) {
                if (seating[row][seat] == 'B') {
                    System.out.println("That ticket has already been purchased");
                } else {
                    int price = calculatePrice(row);
                    System.out.println("Ticket price: $" + price);
                    seating[row][seat] = 'B';
                    valid = true;
                }
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public static int calculatePrice(int row) {
        int totalSeats = rows * seats;
        if (totalSeats <= 60) {
            return 10;
        } else {
            int frontHalf = rows / 2;
            if (row < frontHalf) {
                return 10;
            } else {
                return 8;
            }
        }
    }
}