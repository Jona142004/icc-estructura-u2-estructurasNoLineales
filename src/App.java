import main.Ejecicio_03_listLevels.ListLevels;
import main.Materia.Controller.ArbolBinario;
import main.Materia.Controller.ArbolRecorridos;

public class App {
    public static void main(String[] args) throws Exception {
        //runArbolBinario();
        runLevels();
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
        int[] valores = {4,2,3,1,7,6,9};
        for (int i = 0; i < valores.length; i++) {
            arbolBinario.insert(valores[i]);
        }
        System.out.println("Arbol");
        arbolBinario.printTree();
        ListLevels listLevels = new ListLevels();
        listLevels.listLevels(arbolBinario.getRoot());
    }
}
