package cz.mrq.experiments;

import cz.mrq.experiments.util.Time;

/**
 * Autoboxing
 *
 * @author Lumir Mrkva (lumir.mrkva@topmonks.com)
 */
public class Autoboxing {

    @Time
    public static void autoboxing1() {
        Long sum = 0L;
        for (long i=0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    @Time
    public static void autoboxing2() {
        long sum = 0L;
        for (long i=0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void autoboxing3() {
        long sum = 0L;
        for (Long i=0L; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }


    private Autoboxing() {};
}
