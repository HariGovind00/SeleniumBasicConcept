package hgk.coreJava;

public class TwoDimArray
{
public static void main(String[] args)
{
	//table[rows][Column]   
	//10  20  30
	//50  5   25
	int[][] table=new int[2][3];
	table[0][0]=10;
	table[0][1]=20;
	table[0][2]=30;
	
	table[1][0]=50;
	table[1][1]=5;
	table[1][2]=25;
	
	System.out.println(table.length);
	//Get Table data
	for(int i=0;i<table.length;i++)
	{
		for(int j=0;j<=table.length;j++)
		{
			System.out.print(table[i][j]+"\t");
		}
		System.out.println();
		
	}
	
}
}
