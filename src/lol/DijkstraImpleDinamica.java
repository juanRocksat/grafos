package lol;

import java.util.Hashtable;

public class DijkstraImpleDinamica implements Dijkstra{

	
	@Override
	public Hashtable<Integer, Integer> procesar(Grafo g, int s) {
		// tabla con la solucion del problema
		 Hashtable<Integer, Integer> solu = new Hashtable<Integer, Integer>();
		// inicializo la solucion de la siguiente manera:
		 // * las distancias a los nodos adyacentes o
		 // * INFINITO para los nodos no adyacentes
		 for(int i = 0; i<g.size(); i++)
		 {
		 int d = g.getDistancia(s, i);
		 solu.put(i, d);
		 }
		 // seteo como "procesado" al nodo de origen
		 g.setProcesado(s);
		 // comparo todos contra todos
		 for( int i = 0; i<g.size()-1; i++ )
		 {
		 // retorna la posicion del menor valor contenido en la tabla
		 int posMin = menor(g, solu);
		 // lo marco como visitado
		 g.setProcesado(posMin);
		 for( int j=0; j<g.size(); j++ )
		 {
		 if( !g.isProcesado(j) )
		 {
		 // veo si puedo mejorar las distancias
		 int x = sumar(solu.get(posMin), g.getDistancia(posMin, j));
		 solu.put(j, Math.min(solu.get(j), x));
		 }
		 }
		 }
		 return solu;
		 } 
	private int sumar(int a, int b)
	{
	if( a==Integer.MAX_VALUE || b==Integer.MAX_VALUE )
	{
	return Integer.MAX_VALUE;
	}
	else
	{
	return a+b;
	}
	}
	 private int menor(Grafo g, Hashtable<Integer,Integer> solu)
	 {
	 int min = Integer.MAX_VALUE;
	 int pos = 0;
	 for(int i = 0; i<g.size(); i++)
	 {
	 if(!g.isVisitado(i) && solu.get(i)<min)
	 {
	 min = solu.get(i);
	 pos = i;
	 }
	 }
	 return pos;
	 }
	 
	
}
