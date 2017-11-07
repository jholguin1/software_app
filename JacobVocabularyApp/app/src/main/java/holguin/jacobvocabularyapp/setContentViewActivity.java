package holguin.jacobvocabularyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class setContentViewActivity extends AppCompatActivity {

    private RadioButton setContentViewBtn;
    private RadioButton onCreateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_content_view);

        setContentViewBtn = (RadioButton) findViewById(R.id.setContentViewRadioBtn);
        onCreateBtn = (RadioButton) findViewById(R.id.onCreateRadioBtn);

        public void onRadioButtonClicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch (view.getId()) {
                case R.id.setContentViewRadioBtn:
                    if (checked)

                        break;
                case R.id.onCreateRadioBtn:
                    if (checked)

                        break;
            }
        }
    }

}

