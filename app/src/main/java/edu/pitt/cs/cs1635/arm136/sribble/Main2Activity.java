package edu.pitt.cs.cs1635.arm136.sribble;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private static Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        OnClickButtonListener();
    }
    public void OnClickButtonListener(){
        start = (Button)findViewById(R.id.button);
        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClassName("edu.pitt.cs.cs1635.arm136.sribble","edu.pitt.cs.cs1635.arm136.sribble.MainActivity");
                        startActivity(intent);
                    }
                }
        );
    }
}
