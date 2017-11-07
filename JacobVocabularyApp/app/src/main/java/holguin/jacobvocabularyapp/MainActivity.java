package holguin.jacobvocabularyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button activtyBtn;
    private Button xmlBtn;
    private Button initalizeBtn;
    private Button findViewBtn;
    private Button methodBtn;
    private Button onCreate;
    private Button contentViewBtn;
    private Button onClickListenerBtn;
    private Button onClick;
    private Button intentBtn;
    private Button startActvityBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activtyBtn = (Button)findViewById(R.id.activityBtn);
        xmlBtn = (Button)findViewById(R.id.xmlBtn);
        initalizeBtn = (Button)findViewById(R.id.intializeBtn);
        findViewBtn  = (Button)findViewById(R.id.findViewBtn);
        methodBtn = (Button)findViewById(R.id.methodBtn);
        onCreate = (Button)findViewById(R.id.onCreateBtn);
        contentViewBtn = (Button)findViewById(R.id.setContentBtn);
        onClickListenerBtn = (Button)findViewById(R.id.clickListenerBtn);
        onClick = (Button)findViewById(R.id.onClickBtn);
        intentBtn = (Button)findViewById(R.id.intentBtn);
        startActvityBtn = (Button)findViewById(R.id.startActivityBtn);
    }
}
