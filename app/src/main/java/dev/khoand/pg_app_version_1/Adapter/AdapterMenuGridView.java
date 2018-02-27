package dev.khoand.pg_app_version_1.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import dev.khoand.pg_app_version_1.R;

/**
 * Created by khoam on 2/27/2018.
 */

public class AdapterMenuGridView extends BaseAdapter {

    private Context context;
    private String[] text_buttons;
    private int[] imgs;

    public AdapterMenuGridView(Context context, String[] text_buttons, int[] imgs) {
        this.context = context;
        this.text_buttons = text_buttons;
        this.imgs = imgs;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view_item;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view_item = inflater.inflate(R.layout.grid_item, null);
            TextView text_view = view_item.findViewById(R.id.grid_item_txt);
            ImageView img_view = view_item.findViewById(R.id.grid_item_img);
            text_view.setText(text_buttons[i]);
            img_view.setImageResource(imgs[i]);
        } else {
            view_item = view;
        }

        return view_item;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
