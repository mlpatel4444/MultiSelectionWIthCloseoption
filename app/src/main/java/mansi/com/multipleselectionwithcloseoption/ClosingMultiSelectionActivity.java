package mansi.com.multipleselectionwithcloseoption;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sphere70 on 15/9/17.
 */

public class ClosingMultiSelectionActivity extends AppCompatActivity
{
    Button mbtn;
    ListView mList;
    ArrayAdapter<String> mAdapter;
    List<Model> items;
    List<Model> modellist;
    String[] choices;
    Integer[] images;
    boolean[] checkeditems;
    CustomAdapter customAdapter;
    GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.closing_multis);


         choices= new String[]{"Donut","Eclair","Froyo","GingerBread","HoneyComb","Ice-creame Sandwich","Jellybean","Kitkat","Lolipop","Marshmallow","Nought","Oreo"};
         images = new Integer[]{android.R.drawable.ic_menu_close_clear_cancel,android.R.drawable.ic_menu_close_clear_cancel,android.R.drawable.ic_menu_close_clear_cancel,
                 android.R.drawable.ic_menu_close_clear_cancel,android.R.drawable.ic_menu_close_clear_cancel,android.R.drawable.ic_menu_close_clear_cancel,android.R.drawable.ic_menu_close_clear_cancel,
                 android.R.drawable.ic_menu_close_clear_cancel,android.R.drawable.ic_menu_close_clear_cancel,android.R.drawable.ic_menu_close_clear_cancel,android.R.drawable.ic_menu_close_clear_cancel,android.R.drawable.ic_menu_close_clear_cancel};
        checkeditems = new boolean[]{false,false,false,false,false,false,false,false,false,true,false,false};
        mbtn = (Button) findViewById(R.id.btn);
        mList = (ListView) findViewById(R.id.list_view);
        gridView = (GridView) findViewById(R.id.grid_view);
        items = new ArrayList<Model>();
        modellist = new ArrayList<Model>();


        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ClosingMultiSelectionActivity.this);

                final List<String> selectedlist = Arrays.asList(choices);

                for(int i = 0;i < choices.length;i++)
                {
                    Model _model = new Model(choices[i],images[i]);
                    modellist.add(_model);
                }

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
//                               mAdapter.add(selectedlist.get(i));
                                items.add(modellist.get(i));
                                customAdapter = new CustomAdapter(ClosingMultiSelectionActivity.this,R.layout.custom_option_view,items);
                                //mAdapter = new ArrayAdapter<String>(ClosingMultiSelectionActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, items);
                                mList.setAdapter(customAdapter);
                                gridView.setAdapter(customAdapter);
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

    @Override
    protected void onResume() {
        super.onResume();
        items.clear();
    }
}
