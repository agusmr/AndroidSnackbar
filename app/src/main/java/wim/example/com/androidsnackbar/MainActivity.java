package wim.example.com.androidsnackbar;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn1) {
            Snackbar.make(findViewById(android.R.id.content), "Hai semuanya !", Snackbar.LENGTH_LONG).show();
        }else if(v == btn2) {
            Snackbar.make(findViewById(android.R.id.content), "Kenangan (mantan) telah terhapus !", Snackbar.LENGTH_LONG)
            .setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(findViewById(android.R.id.content), "Anda gagal move on!", Snackbar.LENGTH_SHORT).show();
                }
            }).show();
        }else if(v == btn3) {
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Anda belum beruntung!", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    });

            // action text color
            snackbar.setActionTextColor(Color.BLUE);

            // text color
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
            snackbar.show();
        }
    }
}
