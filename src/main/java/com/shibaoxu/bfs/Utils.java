package com.shibaoxu.bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<String, Persion> createGraph(){
        Persion shibaoxu = new Persion("shibaoxu");
        Persion claire = new Persion("claire");
        Persion thom = new Persion("thom");
        Persion jonny = new Persion("jonny");
        Persion alice = new Persion("alice");
        Persion peggy = new Persion("peggy");
        Persion bob = new Persion("bob");
        Persion anuj = new Persion("anuj");

        shibaoxu.getFriends().addAll(Arrays.asList(bob, claire, alice));
        claire.getFriends().addAll(Arrays.asList(thom, jonny));
        alice.getFriends().addAll(Arrays.asList(peggy));
        bob.getFriends().addAll(Arrays.asList(peggy, anuj));
        Map<String, Persion> graph = new HashMap<>();
        for (Persion p : Arrays.asList(shibaoxu, claire, thom, jonny, alice, peggy, bob, anuj)){
            graph.put(p.getName(), p);
        }
        return graph;
    }
}
