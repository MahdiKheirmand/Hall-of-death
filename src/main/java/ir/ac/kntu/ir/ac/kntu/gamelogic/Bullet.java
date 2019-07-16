package ir.ac.kntu.ir.ac.kntu.gamelogic;

enum Bullet {
    CALIBER_5("CALIBER_5",15,0) ,
    CALIBER_7("CALIBER_7",10,10);

    private String name;
    private int accuracy;
    private int damage;

    Bullet(String name, int accuracy, int damage) {
        this.name = name;
        this.accuracy = accuracy;
        this.damage = damage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}
