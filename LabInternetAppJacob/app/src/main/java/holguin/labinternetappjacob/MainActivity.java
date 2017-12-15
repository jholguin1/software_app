package holguin.labinternetappjacob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    TextView title;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView)findViewById(R.id.textView);
        webView = (WebView)findViewById(R.id.webView);
        spinner = (Spinner) findViewById(R.id.spinner); // Create an ArrayAdapter using the string array and a default spinner layout

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.com");
        webView.setWebViewClient(new WebViewClient());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.webpages, android.R.layout.simple_spinner_item); // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i == 0){ //identify the current position and compare it to the different positions of the url and then load that url
                    webView.loadUrl("https://www.yahoo.com/");
                    webView.setWebViewClient(new WebViewClient());

                }
                else if( i == 1){
                    webView.loadUrl("https://twitter.com");
                    webView.setWebViewClient(new WebViewClient());

                }
                else {
                    webView.loadUrl("https://portal.id.cps.edu/idp/AuthnEngine#/authn");
                    webView.setWebViewClient(new WebViewClient());
                }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
