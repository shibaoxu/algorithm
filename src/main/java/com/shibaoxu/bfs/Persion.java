package com.shibaoxu.bfs;

import java.util.*;

public class Persion {
    private String name;
    private Set<String> career = new HashSet<>();
    private Set<Persion> friends = new HashSet<>();
    private String path = "";

    public Persion(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getCareer() {
        return career;
    }

    public void setCareer(Set<String> career) {
        this.career = career;
    }

    public Set<Persion> getFriends() {
        return friends;
    }

    public void setFriends(Set<Persion> friends) {
        this.friends = friends;
    }

    public void addFriend(Persion persion){
        friends.add(persion);
    }

    public void removeFriends(Persion persion){
        friends.remove(persion);
    }

    public void addCareer(String career){
        this.career.add(career);
    }
    public void removeCareer(String career){
        this.career.remove(career);
    }

    public String getPath() {
        return path;
    }

    public String getFullPath(){
        return this.getPath() + "-->" + this.getName();
    }

    public Persion setPath(String path) {
        this.path = path;
        return this;
    }

    public String toString(){
        return this.getName();
    }
}
