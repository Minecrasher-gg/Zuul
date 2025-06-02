import java.util.ArrayList;
public class Gegner
{
    private ArrayList<DEFINITIONEN_Gegner> DEFINITIONEN_Gegner;
    //Name, Rank, KiTyp, HP, MP, Atk, Def, MgDef, Eva, Acc, Exp
    //KiTyp1: Simple
    //KiTyp2: Random
    //KiTyp3: DPS
    //KiTyp4: Buff Foes -> else 1
    public void Liste () {
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Skelett",    1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 50));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Fledermaus", 1, 2, 8, 12, 7, 7, 7, 7, 15, 10, 40));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Golem",      2, 1, 15, 0, 7, 15, 0, 10, 5, 15, 100));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Drache",    3, 3, 50, 20, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
        DEFINITIONEN_Gegner.add(new DEFINITIONEN_Gegner ("Default",    0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0));
    }
}