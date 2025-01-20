package main.Materia.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
    public void addEdgeD(NodeG src, NodeG dest){
        src.addNeighbor(dest);
        
    }
    public void printGraph() {
        for(NodeG nodeG : nodes) {
            System.out.print("Vertice " + nodeG.getValue() + ": ");
            for(NodeG neighbor : nodeG.getNeighbors()) {
                System.out.print(neighbor.getValue() + " -> ");
            }
            System.out.println(); 
        }
    
    
    }
    public void getDFS(NodeG start){
        Set<NodeG> visited = new HashSet<>();
        System.out.println("DFS desde el node " + start.getValue() + " :");
        getDFSUtil(start, visited);
        System.out.println();
    }
    private void getDFSUtil(NodeG node, Set<NodeG> visited){
        if (visited.contains(node)) {
            return;
        }
        System.out.print(node.getValue() + " ");
        visited.add(node);
        for(NodeG neighbor : node.getNeighbors()){
            getDFSUtil(neighbor, visited);
        }
    }
    public void getDFSO(NodeG start, int objetivo) {
        Set<NodeG> visited = new HashSet<>();
        System.out.println("DFS buscando el nodo con valor " + objetivo + " desde el nodo " + start.getValue() + ":");
        if (!getDFSUtilO(start, visited, objetivo)) {
            System.out.println("Nodo no encontrado.");
        }
    }
    private boolean getDFSUtilO(NodeG node, Set<NodeG> visited, int objetivo){
        if (visited.contains(node)) {
            return false;
        }
        System.out.print(node.getValue() + " ");
        if (node.getValue() == objetivo) {
            System.out.println("\nNodo con valor " + objetivo + " encontrado.");
            return true;  
        }
        visited.add(node);
        for(NodeG neighbor : node.getNeighbors()){
            if (getDFSUtilO(neighbor, visited,objetivo)) {
                return true;
            }
            
        }
        return false;
    }
    public void getBFS(NodeG starNode){
        Set<NodeG> visited = new HashSet<>();
        Queue<NodeG> cola = new LinkedList<>();
        System.out.println("BFS desde el nodo" + starNode.getValue());
        cola.add(starNode);
        visited.add(starNode);

        while (!cola.isEmpty()) {
            NodeG actual = cola.poll();
            System.out.print(actual.getValue() + " ");
            for(NodeG neighbor : actual.getNeighbors()){
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    cola.add(neighbor);
                }
            }
        }       
        

    }
    public int[][] getAdjacencyMatrix(){
            return null;

    }
    public void printAdjacencyMatrix(){

    }
}
