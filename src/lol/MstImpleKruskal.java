package lol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MstImpleKruskal implements Mst{

	@Override
	public Grafo procesar(Grafo g, int n) {
		// tomo el conjunto de aristas del grafo original
		 ArrayList<Arista> aristas = g.getAristas();
		// las ordeno segun su distancia, de menor a mayor
		 Collections.sort(aristas, new ComparaArista());

		 // instancio el grafo solucion (arbol, conexo y sin ciclos)
		 Grafo solu = new Grafo(g.size());

		 // agrego exactamente n-1 aristas
		 int i=0;
		 while( !aristas.isEmpty() && i<g.size()-1 )
		 {
		 // tomo la primer arista del array, la de menor peso
		 Arista a = aristas.get(0);

		 // si no hay ciclo la agrego y cuento “una arista mas”
		 if( !solu.hayCiclo(a.getN1(),a.getN2()) )
		 {
		 solu.addArista(a);
		 i++;
		 }

		 // la remuevo del conjunto de aristas disponibles
		 aristas.remove(0);
		 }

		 return solu;
		 }
	}
class ComparaArista implements Comparator<Arista>
{
public int compare(Arista a1, Arista a2)
{
return a1.getDistancia()-a2.getDistancia();
}


}
