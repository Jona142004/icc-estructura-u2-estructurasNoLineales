package main.Materia.Controller;

import java.util.ArrayList;
import java.util.List;

import main.Materia.Models.NodeG;

public class Graph {
    private List<NodeG> nodes;
    public Graph(){
        this.nodes = new ArrayList<>();
    }
    public NodeG addNode(int value){
        NodeG nodeG = new NodeG(value);
        nodes.add(nodeG);
            return nodeG;

    }
    public void addEdge(NodeG src, NodeG dest){
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }
    public void printGraph() {
        for(NodeG nodeG : nodes) {
            System.out.print("Vertice " + nodeG.getValue() + ": ");
            for(NodeG neighbor : nodeG.getNeighbors()) {
                System.out.print(neighbor.getValue() + " - ");
            }
            System.out.println(); 
        }
    
    
    }
    private void getDFSUtil(NodeG node, boolean[] visited){

    }
    public void getBFS(NodeG starNode){

    }
    public int[][] getAdjacencyMatrix(){
            return null;

    }
    public void printAdjacencyMatrix(){

    }
}
