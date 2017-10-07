package mansi.com.multipleselectionwithcloseoption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView multi_in_textview,with_closing_option;
   // TextView simple_stub_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multi_in_textview = (TextView) findViewById(R.id.multi_in_textview);
        multi_in_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),TextViewMultiSelectionActivity.class);
                startActivity(i);
            }
        });

        with_closing_option = (TextView) findViewById(R.id.with_close_option);
        with_closing_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ClosingMultiSelectionActivity.class);
                startActivity(i);
            }
        });

//        simple_stub_view = (TextView) findViewById(R.id.simple_stub_view);
//        simple_stub_view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(),SimpleViewStubActivity.class);
//                startActivity(i);
//            }
//        });
    }
}
