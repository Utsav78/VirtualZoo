import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Your name: UTSAV BUDATHOKI, student number: 2306084 and FAN: buda0027 here
 */
public class VirtualZoo {
    private static int totalCost;
    private final Scanner scan;
    private final ArrayList<String> animalNameList = new ArrayList<>();

    public VirtualZoo() {
        scan = new Scanner(System.in);
    }

    public static int getTotalCost() {
        return totalCost;
    }

    public static void setTotalCost(int totalCost) {
        VirtualZoo.totalCost = totalCost;
    }

    /**
     * Manages the main loop for simulating week's operation.
     */
    public void beginSimulation() {
        displayWelcome();
        ArrayList<Animal> zooAnimals = animalSelection();
        weekCycle(zooAnimals);
    }

    /**
     * Prompt the user to input the total number of animals in the zoo until the valid number is received
     *
     * @return The valid total number of animals
     */
    public int askNumberAnimals() {
        int totalAnimals = 0;
        boolean isValidInput = false;
        do {
            try {
                System.out.println("How many animals are at your zoo?");
                totalAnimals = scan.nextInt();
                scan.nextLine(); // to consume invalid input
                if (totalAnimals > 0) {
                    isValidInput = true;
                } else {
                    System.out.println("Please enter a positive number of animals");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number of animals");
                // consume invalid input and move to the next line
                scan.nextLine();
            }
        } while (!isValidInput);
        return totalAnimals;
    }

    /**
     * Prompt the user to input the name of an animal.
     *
     * @param id The order of the animal being named.
     * @return The name of the animal.
     */
    public String askAnimalName(int id) {
        String animalName = "";
        while (true) {
            System.out.println("What is the name of animal #" + id + "?");
            animalName = scan.nextLine().trim();

            if (!animalNameList.contains(animalName)) {
                animalNameList.add(animalName);
                break;
            } else
                System.out.println("That name is already taken");
        }
        return animalName;
    }

    /**
     * Prompt the user to input the species of an animal and create an Animal object.
     *
     * @param name The name of the animal.
     * @return An Animal object representing the specified species.
     */
    public Animal askAnimalSpecies(String name) {
        boolean isValidSpecies = false;
        Animal animal = null;
        String inputSpecies;
        while (!isValidSpecies) {
            System.out.println("What is the species of " + name + "?");
            inputSpecies = scan.nextLine().trim().toLowerCase();

            switch (inputSpecies) {
                case "tiger" -> {
                    isValidSpecies = true;
                    animal = new Tiger(name);
                }
                case "giraffe" -> {
                    isValidSpecies = true;
                    animal = new Giraffe(name);
                }
                case "hippo" -> {
                    isValidSpecies = true;
                    animal = new Hippo(name);
                }
                case "panda" -> {
                    isValidSpecies = true;
                    animal = new Panda(name);
                }
                case "monkey" -> {
                    isValidSpecies = true;
                    animal = new Monkey(name);
                }

                default -> System.out.println("That is not a valid species");
            }
        }
        return animal;
    }

    /**
     * Handles the process of selecting and creating animals in the zoo.
     *
     * @return An ArrayList of Animal objects representing the animals in the zoo.
     */
    public ArrayList<Animal> animalSelection() {
        int numberOfAnimals = askNumberAnimals();
        System.out.println();
        ArrayList<Animal> allZooAnimals = new ArrayList<>();
        int count = 1;
        while (count <= numberOfAnimals) {
            String name = askAnimalName(count);
            Animal animal = askAnimalSpecies(name);
            allZooAnimals.add(animal);
            count++;
        }
        return allZooAnimals;
    }

    /**
     * Prompt the user to input an item (food, water, toy) for a specific animal.
     *
     * @param animal The Animal object for which the user is specifying an item.
     */
    public void askItem(Animal animal) {
        String[] validItems = {"food", "water", "toy"};
        String item;
        boolean isValidItem = false;

        while (!isValidItem) {
            System.out.println("What item would you like to give to " + animal.getName() + "?");
            item = scan.nextLine().trim().toLowerCase();

            if (Arrays.asList(validItems).contains(item)) {
                if (!animal.getPreviousItem().equals(item)) {
                    isValidItem = true;
                    animal.setPreviousItem(item);

                    switch (item) {
                        case "food" -> animal.giveFood();
                        case "water" -> animal.giveWater();
                        case "toy" -> animal.giveToy();
                    }

                    if (animal.isDead()) {
                        totalCost += 1000;
                        System.out.println(animal.getName() + " has died");
                    }

                } else {
                    System.out.println("You cannot give the same item as yesterday");
                }
            } else {
                System.out.println("That is not a valid item");
            }
        }
    }

    /**
     * Simulates a week's cycle for all the animals in the zoo.
     *
     * @param zooAnimals An ArrayList of Animal objects representing the animals in the zoo.
     */
    public void weekCycle(ArrayList<Animal> zooAnimals) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String s : daysOfWeek) {
            System.out.println("\nThe current day is " + s + "\n");
            for (Animal animal : zooAnimals) {
                System.out.println(animal.toString());
            }
            for (Animal animal : zooAnimals) {
                if (!animal.isDead())
                    askItem(animal);
            }
        }
        System.out.println("\nTotal week cost = $" + totalCost);
    }

    //-------------------------operational methods------------------------------

    /**
     * Defines the Welcome Message text
     */
    public void displayWelcome() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                     Welcome to the Virtual Zoo!                      |");
        System.out.println("|     Use this application to simulate running a zoo over one week     |");
        System.out.println("|           This program is intended for zoo employees only!           |");
        System.out.println("+----------------------------------------------------------------------+");
    }

}
