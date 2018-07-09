package toong.com.androidchipview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ChipView) findViewById(R.id.chipview)).addItem(new String[]{"A", "B", "SDASD", "DSDASD"});
    }
}
