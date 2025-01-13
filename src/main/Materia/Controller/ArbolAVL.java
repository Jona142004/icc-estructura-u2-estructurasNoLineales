package main.Materia.Controller;

import main.Materia.Models.Node;

public class ArbolAVL {
    private Node root;

    // Bandera para habilitar mensajes de depuración
    

    public void insert(int value) {
        System.out.println("Nodo a insertar: " + value);
        root = insert(root, value);
    }

    private Node insert(Node nodo, int value) {
        if (nodo == null) {
            // Crear un nuevo nodo si el nodo actual es null
            return new Node(value);
        }

        if (value < nodo.getValue()) {
            // Insertar en el subárbol izquierdo si el valor es menor
            nodo.setLeft(insert(nodo.getLeft(), value));
        } else if (value > nodo.getValue()) {
            // Insertar en el subárbol derecho si el valor es mayor
            nodo.setRight(insert(nodo.getRight(), value));
        }

        // Actualizar la altura del nodo
        nodo.setHeight(1 + Math.max(height(nodo.getLeft()), height(nodo.getRight())));

        // Obtener el balance o factor de equilibrio
        int balance = getBalance(nodo);

        // Caso Izquierda-Izquierda
        if (balance > 1 && value < nodo.getLeft().getValue()) {
            return rightRotate(nodo);
        }

        // Caso Derecha-Derecha
        if (balance < -1 && value > nodo.getRight().getValue()) {
            return leftRotate(nodo);
        }

        // Caso Izquierda-Derecha
        if (balance > 1 && value > nodo.getLeft().getValue()) {
            nodo.setLeft(leftRotate(nodo.getLeft()));
            return rightRotate(nodo);
        }

        // Caso Derecha-Izquierda
        if (balance < -1 && value < nodo.getRight().getValue()) {
            nodo.setRight(rightRotate(nodo.getRight()));
            return leftRotate(nodo);
        }

        // Devolvemos el nodo sin cambios
        return nodo;

        



    }

    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();

        System.out.println("Rotamos derecha el nodo: " + y.getValue());

        // Realizamos la rotación
        x.setRight(y);
        y.setLeft(temp);

        // Actualizar las alturas
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));

        System.out.println("Nueva raíz después de rotación derecha: " + x.getValue());
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node temp = y.getLeft();
        

        System.out.println("Rotamos izquierda el nodo: " + x.getValue() + ", Balance " + getBalance(x));

        // Realizamos la rotación
        y.setLeft(x);
        x.setRight(temp);

        // Actualizar las alturas
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));

        System.out.println("Nueva raíz después de rotación izquierda: " + y.getValue());
        return y;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    public void printTree() {
        printTree(root, "", false);
        
    }

    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());

            printTree(node.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        } else {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + "null");
        }
    }
}
