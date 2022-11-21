package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {
    String[] learning = new String[]{"Hi!", "My Name is Clicky", "Want to play a game?", "See? Thats the Goal!", "See This number?", " Its all your moves", "Press Button  ", "Take goal and win!", "Got It?"};
    String[] learning_user = new String[]{"Hi!", "Hi Clicky", "Sure", "Yup", "Ok!", "Yeah", "I see", "Ok"};
    Button btn1, btn2, delete, btn4, button6, btn7, btn8, btn9, button5;
    TextView moves, goal, levele;
    TextView Clicky;
ImageView movesviz;
    ImageView goalviz;

    int check = 0;
    int lvl=0;
    int result=-0;
    int turn=-1;
    int[] gint=new int[]{3,4,12};
    int[] mint=new int[]{2,3,3};
    String[] multi_btn5=new String[]{"+1","+8","*4"};
    String[] multi_btn2=new String[]{"+1","*5","+5"};
    String[] multi_btn8=new String[]{"+1","+3","+1"};
            boolean kno =false;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Clicky = (TextView) findViewById(R.id.Clicky);
        movesviz = (ImageView) findViewById(R.id.movesviz);
        goalviz = (ImageView) findViewById(R.id.goalviz);
        moves = (TextView) findViewById(R.id.moves);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn4 = (Button) findViewById(R.id.btn4);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        goal = (TextView) findViewById(R.id.goal);
        btn2 = (Button) findViewById(R.id.btn2);
        delete=(Button)findViewById(R.id.delete) ;
        button5.setText(learning_user[0]);
        Clicky.setText(learning[0]);
        btn2.setEnabled(false);
        delete.setEnabled(false);
        btn1.setEnabled(false);
        btn4.setEnabled(false);
        button6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
levele=(TextView) findViewById(R.id.levele);

//if(lvl>0){
//button6.setText("<<");}
}




    public void Start(View view) {
if (kno==false){
            Learning();
         //   kno=false;
         //  btn2.setEnabled(false);

        }
        else {


    if (check == learning_user.length) {
//kno=true;
        //    btn2.setEnabled(false);
        EndLearning();
     //   result=result+-1;
        btn2.setEnabled(false);
        btn2.setText("");
    }
    Level(lvl);
   /// if (button5.getText() =="win") {

       //btn2.setEnabled(false);
    //    button6.setEnabled(false);
  // }


 //   GameS((String) button5.getText(), lvl);
  //  Turn(lvl);


    if(lvl>0) {

        btn2.setEnabled(true);
        btn2.setText(multi_btn2[lvl]);
        button6.setEnabled(true);
        button6.setText("<<");}
    GameS((String) button5.getText(), lvl);
    Turn(lvl);


}



}
public void GameS(String action,int i) {
    switch (action) {

        case ("+1"):
            result+=1;
            turn++;
            moves.setText("moves: "+(mint[i]-turn));

            break;
        case ("+10"):
            result+=10;
            turn++;
            moves.setText("moves: "+(mint[i]-turn));
            break;
        case ("Win"):
            result=0;

            moves.setText("moves: "+(mint[i]-turn));
Clicky.setText(""+result);

            break;
        case ("clr"):


            moves.setText("moves: "+(mint[i]-turn));
            Clicky.setText(""+result);
            break;

        case ("<<"):
         //   int k=Math.round(result/10);
            result=Math.round(result/10);
            btn8.setEnabled(false);
            turn++;

            moves.setText("moves: "+(mint[i]-turn));
            Clicky.setText(""+result);
            break;
        case ("+2"):
            result=result+2;
            turn++;
            moves.setText("moves: "+(mint[i]-turn));
            Clicky.setText("");
            break;
        case ("*5"):
            result=result*5;

            moves.setText("moves: "+(mint[i]-turn));
            Clicky.setText("");
            break;
        case ("*4"):
            result=result*4;

            moves.setText("moves: "+(mint[i]-turn));
            Clicky.setText("");
            break;
        case ("+5"):
            result=result+5;
            turn++;
            moves.setText("moves: "+(mint[i]-turn));
            Clicky.setText("");
            break;
        case ("+8"):
            result=result+8;
            turn++;
            moves.setText("moves: "+(mint[i]-turn));

            Clicky.setText("");
            break;

    }

}
public void Turn(int i){


    levele.setText("Level: "+(lvl+1));

    Clicky.setText(""+result);

        if (gint[i]==result){
            button5.setText("Win");
            lvl++;

            turn=0;
            result=0;
            btn2.setEnabled(false);
            button6.setEnabled(false);
        }
        if(turn==mint[i]&&gint[i]!=result||turn>mint[i]){
            Clicky.setText("noooo");
          delete.setEnabled(true);
            turn=0;
            result=0;
          btn2.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            btn8.setEnabled(false);

delete.setText("clr");

    }


}

    public void Victory(int i){

    }

    public void Learning() {
        check++;
        if (check<learning_user.length){

        button5.setText(learning_user[check]);
        Clicky.setText(learning[check]);}
        movesviz.setVisibility(View.INVISIBLE);
        if (check==3){
           goalviz .setVisibility(View.VISIBLE);
        }
        if (check==4){
            goalviz.setVisibility(View.INVISIBLE);
            movesviz.setVisibility(View.VISIBLE);
        }
        if (check>learning_user.length-1){

Clicky.setText(learning[check]);
            EndLearning();}

   // }
  //  public void R(View view) {
  //      Learning();
    }

    public void EndLearning() {
        btn2.setEnabled(true);
        button5.setText("Ок");

        btn2.setText("No");
kno=true;

    }
public void Level(int i){
        goal.setText("goal"+gint[i]);
        moves.setText("moves"+mint[i]);

//Clicky.setText(h);
 if (lvl>1) {
     btn2.setEnabled(true);
   btn2.setText(multi_btn2[i]);
   btn8.setEnabled(true);
     btn8.setText(multi_btn8[lvl]);

 }
   button5.setText(multi_btn5[i]);
//

}

    public void Repeat(View view) {
        if (btn2.getText()=="No") {
            btn2.setEnabled(false);
            check = 1;
            btn2.setText("");

            button5.setText(learning_user[0]);
            Clicky.setText(learning[0]);
           kno=false;
        }
        else{
            if (check==learning_user.length) {
                Level(lvl);

                GameS((String) btn2.getText(), lvl);
                Turn(lvl);
            }
        }
    }


    public void CLR(View view) {
        Level(lvl);
        GameS((String) delete.getText(), lvl);
        Turn(lvl);
btn2.setEnabled(true);
button5.setEnabled(true);
button6.setEnabled(true);
delete.setEnabled(false);

    }

    public void LastNum(View view ) {
        Level(lvl);

        GameS((String) button6.getText(), lvl);
        Turn(lvl);
 //    result=   Math.round(result/10);
//     Clicky.setText(""+result);


    }

    public void finish(View view) {
        Level(lvl);

        GameS((String) btn8.getText(), lvl);
        Turn(lvl);
    }
}
