package mansi.com.multipleselectionwithcloseoption;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sphere70 on 15/9/17.
 */

public class SimpleViewStubActivity extends AppCompatActivity
{
    ViewStub viewStub;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_stubview);

        viewStub = (ViewStub) findViewById(R.id.viewStub1);
        View inflated = viewStub.inflate();
        btn = (Button) findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"View Stab Content Created",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
