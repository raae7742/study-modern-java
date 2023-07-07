package ch6;

import static ch6.main.Main6_6.partitionPrimesWithCustomCollector1;

public class CollectorHarness {
    public static void main(String[] args) {
        long fastest = Long.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            partitionPrimesWithCustomCollector1(1_000_000);

            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
        }

        System.out.println("Fastest execution done in " + fastest + " msecs");
    }
}
