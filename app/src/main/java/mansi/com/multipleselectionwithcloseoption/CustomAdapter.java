package mansi.com.multipleselectionwithcloseoption;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sphere70 on 15/9/17.
 */

public class CustomAdapter extends ArrayAdapter<Model>
{
    Context context;
    List<Model> _model;
    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Model> objects) {
        super(context, resource, objects);
        this.context = context;
        this._model = objects;
    }

    private class ViewHolder
    {
        ImageView imageView;
        TextView textView;
    }

    public View getView(final int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder = null;
        final Model model = getItem(position);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.custom_option_view,null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.row_text);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.row_image);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(model.getName());
        viewHolder.imageView.setImageResource(model.getImg_id());

        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // int index = (int) v.getTag();
                _model.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

}
