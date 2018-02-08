package holguin.savingdatajacob;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        int newHighScore = 56;

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putInt(getString(R.string.saved_high_score), newHighScore);

        editor.commit();

        int defaultValue = getResources().getInteger(R.integer.saved_high_score_default);

        long highScore = sharedPref.getInt(getString(R.string.saved_high_score), defaultValue);

        String result = String.valueOf(highScore);

        textView.setText(result);

    }
}
