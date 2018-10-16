package Graph;

import java.util.Scanner;

/**
 * Created by ziad on 5/20/18.
 */
public class Dijsktra {

    public void dijsktra (int array[][],int NumberOfVertices){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your start vertix for dijkstra : ");
        int sourceVertix=scanner.nextInt();
    	int distance[]=new int[NumberOfVertices]; // distance between vertices
        Boolean vistedVertix[]=new Boolean[NumberOfVertices]; // boolean to set visted vertices in shortest path

        for(int i=0;i<NumberOfVertices;i++)
        {
            distance[i]= 999999999; // make all distances infinity
            vistedVertix[i]=false; // no vertix has been visted yet
        }


        distance[sourceVertix]=0; // first vertix distance should be Zero

        for(int j=0;j<NumberOfVertices-1;j++){
                // choose the minimum weight of unvisted vertices
            int min = 999999999, Minimum=-1000;
            for (int x = 0; x < NumberOfVertices; x++)
                if (vistedVertix[x] == false && distance[x] <= min)
                {
                    min = distance[x];
                    Minimum = x;
                }
            vistedVertix[Minimum]=true; // set the preVertix to be visted

            for (int i=0; i<NumberOfVertices;i++){
                if(vistedVertix[i]==false&&array[Minimum][i]!=0) // updating distance if node is unvisted
                    if(distance[Minimum]!=999999999&&distance[Minimum]+array[Minimum][i]<distance[i]) //
                        //if the weight from sourceVertix to i is smaller than current weight
                         {
                    distance[i]=distance[Minimum]+array[Minimum][i];
                    //System.out.println(counter+"                  "+i);
                    }
            }
        }
        // printing the shortest path
        System.out.println("Vertex   Distance from SourceVertix");
        for (int counter = 0; counter < NumberOfVertices; counter++)
           System.out.println(counter+"                  "+distance[counter]);
    }

}
