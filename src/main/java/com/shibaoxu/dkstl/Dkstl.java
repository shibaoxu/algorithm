package com.shibaoxu.dkstl;

import java.util.*;
import java.util.stream.Collectors;

public class Dkstl {
    private static Integer INF = 500;

    public static void dkstl(Map<String, Node> graph) {
        Map<Node, Integer> costs = new HashMap<>();
        Map<Node, Node> parents = new HashMap<>();
        Set<Node> processed = new HashSet<>();

        initCosts(graph, graph.get("start"), costs);
        Node node = findLowestCostNode(costs, processed);
        while (node != null){
            int cost = costs.get(node);
            for(Node.Path path : node.getPaths()){
                int newCost = cost + path.getWeights();
                if (costs.get(path.getDest()) >= newCost){
                    costs.put(path.getDest(), newCost);
                    parents.put(path.getDest(), node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs, processed);
        }
        System.out.println(costs);
        printResult(parents, graph.get("end"));
    }

    public static Map<String, Node> createGraph1() {
        Node start = new Node("start");
        Node A = new Node("A");
        Node B = new Node("B");
        Node end = new Node("end");

        start
                .addPath(A, 6)
                .addPath(B, 2);
        A.addPath(end, 1);
        B
                .addPath(A, 3)
                .addPath(end, 5);

        Map<String, Node> graph = new HashMap<>();
        Arrays.asList(start, A, B, end).forEach(it -> {
            graph.put(it.getName(), it);
        });
        return graph;
    }

    public static Map<String, Node> createGraph2(){
        Node start = new Node("start");
        Node end = new Node("end");
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        start.addPath(A, 5).addPath(B, 2);
        A.addPath(C, 4).addPath(D, 2);
        B.addPath(A, 8).addPath(D, 7);
        C.addPath(end, 3).addPath(D, 6);
        D.addPath(end, 1);
        Map<String, Node> graph = new HashMap<>();
        Arrays.asList(start, A, B, C, D, end).forEach(it -> {
            graph.put(it.getName(), it);
        });
        return graph;


    }

    public static void initCosts(Map<String, Node> graph, Node node, Map<Node, Integer> costs) {
        if (node.getName().equals("start")){
            costs.put(node, 0);
            for(Node.Path path : node.getPaths()){
                costs.put(path.getDest(), path.getWeights());
                initCosts(graph, path.getDest(), costs);
            }
        }else {
            for(Node.Path path: node.getPaths()){
                if(costs.get(path.getDest()) == null){
                    costs.put(path.getDest(), INF);
                }
                initCosts(graph, path.getDest(),costs);
            }
        }
    }

    public static Node findLowestCostNode(Map<Node, Integer> costs, Set<Node> processed){
        int lowestCost = Integer.MAX_VALUE;
        Node lowestCostNode = null;
        for(Map.Entry<Node, Integer> entry: costs.entrySet()){
            if (entry.getValue() < lowestCost && !processed.contains(entry.getKey())){
                lowestCost = entry.getValue();
                lowestCostNode = entry.getKey();
            }
        }
        return lowestCostNode;
    }

    public static void printResult(Map<Node, Node> result, Node lastNode){
        List<String> nodes = new ArrayList<>();
        Node node = lastNode;
        while(true){
            nodes.add(node.getName());
            node = result.get(node);
            if (node == null) break;;
        }
        Collections.reverse(nodes);
        System.out.println(nodes);
    }
    public static void main(String[] args){
        Map<String, Node> graph = createGraph2();
        dkstl(graph);
    }


}
