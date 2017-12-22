package lol;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class DijkstraImpleGredy implements Dijkstra {
	public Hashtable<Integer, Integer> procesar(Grafo g, int s)
	 {
	 // asigno "infinito" a cada posicion de distMin
	 Hashtable<Integer, Integer> distMin = new Hashtable<Integer, Integer>();
	 inicializar(distMin, g.size(), Integer.MAX_VALUE);
	 // asigno 0 a cada posicion de distAcum
	 Hashtable<Integer, Integer> distAcum = new Hashtable<Integer, Integer>();
	 inicializar(distAcum, g.size(), 0);
	 Queue<Integer> q = new LinkedList<Integer>();
	 q.add(s); 
	 while(!q.isEmpty())
	 {
	 // tomo el primero
	 int n = q.poll();
	 // lo marco como visitado
	 g.setProcesado(n);

	 int acum = distAcum.get(n);
	// obtengo los vecinos de n
	 // pido sus vecinos
	 ArrayList<Integer> vecinos = g.getVecinos(n);

	 for(int i = 0; i<vecinos.size(); i++)
	 {
	 // tomo el i-esimo vecino y su distancia
	 int t = vecinos.get(i); int dist = g.getDistancia(n, t) + acum; int min = distMin.get(t);
	 if( dist<min )
	 {
	 distMin.put(t, dist);
	 distAcum.put(t, dist);
	 }

	 if(!q.contains(t))
	 {
	 q.add(t);
	 }
	 }
	 }

	 return distMin;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
