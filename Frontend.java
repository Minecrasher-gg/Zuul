import java.util.Scanner;
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
        while (i < 23) {
            System.out.println("                                                                                                                                                                          ");
            i++;
        }
    }
    public static void GamePrintWorld() {
        
    }
    public void GameCalculateStats() {
        HPStyled = "";
        int i = HPfull/HPcurrent;
        while (i < HPcurrent*5) {
            HPStyled = HPStyled+ "#";
            i = i + HPfull/HPcurrent;
        }
        while (i < HPfull*5) {
            HPStyled = HPStyled+ "-";
            i = i + HPfull/HPcurrent;
        }
        ManaStyled = "";
        i = Manafull/Manacurrent;
        while (i < Manacurrent*5) {
            HPStyled = ManaStyled+ "#";
            i = i + Manafull/Manacurrent;
        }
        while (i < Manafull*5) {
            ManaStyled = ManaStyled+ "-";
            i = i + Manafull/Manacurrent;
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

