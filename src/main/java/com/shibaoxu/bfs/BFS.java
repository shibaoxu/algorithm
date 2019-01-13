package com.shibaoxu.bfs;

import java.util.*;

public class BFS {
    public static boolean bfsSearch(Map<String, Persion> grahp){
        Queue<Persion> searchQueue = new LinkedList<>();
        searchQueue.offer(grahp.get("shibaoxu").setPath("root"));
        List<String> searched = new ArrayList<>();

        while(!searchQueue.isEmpty()){
            Persion person = searchQueue.poll();
            if (!searched.contains(person.getName())){
                if (isTheOme(person)){
                    System.out.println(person.getFullPath() + " is the One!");
                    return true;
                }else{
                    for(Persion p : person.getFriends()){
                        searchQueue.offer(p.setPath(person.getPath() + "-->" + person.getName()));
                    }
                }
                searched.add(person.getName());
            }
        }
        System.out.println("Not found!");
        return false;
    }

    private static boolean isTheOme(Persion persion){
        return persion.getName().endsWith("j");
    }

    public static void main(String[] args){
        bfsSearch(Utils.createGraph());
    }
}
