package toong.com.androidchipview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import toong.com.androidchipview.chip.ChipView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ChipView) findViewById(R.id.chipview)).addItem(new String[]{"Adsadasd", "dadasdsa", "SDASDdasdasd", "DSDASdasdsadD", "dasdasdsad", "dadasdsad"});
    }
}
