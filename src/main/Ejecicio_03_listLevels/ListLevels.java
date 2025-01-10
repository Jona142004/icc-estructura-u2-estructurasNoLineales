package main.Ejecicio_03_listLevels;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.Materia.Models.Node;

public class ListLevels {
    
    public List<List<Node>> listLevels(Node root){
        //verificar si la lista esta vacia
        if (root != null) {
            return null;
        }
        List<List<Node>> levels = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // Obtenemos el tamaño de la cola para saber cuántos nodos hay en el nivel actual
            int levelSize = queue.size();
            
            // Creamos una lista para almacenar los nodos del nivel actual
            List<Node> currentLevel = new LinkedList<>();
            
            // Procesamos todos los nodos del nivel actual
            for (int i = 0; i < levelSize; i++) {
                // Sacamos el primer nodo de la cola (el nodo que estamos procesando)
                Node currentNode = queue.poll();
                
                // Añadimos el nodo actual a la lista del nivel actual
                currentLevel.add(currentNode);
                
                // Si el nodo tiene hijo izquierdo, lo añadimos a la cola para procesarlo en el siguiente nivel
                if (currentNode.getLeft() != null) {
                    queue.offer(currentNode.getLeft());
                }
                
                // Si el nodo tiene hijo derecho, lo añadimos a la cola para procesarlo en el siguiente nivel
                if (currentNode.getRight() != null) {
                    queue.offer(currentNode.getRight());
                }
            }
            
            // Añadimos la lista del nivel actual a la lista de todos los niveles
            levels.add(currentLevel);
        }
        
        // Devolvemos la lista que contiene los nodos de cada nivel
        return levels;
    

        
    }
}
