package mystars;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
//            System.out.println("(1) Show number of empty seats");
//            System.out.println("(2) Show the list of empty seats");
//            System.out.println("(3) Show the list of seat assignments by seat ID");
//            System.out.println("(4) Show the list of seat assignments by customer ID");
//            System.out.println("(5) Assign a customer to a seat");
//            System.out.println("(6) Remove a seat assignment");
//            System.out.println("(7) Exit");
//            System.out.print("Enter the number of your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: System.out.println("1...");
                    break;
                case 2: System.out.println("2...");
                    break;
                case 3: System.out.println("3...");
                    break;
                case 4: System.out.println("4...");
                    break;
                case 5:
                    System.out.println("5...");
                    break;
                case 6:
                    System.out.println("6...");
                    break;

                case 7: System.out.println("Program terminating...");break;
            }
        } while (choice<7);
    }

}
