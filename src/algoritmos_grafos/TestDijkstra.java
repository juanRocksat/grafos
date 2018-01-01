package algoritmos_grafos;

import java.util.Hashtable;
public class TestDijkstra {
	public static void main(String[] args)
	 {
	 int i = Integer.MAX_VALUE;
	 int[][] mAdy= { {i, 6, i, 6, i, i, i}
	 ,{6, i, 2, i, 4, i, i}
	 ,{i, 2, i, 4, 6, 4, i}
	 ,{6, i, 4, i, i, 2, 6}
	 ,{i, 4, 6, i, i, 6, i}
	 ,{i, i, 4, 2, 6, i, 4}
	 ,{i, i, i, 6, i, 4, i} };

	 // instancio el grafo a partir de su matriz de adyacencias
	 Grafo g = new Grafo(mAdy);
	 // defino el nodo de origen
	 int origen = Integer.parseInt(args[0]);

	 Dijkstra d = new DijkstraImpleGreddy();
	 Hashtable<Integer, Integer> minimos = d.procesar(g, origen);
	 // muestro los resultados
	 System.out.println(minimos);
	 }
	
	

}
