package control_work_02;

public class DrawProduct extends Product {

    private int chance;

    public DrawProduct (int id, String name, int count, int chance){
        super(chance, name, count);
        this.chance = chance;
    }
    public int getChance() {
        return chance;
    }

}
