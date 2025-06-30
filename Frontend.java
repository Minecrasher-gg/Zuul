import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
public class Frontend
{
    private ArrayList<Gegner> DEFINITIONEN_Gegner= new ArrayList<Gegner>();
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
    public Frontend() {
        DEFINITIONEN_Gegner.add(new Gegner ("Zombie",    10, 3, 5));
        DEFINITIONEN_Gegner.add(new Gegner ("Skelett",    8, 5, 7));
        DEFINITIONEN_Gegner.add(new Gegner ("Fledermaus", 7, 2, 4));
        DEFINITIONEN_Gegner.add(new Gegner ("Golem",      15, 8, 9));
        DEFINITIONEN_Gegner.add(new Gegner ("Drache",     20, 7, 9));
        MainMenu();
        NewRoom = true;
        CurrentEnemyIsDead = false;
        Scanner GameSelect = new Scanner(System.in);
        String GameSelected = GameSelect.nextLine();
        if (GameSelected.equals("N")) {
            MainMenuS1();
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            MainMenu();
            HPfull = 10;
            HPcurrent = 10;
            Manafull = 20;
            Manacurrent = 10;
            GameCalculateStats();
            GamePrintWorld();
            GamePrintActions();
            GameGetInput();
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
            MainMenuS1();
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            MainMenu();
            HPfull = 10;
            HPcurrent = 5;
            Manafull = 20;
            Manacurrent = 0;
            GameCalculateStats();
            GamePrintWorld();
            GamePrintActions();
            GameGetInput();
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
    public static void MainMenuS1() {
        Logo();
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|                           |------------------------|                                      |------------------------|                                                     |");
        System.out.println("|                           |(N)ew Game████████████ |                                      |     (C)redits          |                                                     |");
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
    Random random = new Random();
    public boolean getBoolean() {
        return random.nextBoolean();
    }
    public void GamePrintWorld() {
        boolean ProbDoor2 = getBoolean();
        if ( ProbDoor2 == true) {
            Door2 = "|========|";
        }else {
            Door2 ="----------";
        }
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
            System.out.println("                                    |----------------------------------------------"+ Door2 +"-----------------------------------------|");
            System.out.println("                                    |                                                                                                  |");
            System.out.println("                                    |                                                                                                  |");
            System.out.println("                                    |                                                                                                  |");
        }
        if (getBoolean() == true && Door2.equals("|========|")) {
            System.out.println("                                    -                                                                                                 -");
            int i = 0;
            if (getBoolean() == true) {
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
            if (getBoolean() == true || Door2.equals("----------")) {
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
            MainMenuS1();
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            MainMenu();
            HPfull = 10;
            HPcurrent = 5;
            Manafull = 20;
            Manacurrent = 0;
            GameCalculateStats();
            GamePrintWorld();
            GamePrintActions();
            GameGetInput();
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
        System.out.println("|    Mana["+ ManaStyled+ "]                 HP["+ HPStyled+ "] "+ HPcurrent+"/"+ HPfull+ "                                                                                                         |");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|                          |-------------------|             |-------------------|             |-------------------|                                                       |");
        System.out.println("|                          |(M)agic            |             |(W)eapon           |             |(C)ombo            |                                                       |");
        System.out.println("|                          |-------------------|             |-------------------|             |-------------------|                                                       |");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|                          |-------------------|             |-------------------|             |-------------------|                                                       |");
        if (Door1 == true) {
            System.out.print("|                          |(A) left door      |             ");
        }else {
            System.out.print("|                          |█████████████████|             ");
        }
        if (Door2.equals("|========|")) {
            System.out.print("|(S) front door     |             ");
        }else {
            System.out.print("|█████████████████|             ");
        }
        if (Door3 == true) {
            System.out.println("|(D) right door     |                                                       |");
        }else {
            System.out.println("|█████████████████|                                                       |");
        }
        System.out.println("|                          |-------------------|             |-------------------|             |-------------------|                                                       |");
        System.out.println("|                                                                                                                                                                          |");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
    }
    public void GameGetInput() {
        Scanner DecidedInput = new Scanner(System.in);
        String GameSetInput = DecidedInput.nextLine();
        if (GameSetInput.equals("A") && Door1 == true) {
            NewRoom = true;
            GamePrintWorld();
            GameCalculateStats();
            GamePrintActions();
        }else if (GameSetInput.equals("S") && Door2.equals("|========|")) {
            NewRoom = true;
            GamePrintWorld();
            GameCalculateStats();
            GamePrintActions();
        }else if (GameSetInput.equals("D") && Door3 == true) {
            NewRoom = true;
            GamePrintWorld();
            GameCalculateStats();
            GamePrintActions();
        }else if (GameSetInput.equals("M")) {
            CurrentEnemyHealth = CurrentEnemyHealth - 3;
            Manacurrent = Manacurrent - 2;
            GamePrintWorld();
            GamePrintActions();
        }else {
            System.out.println("Err: Unknown Input");
        }
        GameGetInput();
    }
}

