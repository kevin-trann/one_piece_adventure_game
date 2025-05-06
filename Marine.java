public class Marine extends Character {
    private String rank;
    private int totalPiratesCaught;
    private int rankValue;
    private int trainValue = 0;
    
    ///Marine creation that extends from character
    public Marine (String name, int age, boolean wantDevilFruit){
        super(name, age, wantDevilFruit);
        this.rank = "Recruit";
        this.rankValue = 1;
    }

    ///Marine attempts to capture pirate. %45 chance of sucesss at default
    public void Capture(){
    int captureChance = random.nextInt(0, 100);
    captureChance = captureChance + trainValue;
    if (captureChance > 45 ){
        rankValue +=1;
        totalPiratesCaught += 1;
        int battleResult = random.nextInt(250, 500) ;
        changeBerries(getBerries() + battleResult);
        
        System.out.println("\n");
        System.out.println("You've successfully captured a pirate!");
        if (rankValue < 9) {
        System.out.println("You've been promoted to " + getRank());
        
        }
        System.out.println("You've been paid generously for your bravery" + " +" + getBerries() + " Berries" );
    }
    if (captureChance < 45){
        rankValue -=1;
        System.out.println("\n");
        System.out.println("You've failed to capture the pirate. Better luck next time!");
        if (rankValue != 0) {
        System.out.println("You've been demoted to " + getRank() + "!");
        }
    }
}

    ///Marine trains to increase their strength which can increase their chance of success for capturing pirates
    public void train(){
        if (trainValue > 35){
            System.out.println("Strength is maxed out. Can't train any higher");
        }
        else if (trainValue <=35){
        trainValue = trainValue + 1;
        System.out.println("\n");
        System.out.println("Your strength has increased by 1! Strength is now " + getStrength());
        System.out.println("You now have a +" + trainValue + "% chance of capturing a pirate");
        }
    }
    

    @Override
    // returns characters stats + rank + strength + pirate captured
    public String toString(){
        return super.toString() + "Rank: " + getRank() + "\n" + "Strength: " + getStrength() + "\n" + "Pirates Captured: " + getPiratesCaught();
    }

    // how marine rank is calculated
    public String getRank() {

        if (rankValue < 0){
            rankValue = 0;
        }

        if(rankValue <= 1){
            rank = "Recruit";
        }
        else if(rankValue == 2 ){
            rank = "Private";
        }
        else if(rankValue == 3 ){
            rank = "Lieutenant";
        }
        else if(rankValue == 4 ){
            rank = "Vice-Captain";
        }
        else if(rankValue == 5 ){
            rank = "Captain";
        }
        else if(rankValue == 6 ){
            rank = "Rear-Admiral";
        }
        else if(rankValue == 7 ){
            rank = "Admiral";
        }
        else if(rankValue >= 8 ){
            rank = "Fleet-Admiral";
        }
        
        return rank;}

    //getters
    public int getPiratesCaught() {return totalPiratesCaught;}
    public int getStrength() {return trainValue;}

    
}
