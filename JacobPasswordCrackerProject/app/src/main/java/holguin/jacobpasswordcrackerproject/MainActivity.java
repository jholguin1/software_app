package holguin.jacobpasswordcrackerproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView titleText;
    TextView infoText;
    EditText userInput;
    CheckBox showPassword;
    Button checkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText = (TextView)findViewById(R.id.titleText);
        infoText = (TextView)findViewById(R.id.infoTextView);
        userInput = (EditText)findViewById(R.id.userInputText);
        showPassword = (CheckBox)findViewById(R.id.checkBox);
        checkBtn = (Button)findViewById(R.id.checkBtn);


        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                int start, end;

                if (!isChecked) {
                    start = userInput.getSelectionStart();
                    end = userInput.getSelectionEnd();
                    userInput.setTransformationMethod(new PasswordTransformationMethod());
                    userInput.setSelection(start, end);
                } else {
                    start = userInput.getSelectionStart();
                    end = userInput.getSelectionEnd();
                    userInput.setTransformationMethod(null);
                    userInput.setSelection(start, end);
                }
            }
        });

        String password = userInput.getText().toString();

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = userInput.getText().toString();
                Intent intent = new Intent(getApplicationContext(), userInputActivity.class);
                intent.putExtra("userPassWord", password);
                startActivity(intent);


            }
        });

    }
}
