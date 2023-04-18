package org.example;
/*
Description
Running a cinema theatre is no easy business. To help our friends, let's add statistics to your program. The stats will show the current income, total income, the number of available seats, and the percentage of occupancy.

In addition, our friends asked you to take care of a small inconvenience: it's not good when a user can buy a ticket that has already been purchased by another user. Let's fix this!

Objectives
Now your menu should look like this:

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
When the item Statistics is chosen, your program should print the following information:

The number of purchased tickets;
The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
Current income;
The total income that shows how much money the theatre will get if all the tickets are sold.
The rest of the menu items should work the same way as before, except the item Buy a ticket shouldn't allow a user to buy a ticket that has already been purchased.

If a user chooses an already taken seat, print That ticket has already been purchased! and ask them to enter different seat coordinates until they pick an available seat. Of course, you shouldn't allow coordinates that are out of bounds. If this happens, print Wrong input! and ask to enter different seat coordinates until the user picks an available seat.

Examples
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Enter the number of rows:
> 6
Enter the number of seats in each row:
> 6

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 0
Percentage: 0.00%
Current income: $0
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
> 1
Enter a seat number in that row:
> 1

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 1
Percentage: 2.78%
Current income: $10
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
> 1
Enter a seat number in that row:
> 1

That ticket has already been purchased!

Enter a row number:
> 10
Enter a seat number in that row:
> 20

Wrong input!

Enter a row number:
> 4
Enter a seat number in that row:
> 4

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 1

Cinema:
  1 2 3 4 5 6
1 B S S S S S
2 S S S S S S
3 S S S S S S
4 S S S B S S
5 S S S S S S
6 S S S S S S

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 2
Percentage: 5.56%
Current income: $20
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 0
 */

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int rows;
    static int seatsPerRow;
    static int totalSeats;
    static int currentIncome;
    static int totalIncome;
    static boolean[][] seats;
    public static void main(String[] args) {
        readInput();
        initSeats();
        menu();
    }
    public static void readInput() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsPerRow = scanner.nextInt();
        totalSeats = rows * seatsPerRow;
        totalIncome = calculateTotalIncome();
    }

    public static void initSeats() {
        seats = new boolean[rows][seatsPerRow];
    }

    public static void menu() {
        while (true) {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showSeats();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    showStatistics();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    public static void showSeats() {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 1; i <= seatsPerRow; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seatsPerRow; j++) {
                System.out.print(seats[i][j] ? "B " : "S ");
            }
            System.out.println();
        }
    }

    public static void buyTicket() {
        int row;
        int seat;
        while (true) {
            System.out.println("\nEnter a row number:");
            row = scanner.nextInt() - 1;
            System.out.println("Enter a seat number in that row:");
            seat = scanner.nextInt() - 1;
            if (row < 0 || row >= rows || seat < 0 || seat >= seatsPerRow) {
                System.out.println("Wrong input!");
            } else if (seats[row][seat]) {
                System.out.println("That ticket has already been purchased!");
            } else {
                break;
            }
        }
        seats[row][seat] = true;
        int ticketPrice = calculateTicketPrice(row, rows, seatsPerRow);
        System.out.printf("Ticket price: $%d\n", ticketPrice);
        currentIncome += ticketPrice;
    }

    public static void showStatistics() {
        int purchasedTickets = calculatePurchasedTickets();
        double percentage = calculatePercentage(purchasedTickets, totalSeats);
        System.out.printf("\nNumber of purchased tickets: %d\n", purchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.printf("Current income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d\n", totalIncome);
    }

    public static int calculateTicketPrice(int row, int numberOfRows, int numberOfSeatsInRow) {
        int totalSeats = numberOfRows * numberOfSeatsInRow;
        int frontHalfPrice = 10;
        int backHalfPrice = 8;
        int ticketPrice;

        if (totalSeats < 60) {
            ticketPrice = 10;
        } else {
            if (row < numberOfRows / 2) {
                ticketPrice = frontHalfPrice;
            } else {
                ticketPrice = backHalfPrice;
            }
        }

        return ticketPrice;
    }


    public static int calculateTotalIncome() {
        int frontRows = rows / 2;
        int backRows = rows - frontRows;
        return frontRows * seatsPerRow * 10 + backRows * seatsPerRow * 8;
    }

    public static double calculatePercentage(int numerator, int denominator) {
        if (denominator == 0) {
            return 0.0;
        }
        return (double) numerator / denominator * 100.0;
    }

    public static int calculatePurchasedTickets() {
        int purchasedTickets = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                if (seats[i][j]) {
                    purchasedTickets++;
                }
            }
        }
        return purchasedTickets;
    }
}
