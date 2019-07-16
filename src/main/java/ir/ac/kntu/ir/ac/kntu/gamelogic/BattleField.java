package ir.ac.kntu.ir.ac.kntu.gamelogic;

import java.util.ArrayList;

public class BattleField {
    private ArrayList<Soldier> defendingSoldiers;
    private ArrayList<Soldier> attackingSoldiers;
    private int size;

    public BattleField(int size) {
        defendingSoldiers = new ArrayList<>();
        attackingSoldiers = new ArrayList<>();
        this.size = size;
        init();
    }

    private void init() {
        int i;
        for (i = 1; i <= size; i++) {
            Soldier defence = new Soldier(i, 200);
            defendingSoldiers.add(defence);
            defence.chooseGun();
            defence.chooseBullet();

            Soldier attack = new Soldier(i, 200);
            attackingSoldiers.add(attack);
            attack.chooseGun();
            attack.chooseBullet();
        }
        handle();
    }

    private void handle() {
        int count = 0;
        boolean again = true;
        while (again) {
            System.out.println("###########" + "ROUND " +
                    count + "###########");

            if (count != 0) {
                run();
            }

            printStatus(count);

            count++;

            again = printResult();
        }
    }

    private void run() {
        int defenceId = RandomHelper.nextInt(defendingSoldiers.size());
        if (defenceId == defendingSoldiers.size()) {
            defenceId--;
        }
        Soldier defence = defendingSoldiers.get(defenceId);

        int attackId = RandomHelper.nextInt(attackingSoldiers.size());
        if (attackId == attackingSoldiers.size()) {
            attackId--;
        }
        Soldier attack = attackingSoldiers.get(attackId);

        boolean check;
        int random = RandomHelper.nextInt(2);
        if (random == 1) {
            check = fire(defence, attack, attackId, random);
        } else {
            check = fire(attack, defence, defenceId, random);
        }
        if (check) {
            if (random == 2) {
                fire(attack, defence, defenceId, random);
            } else {
                fire(defence, attack, attackId, random);
            }
        }

    }

    private boolean fire(Soldier first, Soldier second,
                         int secondId, int random) {
        int damage;
        damage = first.fire();
        second.setHealth(damage);
        if (!checkAlive(second)) {
            if (random == 1) {
                attackingSoldiers.remove(secondId);
                return false;
            } else {
                defendingSoldiers.remove(secondId);
                return false;
            }
        }
        return true;
    }

    private boolean checkAlive(Soldier soldier) {
        return (soldier.getHealth() > 0);
    }

    private void printStatus(int count) {
        printSoldiers(defendingSoldiers);
        printSoldiers(attackingSoldiers);
        System.out.println("aliveAttackSide:" +
                defendingSoldiers.size());
        System.out.println("aliveDefenceSide:" +
                attackingSoldiers.size());

        System.out.println("###########" + "END ROUND " +
                count + "###########");
    }

    private void printSoldiers(ArrayList<Soldier> soldiers) {
        for (Soldier soldier : soldiers) {
            System.out.print("[S" + soldier.getId() + "$" +
                    soldier.getHealth() + "@" + soldier.getGun().getName() +
                    "@" + soldier.getGun().getBullet().getName() + "]");
        }
        System.out.println();
    }

    private boolean printResult(){
        if (attackingSoldiers.size() == 0) {
            System.out.println("########Defending soldiers Won########");
            return false;
        } else if (defendingSoldiers.size() == 0) {
            System.out.println("########Atacking soldiers WON########");
            return false;
        }
        return true;
    }


}
