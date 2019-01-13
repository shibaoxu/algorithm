package com.shibaoxu;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static List<Integer> prepareData(int length){
        List<Integer> data = new ArrayList<>();
        Random ra = new Random();
        for (int i = 0; i < length; i++){
            data.add(ra.nextInt(1000));
        }
        return data;
    }

    public static void printElements(List<Integer> elements, String title){
        System.out.println(title);
        for(int e : elements){
            System.out.print(e);
            System.out.print(", ");
        }
        System.out.print("\n");
    }

    public static void printTime(Duration duration){
        System.out.println("== 运算总共耗时 " + duration.toMillis() + " 毫秒 ==");
    }
}
