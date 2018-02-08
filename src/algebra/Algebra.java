package algebra;
import java.util.Scanner;
public class Algebra
{
	public Object [][] matriz = null;
	public int dimension ;
	Scanner scanner = null;
	public Algebra()
	{
//		matriz = crearMatrizNula(3);
//		dimension=3;
	}
	public Algebra(int dimension__){
		dimension=dimension__;
		crearMatrizNula(dimension__);
	}
	public Algebra(Object  [][] matriz_){
		matriz = matriz_;
		dimension = matriz_[0].length;
	}
	public Object[][] crearMatrizNula(int n)
	{
		matriz = null;//hay que averiguar como borrar los registros innecesarios para que no consuma memoria 
		
		matriz = new Object[n][n];
		for(int i =0;i<n;i++){
			for(int j =0;j<n;j++){
				matriz[i][j]=0;
			}
		}
		return matriz;
	}
	private void mostrarMatriz()
	{
		for(int i =0;i<dimension;i++){
			for(int j =0;j<dimension;j++){
				System.out.print( matriz[i][j]);
			}
			System.out.println();
		}
	}
	private void leerAlgo()
	{
		scanner = new Scanner(System.in);
	}
	public static void main(String[] args)
	{
		Algebra matriz = new Algebra();
		System.out.print("lol");
		matriz.leerAlgo();
		int dimension = matriz.getScanner().nextInt();
		matriz.crearMatrizNula(dimension);
		System.out.println(matriz.getMatriz());
		matriz.mostrarMatriz();
		System.exit(0);
	}
	
	public Object[][] getMatriz()
	{
		return matriz;
	}
	public void setMatriz(Object[][] matriz)
	{
		this.matriz=matriz;
	}
	public Scanner getScanner()
	{
		return scanner;
	}
	public void setScanner(Scanner scanner)
	{
		this.scanner=scanner;
	}
}
