
// fix/improve all PRINT statements! (with color as well, research)
package utility;

import objects.Shelter;
import java.util.Scanner;
import java.util.ArrayList;
import objects.Pet;

public class Ink {
    private Scanner input = new Scanner(System.in);
    private int choice;

    // ANSI escape codes for colors
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";

    public int validateMainMenu() {
        boolean valid = false;

        while (!valid) {
            System.out.println(RED + "##### MAIN MENU #####");
            System.out.println("(1) View Pets\n(2) Shelter Details\n(3) Book Appointment\n(4) Exit" + RESET);
            try {
                choice = input.nextInt();
                if (choice >= 1 && choice <= 4) {
                    valid = true;
                } else {
                    System.out.println(RED + "Please enter a number between 1 and 4" + RESET);
                }
            } catch (Exception e) {
                System.out.println(RED + "That's not a number!" + RESET);
            } finally {
                input.nextLine();
            }
        }
        return choice;
    }

    public void printPetDetails(Pet pet) {
        System.out.printf("Name: %s\n", pet.getName());
        System.out.printf("Age: %d\n", pet.getAge());
        System.out.printf("Breed: %s\n", pet.getBreed());
        System.out.printf("Color: %s\n", pet.getColor());
        System.out.printf("Owner: %s\n", pet.getOwner());
        System.out.printf("Is Adopted: %s\n", pet.getIsAdopted() ? GREEN + "Yes" + RESET : RED + "No" + RESET);
    }

    public void printAvailablePets(ArrayList<Pet> pets) {
        for (int i = 0; i < pets.size(); i++) {
            if (!pets.get(i).getIsAdopted()) {
                System.out.printf("(%d) Name: %s Type: %s Age: %d\n", i + 1,
                        pets.get(i).getName(), pets.get(i).getType(), pets.get(i).getAge());
            }
        }
        System.out.println("Enter 0 to go back");
    }

    public void printShelterDetails(Shelter shelter) {
        System.out.printf("Shelter Address: %s\n", shelter.getAddress());
        String[] hours = shelter.getHours();
        for (int i = 0; i < hours.length; i++) {
            System.out.println(hours[i]);
        }
        System.out.println("Hit any key to go back");
    }

    public int validateAppointmentMenu() {
      boolean valid = false;
  
      while (!valid) {
          System.out.println(RED + "##### APPOINTMENT MENU #####");
          System.out.println("(1) Book Appointment\n(2) Cancel Appointment" + RESET);
          try {
              choice = input.nextInt();
              if (choice == 1 || choice == 2) {
                  valid = true;
              } else {
                  System.out.println(RED + "Please enter either 1 or 2" + RESET);
              }
          } catch (Exception e) {
              System.out.println(RED + "That's not a number!" + RESET);
          } finally {
              input.nextLine();
          }
      }
      return choice;
  }
  
} // class
