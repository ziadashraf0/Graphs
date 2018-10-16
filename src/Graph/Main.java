package Graph;

import java.util.Scanner;

//import com.sun.java.util.jar.pack.Instruction.Switch;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of vertices :  " );
        int NumberOfVertices= scanner.nextInt();
       
        int array[][]=new int[NumberOfVertices][NumberOfVertices];
        System.out.println("Enter input of array(Graph)\n");
        // scanning n*n weighted graph
        for(int i=0;i<NumberOfVertices;i++){
            for ( int j=0 ; j<NumberOfVertices;j++){
                System.out.println("Row["+i+"]Column["+j+"]: ");
                array[i][j]=scanner.nextInt();
            }
        }
        System.out.println("Press 1 For MST: ");
        System.out.println("Press 2 For Shortest Path:");
        int x;
        x=scanner.nextInt();
        switch(x){
        case 1:
        {
        	 Prim p=new Prim();
            p.minimumSpaningTree(array, NumberOfVertices);
            break;
        }
        case 2:
        {
        	Dijsktra dijsktra=new Dijsktra();
        	dijsktra.dijsktra(array,NumberOfVertices);
        	break;
        }
        	
     //  }

// calling shortest path algorithm
        }

    }
}
