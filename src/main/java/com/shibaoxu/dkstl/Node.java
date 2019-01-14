package com.shibaoxu.dkstl;

import java.util.HashSet;
import java.util.Set;

public class Node {
    private String name;
    private Set<Path> paths = new HashSet<>();

    public Node(String name){
        this.name = name;
    }

    public Node addPath(Node node, int weights){
        this.paths.add(new Path(node, weights));
        return this;
    }

    class Path {
        public Path(Node node, int weights){
            this.dest = node;
            this.weights = weights;
        }
        private Node dest;
        private int weights;

        public Node getDest() {
            return dest;
        }
        public int getWeights() {
            return weights;
        }
    }

    public String getName() {
        return name;
    }

    public Set<Path> getPaths() {
        return paths;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
