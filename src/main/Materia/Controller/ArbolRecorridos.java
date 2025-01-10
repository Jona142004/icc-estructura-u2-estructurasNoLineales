package main.Materia.Controller;

import java.util.Stack;

import main.Materia.Models.Node;

public class ArbolRecorridos {
    public void preOrderIterativo(Node root){
        //verificar si no esta vacio
        if (root == null) {
            return;
        }
        //Pila para manejar los nodos del arbol durante el recorrido
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            
            System.out.print(node.getValue() + ", ");
            if (node.getRight() != null) {
                stack.push(node.getRight());

            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }
    public void preOrderRecurisvo(Node node){
        
        //Verificar si el nodo esta vacio
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            preOrderIterativo(node.getLeft());
            preOrderIterativo(node.getRight());
        }
    }
    public void postOrderRecursivo(Node node){
        if (node != null) {
            
            postOrderRecursivo(node.getLeft());
            
            postOrderRecursivo(node.getRight()); 
            System.out.print(node.getValue() + ", ");
        }
    }
    public void inOrderRecursivo(Node node){
        if (node != null) {
            
            inOrderRecursivo(node.getLeft());
            System.out.print(node.getValue() + ", ");
            inOrderRecursivo(node.getRight());
        }
    }
}
