package pogorzelec.irregularverbs.utils;

import java.util.Random;

public class RandomUtil {

    private static RandomUtil instance = null;
    private Random random;

    public static RandomUtil getInstance() {
        if (RandomUtil.instance == null) {
            instance = new RandomUtil();
        }
        return instance;
    }

    public int nextInt() {
        return random.nextInt();
    }

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    private RandomUtil() {
        random = new Random();
    }
}
