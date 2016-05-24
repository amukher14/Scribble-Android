package edu.pitt.cs.cs1635.arm136.sribble;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private ScribbleView v;//create a instance variable of the class
    private Button currPaint;
    private Button EraseScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = (ScribbleView)findViewById(R.id.makeScribble);
        LinearLayout MyLayout = (LinearLayout)findViewById(R.id.paint_colors);
    }

    public void paintClicked(View view){
        if(view!=currPaint){
            Button imgView = (Button)view;
            String color = view.getTag().toString();
            v.setColor(color);
        }
    }
    public void EraseScreen(View view) {
        v.EraseScreen();
    }
}


