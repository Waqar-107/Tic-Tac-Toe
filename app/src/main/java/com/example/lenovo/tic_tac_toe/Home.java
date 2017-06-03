package com.example.lenovo.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity
{

    public static char player1;
    public static char player2;
    public static int probability;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void selectAvatar(View view)
    {
        if(findViewById(R.id.dotAvatar)==view)
        {
            player1='o';
            player2='x';

            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setClassName(this,"com.example.lenovo.tic_tac_toe.MainActivity");
            startActivity(intent);
        }

        if(findViewById(R.id.crossAvatar)==view)
        {
            player1='x';
            player2='o';

            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setClassName(this,"com.example.lenovo.tic_tac_toe.MainActivity");
            startActivity(intent);
        }
    }
}
