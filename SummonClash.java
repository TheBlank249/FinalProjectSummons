/* Andres Cagungun
 * Randy Coronado Cifuentes
 * Christopher Del Cid
 * Rafael Gonzalez
 * David Martinez
 * CS2011 - 01
 * 
 * Description: This is the attack system for Summon Clash
 * 
 * Other Comments: :)
 */

import java.util.Scanner;

public class SummonClash {
        final static int SLASH = 0 ;
        final static int BITE = 1;
        final static int THROW = 2; 
        final static int CHRUSH = 3;
        final static int TACKLE = 4 ;
        final static int RUSH = 5 ;
        final static int EXTREMEFORCE = 6 ;
        final static int FULLCHARGE = 7 ;
        final static int JAWBREAKER = 8 ;
            
    public static void main (String[] args) {
        if (args.length != 0 && args[0].equals("-help")) { // Checks if command
                                                          // line is "java GameTitle -help"
            displayHelp();
            System.exit(0);
        }
        
        Scanner choose = new Scanner(System.in);
        
        String divider = "#############################################################################################";
        
        String summon = ""; // This is the name of the summon chosen.
        int[] attackDamage = new int[3]; //these are the arrays in the game that
        String[] attack = new String[3]; // catalog attack damage and attack names.
                                         // They are in rows of 3.
        
        // Lore dump
        // Bandit dialogue
        // Something like:
        // Bandit 1: Look what we got here
        // Bandit 2: We're gonna rob you
        // You frantically use one of your issued summons
        // main menu pops up
        
        System.out.println("");
        System.out.println(divider);
        System.out.println("");
        
        String storyIntro = "In the badlands where people loot and rob with their trusty Summons,";
        slowText(storyIntro);
        
        String storyIntro1 = "you are a courier for a delivery company called <<<Courier Emporium>>>";
        slowText(storyIntro1);
        
        String storyIntro2 = "You were tasked with delivering a special package to a valuable customer.";
        slowText(storyIntro2);
        
        String storyIntro3 = "Before you headed out to deliver the package, you were issued one of three Summons to help you on your job.";
        slowText(storyIntro3);
        
        System.out.println("");
        
        System.out.println(divider);
        
        System.out.println("");
        String chooseStarterSummon = "Choose your Summon: 1, 2, 3 ";
        slowText(chooseStarterSummon);
        
        String choices = red("Fire-Spirit ") + "= 1, " + blue("King Crustation ") + "= 2, " + green("Earthlem ") + "= 3";
        slowText(choices); // The game will ask the player what summon they want to choose.
        
        int starterSummon = choose.nextInt();
        
        // These are the summons
        if (starterSummon == 1) {
            summon = red("Fire-Spirit"); // This is the name of the summon.
            attackDamage = new int[]{8,4,5}; // These are the attack values.
            attack = new String[]{"Fire Splash","Magma Bite","Firey Rocks"}; // These are the names of the moves.
        }
        else if (starterSummon == 2) { 
            summon = blue("King Crustation");
            attackDamage = new int[]{9,3,4};
            attack = new String[]{"Neo TriBeam","Sea Volley","Water Swipe"};
        
        }
        else if (starterSummon == 3) { 
            summon = green("Earthlem");
            attackDamage = new int[]{7,3,5};
            attack = new String[]{"Boulder Throw","Tree Whip","Mud Slide"};
        }
        else {
            System.out.println("Try Again");
            System.exit(0);// If there's an invalid input, the game will ask for a valid one instead.
        }
        
        String selectedStarterSummon = "You chose " + summon; // This will indicate what summon the player chose.
        slowText(selectedStarterSummon);
        
        System.out.println("");
        
        String battleIntro = "Halfway through the delivery, you were ambushed by 3 bandits trying to steal the package.";
        slowText(battleIntro);
        
        System.out.println("");
        
        String banditDialogue = yellow("Bandit Jake") + ": Look what we got here fellas!";
        slowText(banditDialogue);
        System.out.println("");
        
        String banditDialogue1 = yellow("Bandit George") + ": PAYDAY!!!";
        slowText(banditDialogue1);
        System.out.println("");
        
        String banditDialogue2 = yellow("Bandit Randy") + ": What are we gonna do boss?";
        slowText(banditDialogue2);
        System.out.println("");
        
        String banditDialogue3 = yellow("Bandit Jake") + ": GET EM!!!";
        slowText(banditDialogue3);
        System.out.println("");
        
        String battleIntro1 = "Luckily they were too stupid to attack you at the same time with their summons.";
        slowText(battleIntro1);
        
        String battleIntro2 = "Unfortunately you are going to have to battle all 3 of them to get this package delivered.";
        slowText(battleIntro2);
        
        System.out.println("");
        
        String attacks = summon + "'s attacks are: "; // Using a for loop, the game will show how much damage the attacks deal.
        slowText(attacks);
        for (int i = 0; i < attack.length; i++) {
            String starterAtkMenu = attack[i] + " " + attackDamage[i] + " Damage";
            slowText(starterAtkMenu);
        }
        
        System.out.println("");
        String missTutorial = attack[0] + " has a 60 percent chance to " + red("Miss");
        slowText(missTutorial);
        String critTutorial = attack[1] + " has a 30 percent chance to " + yellow("Land A Critical");
        slowText(critTutorial);
        System.out.println("");
        
        
        /* These are the common attacks that the opponent would use.
        String[] commonMoveSetName = {"Slash","Bite","Throw","Crush","Tackle","Rush"}; 
        int[] commonMoveSet = {4,2,2,4,3,3};*/
        
        String bandit;
        String[] commonMoveSetName = new String[7];
        int[] commonMoveSet = new int [7];
        int[] opponentNewHealth = {0,5,15};

        //For loop for the floors.
        for(int floor = 1; floor <= 3; floor++ ) {
            
            // If else statement for bandits per floor
            if(floor == 1){
                bandit = "Randy";
                commonMoveSet = new int[]{4,2,2,4,3,3,6,6};
                //commonMoveSet = new int{}{4,2,2,4,3,3,6,6};
                commonMoveSetName = new String[]
                {"Slash","Bite","Throw","Crush","Tackle","Rush", "ExtremeForce", "ExtremeForce"};
            }
            else if(floor == 2){
                bandit = "George";
                commonMoveSetName = new String[]
                {"Slash","Bite","Throw","Crush","Tackle","Rush", "FullCharge", "FullCharge",
                 "FullCharge"};
                commonMoveSet = new int[]{4,2,2,4,3,3,7,7,7};
            }
            else{
                bandit = "Jake";
                commonMoveSetName = new String[]
                {"Slash","Bite","Throw","Crush","Tackle","Rush", "JawBreaker", "JawBreaker",
                 "JawBreaker", "JawBreaker"};
                commonMoveSet = new int[]{4,2,2,4,3,3,8,8,8,8};
            }
            
            String opSummon = yellow("Bandit " + bandit) + " brings out their Summon!";
            slowText(opSummon);
        
            //these are the HP values.
            int myMaxHp = 20;
            int myHealth = 20;
            int opponentHealth = 15;
            int opponentMaxHp = 15;
            
            opponentHealth += opponentNewHealth[floor - 1];
            opponentMaxHp +=  opponentNewHealth[floor - 1]; 
            
            String HpBar = green("||||||||||||||||||||||");
            String midHpBar = yellow("|||||||||||");
            String lowHpBar = red("|||");
            
            String finalOpHp = yellow("Bandit " + bandit) + "'s summon's Health: 0/" + opponentMaxHp;
            
            

        
            // This while loop is the gameplay loop.
            while(opponentHealth > 0) {
            
                // These are misc. Gameplay Values //
                String chooseAtk = "Choose " + summon + "'s attack using [1-3]:"; 
                String opAttackCrit= "";
            
                String missText = summon + red(" MISSED.");
            
                String opMissText = yellow("Bandit " + bandit) + red("'s summon MISSED.");
            
                String banditDown = green("You defeated" + yellow(" Bandit " + bandit) + green("!"));
                int randomIndex = (int) (Math.random() * 6);
                // These are misc. Gameplay Values //
                
                if (myHealth > 0) {
                    System.out.println(""); // Your summon's health.
                    String summonHp = summon + "'s Health is: " + myHealth;
                    slowText(summonHp);
                    
                    String opSummonHp = "The opposing summon's health is: " + opponentHealth;
                    slowText(opSummonHp); //The Opponent's summon's health
                    System.out.println("");

                    slowText(chooseAtk); // The summon's attacks.
                    
                    for (int i = 0; i < attack.length; i++) {
                        String attackMenu = attack[i];
                        System.out.println(attackMenu);
                    }
                
                    int attackChoice = choose.nextInt();
                    String attackCritText = "";
                    String selectedAtk = summon + " used " + attack[attackChoice - 1];
                    System.out.println("");
                    slowText(selectedAtk);
                
                    if ((attack[attackChoice - 1] == attack[0]) && Math.random() < 0.6) { // The MISS system.
                        slowText(missText); 
                        System.out.println("");
                    
                        if (opponentHealth <= 25 && opponentHealth >= 20) { //The opponent's health after a miss.
                            slowText(HpBar);
                            String highOpHp = yellow("Bandit " + bandit) + "'s summon's Health: " + green(opponentHealth + "/" + opponentMaxHp);
                            slowText(highOpHp);
                        }
                    
                        else if (opponentHealth <= 19 && opponentHealth >= 10) {
                            slowText(midHpBar);
                            String midOpHp = yellow("Bandit " + bandit) + "'s summon's Health: " + yellow(opponentHealth + "/" + opponentMaxHp);
                            slowText(midOpHp);
                        }
                    
                        else if (opponentHealth <= 9 && opponentHealth >= 1) {
                            slowText(lowHpBar);
                            String lowOpHp = yellow("Bandit " + bandit) + "'s summon's Health: " + red(opponentHealth + "/" + opponentMaxHp);
                            slowText(lowOpHp);
                        }
                    
                    }
                    
                    else if ((attack[attackChoice - 1] == attack[1]) && Math.random() < 0.3) { // The CRIT system.
                        int attackCrit = ((attackDamage[attackChoice - 1]) * 2);
                        String critText = " -> " + attackCrit + " Damage";
                        slowText(critText);
                        attackCritText = summon + yellow(" landed a CRTICAL attack!");
                        
                        String critTextTrue = yellow(attackCritText); // JUST TO BE SAFE!!! This string value will be put here.
                        slowText(critTextTrue);
                        
                        opponentHealth = opponentHealth - attackCrit;
                        System.out.println("");
                     
                        if (opponentHealth <= 25 && opponentHealth >= 20) { //The opponent's health after a crit.
                            slowText(HpBar);
                            String highOpHp1 = yellow("Bandit " + bandit) + "'s summon's Health: " + green(opponentHealth + "/" + opponentMaxHp);
                            slowText(highOpHp1);
                        }
                    
                        else if (opponentHealth <= 19 && opponentHealth >= 10) {
                            slowText(midHpBar);
                            String midOpHp1 = yellow("Bandit " + bandit) + "'s summon's Health: " + yellow(opponentHealth + "/" + opponentMaxHp);
                            slowText(midOpHp1);
                        }
                    
                        else if (opponentHealth <= 9 && opponentHealth >= 1) {
                            slowText(lowHpBar);
                            String lowOpHp1 = yellow("Bandit " + bandit) + "'s summon's Health: " + red(opponentHealth + "/" + opponentMaxHp);
                            slowText(lowOpHp1);
                        }
                    }
                
                    else {
                            String damageText = " -> " + (attackDamage[attackChoice - 1]) + " Damage";
                            slowText(damageText); // The damage system.
                            opponentHealth = opponentHealth - attackDamage[attackChoice - 1];
                            System.out.println("");
                   
                        if (opponentHealth <= 25 && opponentHealth >= 20) { // The opponent's health after damage calculation.
                            slowText(HpBar);
                            String highOpHp2 = yellow("Bandit " + bandit) + "'s summon's Health: " + green(opponentHealth + "/" + opponentMaxHp);
                            slowText(highOpHp2);
                        }
                    
                        else if (opponentHealth <= 19 && opponentHealth >= 10) {
                            slowText(midHpBar);
                            String midOpHp2 = yellow("Bandit " + bandit) + "'s summon's Health: " + yellow(opponentHealth + "/" + opponentMaxHp);
                            slowText(midOpHp2);
                        }
                    
                        else if (opponentHealth <= 9 && opponentHealth >= 1) {;
                            slowText(lowHpBar);
                            String lowOpHp2 = yellow("Bandit " + bandit) + "'s summon's Health: " + red(opponentHealth + "/" + opponentMaxHp);
                            slowText(lowOpHp2);
                        }
                    }
                
                    if (opponentHealth > 0) {
                    int attackVal = commonMoveSet[randomIndex]; // They enemy's attack is choses in an array between 0 and 5.
                    slowText(opAttackCrit);
                    
                        if (Math.random() < 0.2) {
                            attackVal = (attackVal * 2);
                            opAttackCrit = (yellow("Bandit " + bandit + "'s summon landed a CRTICAL attack!")); // The CRIT system for the opponent.
                            System.out.println("");
                        }
                        
                        if (Math.random() < 0.2) {
                            slowText(opMissText);
                            System.out.println("");
                       
                            if (myHealth <= 20 && myHealth >= 15) { // The summon's health after MISS.
                                slowText(HpBar);
                                String highHp = summon + "'s Health: " + green(myHealth + "/" + myMaxHp);
                                slowText(highHp);
                            }
                            else if (myHealth <= 14 && myHealth >= 10) {
                                slowText(midHpBar);
                                String midHp = summon + "'s Health: " + yellow(myHealth + "/" + myMaxHp);
                                slowText(midHp);
                            }
                    
                            else if (myHealth <= 9 && myHealth >= 1) {
                                slowText(lowHpBar);
                                String lowHp = summon + "'s Health: " + red(myHealth + "/" + myMaxHp);
                                slowText(lowHp);
                            }
                        }
                        
                        else {
                            System.out.println("");// The damage system for the opponent.
                            String opSelectedAtk = yellow("Bandit " + bandit) + "'s summon used " + commonMoveSetName[randomIndex];
                            slowText(opSelectedAtk);
                            
                            String opDamageText = " -> " + (attackVal) + " Damage";
                            slowText(opDamageText);
                            slowText(opAttackCrit);
                            System.out.println("");
                            
                            myHealth = myHealth - attackVal;
                      
                            if (myHealth <= 20 && myHealth >= 15) { 
                                slowText(HpBar);
                                String highHp1 = summon + "'s Health: " + green(myHealth + "/" + myMaxHp);
                                slowText(highHp1);
                            }
                            else if (myHealth <= 14 && myHealth >= 10) {
                                slowText(midHpBar);
                                String midHp1 = summon + "'s Health: " + yellow(myHealth + "/" + myMaxHp);
                                slowText(midHp1);
                            }
                            else if (myHealth <= 9 && myHealth >= 1) {
                                slowText(lowHpBar);
                                String lowHp1 = summon + "'s Health: " + red(myHealth + "/" + myMaxHp);
                                slowText(lowHp1);
                            }
                
                
                            else { // This is displayed whenever the player's summon dies.
                        
                                String redDivider = red("#############################################################################################");
                                System.out.println(redDivider);
                                System.out.println("");
                        
                        
                                myHealth = 0;
                            
                                String battleFail = yellow("Bandit " + bandit) + ": HAHA! SUCKER!!!";
                                slowText(battleFail);
                        
                                String battleFail1 = "The bandits run off into the distance with YOUR package.";
                                slowText(battleFail1);
                        
                                String battleFail2 = "As you walk back with shame, you mutter to yourself... ";
                                slowText(battleFail2);
                            
                                String battleFail3 = red("This is definitely coming out of my pay.");
                                slowText(battleFail3);
                                System.out.println("");
                        
                                String loss = red("[[[[[[[[[[[[[YOU LOSE]]]]]]]]]]]]]");
                                slowText(loss);
                        
                                System.out.println("");
                                System.out.println(redDivider);
                        
                                System.exit(0);
                            }
                        }
                    }
                    else {
                        slowText(finalOpHp);
                        slowText(banditDown);
                        System.out.println("");
                    }
                }

            }
        }
        // This is displayed after the player wins the interaction.
        String greenDivider = green("#############################################################################################");
        System.out.println(greenDivider);
        System.out.println("");
        
        String battleVictory = "You have successfully defended the package from the bandits!";
        slowText(battleVictory);
        
        String battleVictory1 = "As you approach your destination, you decide to take a peek inside the package.";
        slowText(battleVictory1);
        
        String battleVictory2 = "There are 3 gold bars inside.";
        slowText(battleVictory2);
        
        String battleVictory3 = "The thought of even delivering such treasure to someone else feels unbearable.";
        slowText(battleVictory3);
        
        String battleVictory4 = "As you near the location of the customer, you ready up your summon.";
        slowText(battleVictory4);
        
        System.out.println("");
        
        String customerDialogue = "Customer: Oh, this must be the package. Thank you so much!";
        slowText(customerDialogue);
        System.out.println("");
        
        String battleVictory5 = "The customer begins to reach for the package, but in a haste, you order your summon to kill him.";
        slowText(battleVictory5);
        
        System.out.println("");
        
        String customerDialogue1 = "Customer: Wait, what are you- GAAAAAAAAAAAHHHH!";
        slowText(customerDialogue1);
        System.out.println("");
        
        String battleVictory6 = "Now that the customer can no longer report the package, all that is left is a great amount of wealth in your hands.";
        slowText(battleVictory6);
        
        String battleVictory7 = "You walk back, your heart pounding as you wonder if this betrayal will be the start of something far worse...";
        slowText(battleVictory7);
        
        System.out.println("");

        
        String win = green("[[[[[[[[[[[[[YOU WIN]]]]]]]]]]]]]");
        slowText(win);
        System.out.println("");
        System.out.println(greenDivider);
        
    }
    
    
    public static void displayHelp() {
        String s = " *** Here are the rules ***";
        slowText( yellow(s) );
        
        String r1 = " - You get to choose 1 summon to be yours out of 3 total summons. To select a summon, respond with one these inputs [ 1, 2, 3 ] ";
            slowText(r1);
        
        System.out.println("");
        String r2 = " - Your summon will have 3 types of attacks.";
        slowText(r2);
        
        String r5 = "The first attack has does the most damage but has a high chance to miss";
        slowText(r5);
        
        String r6 = "The second attack is the only move that can do critical damage, which has a x2 mulitplier.";
        slowText(r6);
        
        String r7 = "The third attack is a basic attack that does guaranteed damage.";
        slowText(r7);
        
        String r8 = "To select an attack, respond with one of these inputs [ 1, 2, 3 ]";
        slowText(r8);
    
        System.out.println("");
        String r3 = " - There will be 3 total bandits which you will have to defeat their summons to proceed to the next bandit.";
                slowText(r3);
        
        System.out.println("");
        String r9 = " - After you defeat a bandit, your summon's health will be restored to full and the enemies summon's health will increase by this order";
        slowText(r9);
        
        String r12 = "1st summon: +0 health (total health: 15)";
        slowText(r12);
        
        String r10 = "2nd summon: +5 health (total health: 20)";
        slowText(r10);
        
        String r11 = "3rd summon: +15 health (total health: 30)";
        slowText(r11);
        
        System.out.println("");
        String r4 = " - Defeat all 3 bandits and their summons in to win the game!";
            slowText(r4);
    }

    public static String red(String s) {
        return "\u001B[31m" + s + "\u001B[0m";
    }
    public static String green(String s) {
        return "\u001B[32m" + s + "\u001B[0m";
    }
    public static String yellow(String s) {
        return "\u001B[33m" + s + "\u001B[0m";
    }
    public static String blue(String s) {
        return "\u001B[34m" + s + "\u001B[0m";
    }
    
    public static void slowText(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            pause(25); // Change speed delay
        }
        System.out.println(); // Moves to the next line after a text is printed
    }
    public static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ie) {}
}
}

    