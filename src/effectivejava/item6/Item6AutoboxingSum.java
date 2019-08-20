package effectivejava.item6;

import java.util.concurrent.TimeUnit;

public class Item6AutoboxingSum {
    private static long sum(){
        Long sum = 0L;  // autoboxing to long to Long in for loop. unnecessary object creation.
        //long sum = 0L;  // primitive to primitive.

        for (long i = 0; i <= Integer.MAX_VALUE ; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println("Start " + start);
        System.out.println(Item6AutoboxingSum.sum());
        long end = System.nanoTime();
        System.out.println("End " + end);
        long duration = end - start;
        System.out.println(TimeUnit.MICROSECONDS.convert(duration,TimeUnit.NANOSECONDS));
    }
}
