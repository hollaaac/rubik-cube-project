package com.display;

public class AStar {

    //This class can only be used by AStar
    private class Node {

        //Node Class Variables
        private Node parent;
        private Node child; //Don't think will need child nodes, but here just in case
        private int cost;

        //Default Node Constructor
        //Default Values
        public Node(){
            parent = null;
            child = null;
            cost = 0; 
        }

        public Node(int cost){
            parent = null;
            child = null;
            this.cost = cost;
        }

        public Node(Node parent){
            this.parent = parent;
            child = null;
            cost = 0;
        }

        public Node(Node parent, int cost){
            this.parent = parent;
            child = null;
            this.cost = cost;
        }

        public Node getParent(){
            return parent;
        }

        public Node getChild(){
            return child;
        }

        public int getCost(){
            return cost;
        }

        public void setParent(Node parent){
            this.parent = parent;
        }

        public void setChild(Node child){
            this.child = child;
        }

        public void setCost(int cost){
            this.cost = cost;
        }

    }

    //Class Variables
    Node head;
    int cost = 0;

    public AStar(){
        System.out.println("We made it to here");
    }


}
