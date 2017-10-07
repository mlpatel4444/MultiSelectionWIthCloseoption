package mansi.com.multipleselectionwithcloseoption;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sphere70 on 14/9/17.
 */
public class TextViewMultiSelectionActivity extends AppCompatActivity
{
    RelativeLayout mRel;
    Button mbtn;
    TextView mtv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multis_using_textview);

        mRel = (RelativeLayout) findViewById(R.id.msut);
        mbtn = (Button) findViewById(R.id.btn);
        mtv = (TextView) findViewById(R.id.textView);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(TextViewMultiSelectionActivity.this);
                String[] choices = new String[]{"Donut","Eclair","Froyo","GingerBread","HoneyComb","Ice-creame Sandwich","Jellybean","Kitkat","Lolipop","Marshmallow","Nought","Oreo"};
                final boolean[] checkeditems = new boolean[]{false,false,false,false,false,false,false,false,false,true,false,false};
                final List<String> selectedlist = Arrays.asList(choices);

                builder.setMultiChoiceItems(choices, checkeditems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkeditems[which] = isChecked;
                        String curitem = selectedlist.get(which);

                    }
                });
                builder.setCancelable(false);
                builder.setTitle(R.string.put_selection);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(int i = 0;i < checkeditems.length;i++)
                        {
                            boolean checked = checkeditems[i];
                            if(checked)
                            {
                                mtv.setText(mtv.getText() + selectedlist.get(i) + "\n");
                            }
                        }
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //dialog.cancel();
                    }
                });

                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // dialog.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
