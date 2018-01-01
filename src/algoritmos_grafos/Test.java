package algoritmos_grafos;

import java.util.Hashtable;
import java.util.Scanner;

public class Test {
//	public static void main(String[] args) throws Exception
//	 {
//	 Scanner scanner = new Scanner(System.in);
//	 int i = Integer.MAX_VALUE; int[][] mAdy= { {i, 6, i, 6, i, i, i}
//	 ,{6, i, 2, i, 4, i, i}
//	 ,{i, 2, i, 4, 6, 4, i}
//	 ,{6, i, 4, i, i, 2, 6}
//	 ,{i, 4, 6, i, i, 6, i}
//	 ,{i, i, 4, 2, 6, i, 4}
//	 ,{i, i, i, 6, i, 4, i} };
//	 // instancio el grafo a partir de su matriz de adyacencias
//	 Grafo g = new Grafo(mAdy);
//	 System.out.print("Ingrese el vertice de origen: ");
//	 int origen = scanner.nextInt();
//	 System.out.println("Ingrese implementacion de Dijkstra: ");
//	 String sClassImple = scanner.next();
//	 // instancio dinamicamente la implementacion ingresada por el usuario
//	 Dijkstra d = (Dijkstra)Class.forName(sClassImple).newInstance();
//	 // invoco el metodo procesar
//	 Hashtable<Integer, Integer> minimos = d.procesar(g, origen);
//	 // muestro los resultados
//	 System.out.println(minimos);
//	 }
	public static void main(String[] args) throws Exception
	 {
	 Scanner scanner = new Scanner(System.in);
	 int i = Integer.MAX_VALUE; int[][] mAdy = { { i, 6, i, 6, i, i, i }
	 , { 6, i, 2, i, 4, i, i }
	 , { i, 2, i, 4, 6, 4, i }
	 , { 6, i, 4, i, i, 2, 6 }
	 , { i, 4, 6, i, i, 6, i }
	 , { i, i, 4, 2, 6, i, 4 }
	 , { i, i, i, 6, i, 4, i } };
	 // instancio el grafo a partir de su matriz de adyacencias
	 Grafo g = new Grafo(mAdy);
	 System.out.print("Ingrese el nodo inicial: ");
	 int s = scanner.nextInt();
	 System.out.println("Ingrese la implementacion: ");
	 String sClassImple = scanner.next();
	 // obtengo una instancia de la implementacion indicada por el usuario
	 Mst mst = (Mst) Class.forName(sClassImple).newInstance();
	 // proceso
	 Grafo solu = mst.procesar(g, 0);
	 for(Arista a: solu.getAristas())
	 {
	 System.out.println(a);
	 }
	 }
}
