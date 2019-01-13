package com.shibaoxu;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class BinarySearch {
    public static int binarySearch(List<Integer> elements, int item){
        int low = 0;
        int high = elements.size() - 1;
        while (low <= high){
            int mid = (low + high)/2;
            int guess = elements.get(mid);
            if (guess == item){
                return mid;
            }else if (guess > item){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        List<Integer> elements = QuickSort.qsort(Utils.prepareData(1000));
        int itemIndex = new Random().nextInt(99);
        int item = elements.get(itemIndex);
        LocalDateTime start = LocalDateTime.now();
        int foundIndex = BinarySearch.binarySearch(elements, item);
        if (itemIndex == foundIndex && item == elements.get(foundIndex)){
            System.out.println("==== 查找成功 =====");
        }
        if (foundIndex == -1){
            System.out.println("=== 查找失败 ===");
        }
        Duration duration = Duration.between(start, LocalDateTime.now());
        Utils.printTime(duration);
    }
}
