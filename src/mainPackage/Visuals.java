package mainPackage;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.*;


import java.awt.*;
import java.util.ArrayList;


public class Visuals {
    private static Canvas canvas;
    private static double canvasWidth;
    private static double canvasHeight;

    private static int vertexCount=0;

    private static ArrayList<Pair<Double,Double>> arrVertexPos=new ArrayList<Pair<Double, Double>>();
    private static GraphicsContext gc;
    private static Graph graph=new Graph();

    public Visuals(Canvas c){
        canvas=c;
        canvasWidth=canvas.getWidth();
        canvasHeight=canvas.getHeight();

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.setLineWidth(4.0D);
        gc.fillRect(0,0,canvasWidth,canvasHeight);

        canvas.setOnMouseClicked(event -> {
            drawVertix(event.getX()-5,event.getY()-5);
        });
    }

    private void drawVertix(double x,double y){

        if(validVertexPos(x,y)) {
            Pair pair = new Pair(x, y);
            arrVertexPos.add(pair);
            gc.setFill(Color.BLACK);
            gc.setLineWidth(2.0D);

            gc.strokeOval(x, y, 40, 40);
            gc.setFont(javafx.scene.text.Font.font(Font.SERIF, 20));
            if ((vertexCount + "").length() == 1) {
                gc.fillText(vertexCount + "", x + 15, y + 25);
            } else {
                gc.fillText(vertexCount + "", x + 10, y + 25);
            }

            Vertex vertex = new Vertex(vertexCount);
            graph.addVertex(vertex);
            vertexCount++;
        }
        else{
            System.out.println("Invalid vertex pos");
        }
    }

    private boolean validVertexPos(double x,double y){
        Double tempX,tempY;
        if(y+40>canvasHeight || x-40<0){//basic bounds checking
            return false;

        }
        for (int i=0;i<arrVertexPos.size();i++){
            tempX=arrVertexPos.get(i).getKey();
            tempY=arrVertexPos.get(i).getValue();
            System.out.println("tempX: "+tempX+" tempY:"+tempY);
            System.out.println(x+"   "+y);
            if((tempX-45<x && x<tempX+45) && (tempY-45<y && y<tempY+45)){
                return false;
            }
        }
        return true;
    }

}