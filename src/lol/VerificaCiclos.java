package lol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VerificaCiclos {
	public static void main(String[] args)
	 {
	 Scanner scanner = new Scanner(System.in);

	 // ingresa x consola los valores del grafo
	 Grafo g = ingresaGrafo(scanner);
	 // ingresa x consola los valores de la arista
	 Arista a = ingresaAristaAVerificar(scanner);

	 if( hayCiclo(g,a) )
	 {
	 System.out.println("La arista forma un ciclo");
	 }
	 else
	 {
	 System.out.println("La arista no forma ciclo");
	 }
	 }
	private static boolean hayCiclo(Grafo g, Arista a)
	 {
	 // arraylist para recordar los nodos procesados
	 ArrayList<Integer> procesados = new ArrayList<Integer>();

	 // cola de nodos pendientes de proceso
	 Queue<Integer> q = new LinkedList<Integer>();
	// extremos de la arista
	 int nInicio = a.getN1(); int nFin = a.getN2();
	 // encolamos el extremo inicial
	 q.add(nInicio);

	 while( !q.isEmpty() )
	 {
	 // desencolo y proceso un nodo
	 int n = q.poll();
	 // llegamos al extremo final?
	 if( n==nFin )
	 {
	 return true; // HAY CICLO
	 }
	 // agrego el nodo a la lista de nodos procesados...
	 procesados.add(n);

	 // pido sus vecinos...
	 ArrayList<Integer> vecinos = g.getVecinos(n);

	 // encolo a sus vecinos, salvo los que ya fueron procesados
	 for(int v:vecinos)
	 {
	 if( !procesados.contains(v) )
	 {
	 q.add(v);
	 }
	 }
	 }
	 // si llegamos hasta aqui sera porque la arista no forma ciclo
	 return false;
	 }
	private static Grafo ingresaGrafo(Scanner scanner)
	 {
	 System.out.println("--Ingreso del grafo --");
	 System.out.print("Cantidad de vertices: ");
	 int n = scanner.nextInt();

	 Grafo g = new Grafo(n);
	 System.out.print("Cantidad de aristas: ");
	 int a = scanner.nextInt();

	 System.out.println("- Ingrese "+a+" aristas -");
	 for( int i=0; i<a; i++ )
	 {
	 g.addArista( ingresaArista(scanner) );
	 }
	 return g;
	 }
	private static Arista ingresaAristaAVerificar(Scanner scanner)
	 {
	 System.out.println("-- Ingrese la arista a verificar --");
	 return ingresaArista(scanner);
	 }
	private static Arista ingresaArista(Scanner scanner)
	 {
	 System.out.print("Extremo inicial: ");
	 int n1 = scanner.nextInt();

	 System.out.print("Extremo final: ");
	 int n2 = scanner.nextInt();

	 System.out.print("Distancia: ");
	 int d = scanner.nextInt();

	 Arista a = new Arista(n1, n2, d);
	 System.out.println("Arista ingresada: "+a);

	 return a;
	 }
}
