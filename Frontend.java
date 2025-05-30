import java.util.Scanner;
import java.util.Random;
public class Frontend
{
    public int Mana;
    public int Manafull;
    public int Manacurrent;
    public String ManaStyled;
    public int HPfull;
    public int HPcurrent;
    public String HPStyled;
    public Frontend() {
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
        String Door2;
        boolean ProbDoor2 = getBoolean();
        if ( ProbDoor2 == true) {
            Door2 = "|========|";
        }else {
            Door2 ="----------";
        }
        System.out.println("");
        System.out.println("");
        System.out.println("                                    |-------------------------------------------------"+ Door2 +"--------------------------------------|");
        System.out.println("                                    |                                                                                                 |");
        System.out.println("                                    |                                                                                                 |");
        System.out.println("                                    |                                                                                                 |");
        if (getBoolean() == true) {
            System.out.println("                                    -                                                                                                 -");
            int i = 0;
            while (i < 8) {
                System.out.println("                                    =                                                                                                 =");
                i++;
            }
            System.out.println("                                    -                                                                                                 -");
        }else {
            int i = 0;
            while (i < 11) {
                System.out.println("                                    |                                                                                                 |");
                i++;
            }
        }
        
        System.out.println("                                    |                                                                                                 |");
        System.out.println("                                    |                                                                                                 |");
        System.out.println("                                    |                                                                                                 |");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    public void GameCalculateStats() {
        HPStyled = "";
        int i;
        if ( HPcurrent == 0) {
            i = 0;
        }else {
            i = HPfull/HPcurrent;
        }
        while (i < HPcurrent*5) {
            HPStyled = HPStyled+ "#";
            i = i + HPfull/HPcurrent;
        }
        if (HPcurrent > 0) {
            while (i < HPfull*5) {
                HPStyled = HPStyled+ "-";
                i = i + HPfull/HPcurrent;
            }
        }else {
            while (i < HPfull*20) {
                HPStyled = HPStyled + "-";
                i = i + HPfull;
            }
        }
        ManaStyled = "";
        if ( Manacurrent == 0) {
            i = 0;
        }else {
            i = Manafull/Manacurrent;
        }
        while (i < Manacurrent*5) {
            HPStyled = ManaStyled+ "#";
            i = i + Manafull/Manacurrent;
        }
        if (Manacurrent > 0) {
            while (i < Manafull*5) {
                ManaStyled = ManaStyled+ "-";
                i = i + Manafull/Manacurrent;
            }
        }else {
            while (i < Manafull*20) {
                ManaStyled = ManaStyled+ "-";
                i = i + Manafull;
            }
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
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
    }
}

