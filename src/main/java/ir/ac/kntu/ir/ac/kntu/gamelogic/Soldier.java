package ir.ac.kntu.ir.ac.kntu.gamelogic;

public class Soldier {
    private int id;
    private double health;
    private Gun gun;

    public Soldier(int id, double health) {
        this.id = id;
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public double getHealth() {
        return health;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public void chooseGun(){
        int random = RandomHelper.nextInt(2);
        if(random == 1){
            setGun(new AssaultRifle());
        } else if(random == 2){
            setGun(new SniperRifle(RandomHelper.nextBoolean()));
        }
    }

    public void chooseBullet(){
        if(RandomHelper.nextInt(2) == 1){
            gun.setBullet(Bullet.CALIBER_5);
            gun.setAccuracy(Bullet.CALIBER_5.getAccuracy());

        } else {
            gun.setBullet(Bullet.CALIBER_7);
            gun.setAccuracy(-1 * Bullet.CALIBER_7.getAccuracy());
            gun.setDamage(Bullet.CALIBER_7.getDamage());
        }
    }

    public int fire(){
        int fireAccuracy = RandomHelper.nextInt( 100);
        if(fireAccuracy < gun.getAccuracy()){
            return gun.getDamage();
        } else {
            return 0;
        }
    }

    public void setHealth(int healthDamage) {
        this.health -= healthDamage;
    }

    public Gun getGun() {
        return gun;
    }


}
