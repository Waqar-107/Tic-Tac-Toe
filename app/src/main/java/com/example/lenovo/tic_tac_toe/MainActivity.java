package com.example.lenovo.tic_tac_toe;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    int[] cross={R.drawable.one_one_x,R.drawable.one_two_x,R.drawable.one_three_x,R.drawable.two_one_x,
            R.drawable.cross,R.drawable.two_three_x,R.drawable.three_one_x,R.drawable.three_two_x,
            R.drawable.three_three_x};


    int[] circle={R.drawable.one_one_c,R.drawable.one_two_c,R.drawable.one_three_c,R.drawable.two_one_c,
            R.drawable.circle,R.drawable.two_three_c,R.drawable.three_one_c,R.drawable.three_two_c,
            R.drawable.three_three_c};


    int turn,p1,p2;
    int[][] board=new int[3][3];
    int[] one=new int[9];
    int[] two=new int[9];
    int win=-1;
    ArrayList arr;


    Button button;
    TextView judge;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        judge= (TextView) findViewById(R.id.judge);
        turn=1;
        arr=new ArrayList();

        //---------------------------------------initial board state
        //---------------------------------------0 for 'o',1 for 'X'
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=-1;
            }
        }
        //---------------------------------------initial board state



        //---------------------------------------image array for players
        if(Home.player1=='o')
        {
            p1=0;p2=1;
            for(int i=0;i<9;i++)
            {
                one[i]=circle[i];
                two[i]=cross[i];
            }
        }

        else
        {
            p1=1;p2=0;
            for(int i=0;i<9;i++)
            {
                one[i]=cross[i];
                two[i]=circle[i];
            }
        }
        //---------------------------------------image array for players


    }


    //-------------------------------------------Move player 1
    public void changePic(View view)
    {
        if(findViewById(R.id.one_one)==view.findViewById(R.id.one_one))
        {
            if(board[0][0]==-1 & win==-1)
            {
                int x;
                if(turn%2==1)
                {
                    turn=2;
                    board[0][0]=p1;

                    button= (Button) findViewById(R.id.one_one);
                    button.setBackgroundResource(one[0]);

                    x=terminate();
                    if(x!=-1)
                    {
                        win=1;
                        if(x==1)
                            judge.setText("X wins!!!");
                        else if(x==0)
                            judge.setText("O wins!!!");
                        else
                            judge.setText("Tie :(");
                    }

                    if(win==-1)
                    {
                        //get player2's move
                        if(arr.size()>0)
                            arr.clear();

                        arr=AI.bestMove(board,p2);
                        Log.e(arr.get(0).toString(),arr.get(1).toString());

                        //move image
                        movePlayer2();

                        x=terminate();
                        if(x!=-1)
                        {
                            win=1;
                            if(x==1)
                                judge.setText("X wins!!!");
                            else if(x==0)
                                judge.setText("O wins!!!");
                            else
                                judge.setText("Tie :(");
                        }

                        turn=1;
                    }
                }
            }
        }

        if(findViewById(R.id.one_two)==view)
        {
            if(board[0][1]==-1 & win==-1)
            {
                if(turn%2==1)
                {
                    int x;
                    turn=2;
                    board[0][1]=p1;

                    button= (Button) findViewById(R.id.one_two);
                    button.setBackgroundResource(one[1]);

                    x=terminate();
                    if(x!=-1)
                    {
                        win=1;
                        if(x==1)
                            judge.setText("X wins!!!");
                        else if(x==0)
                            judge.setText("O wins!!!");
                        else
                            judge.setText("Tie :(");
                    }

                    if(win==-1)
                    {
                        //get player2's move
                        if(arr.size()>0)
                            arr.clear();

                        arr=AI.bestMove(board,p2);
                        Log.e(arr.get(0).toString(),arr.get(1).toString());

                        //move image
                        movePlayer2();

                        x=terminate();
                        if(x!=-1)
                        {
                            win=1;
                            if(x==1)
                                judge.setText("X wins!!!");
                            else if(x==0)
                                judge.setText("O wins!!!");
                            else
                                judge.setText("Tie :(");
                        }

                        turn=1;
                    }
                }


            }
        }

        if(findViewById(R.id.one_three)==view )
        {
            if(board[0][2]==-1 & win==-1)
            {
                int x;
                if(turn%2==1)
                {
                    turn=2;
                    board[0][2]=p1;

                    button= (Button) findViewById(R.id.one_three);
                    button.setBackgroundResource(one[2]);

                    x=terminate();
                    if(x!=-1)
                    {
                        win=1;
                        if(x==1)
                            judge.setText("X wins!!!");
                        else if(x==0)
                            judge.setText("O wins!!!");
                        else
                            judge.setText("Tie :(");
                    }

                    if(win==-1)
                    {
                        //get player2's move
                        if(arr.size()>0)
                            arr.clear();

                        arr=AI.bestMove(board,p2);
                        Log.e(arr.get(0).toString(),arr.get(1).toString());

                        //move image
                        movePlayer2();

                        x=terminate();
                        if(x!=-1)
                        {
                            win=1;
                            if(x==1)
                                judge.setText("X wins!!!");
                            else if(x==0)
                                judge.setText("O wins!!!");
                            else
                                judge.setText("Tie :(");
                        }

                        turn=1;
                    }
                }
            }
        }

        if(findViewById(R.id.two_one)==view )
        {
            if(board[1][0]==-1 & win==-1)
            {
                int x;
                if(turn%2==1)
                {
                    turn=2;
                    board[1][0]=p1;

                    button= (Button) findViewById(R.id.two_one);
                    button.setBackgroundResource(one[3]);

                    x=terminate();
                    if(x!=-1)
                    {
                        win=1;
                        if(x==1)
                            judge.setText("X wins!!!");
                        else if(x==0)
                            judge.setText("O wins!!!");
                        else
                            judge.setText("Tie :(");
                    }

                    if(win==-1)
                    {
                        //get player2's move
                        if(arr.size()>0)
                            arr.clear();

                        arr=AI.bestMove(board,p2);
                        Log.e(arr.get(0).toString(),arr.get(1).toString());

                        //move image
                        movePlayer2();

                        x=terminate();
                        if(x!=-1)
                        {
                            win=1;
                            if(x==1)
                                judge.setText("X wins!!!");
                            else if(x==0)
                                judge.setText("O wins!!!");
                            else
                                judge.setText("Tie :(");
                        }

                        turn=1;
                    }
                }
            }
        }

        if(findViewById(R.id.two_two)==view )
        {
            if(board[1][1]==-1 & win==-1)
            {
                int x;
                if(turn%2==1)
                {
                    turn=2;
                    board[1][1]=p1;

                    button= (Button) findViewById(R.id.two_two);
                    button.setBackgroundResource(one[4]);

                    x=terminate();
                    if(x!=-1)
                    {
                        win=1;
                        if(x==1)
                            judge.setText("X wins!!!");
                        else if(x==0)
                            judge.setText("O wins!!!");
                        else
                            judge.setText("Tie :(");
                    }

                    if(win==-1)
                    {
                        //get player2's move
                        if(arr.size()>0)
                            arr.clear();

                        arr=AI.bestMove(board,p2);
                        Log.e(arr.get(0).toString(),arr.get(1).toString());

                        //move image
                        movePlayer2();

                        x=terminate();
                        if(x!=-1)
                        {
                            win=1;
                            if(x==1)
                                judge.setText("X wins!!!");
                            else if(x==0)
                                judge.setText("O wins!!!");
                            else
                                judge.setText("Tie :(");
                        }

                        turn=1;
                    }
                }
            }
        }

        if(findViewById(R.id.two_three)==view )
        {
            if(board[1][2]==-1 & win==-1)
            {
                int x;
                if(turn%2==1)
                {
                    turn=2;
                    board[1][2]=p1;

                    button= (Button) findViewById(R.id.two_three);
                    button.setBackgroundResource(one[5]);

                    x=terminate();
                    if(x!=-1)
                    {
                        win=1;
                        if(x==1)
                            judge.setText("X wins!!!");
                        else if(x==0)
                            judge.setText("O wins!!!");
                        else
                            judge.setText("Tie :(");
                    }

                    if(win==-1)
                    {
                        //get player2's move
                        if(arr.size()>0)
                            arr.clear();

                        arr=AI.bestMove(board,p2);
                        Log.e(arr.get(0).toString(),arr.get(1).toString());

                        //move image
                        movePlayer2();

                        x=terminate();
                        if(x!=-1)
                        {
                            win=1;
                            if(x==1)
                                judge.setText("X wins!!!");
                            else if(x==0)
                                judge.setText("O wins!!!");
                            else
                                judge.setText("Tie :(");
                        }

                        turn=1;
                    }
                }
            }
        }

        if(findViewById(R.id.three_one)==view )
        {
            if(board[2][0]==-1 & win==-1)
            {
                int x;
                if(turn%2==1)
                {
                    turn=2;
                    board[2][0]=p1;

                    button= (Button) findViewById(R.id.three_one);
                    button.setBackgroundResource(one[6]);

                    x=terminate();
                    if(x!=-1)
                    {
                        win=1;
                        if(x==1)
                            judge.setText("X wins!!!");
                        else if(x==0)
                            judge.setText("O wins!!!");
                        else
                            judge.setText("Tie :(");
                    }

                    if(win==-1)
                    {
                        //get player2's move
                        if(arr.size()>0)
                            arr.clear();

                        arr=AI.bestMove(board,p2);
                        Log.e(arr.get(0).toString(),arr.get(1).toString());

                        //move image
                        movePlayer2();

                        x=terminate();
                        if(x!=-1)
                        {
                            win=1;
                            if(x==1)
                                judge.setText("X wins!!!");
                            else if(x==0)
                                judge.setText("O wins!!!");
                            else
                                judge.setText("Tie :(");
                        }

                        turn=1;
                    }
                }
            }
        }

        if(findViewById(R.id.three_two)==view)
        {
            if(board[2][1]==-1 & win==-1)
            {
                int x;
                if(turn%2==1)
                {
                    turn=2;
                    board[2][1]=p1;

                    button= (Button) findViewById(R.id.three_two);
                    button.setBackgroundResource(one[7]);

                    x=terminate();
                    if(x!=-1)
                    {
                        win=1;
                        if(x==1)
                            judge.setText("X wins!!!");
                        else if(x==0)
                            judge.setText("O wins!!!");
                        else
                            judge.setText("Tie :(");
                    }

                    if(win==-1)
                    {
                        //get player2's move
                        if(arr.size()>0)
                            arr.clear();

                        arr=AI.bestMove(board,p2);
                        Log.e(arr.get(0).toString(),arr.get(1).toString());

                        //move image
                        movePlayer2();

                        x=terminate();
                        if(x!=-1)
                        {
                            win=1;
                            if(x==1)
                                judge.setText("X wins!!!");
                            else if(x==0)
                                judge.setText("O wins!!!");
                            else
                                judge.setText("Tie :(");
                        }

                        turn=1;
                    }
                }
            }
        }

        if(findViewById(R.id.three_three)==view)
        {
            if(board[2][2]==-1 & win==-1)
            {
                int x;
                if(turn%2==1)
                {
                    turn=2;
                    board[2][2]=p1;

                    button= (Button) findViewById(R.id.three_three);
                    button.setBackgroundResource(one[8]);
                    x=terminate();
                    if(x!=-1)
                    {
                        win=1;
                        if(x==1)
                            judge.setText("X wins!!!");
                        else if(x==0)
                            judge.setText("O wins!!!");
                        else
                            judge.setText("Tie :(");
                    }

                    if(win==-1)
                    {
                        //get player2's move
                        if(arr.size()>0)
                            arr.clear();

                        arr=AI.bestMove(board,p1);
                        Log.e(arr.get(0).toString(),arr.get(1).toString());

                        //move image
                        movePlayer2();

                        x=terminate();
                        if(x!=-1)
                        {
                            win=1;
                            if(x==1)
                                judge.setText("X wins!!!");
                            else if(x==0)
                                judge.setText("O wins!!!");
                            else
                                judge.setText("Tie :(");
                        }

                        turn=1;
                    }
                }
            }
        }


    }
    //-------------------------------------------change image



    //--------------------------------------------------------------------determines if anyone has won
    public int terminate()
    {
        int[][] a=board;
        //---------------------------------------checking the two diagonals
        if(a[0][0]!=-1 && a[0][0]== a[1][1] && a[1][1]==a[2][2])
        {
            if(a[0][0]==0)
                return  0;
            else
                return  1;
        }

        if(a[0][2]!=-1 && a[0][2]==a[1][1] && a[1][1]==a[2][0])
        {
            if(a[0][0]==0)
                return  0;
            else
                return  1;
        }
        //---------------------------------------checking the two diagonals



        //---------------------------------------checking the rows
        for(int i=0;i<3;i++)
        {
            if(a[i][0]!=-1 && a[i][0]==a[i][1] && a[i][1]==a[i][2])
            {
                if(a[i][0]==0)
                    return  0;
                else
                    return  1;
            }
        }
        //---------------------------------------checking the rows



        //---------------------------------------checking the columns
        for(int i=0;i<3;i++)
        {
            if(a[0][i]!=-1 && a[0][i]==a[1][i] && a[1][i]==a[2][i])
            {
                if(a[0][i]==0)
                    return  0;
                else
                    return  1;
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
            return 7;

        //---------------------------------------checking for a tie

        return -1;

    }
    //--------------------------------------------------------------------determines if anyone has won




    //--------------------------------------------------------------------Move player2
    public void movePlayer2()
    {
        if((int)arr.get(0)==0 && (int)arr.get(1)==0)
        {
            board[0][0]=p2;

            button= (Button) findViewById(R.id.one_one);
            button.setBackgroundResource(two[0]);
        }

        if((int)arr.get(0)==0 && (int)arr.get(1)==1)
        {
            board[0][1]=p2;

            button= (Button) findViewById(R.id.one_two);
            button.setBackgroundResource(two[1]);
        }

        if((int)arr.get(0)==0 && (int)arr.get(1)==2)
        {
            board[0][2]=p2;

            button= (Button) findViewById(R.id.one_three);
            button.setBackgroundResource(two[2]);
        }

        if((int)arr.get(0)==1 && (int)arr.get(1)==0)
        {
            board[1][0]=p2;

            button= (Button) findViewById(R.id.two_one);
            button.setBackgroundResource(two[3]);
        }

        if((int)arr.get(0)==1 && (int)arr.get(1)==1)
        {
            board[1][1]=p2;

            button= (Button) findViewById(R.id.two_two);
            button.setBackgroundResource(two[4]);
        }

        if((int)arr.get(0)==1 && (int)arr.get(1)==2)
        {
            board[1][2]=p2;

            button= (Button) findViewById(R.id.two_three);
            button.setBackgroundResource(two[5]);
        }

        if((int)arr.get(0)==2 && (int)arr.get(1)==0)
        {
            board[2][0]=p2;

            button= (Button) findViewById(R.id.three_one);
            button.setBackgroundResource(two[6]);
        }

        if((int)arr.get(0)==2 && (int)arr.get(1)==1)
        {
            board[2][1]=p2;

            button= (Button) findViewById(R.id.three_two);
            button.setBackgroundResource(two[7]);
        }

        if((int)arr.get(0)==2 && (int)arr.get(1)==2)
        {
            board[2][2]=p2;

            button= (Button) findViewById(R.id.three_three);
            button.setBackgroundResource(two[8]);
        }
    }
    //--------------------------------------------------------------------Move player2


    //--------------------------------------------------------------------New Game
    public void newGame(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setClassName(this,"com.example.lenovo.tic_tac_toe.Home");
        startActivity(intent);
    }
    //--------------------------------------------------------------------New Game

}
