package toong.com.androidchipview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ChipView chipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipView = findViewById(R.id.chipview);

        findViewById(R.id.button_get_selected).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "selected item = " + ((ChipView) findViewById(R.id.chipview)).getSelectedItems(), Toast.LENGTH_SHORT).show();
            }
        });
        chipView.addItem(new String[]{"AAAAAAA", "BBBBBB", "SDASD", "DSDASD", "EEEEEEEEE", "EEEEEEE"});
        chipView.setOnItemClickListener(new ChipView.OnItemClickListener() {
            @Override
            public void onItemClicked(String item) {
                Toast.makeText(MainActivity.this, "item clicked = " + item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
