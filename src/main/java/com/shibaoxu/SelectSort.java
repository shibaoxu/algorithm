package com.shibaoxu;

import java.util.ArrayList;
import java.util.List;

public class SelectSort {
    public static List<Integer> selectSort(List<Integer> elements){
        List<Integer> sorted = new ArrayList<>();
        while(!elements.isEmpty()){
            sorted.add(findSmallest(elements));
        }
        return sorted;
    }

    private static int findSmallest(List<Integer> elements){
        int small = elements.get(0);
        int smallIndex = 0;
        for(int i = 1; i < elements.size(); i++){
            if (elements.get(i) < small){
                small = elements.get(i);
                smallIndex = i;
            }
        }
        elements.remove(smallIndex);
        return small;
    }

    public static void main(String[] args){
        List<Integer> unsorted = Utils.prepareData(10);
        List<Integer> sorted = SelectSort.selectSort(unsorted);
        Utils.printElements(sorted, "排序结果");
    }
}
