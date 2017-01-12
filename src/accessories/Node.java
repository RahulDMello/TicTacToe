/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accessories;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Rahul
 */
public class Node {
    
    private static final int MAX_DEPTH = 9;
    private int value;
    private int[][] gamestate;
    private LinkedList<Node> childNodes;
    private int depth;
    ArrayList<Integer> values;
    
    public Node(int[][] gstate,int depth){
        childNodes = new LinkedList<>();
        values = new ArrayList<>();
        gamestate = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                gamestate[i][j]=gstate[i][j];
            }
        }
        this.depth = depth;
        value = check();
        if(value==0 && depth<=MAX_DEPTH){
            getChildren();
            for(Node n:childNodes){
                values.add(n.value);
            }
            setValue();
        }else{
            childNodes = null;
        }
    }
    
    private int check(){
        int ans=0;
        for(int i=0;i<3;i++){
            if(gamestate[i][0]==gamestate[i][1] && gamestate[i][0]==gamestate[i][2] && gamestate[i][0]!=0){
                ans = gamestate[i][0];
                break;
            }else if(gamestate[0][i]==gamestate[1][i] && gamestate[0][i]==gamestate[2][i]  && gamestate[0][i]!=0){
                ans = gamestate[0][i];
                break;
            }
        }
        if(gamestate[0][0]==gamestate[1][1] && gamestate[0][0]==gamestate[2][2] && gamestate[0][0]!=0){
            ans = gamestate[0][0];
        }else if(gamestate[0][2]==gamestate[1][1] && gamestate[0][2]==gamestate[2][0] && gamestate[0][2]!=0){
            ans = gamestate[0][2];
        }
        switch(ans){
            case 1:
                return -1;
            case -1:
                return 1;
            default :
                return 0;
        }
    }
    
    private void getChildren(){
        int[][] newGameState = new int[3][3];
        if(depth%2==0){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(gamestate[i][j]==0){
                        for(int a=0;a<3;a++){
                            for(int b=0;b<3;b++){
                                newGameState[a][b]=gamestate[a][b];
                            }
                        }
                        newGameState[i][j]= -1;
                        childNodes.add(new Node(newGameState,depth+1));
                    }
                }
            }
        }else{
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(gamestate[i][j]==0){
                        for(int a=0;a<3;a++){
                            for(int b=0;b<3;b++){
                                newGameState[a][b]=gamestate[a][b];
                            }
                        }
                        newGameState[i][j]= 1;
                        childNodes.add(new Node(newGameState,depth+1));
                    }
                }
            }
        }
    }
    
    private void setValue(){
        if(depth%2==0){
            value = maxOf(values);
        }else{
            value = minOf(values);
        }
    }
    
    private int maxOf(ArrayList<Integer> values){
        int ans = -1;
        for(int i:values){
            ans = Math.max(ans,i);
        }
        return ans;
    }
    
    private int minOf(ArrayList<Integer> values){
        int ans = 1;
        for(int i:values){
            ans = Math.min(ans,i);
        }
        return ans;
    }
    
    public Node getBestNode(){
        ArrayList<Node> ans = new ArrayList<>();
        if(childNodes!=null){
            
            for(Node n : childNodes){
                if(n.value == value){
                     ans.add(n);
                }
            }
            double index = Math.random();
            index = index*(ans.size()-1);
            return ans.get((int)index);
        }
        return this;
    }

    public int[][] getGamestate() {
        return gamestate;
    }
    
}
