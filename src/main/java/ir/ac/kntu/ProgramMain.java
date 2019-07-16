package ir.ac.kntu;

import ir.ac.kntu.ir.ac.kntu.gamelogic.BattleField;

import java.util.Scanner;

public class ProgramMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of soldiers: ");
        int size = scanner.nextInt();
        scanner.close();
        new BattleField(size);
    }

}
