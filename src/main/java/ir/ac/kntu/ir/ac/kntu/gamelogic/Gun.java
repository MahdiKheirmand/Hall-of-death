package ir.ac.kntu.ir.ac.kntu.gamelogic;

public class Gun {
    private String name;
    private int accuracy;
    private int damage;
    private Bullet bullet;

    public Gun(String name, int accuracy, int damage) {
        this.name = name;
        this.accuracy = accuracy;
        this.damage = damage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int bulletAccuracy) {
        accuracy += bulletAccuracy;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int bulletDamage) {
        damage += bulletDamage;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public String getName() {
        return name;
    }

    public Bullet getBullet() {
        return bullet;
    }
}
