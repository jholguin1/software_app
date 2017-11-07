package holguin.jacobvocabularyapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private Button activtyBtn;
    private Button xmlBtn;
    private Button initalizeBtn;
    private Button findViewBtn;
    private Button methodBtn;
    private RadioButton onCreate;
    private RadioButton contentViewBtn;
    private RadioGroup rG;
//    private Button onClickListenerBtn;
//    private Button onClick;
//    private Button intentBtn;
//    private Button startActvityBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activtyBtn = (Button)findViewById(R.id.activityBtn);
        xmlBtn = (Button)findViewById(R.id.xmlBtn);
        initalizeBtn = (Button)findViewById(R.id.intializeBtn);
        findViewBtn  = (Button)findViewById(R.id.findViewBtn);
        methodBtn = (Button)findViewById(R.id.methodBtn);
        onCreate = (RadioButton)findViewById(R.id.onCreateRBtn);
        contentViewBtn = (RadioButton)findViewById(R.id.contentViewRBtn);
        rG = (RadioGroup)findViewById(R.id.radioGroup);
//        onClickListenerBtn = (Button)findViewById(R.id.clickListenerBtn);
//        onClick = (Button)findViewById(R.id.onClickBtn);
//        intentBtn = (Button)findViewById(R.id.intentBtn);
//        startActvityBtn = (Button)findViewById(R.id.startActivityBtn);

        activtyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        rG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(onCreate.isChecked()){

                }
                if(contentViewBtn.isChecked()){

                }
            }
        });


    }
}
