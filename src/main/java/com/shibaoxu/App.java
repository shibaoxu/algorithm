package com.shibaoxu;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Integer> unsort = Utils.prepareData(200);
        LocalDateTime start = LocalDateTime.now();
        List<Integer> sorted = QuickSort.qsort(unsort);
        Duration duration = Duration.between(start, LocalDateTime.now());
        Utils.printTime(duration);
//        printElements(unsort, "=== Before QuickSort ====");
//        printElements(sorted, "=== Sorted =====");
    }


}
