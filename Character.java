import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Character {
    
    private String name;
    private int age;
    private Boolean wantDevilFruit;
    private String devilFruit;
    private int berries; //name of currency in One Piece
    private int distanceTraveled;

    /// Setting up random
    Random random = new Random();

    /// Array containing list of possible devil fruits
    private static final ArrayList <String> devilFruitList = new ArrayList<>(Arrays.asList("Rubber Fruit", "Fire Fruit", 
    "Ice Fruit", "Dark Fruit", "Magma Fruit", "Light Fruit", "Gravity Fruit", "Lightning Fruit", "Venom Fruit", "Earthquake Fruit"));


    /// ArrayList containing devil fruits that have been used as there can only be one of each (2 characters can't have the same one)
    private static ArrayList<String> usedDevilFruits = new ArrayList<>();
    
    /// ArrayList to keep track of names to prevent 2 characters with the same name
    private static ArrayList<String> usedNames = new ArrayList<>();

    /// if wantDevilFruit is true; assigns random devil fruit from list "devilFruitList"
    public Character (String name, int age, Boolean wantDevilFruit){
        this.name = name; 
        for (String i : usedNames){
            if (name.equals(i)){
                System.out.println("Name has already been taken. Please choose another name!");
                this.name = "N/A";
                this.age = 0;
                this.devilFruit = "N/A";
                break;
            }
        }
        usedNames.add(name); /// adds name to usedNames
        this.age = age;
        this.berries = 0;

        if (wantDevilFruit){

        int randomDfIndex = random.nextInt(devilFruitList.size()); //creates a random integer from 0 - size of devilFruitList and assigns it to randomDfIndex
        this.devilFruit = devilFruitList.get(randomDfIndex); // assigns random devil fruit to player
        usedDevilFruits.add(devilFruitList.get(randomDfIndex)); // adds devilfruit to arraylist of used devil fruits
        devilFruitList.remove(randomDfIndex); // removes devil fruit from list of devil fruits as there can only be of each devil fruit
        }
        else if (wantDevilFruit == false){
            devilFruit = "None";
        }
        
    }

    /// option to reroll and change devil fruit for 500 berries
    public void changeDevilFruit(){
        if (berries < 500){ /// checks if user has enough berries to change devil fruit
            System.out.println("\n");
            System.out.println("Not enough berries. Changing devil fruit costs 500 berries");
        }
        else if (berries >= 500){
            System.out.println("\n");
            berries = berries - 500;
            int randomDfIndex = random.nextInt(devilFruitList.size()); //creates a random integer from 0 - size of devilFruitList and assigns it to randomDfIndex

            this.devilFruit = devilFruitList.get(randomDfIndex); //assigns random devil fruit to player
            
            usedDevilFruits.add(this.devilFruit); //adds the new devil fruit to used devil fruit arraylist

            if (!(usedDevilFruits.isEmpty())){ // checks if a devil fruit has been used
            devilFruitList.add(usedDevilFruits.get(0)); // adds the old devil fruit that user was using to offical devil fruit list
            devilFruitList.remove(randomDfIndex); //removes new devil fruit from offical devil fruit list as it's now used
            }
            System.out.println("You've spent 500 berries to roll a new devil fruit. Your new devil fruit is " + devilFruit);
        }
    }

    // travel by boat a random number of kilometers from 10-100
    public void sail(){
        int currentTraveled = random.nextInt(10,100);
        distanceTraveled = distanceTraveled + currentTraveled;
        System.out.println("\n");
        System.out.println("You traveled " + currentTraveled + " km. Total distance travelled: " + distanceTraveled + "km");
    }
    

    @Override
    // prints out a characters stats, name, age, devil fruit, distance travelled,
    public String toString(){
        return ("\n" + "Name: " + name + "\n" + "Age: " + age + "\n" + "Devil Fruit: " + devilFruit +  "\n" + "Distance Travelled: " + distanceTraveled + "km" + "\n");

    }

    @Override
    //checks if two names of two characters are the same
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o.getClass() == this.getClass())){
            return false;
        }

        Character other = (Character) o;

        return this.name.equals(other.name);
    }

    /// getter methods
    public String getName() {return name;}
    public int getAge() {return age;}
    public String getDevilFruit() {return devilFruit;}
    public int getBerries() {return berries;}
    public int getDistanceTraveled() {return distanceTraveled;}
    
    /// setter methods
    public void changeName(String name) {this.name = name;}
    public void changeAge(int age) {this.age = age;}
    public void changeBerries(int berries) {this.berries = berries;}
    

    

}
