package algoritmos_grafos;
public class Arista
{
 private int n1; private int n2; private int distancia;
 // constructor
 public Arista(int n1,int n2, int dist)
 {
 this.n1 = n1; this.n2 = n2; this.distancia = dist;
 }
 	
 // determinar si "yo", que soy una arista, soy igual a otra
 public boolean equals(Object a)
 {
 Arista otra = (Arista)a;
 return (n1==otra.n2 && n2==otra.n1)
 || (n1==otra.n1 && n2==otra.n2);
 }
 public String toString()
 {
 return "Desde: "+n1+", Hasta: "+n2+" Distancia: "+distancia;
 }
 	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public int getN2() {
		return n2;
	}
	public void setN2(int n2) {
		this.n2 = n2;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
 
 
} 