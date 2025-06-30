public class Gegner {
    private String name;
    private int HP, basicATC, magicATC;

    public Gegner(String name, int stat1, int stat2, int stat3) {
        this.name = name;
        this.HP = stat1;
        this.basicATC = stat2;
        this.magicATC = stat3;
    }

    public String ReturnName() {
        return name;
    }

    public int ReturnHP() {
        return HP;
    }
    
    public int ReturnBasic() {
        return basicATC;
    }
    
    public int ReturnMagic() {
        return magicATC;
    }
}