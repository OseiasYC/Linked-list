package tui;

import java.util.Scanner;

import controller.List;

public class Menu {
    Scanner input = new Scanner(System.in);
    String choice, information;
    List list = new List();

    public void MenuTUI() {

        System.out.print("----------------------------------" +
                "\n 1- Set a head in list\n 2- Set a tail in list\n 3- Remove index\n 4- Show list\n 5- Find in the list\n 0- Close\n\nPut your choice: ");
        choice = input.next();

        switch (choice) {
            case "1":
                System.out.println("\nSet information: ");
                information = input.next();
                list.setHead(information);
                break;

            case "2":
                System.out.println("\nSet information: ");
                information = input.next();
                list.setTail(information);
                break;
            case "3":
                int position = 0;
                System.out.println("\nSet index (0 - n): ");
                position = input.nextInt();
                list.removeIndex(position);
                System.out.println("\n" + list.toString());
                break;
            case "4":
                System.out.println("\n" + list.toString());
                break;
            case "5":
                System.out.println("\nSet information: ");
                information = input.next();
                System.out.println(list.findString(information));
                break;
            case "0":
                System.exit(0);
            default:
                System.out.println("\nJust type the integer numbers in context.");
                break;
        }

        MenuTUI();

    }

}
