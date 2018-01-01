package algoritmos_grafos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Grafo
{
 // matriz de adyacencias
	private int matriz[][];
	private ArrayList<Integer> procesados = new ArrayList<Integer>();
 
 
 // constructor, recibe la matriz de adyacencias
	 public Grafo(int mat[][])
	 {
		 this.matriz = mat;
	 }
	//recibe la dimension de la matriz, la instancia
	// y le asigna "infinito" a cada celda
	public Grafo(int n)
	{
	// matriz cuadrada de n filas y n columnas
		matriz = new int[n][n];

	// inicializo la matriz
		for(int i=0;i<n; i++)
		{
		for(int j=0; j<n; j++)
		{
			matriz[i][j] = Integer.MAX_VALUE;
		}
		}
	}
	// recibe la dimension de la matriz, y un conjunto de aristas
	// los nodos no afectados por las aristas no seran adyacentes
	public Grafo(int n, Arista[] arr)
	{
		// invoco al otro constructor para inicializar la matriz
		this(n);

		for(Arista a:arr)
		{
		addArista(a);
		}
	}
// agregar una arista implica asignar la distancia
// en las celdas correspondientes
public void addArista(Arista a)
{
	matriz[a.getN1()][a.getN2()]=a.getDistancia();
	matriz[a.getN2()][a.getN1()]=a.getDistancia();
}
// retorna los nodos adyacentes
//public ArrayList<Integer> getVecinos(int n)
//{
//ArrayList<Integer> a = new ArrayList<Integer>();
//for( int i=0; i<matriz.length; i++ )
//{
//if( matriz[n][i]!=Integer.MAX_VALUE )
//{
//a.add(i);
//}
//}
//return a;
//}
//viene de mas arriba
// retorna la longitud de la matriz de adyacencias
public int size()
{
	return matriz.length;
}
// retorna el valor de matriz[a][b]
public int getDistancia(int a, int b)
{
	return matriz[a][b];
}

public void setProcesado(int n)
{
	procesados.add(n);
}
public boolean isProcesado(int n)
{
	return procesados.contains(n);
}
public void resetProcesados()
{
	procesados.clear();
}
public ArrayList<Integer> getVecinos(int n)
{
	ArrayList<Integer> a = new ArrayList<Integer>();
	for( int i=0; i<matriz.length; i++ )
	{
		if(matriz[n][i]!= Integer.MAX_VALUE)
		{
	// lo agrego solo si no fue procesado
			if(!procesados.contains(i))
			{
				a.add(i);
			}
		}
	}
	return a;

}
public boolean hayCiclo(int nInicio, int nFin)
{
	// resguardo el estado actual de los nodos procesados
	ArrayList<Integer> bkpProcesados = (ArrayList<Integer>) procesados.clone();
	resetProcesados();
	// encolo b y veo si llego hasta a
	Queue<Integer> q = new LinkedList<Integer>();
	q.add(nInicio);
	while( !q.isEmpty() )
	{
		int n = q.poll();
		if( n==nFin )
		{
			return true;
		}
		setProcesado(n);
	// obtengo los vecinos
		ArrayList<Integer> vecinos = getVecinos(n);
		for(int x: vecinos)
		{
			q.add(x);
		}
	}
	// restauro el estado de nodos procesados que el grafo tenia al inicio
	procesados = bkpProcesados;
	return false;
}
	public static void main(String[] args) {
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
	}
	public boolean isVisitado(int i) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ArrayList<Arista> getAristas()
	 {
		ArrayList<Arista> arr = new ArrayList<Arista>(); for( int i=0; i<matriz.length; i++ )
		{
			for(int j=0; j<matriz.length; j++ )
			{
				if( matriz[i][j] != Integer.MAX_VALUE )
				{
					Arista a = new Arista(i, j, matriz[i][j]);
	 // recordemos que sobrescribimos el metodo
	 // equals indicando que la arista (a,b)
	 // identica a la arista (b,a)
					if( !arr.contains(a) )
					{
						arr.add(a);
					}
				}
			}
		}
	 return arr;
	 }

}
