package org.uitestingespresso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    TextView tvResult;

    private String currentString = "fqicabcdefg";
    private ArrayList<String> allSubWDup = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvResult = (TextView) findViewById(R.id.tv_result);
        // Bundle bundle = getIntent().getExtras();
        //tvResult.setText(bundle.getString("input"));
        getNewStartPosition(0);
        for (int i = 0; i < allSubWDup.size(); i++) {
            System.out.println(allSubWDup.get(i));
        }
    }

    public void getNewStartPosition(int previousPosition) {
        String newSubString = String.valueOf(currentString.charAt(previousPosition));
        for (int i = previousPosition + 1; i < currentString.length(); i++) {
            if (newSubString.contains(String.valueOf(currentString.charAt(i)))) {
                allSubWDup.add(newSubString);
                //return currentString.indexOf(currentString.charAt(i), previousPosition);
                getNewStartPosition(currentString.indexOf(currentString.charAt(i),previousPosition)+1);
                break;
            } else {
                newSubString = newSubString + String.valueOf(currentString.charAt(i));
                if(i+1==currentString.length()){
                    allSubWDup.add(newSubString);
                }
            }

        }

    }
}
