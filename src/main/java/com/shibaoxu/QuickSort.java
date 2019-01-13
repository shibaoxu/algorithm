package com.shibaoxu;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static List<Integer> qsort(List<Integer> elements){
        if (elements.size() < 2) {
            return elements;
        }else {
            int pivot = elements.get(0);
            List<Integer> less = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();
            for(int i = 1; i < elements.size(); i++){
                if (elements.get(i) <= pivot){
                    less.add(elements.get(i));
                }else{
                    greater.add(elements.get(i));
                }
            }

            List<Integer> result = qsort(less);
            result.add(pivot);
            result.addAll(qsort(greater));
            return result;
        }
    }

}
