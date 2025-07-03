import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
public class Frontend
{
    private ArrayList<Gegner> DEFINITIONEN_Gegner= new ArrayList<Gegner>();
    EndPoemManager poemManager = new EndPoemManager();
    ArrayList<TheEnd> poem = poemManager.getPoem();
    public int Mana;
    public int Manafull;
    public int Manacurrent;
    public String ManaStyled;
    public int HPfull;
    public int HPcurrent;
    public String HPStyled;
    public boolean Door1;
    public String Door2;
    public boolean Door3;
    public String CurrentEnemy;
    public int CurrentEnemyHealth;
    public int CurrentEnemyBasicAttack;
    public int CurrentEnemyMagicAttack;
    public boolean CurrentEnemyIsDead;
    public boolean NewRoom;
    public boolean HealthPackExists;
    public int RoomsToWin;
    public Frontend() {
        DEFINITIONEN_Gegner.add(new Gegner ("Zombie",    10, 3, 5));
        DEFINITIONEN_Gegner.add(new Gegner ("Skelett",    8, 5, 7));
        DEFINITIONEN_Gegner.add(new Gegner ("Fledermaus", 7, 2, 4));
        DEFINITIONEN_Gegner.add(new Gegner ("Golem",      15, 8, 9));
        DEFINITIONEN_Gegner.add(new Gegner ("Drache",     20, 7, 9));
        
        MainMenu();
        NewRoom = true;
        CurrentEnemyIsDead = true;
        Scanner GameSelect = new Scanner(System.in);
        String GameSelected = GameSelect.nextLine();
        if (GameSelected.equals("N")) {
            HPfull = 10;
            HPcurrent = 10;
            Manafull = 20;
            Manacurrent = 10;
            SelectGamemode();
        }else if (GameSelected.equals("C")) {
            Credits();
        }else {
            System.out.println("Nothing selected");
        }
    }
    public void FrontendAgain() {
        MainMenu();
        Scanner GameSelect = new Scanner(System.in);
        String GameSelected = GameSelect.nextLine();
        if (GameSelected.equals("N")) {
            HPfull = 10;
            HPcurrent = 10;
            Manafull = 20;
            Manacurrent = 10;
            SelectGamemode();
        }else if (GameSelected.equals("C")) {
            Credits();
        }else {
            System.out.println("Nothing selected");
        }
    }
    public static void MainMenu() {
        Logo();
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|                           |------------------------|                                      |------------------------|                                                     |");
        System.out.println("|                           |(N)ew Game              |                                      |     (C)redits          |                                                     |");
        System.out.println("|                           |------------------------|                                      |------------------------|                                                     |");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
    }
    public static void Logo() {
        int i = 0;
        while (i < 25) {
            System.out.println("");
            i++;
        }
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.print("""
                                                            ░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                                    ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                                  ░▒▓██▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                                ░▒▓██▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                              ░▒▓██▓▒░    ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                             ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                             ░▒▓████████▓▒░░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓████████▓▒░                                                  
                                                                                                                                                                          
                                                                                                                                                                                                                                          
        """);
        i = 0;
        while (i < 22) {
            System.out.println("                                                                                                                                                                          ");
            i++;
        }
    }
    public void SelectGamemode() {
        Logo();
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|                           |------------------------|                                      |------------------------|                                                     |");
        System.out.println("|                           |(E)asy         10 rooms |                                      |(H)ard         20 rooms |                                                     |");
        System.out.println("|                           |------------------------|                                      |------------------------|                                                     |");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        Scanner DecidedInput = new Scanner(System.in);
        String GameSetInput = DecidedInput.nextLine();
        if (GameSetInput.equals("E") || GameSetInput.equals("e")) {
            RoomsToWin = 10;
        }else if (GameSetInput.equals("H") || GameSetInput.equals("h")) {
            RoomsToWin = 20;
        }else {
            System.out.println("POV game hasn't started and you just lost");
            RoomsToWin = 1000000;
        }
        GameCalculateStats();
        GamePrintWorld();
        GamePrintActions();
        GameGetInput();
    }
    Random random = new Random();
    public boolean getBoolean() {
        return random.nextBoolean();
    }
    public void GamePrintWorld() {
        Door2 = "|========|";
        System.out.println("");
        System.out.println("");
        GamePrintEnemy();
        System.out.println("");
        System.out.println("");
        if (CurrentEnemyIsDead == false) {
            System.out.println("                                    |----------------------------------------------"+ Door2 +"-----------------------------------------|");
            System.out.println("                                    |                                                 ▓███▓                                          |");
            System.out.println("                                    |                                                ▓▓   ▓▓                                         |");
            System.out.println("                                    |                                                ▓▓   ▓▓                                          |");
        }else {
            Random rand = new Random();
            if (rand.nextBoolean() == true) {
                HealthPackExists = true;
                System.out.println("                                    |----------------------------------------------"+ Door2 +"-----------------------------------------|");
                System.out.println("                                    |                                  |----------------------------|                                  |");
                System.out.println("                                    |                                  | Health pack (Pickup with E)|                                  |");
                System.out.println("                                    |                                  |----------------------------|                                  |");
            }else {
                HealthPackExists = false;
                System.out.println("                                    |----------------------------------------------"+ Door2 +"-----------------------------------------|");
                System.out.println("                                    |                                                                                                  |");
                System.out.println("                                    |                                                                                                  |");
                System.out.println("                                    |                                                                                                  |");
            }
        }
            if (getBoolean() == true && Door2.equals("|========|") && CurrentEnemyIsDead == true) {
            System.out.println("                                    -                                                                                                 -");
            int i = 0;
            if (getBoolean() == true && CurrentEnemyIsDead == true) {
                Door1 = true;
                Door3 = true;
                while (i < 8) {
                    System.out.println("                                    =                                                                                                 =");
                    i++;
                }
            }else {
                Door1 = true;
                Door3 = false;
                while (i < 8) {
                    System.out.println("                                    =                                                                                                 |");
                    i++;
                }
            }
            System.out.println("                                    -                                                                                                 -");
        }else {
            int i = 0;
            if (getBoolean() == true || Door2.equals("----------") && CurrentEnemyIsDead == true) {
                Door1 = false;
                Door3 = true;
                while (i < 8) {
                    System.out.println("                                    |                                                                                                 =");
                    i++;
                }
            }else {
                Door1 = false;
                Door3 = false;
                while (i < 8) {
                    System.out.println("                                    |                                                                                                 |");
                    i++;
                }
            }
        }
        
        System.out.println("                                    |                                                                                                 |");
        System.out.println("                                    |                                                                                                 |");
        System.out.println("                                    |                                                                                                 |");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    public void Credits() {
        int i = 0;
        while (i < 25) {
            System.out.println("");
            i++;
        }
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.print("""
                                                            ░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                                    ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                                  ░▒▓██▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                                ░▒▓██▓▒░  ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                              ░▒▓██▓▒░    ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                             ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░                                                          
                                                             ░▒▓████████▓▒░░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓████████▓▒░                                                  
                                                                                                                                                                          
                                                                                                                                                                                                                                          
        """);
        System.out.println("                                                                Entwickelt und realisiert von:");
        System.out.println("                                                                Silas, Vivian, Alessa, Kristin");
        System.out.println("                                                                    am Gymnasium Dorfen 10C");
        i = 0;
        while (i < 16) {
            System.out.println("");
            i++;
        }
        System.out.println("(B)ack");
        i = 0;
        while (i < 10) {
            System.out.println("");
            i++;
        }
        Scanner GameSelect = new Scanner(System.in);
        String GameSelected = GameSelect.nextLine();
        if (GameSelected.equals("N")) {
            HPfull = 10;
            HPcurrent = 10;
            Manafull = 20;
            Manacurrent = 0;
            SelectGamemode();
        }else if (GameSelected.equals("B")) {
            FrontendAgain();
        }else {
            System.out.println("Err: Bad keybind (get rekt loser)");
        }
    }
    public void GameCalculateStats() {
    HPStyled = "";
    ManaStyled = "";
    
    // Calculate HP display
    int hpFilled = HPcurrent * 15 / HPfull;  // Total bar size = 15
    int hpEmpty = 15 - hpFilled;

    // Add filled HP blocks
    for (int i = 0; i < hpFilled; i++) {
        HPStyled += "#";
    }

    // Add empty HP blocks
    for (int i = 0; i < hpEmpty; i++) {
        HPStyled += "-";
    }

    // Calculate Mana display
    int manaFilled = Manacurrent * 15 / Manafull;  // Total bar size = 15
    int manaEmpty = 15 - manaFilled;

    // Add filled Mana blocks
    for (int i = 0; i < manaFilled; i++) {
        ManaStyled += "#";
    }

    // Add empty Mana blocks
    for (int i = 0; i < manaEmpty; i++) {
        ManaStyled += "-";
    }
    
    if (HPcurrent == 0) {
        System.out.println("You died loser (get rekt");
        System.exit(0);
    }
}


    public void GamePrintEnemy() {
        int Min = 1;
        int Max = 4;
        int RandomEnemy = ThreadLocalRandom.current().nextInt(Min, Max + 1);
        if (NewRoom == true) {
            CurrentEnemy = DEFINITIONEN_Gegner.get(RandomEnemy).ReturnName();
            CurrentEnemyHealth = DEFINITIONEN_Gegner.get(RandomEnemy).ReturnHP();
            CurrentEnemyBasicAttack = DEFINITIONEN_Gegner.get(RandomEnemy).ReturnBasic();
            CurrentEnemyMagicAttack = DEFINITIONEN_Gegner.get(RandomEnemy).ReturnMagic();
            CurrentEnemyIsDead = false;
            NewRoom = false;
        }
        if (CurrentEnemyHealth > 0) {
            System.out.println("                                                                                        ❰  "+ CurrentEnemy +"  ❱"+ "   ❰ HP: "+CurrentEnemyHealth+" ❱");
        }else {
            CurrentEnemyIsDead = true;
            System.out.println("                                                                                        ❰  Defeated  ❱"+ "   ❰  ❱");
        }
        
    }
    public void GamePrintActions() {
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|    Mana["+ ManaStyled+ "]                 HP["+ HPStyled+ "] "+ HPcurrent+"/"+ HPfull+ "   Rooms left[" +RoomsToWin+ "] ");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|                          |-------------------|             |-------------------|             |-------------------|                                                       |");
        System.out.println("|                          |(M)agic            |             |(W)eapon           |             |(C)ombo            |                                                       |");
        System.out.println("|                          |-------------------|             |-------------------|             |-------------------|                                                       |");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|                          |-------------------|             |-------------------|             |-------------------|                                                       |");
        if (Door1 == true  && CurrentEnemyIsDead == true) {
            System.out.print("|                          |(A) left door      |             ");
        }else {
            System.out.print("|                          |█████████████████|             ");
        }
        if (Door2.equals("|========|") && CurrentEnemyIsDead == true) {
            System.out.print("|(S) front door     |             ");
        }else {
            System.out.print("|█████████████████|             ");
        }
        if (Door3 == true && CurrentEnemyIsDead == true) {
            System.out.println("|(D) right door     |                                                       |");
        }else {
            System.out.println("|█████████████████|                                                       |");
        }
        System.out.println("|                          |-------------------|             |-------------------|             |-------------------|                                                       |");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
    }
    public void GameFinished() {
        Logo();
        for (TheEnd line : poem) {
            System.out.println("                                                  " +line.getLine());
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        
    }
    public void GameGetInput() {
        Scanner DecidedInput = new Scanner(System.in);
        String GameSetInput = DecidedInput.nextLine();
        if (GameSetInput.equals("A") && Door1 == true) {
            if (CurrentEnemyIsDead == true) {
            RoomsToWin = RoomsToWin - 1;
            if (RoomsToWin == 0) {
                GameFinished();
            }
            NewRoom = true;
            if (Manacurrent < Manafull) {
                Manacurrent = Manacurrent + 2;
            }
            GamePrintWorld();
            GameCalculateStats();
            GamePrintActions();                
            }else {
                System.out.println("Err: You must defeat the enemy first");
            }
        }else if (GameSetInput.equals("S") && Door2.equals("|========|")) {
            if (CurrentEnemyIsDead == true) {
            RoomsToWin = RoomsToWin - 1;
            if (RoomsToWin == 0) {
                GameFinished();
            }
            NewRoom = true;
            if (Manacurrent < Manafull) {
                Manacurrent = Manacurrent + 2;
            }
            GamePrintWorld();
            GameCalculateStats();
            GamePrintActions();
            }else {
                System.out.println("Err: You must defeat the enemy first");
            }
        }else if (GameSetInput.equals("D") && Door3 == true) {
            if (CurrentEnemyIsDead == true) {
            RoomsToWin = RoomsToWin - 1;
            if (RoomsToWin == 0) {
                GameFinished();
            }
            NewRoom = true;
            if (Manacurrent < Manafull) {
                Manacurrent = Manacurrent + 2;
            }
            GamePrintWorld();
            GameCalculateStats();
            GamePrintActions();
            }else {
                System.out.println("Err: You must defeat the enemy first");
            }
        }else if (GameSetInput.equals("M") || GameSetInput.equals("m")) {
            if (Manacurrent > 1) {
                CurrentEnemyHealth = CurrentEnemyHealth - 3;
                Manacurrent = Manacurrent - 2;
                int RandomEnemyAtk = ThreadLocalRandom.current().nextInt(0, 1);
                if (RandomEnemyAtk == 0) {
                    HPcurrent = HPcurrent - CurrentEnemyBasicAttack/5;
                }else {
                    HPcurrent = HPcurrent - CurrentEnemyMagicAttack/5;
                }
                GameCalculateStats();
                GamePrintWorld();
                GamePrintActions();
            }else {
                System.out.println("Err: You're broke");
            }
        }else if (GameSetInput.equals("W") || GameSetInput.equals("w")) {
                CurrentEnemyHealth = CurrentEnemyHealth - 1;
                Manacurrent = Manacurrent + 2;
                int RandomEnemyAtk = ThreadLocalRandom.current().nextInt(0, 1);
                if (RandomEnemyAtk == 0) {
                    HPcurrent = HPcurrent - CurrentEnemyBasicAttack/5;
                }else {
                    HPcurrent = HPcurrent - CurrentEnemyMagicAttack/5;
                }
                GameCalculateStats();
                GamePrintWorld();
                GamePrintActions();
        }else if (GameSetInput.equals("C") || GameSetInput.equals("c")) {
            if (Manacurrent > 2) {
                CurrentEnemyHealth = CurrentEnemyHealth - 4;
                Manacurrent = Manacurrent - 3;
                int RandomEnemyAtk = ThreadLocalRandom.current().nextInt(0, 1);
                if (RandomEnemyAtk == 0) {
                    HPcurrent = HPcurrent - CurrentEnemyBasicAttack/5;
                }else {
                    HPcurrent = HPcurrent - CurrentEnemyMagicAttack/5;
                }
                GameCalculateStats();
                GamePrintWorld();
                GamePrintActions();
            }else {
                System.out.println("Err: Not enough mana");
            }
        }else if (GameSetInput.equals("E") || GameSetInput.equals("e")) {
            if (HealthPackExists == true) {
                HPcurrent = HPcurrent + ThreadLocalRandom.current().nextInt(1, HPfull - HPcurrent);
                Manacurrent = Manafull;
                HealthPackExists = false;
            }else {
                System.out.println("Err: There aint no heal pack");
            }
            GameCalculateStats();
            GamePrintWorld();
            GamePrintActions();
        }else {
            System.out.println("Err: Unknown Input");
        }
        if (RoomsToWin > 0) {
            GameGetInput();
        }
    }
}

