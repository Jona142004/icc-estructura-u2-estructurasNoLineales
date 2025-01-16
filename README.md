Estructuras de Datos en Java: Ejercicios de Árboles Binarios

Este repositorio contiene la implementación de diversos ejercicios relacionados con árboles binarios en Java. Cada ejercicio está diseñado para abordar una funcionalidad específica de los árboles binarios y está separado en clases individuales. A continuación, se describe el propósito y funcionamiento de cada clase.

Ejercicio 01: Insertar nodos en un Árbol Binario de Búsqueda (BST)

Clase: InsertBSTTest

Esta clase permite crear un árbol binario de búsqueda (BST) e insertar nodos en él. Además, incluye un método para imprimir el árbol por niveles.

Funcionalidades:

insert(int value): Inserta un nodo con un valor dado en el árbol BST.

listLevels(Node root): Genera una lista de listas, donde cada lista interna representa los nodos de un nivel del árbol.

printLevels(List<List<Node>> levels): Imprime los valores de los nodos nivel por nivel con formato claro.

Uso:


InsertBSTTest insert = new InsertBSTTest();
int[] values = {5, 3, 7, 2, 4, 6, 8};
for (int value : values) {
    insert.insert(value);
}
Node root = insert.getRoot();
System.out.println("\arbol original:");
insert.printLevels(insert.listLevels(root));

Ejercicio 02: Invertir un Árbol Binario

Clase: InvertBinaryTree

Esta clase proporciona la funcionalidad de invertir un árbol binario, intercambiando los hijos izquierdo y derecho de todos los nodos.

Funcionalidades:

invertTree(Node root): Invierte el árbol binario recursivamente.

printTreeLevels(Node root): Imprime los valores de los nodos por niveles utilizando el método listLevels de la clase InsertBSTTest.

Uso:

InvertBinaryTree invert = new InvertBinaryTree();
Node invertedRoot = invert.invertTree(root);
System.out.println("\arbol invertido:");
insert.printLevels(insert.listLevels(invertedRoot));

Ejercicio 03: Listar niveles de un Árbol Binario

Clase: ListLevels

Esta clase es una implementación dedicada para obtener y mostrar los niveles de un árbol binario.

Funcionalidades:

listLevels(Node root): Devuelve una lista de listas representando los niveles del árbol.

printLevels(List<List<Node>> levels): Imprime los niveles del árbol de forma clara y ordenada.

Uso:

ListLevels listLevels = new ListLevels();
List<List<Node>> levels = listLevels.listLevels(root);
listLevels.printLevels(levels);

Ejercicio 04: Calcular la profundidad máxima de un Árbol Binario

Clase: Depth

Esta clase permite calcular la profundidad máxima de un árbol binario, que se define como la longitud del camino más largo desde la raíz hasta una hoja.

Funcionalidades:

maxDepth(Node root): Calcula la profundidad máxima de un árbol binario de manera recursiva.

printDepth(Node root): Imprime la profundidad máxima calculada
