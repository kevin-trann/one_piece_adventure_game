import java.util.Scanner;

/* 
The problem is based off the TV show known as "One Piece". The program
will allow the user to create a character in a video game that is based
off of this tv show. They can then choose to be a pirate or marine and 
then do a variety of actions in this "luck" based game. The goal is to
gain as much bounty as a pirate or get a high rank as a marine.
Warning: Validity for input wasn't checked so make sure you input the options given to you
Run this file to start the game.
*/

public class ProjectOneTester {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Welcome to my One Piece Game! By Kevin Tran");
        System.out.println("Choose your path: Type '1' for Pirate or Type '2' for Marine");

        int pathChoice = -1;
        while (pathChoice != 1 && pathChoice != 2) {
            if (scanner.hasNextInt()) {
                pathChoice = scanner.nextInt();
                scanner.nextLine();
                if (pathChoice != 1 && pathChoice != 2) {
                    System.out.println("Invalid choice. Please enter '1' for Pirate or '2' for Marine.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        if (pathChoice == 1) {
            System.out.println();
            System.out.println("You've chosen to be a pirate! Your quest for the One Piece begins!!");
            System.out.println("Enter your pirate name: ");
            String name = scanner.nextLine();
            System.out.println();
            System.out.println("You've chosen " + name + " as your name!");

            System.out.println();
            System.out.println("Enter your age: ");
            int age = -1;
            while (age <= 0) {
                if (scanner.hasNextInt()) {
                    age = scanner.nextInt();
                    if (age <= 0) {
                        System.out.println("Please enter a valid age.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid age.");
                    scanner.nextLine();
                }
            }

            System.out.println();
            System.out.println(name + " is " + age + " years old!");

            System.out.println();
            System.out.println("Would you like a crew name? Type '1' if YES | Type '2' if NO: ");
            int crewChoice = -1;
            while (crewChoice != 1 && crewChoice != 2) {
                if (scanner.hasNextInt()) {
                    crewChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (crewChoice != 1 && crewChoice != 2) {
                        System.out.println("Invalid choice. Please enter '1' for YES or '2' for NO.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                }
            }
            String crewName = "N/A";
            if (crewChoice == 1) {
                System.out.println();
                System.out.println("Enter your crew name: ");
                crewName = scanner.nextLine();
                System.out.println();
                System.out.println("You've decided to embark on your journey with a crew.");
                System.out.println("You've chosen " + crewName + " as your crew name!");
            } else {
                System.out.println();
                System.out.println("You've decided to embark on your journey solo.");
            }

            System.out.println();
            System.out.println("Do you want a devil fruit? Consuming the fruit will grant you mythical powers from the gods");
            System.out.println("Type '1' if YES | Type '2 if NO: ");
            int devilFruitChoice = -1;
            while (devilFruitChoice != 1 && devilFruitChoice != 2) {
                if (scanner.hasNextInt()) {
                    devilFruitChoice = scanner.nextInt();
                    if (devilFruitChoice != 1 && devilFruitChoice != 2) {
                        System.out.println("Invalid choice. Please enter '1' for YES or '2' for NO.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                }
            }

            boolean wantDevilFruit = (devilFruitChoice == 1);
            if (wantDevilFruit) {
                System.out.println();
                System.out.println("You've chosen to consume a devil fruit!");
            } else {
                System.out.println();
                System.out.println("You've chosen not to consume a devil fruit.");
            }

            Pirate player = new Pirate(name, age, wantDevilFruit, crewName);
            System.out.println();
            System.out.println("Here are your stats!");
            System.out.println(player.toString());
            System.out.println();
            System.out.println("Your journey for the One Piece begins!!");

            while (true) {
                System.out.println();
                System.out.println("1. Sail");
                System.out.println("2. Plunder (Loot and raid islands for berries)");
                System.out.println("3. Fight (50% chance of success; Can lead to more bounty and berries!)");
                System.out.println("4. Check Stats");
                System.out.println("5. Buy New Devil Fruit (costs 500 berries)");
                System.out.println("6. Close Game");

                System.out.println("Enter the number of your choice");
                int actionChoice = -1;
                while (actionChoice < 1 || actionChoice > 6) {
                    if (scanner.hasNextInt()) {
                        actionChoice = scanner.nextInt();
                        if (actionChoice < 1 || actionChoice > 6) {
                            System.out.println("Invalid choice. Please enter a valid input.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 6.");
                        scanner.nextLine();
                    }
                }

                if (actionChoice == 1) {
                    player.sail();
                } else if (actionChoice == 2) {
                    player.Plunder();
                } else if (actionChoice == 3) {
                    player.Fight();
                } else if (actionChoice == 4) {
                    System.out.println(player.toString());
                } else if (actionChoice == 5) {
                    player.changeDevilFruit();
                } else if (actionChoice == 6) {
                    System.out.println();
                    System.out.println("Closing game");
                    break;
                }
            }

        } else if (pathChoice == 2) {
            System.out.println();
            System.out.println("You've chosen to be a Marine! Your quest to protect citizens from pirates begins!");
            System.out.println("Enter your marine name: ");
            String name = scanner.nextLine();
            System.out.println();
            System.out.println("You've chosen " + name + " as your name!");

            System.out.println();
            System.out.println("Enter your age: ");
            int age = -1;
            while (age <= 0) {
                if (scanner.hasNextInt()) {
                    age = scanner.nextInt();
                    if (age <= 0) {
                        System.out.println("Please enter a valid age.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid age.");
                    scanner.nextLine();
                }
            }

            System.out.println();
            System.out.println(name + " is " + age + " years old!");

            System.out.println();
            System.out.println("Do you want a devil fruit? Consuming the fruit will grant you mythical powers from the gods");
            System.out.println("Type '1' if YES | Type '2 if NO: ");
            int devilFruitChoice = -1;
            while (devilFruitChoice != 1 && devilFruitChoice != 2) {
                if (scanner.hasNextInt()) {
                    devilFruitChoice = scanner.nextInt();
                    if (devilFruitChoice != 1 && devilFruitChoice != 2) {
                        System.out.println("Invalid choice. Please enter '1' for YES or '2' for NO.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                }
            }

            boolean wantDevilFruit = (devilFruitChoice == 1);
            if (wantDevilFruit) {
                System.out.println();
                System.out.println("You've chosen to consume a devil fruit!");
            } else {
                System.out.println();
                System.out.println("You've chosen not to consume a devil fruit.");
            }

            Marine player2 = new Marine(name, age, wantDevilFruit);
            System.out.println();
            System.out.println("Here are your stats!");
            System.out.println(player2.toString());
            System.out.println();
            System.out.println("Your journey to serve the World Government and catch pirates begins!");

            while (true) {
                System.out.println();
                System.out.println("1. Sail");
                System.out.println("2. Train (Increase chance of capture working)");
                System.out.println("3. Capture (Capture pirates to potentially increase rank and berries!)");
                System.out.println("4. Check Stats");
                System.out.println("5. Buy New Devil Fruit (costs 500 berries)");
                System.out.println("6. Close Game");

                System.out.println("Enter the number of your choice");
                int actionChoice = -1;
                while (actionChoice < 1 || actionChoice > 6) {
                    if (scanner.hasNextInt()) {
                        actionChoice = scanner.nextInt();
                        if (actionChoice < 1 || actionChoice > 6) {
                            System.out.println("Invalid choice. Please enter a valid input.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 6.");
                        scanner.nextLine();
                    }
                }

                if (actionChoice == 1) {
                    player2.sail();
                } else if (actionChoice == 2) {
                    player2.train();
                } else if (actionChoice == 3) {
                    player2.Capture();
                } else if (actionChoice == 4) {
                    System.out.println(player2.toString());
                } else if (actionChoice == 5) {
                    player2.changeDevilFruit();
                } else if (actionChoice == 6) {
                    System.out.println();
                    System.out.println("Closing game");
                    break;
                }
            }

        }
    }
}