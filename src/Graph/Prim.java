package Graph;

import java.util.ArrayList;

/**
 * Created by Omar Wagdy on 5/21/18.
 */
public class Prim {
	final static int infinity= 1000000;
	int i,j,k,l,flag,min=infinity,row,minRow,minCol,weight=0;
	public void minimumSpaningTree(int array[][],int NumberOfVertices)
	{
		int	MST[][]=new int[NumberOfVertices][NumberOfVertices];
		
		for(i=0;i<NumberOfVertices;i++)
				for(j=0;j<NumberOfVertices;j++)
				{
					MST[i][j]=0;
					if(i!=j&& array[i][j]==0)
					{
						array[i][j]=infinity;
					}
				}
		
		
		for (i=0;i<NumberOfVertices ;i++)	//	Conserving the Non Reflexive property of a MST
		{
			array[i][i]=0;
		}
		ArrayList<Integer> visited=new ArrayList<>();
		visited.add(0);
	for(i=0;i<NumberOfVertices-1;i++)
	{
			min=infinity;
		for(j=0;j<visited.size();j++) //Finding minimum branch for the visited vertices;
		{
			row=visited.get(j);
			for(k=0;k<NumberOfVertices;k++)
			{
				if(array[row][k]<min&&array[row][k]!=0)
				{
					min=array[row][k];
					minRow=row;
					minCol=k;
					
				}
			}
			
			array[minRow][minCol]=0;
			array[minCol][minRow]=0;
			MST[minRow][minCol]=min;
			MST[minCol][minRow]=min;
			
			
			
			
		}
		
		flag=0;
		for(l=0;l<visited.size();l++) {
			if(minCol==visited.get(l))
			{
				flag=1;
				break;
				
			}
			
		}
		if(flag==0)
			visited.add(minCol);
		

		
		System.out.println("Edge "+minRow+","+minCol +" Weight= "+ min);
		weight+=min;
		
	}
		
		
	System.out.println("Total Weight= "+weight);
		
		
		
	}
	
}
