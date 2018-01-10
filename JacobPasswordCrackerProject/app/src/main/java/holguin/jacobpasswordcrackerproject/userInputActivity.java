package holguin.jacobpasswordcrackerproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class userInputActivity extends AppCompatActivity {

    TextView titleText;
    TextView pWStrength;
    TextView pWUsage;
    ProgressBar progressBar;
    Button backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
        //Probably need to come afterschool to get help, specifically about the comparing passwords to some database and/or the machine learning to create a password cracking algorithm

        titleText = (TextView)findViewById(R.id.titleText);
        pWStrength = (TextView)findViewById(R.id.pWStrength);
        pWUsage = (TextView)findViewById(R.id.pWUsageText);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        backBtn = (Button)findViewById(R.id.backBtn);


        progressBar.setProgress((int) (Math.random() * 100) );

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userInputActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
