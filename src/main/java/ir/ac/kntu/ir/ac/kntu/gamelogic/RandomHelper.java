package ir.ac.kntu.ir.ac.kntu.gamelogic;

import java.util.Random;

public class RandomHelper {

    private static final Random RANDOM_GENERATOR =
            new Random(System.nanoTime());

    private RandomHelper() {

    }

    public static int nextInt(int high) {
        int random = RandomHelper.nextInt();
        if(random < 1){
            return 1;
        } else if(random > high){
            return high;
        } else{
            return random;
        }
    }

    public static boolean nextBoolean() {
        return RANDOM_GENERATOR.nextBoolean();
    }

    public static int nextInt() {
        return RANDOM_GENERATOR.nextInt();
    }

}
