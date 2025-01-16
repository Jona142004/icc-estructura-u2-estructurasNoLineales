package main.Materia.Ejercicio_02_invert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.Materia.Models.Node;

public class InvertBinaryTree {
public Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        Node temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        invertTree(root.getLeft());
        invertTree(root.getRight());

        return root;
    }

    public void printTreeLevels(Node root) {
        List<List<Node>> levels = listLevels(root);
        for (List<Node> level : levels) {
            for (Node node : level) {
                System.out.print(node.getValue() + " ");
            }
            System.out.println();
        }
    }

    private List<List<Node>> listLevels(Node root) {
        List<List<Node>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Node> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode);

                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }

                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}

