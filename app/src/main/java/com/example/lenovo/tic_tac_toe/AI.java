package com.example.lenovo.tic_tac_toe;


import android.util.Log;

import java.util.ArrayList;

public class AI
{


    public static int minimax(int[][] a,int depth,boolean isMax,int player1)
    {
        int player2=1;

        if(player1==1)
            player2=0;

        int score=terminate(a,player1);

        if(score==10)
            return score;

        if(score==-10)
            return score;

        if(score==0)
            return 0;

        int best;
        //maximizer's move
        if(isMax)
        {
            best=-1000;

            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(a[i][j]==-1)
                    {
                        //make the move
                        a[i][j]=player1;

                        best=Math.max(best,minimax(a,depth+1,!isMax,player1));

                        a[i][j]=-1;
                    }
                }

                best-=depth;
            }
        }

        //minimizer
        else
        {
            best=1000;

            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(a[i][j]==-1)
                    {
                        //make the move
                        a[i][j]=player2;

                        best=Math.min(best,minimax(a,depth+1,!isMax,player2));

                        a[i][j]=-1;
                    }
                }

                best+=depth;
            }
        }


        return best;
    }



    public static ArrayList<Integer> bestMove(int[][] a, int player)
    {
        int max=-1000,value;
        int row=-1,column=-1;


        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                //empty
                if(a[i][j]==-1)
                {
                    //making the move
                    a[i][j]=player;

                    //calculating value
                    value=minimax(a,0,false,player);

                    //undo the move
                    a[i][j]=-1;

                    if(max<value)
                    {
                        max=value;
                        row=i;
                        column=j;
                    }
                }


            }
        }

        //the minimax is intented to win
        //but what about defending losing??
        //defending will not always be work as it will never let the user win
        //so here probability is used

        int random,sum=0;
        for(int i=0;i<100;i++)
        {
            random=1+(int)(Math.random()*100);
            sum+=random;
        }
        Home.probability=sum/100;
        if(Home.probability%2==0)
        {
            int p1=player,p2=1-p1;

            //--------------------------------------------------diagonals
            if(a[0][0]==a[1][1] && a[0][0]==p2 && a[2][2]==-1)
            {
                row=2;column=2;
            }

            else if(a[0][0]==a[2][2] && a[0][0]==p2 && a[1][1]==-1)
            {
                row=1;column=1;
            }

            else if(a[1][1]==a[2][2] && a[1][1]==p2 && a[0][0]==-1)
            {
                row=1;column=1;
            }
            //--------------------------------------------------diagonals

            //--------------------------------------------------diagonals
            else if(a[0][2]==a[1][1] && a[0][2]==p2 && a[2][0]==-1)
            {
                row=2;column=0;
            }

            else if(a[2][0]==a[0][2] && a[2][0]==p2 && a[1][1]==-1)
            {
                row=1;column=1;
            }

            else if(a[1][1]==a[2][0] && a[1][1]==p2 && a[0][2]==-1)
            {
                row=0;column=2;
            }
            //--------------------------------------------------diagonals


            //--------------------------------------------------columns
            for(int i=0;i<3;i++)
            {
                if(a[0][i]==a[1][i] && a[0][i]==p2 && a[2][i]==-1)
                {
                    row=2;column=i;
                    break;
                }

                if(a[0][i]==a[2][i] && a[0][i]==p2 && a[1][i]==-1)
                {
                    row=1;column=i;
                    break;
                }

                if(a[2][i]==a[1][i] && a[2][i]==p2 && a[0][i]==-1)
                {
                    row=0;column=i;
                    break;
                }
            }
            //--------------------------------------------------columns


            //--------------------------------------------------rows
            for(int i=0;i<3;i++)
            {
                if(a[i][0]==a[i][1] && a[i][0]==p2 && a[i][2]==-1)
                {
                    row=i;column=2;
                    break;
                }

                if(a[i][0]==a[i][2] && a[i][0]==p2 && a[i][1]==-1)
                {
                    row=i;column=1;
                    break;
                }

                if(a[i][2]==a[i][1] && a[i][2]==p2 && a[i][0]==-1)
                {
                    row=i;column=0;
                    break;
                }
            }
            //--------------------------------------------------rows
            Log.e("defendind",String.valueOf(row));
            Log.e("defendind",String.valueOf(column));

        }


        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(row);
        arr.add(column);

        return arr;
    }


    //--------------------------------------------------------------------determines if anyone has won
    public static int terminate(int[][] board,int player1)
    {
        int[][] a=board;
        //---------------------------------------checking the two diagonals
        if(a[0][0]!=-1 && a[0][0]== a[1][1] && a[1][1]==a[2][2])
        {
            if(a[0][0]==player1)
                return  10;
            else
                return  -10;
        }

        if(a[0][2]!=-1 && a[0][2]==a[1][1] && a[1][1]==a[2][0])
        {
            if(a[0][0]==player1)
                return  10;
            else
                return  -10;
        }
        //---------------------------------------checking the two diagonals



        //---------------------------------------checking the rows
        for(int i=0;i<3;i++)
        {
            if(a[i][0]!=-1 && a[i][0]==a[i][1] && a[i][1]==a[i][2])
            {
                if(a[i][0]==player1)
                    return  10;
                else
                    return  -10;
            }
        }
        //---------------------------------------checking the rows



        //---------------------------------------checking the columns
        for(int i=0;i<3;i++)
        {
            if(a[0][i]!=-1 && a[0][i]==a[1][i] && a[1][i]==a[2][i])
            {
                if(a[0][i]==player1)
                    return  10;
                else
                    return  -10;
            }
        }
        //---------------------------------------checking the columns


        //---------------------------------------checking for a tie
        int count=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(a[i][j]==-1)
                    count++;
            }
        }

        if(count==0)
            return 0;

        //---------------------------------------checking for a tie

        return -1;

    }
    //--------------------------------------------------------------------determines if anyone has won
}
