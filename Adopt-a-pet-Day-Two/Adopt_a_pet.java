
// add a validation method for the Book an appointment method/option/feature
import utility.*;
import objects.*;
import java.util.Scanner;

public class Adopt_a_pet {
   private static Scanner input = new Scanner(System.in);
   private static Ink ink = new Ink();
   private static User user;
   private static Shelter shelter = new Shelter();
   private static Pet pet;

   private static int choice;
   private static boolean isDone = false;
   private static boolean goBack = false;

   public static void main(String[] args) {
      
    createUser(); // create the user
    createPets(); // helper pets

    while(!isDone) {
      choice = ink.validateMainMenu();

      switch (choice) {
        case 1: // print available pets
          ink.printAvailablePets(shelter.getPets());
          while(!goBack) {
            int choice = input.nextInt();
            if(choice != 0) {
              // print pet details - not perfect yet!!
              // maybe a good assignment problem ;)
              ink.printPetDetails(shelter.getPet(choice - 1));
              System.out.println("Adopt this pet? Y/N");
              String answer = input.next();
              if(answer.equalsIgnoreCase("Y")) {
                shelter.adopt(choice - 1, user.getName());
                goBack = !goBack;
              }
              else {
                goBack = !goBack;
              }
            }
            else {
              goBack = !goBack;
            }
          } // while
          break;
        case 2: // print shelter details
          ink.printShelterDetails(shelter);
          while(!goBack) {
            input.nextLine();
            goBack = !goBack;
          } // while
          break;


          case 3: // book an appointment menu
          while (!goBack) {
              int appointmentChoice = ink.validateAppointmentMenu();
              switch (appointmentChoice) {
                  // Implement appointment booking logic here
                  case 1:
                      System.out.println("You've booked an appointment!");
                      goBack = true;
                      break;
                  case 2:
                      System.out.println("You've canceled the appointment booking.");
                      goBack = true;
                      break;
                  default:
                      System.out.println("Invalid option. Please choose again.");
                      break;
              }
          }
          break;
        case 4:
          System.exit(0);
          break;
        default:
          System.out.println("Oops!");
          break;
      } // switch
      goBack = !goBack; // correct don't listen to J, he's on Bell ;)
    } // while(main)
  } // main()

  // 100% for test data!
  public static void createPets() {
    pet = new Pet("spot", "dog",
      3, "black", "hound");
    shelter.addPet(pet);
    pet = new Pet("cleveland", "dog",
      7, "brown", "boxer");
    shelter.addPet(pet);
    pet = new Pet("monster", "cat",
      1, "calico", "calico");
    shelter.addPet(pet);
  } // createPets()

  public static void createUser() {
    String name, email;
    int phone;
    System.out.println("What is your name? ");
    name = input.nextLine();
    System.out.println("What is your email? ");
    email = input.nextLine();
    System.out.println("What is your phone? ");
    phone = input.nextInt();
    user = new User(name, email, phone);
  } // createUser()

} // class