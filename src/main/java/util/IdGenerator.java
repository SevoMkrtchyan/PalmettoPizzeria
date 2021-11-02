package util;

import java.util.Random;

public class IdGenerator {

    public static int generateId() {
        Random random = new Random();
        return ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
    }

}