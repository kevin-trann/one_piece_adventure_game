public class Pirate extends Character implements Comparable <Pirate>{
    
    private String crewName = "N/A"; //naming pirate crew
    private int bounty; 

    /// Constructor pirate that extends from character
    public Pirate (String name, int age, boolean wantDevilFruit, String crewName){
        super(name, age, wantDevilFruit);
        this.crewName = crewName;
    }

    /// Construtor overloading; choice to not have a crew name and be a solo pirate
    public Pirate (String name, int age, boolean wantDevilFruit){
        super (name, age, wantDevilFruit);
    }

    /// Pirate loots treasure on islands that can contain loot worth 1-100. Then adds amount looted to berries.
    public void Plunder(){
        int lootAmount = (int) (Math.random() * 100) + 1;

        changeBerries(getBerries() + lootAmount); 
        
        System.out.println("\n");
        System.out.println("You've looted " + lootAmount + " berries worth of treasure!");
        System.out.println("Total Berry Count: " +  getBerries());
    }

    /// Pirate gets into battle with another crew. 50% Can lead to a berry change from -500 to +500 depending on win or loss
    /// Also increases bounty by 100 on a win and -100 on a loss
    public void Fight(){
        int battleResult = (int) (((Math.random() * 2) - 1 )* 500);
        int currentBounty = getBounty();

        changeBerries(getBerries() + battleResult);
        
        if (battleResult > 0){
            System.out.println("\n");
            System.out.println("You've won the battle! +100 bounty. " + "You've earned " + battleResult + " berries worth of treasure!");
            changeBounty(currentBounty + 100);
        }
        if (battleResult < 0){
            System.out.println("\n");
            System.out.println("You've lost the battle. -100 bounty. " + "You've lost " + battleResult + " berries worth of treasure!");
            changeBounty(currentBounty - 100);
            }
        if (battleResult == 0){
            System.out.println("\n");
            System.out.println("Stalemate! Both crews run away with major injuries! No berries gained or lost.");
        }
        if (getBerries() < 0){
            changeBerries(0);
        }
        System.out.println("Total Berry Count: " +  getBerries());
        System.out.println("Total Bounty: " + getBounty());

    }

    @Override
    // compares bounties of 2 pirates, 1 if this is greater, -1 if other is greater, 0 if equal
    public int compareTo(Pirate other){
        System.out.println("\n");
        return Integer.compare(this.bounty, other.bounty);
    }

    @Override
    // returns characters stats, characters stats + crew name and bounty
    public String toString(){ 
        return super.toString() + "Crew Name: " + crewName + "\n" + "Bounty: " + bounty;
    }

    // getters
    public String getCrewName() {return crewName;}
    public int getBounty() {return bounty;}


    // setters
    public void changeCrewName(String a) {this.crewName = a;}
    public void changeBounty(int bounty) {
        this.bounty = bounty;
        if (this.bounty < 0){
            this.bounty = 0;
        }
    }

    
}
