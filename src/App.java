import java.util.List;

import main.Ejecicio_03_listLevels.ListLevels;
import main.Materia.Controller.ArbolAVL;
import main.Materia.Controller.ArbolBinario;
import main.Materia.Controller.ArbolRecorridos;
import main.Materia.Models.Node;
import main.Materia.Ejercicio_01_insert.    InsertBSTTest;
import main.Materia.Ejercicio_02_invert.    InvertBinaryTree;
import main.Materia.Ejercicio_04_depth.Depth;
import main.Materia.Ejercicio_03_ListLevels.*;
import main.Materia.Ejercicio_04_depth.Depth;       

public class App {
    public static void main(String[] args) throws Exception {
        //runArbolBinario();

        runArbolAVL();
        runEjercicios();
    }
    public static void runArbolBinario(){
        ArbolBinario arbolBinario = new ArbolBinario();
        ArbolRecorridos arbolRecorridos = new ArbolRecorridos();
        int[] valores = {40,20,60,10,30,50,70,5,15,55};
        for (int i = 0; i < valores.length; i++) {
            arbolBinario.insert(valores[i]);
        }
        arbolBinario.printTree();
        System.out.println("Recorrido preOrder");
        arbolRecorridos.preOrderIterativo(arbolBinario.getRoot());
        
        System.out.println("\n preOrderRecursivo");
        arbolRecorridos.preOrderRecurisvo(arbolBinario.getRoot());

        System.out.println("\n postOrder Recursivo");
        arbolRecorridos.postOrderRecursivo(arbolBinario.getRoot());

        System.out.println("\n inOrderRecursivo");
        arbolRecorridos.inOrderRecursivo(arbolBinario.getRoot());
    }
    public static void runLevels(){
        ArbolBinario arbolBinario = new ArbolBinario();
        ListLevels listLevels = new ListLevels();
        
        int[] valores = {4,2,3,1,7,6,9};
        for (int i = 0; i < valores.length; i++) {
            arbolBinario.insert(valores[i]);
        }
        System.out.println("Arbol");
        arbolBinario.printTree();
        
        List<List<Node>> listaFinal = listLevels.listLevels(arbolBinario.getRoot());
        listLevels.printLevels(listaFinal);
    }

    public static void runArbolAVL(){
        int[] values = {10,20,15,24,9,8,21,23,50,25};
        ArbolAVL arbolAVL = new ArbolAVL();
        for (int i = 0; i < values.length; i++) {
            arbolAVL.insert(values[i]);
            arbolAVL.printTree();  
        }
        
        

}
public static void runEjercicios() {
     // Ejercicio 01: Insertar nodos en el árbol binario de búsqueda
     InsertBSTTest insert = new InsertBSTTest();
     int[] values = {5, 3, 7, 2, 4, 6, 8};
     for (int value : values) {
         insert.insert(value);
     }

     Node root = insert.getRoot();

    // Imprimir el árbol original usando listLevels
    System.out.println("Árbol original:");
    List<List<Node>> levels = insert.listLevels(root);
    insert.printLevels(levels);
    System.out.println("");

    // Ejercicio 02: Invertir el árbol
    InvertBinaryTree invert = new InvertBinaryTree();
    Node invertedRoot = invert.invertTree(root);

    // Imprimir el árbol invertido con el mismo formato
    System.out.println("Árbol invertido:");
    List<List<Node>> invertedLevels = insert.listLevels(invertedRoot);
    insert.printLevels(invertedLevels);

    // Ejercicio 03: Listar niveles
    InsertBSTTest insert2 = new     InsertBSTTest();
    for (int value : values    ) {
        insert2.insert(value);
        }

    Node root2 = insert2.getRoot(); // Corregido: usar insert2 para obtener la raíz
    System.out.println("\nListar niveles del árbol:");
    ListLevels listLevels = new ListLevels();
    listLevels.printLevels(listLevels.listLevels(root2));

    // Ejercicio 04: Calcular la profundidad máxima
    System.out.println("\nProfundidad  del árbol:");
    Depth depth = new Depth();
    depth.printDepth(root);
}
}

