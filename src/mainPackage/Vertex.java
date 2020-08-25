package mainPackage;

import java.util.ArrayList;

public class Vertex {

    private int vertexNumber;
    private int colour;
    private ArrayList<Vertex>adjacencies =new ArrayList<>();

    public Vertex(int num){
        vertexNumber=num;
        colour=-1;//Sets the colour of that vertex to -1 representing uncoloured
    }

    public void addAdjacency(Vertex v){
        adjacencies.add(v);
    }

    public boolean isAdjacent(Vertex v){

        return adjacencies.contains(v);//returns true if it is adjacent to that vertex
    }

    public int getDegree(){
        return adjacencies.size();//returns the degree(number of edges) of current vertex
    }

    public int getColour() {
        return colour;
    }

    public void setColor(int degreeGraph) {
        int[] used=new int[degreeGraph];
        for(int i=0;i<degreeGraph;i++){
            used[i]=0;
        }

        for(int i=0;i<adjacencies.size();i++){
            if(adjacencies.get(i).getColour()!=-1){
                used[adjacencies.get(i).getColour()]=1;//marks that color as used
            }
        }

        for(int i=0;i<degreeGraph;i++){
            if(used[i]==0){
                this.colour=i;
                return;
            }
        }
    }
}
