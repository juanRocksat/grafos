package lol;

import java.util.ArrayList;

public class MstImplePrim implements Mst {
	public Grafo procesar(Grafo g, int s)
	 {
	 // nodos incorporados al arbol, inicialmente vacio
	 ArrayList<Integer> incorporados = new ArrayList<Integer>();
	 // arbol recubridor minimo implementado como una instancia de Grafo
	 Grafo solu = new Grafo(g.size());
	 // en cada iteracion procesamos al nodo n, comenzando por s
	 int n = s; for(int i=0; i<g.size()-1; i++)
	 {
	 // marco a n como “procesado” y lo incorporo al array
	 g.setProcesado(n);
	 incorporados.add(n);

	 // de todos los nodos incorporados busca el nodo no imporporado
	 // cuya distancia sea la menor...
	 int incorporar[] = buscarMinimos(g,incorporados); int desde = incorporar[0]; // nodo ya incorporado
	 int hasta = incorporar[1]; // nodo a incorporar...
	 int dist = g.getDistancia(desde,hasta);
	 // agrego al arbol la arista que conecta el nuevo nodo
	 solu.addArista(new Arista(desde, hasta, dist));
	 // en la proxima iteracion marcaremos como "procesado"
	 // al nodo que acabamos de incorporar al arbol solucion
	 n = hasta;
	 }

	 return solu;
	 } 

	 private int[] buscarMinimos(Grafo g, ArrayList<Integer> incorporados)
	 {
	 int ret[]=new int[2] ;
	 int min = Integer.MAX_VALUE; for(int i=0; i<incorporados.size(); i++)
	 {
	 int desde = incorporados.get(i);
	 ArrayList<Integer> vecinos = g.getVecinos(desde);
	 for(int j=0; j<vecinos.size();j++)
	 {
	 int vecino = vecinos.get(j); if( vecino!=desde && g.getDistancia(desde,vecino)<min )
	 {
	 min = g.getDistancia(desde,vecino);
	 ret[0]=desde;
	 ret[1]=vecino;
	 }
	 }
	 }

	 return ret;
	 } 
}
