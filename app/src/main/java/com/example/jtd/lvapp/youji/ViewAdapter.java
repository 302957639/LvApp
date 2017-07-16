package com.example.jtd.lvapp.youji;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.youji.entity.Views;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Marco on 2017/7/14.
 */

public class ViewAdapter extends BaseAdapter {

    private Context context;

    private List<Views> viewsList;

    public ViewAdapter(Context context, List<Views> viewsList) {
        this.context = context;
        this.viewsList = viewsList;
    }

    @Override
    public int getCount() {
        return viewsList.size();
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
        if (view == null) {
            view = View.inflate(context, R.layout.youji_view_item, null);
        }
        TextView textshow = view.findViewById(R.id.textshow);
        ImageView background = view.findViewById(R.id.background);

        textshow.setText(viewsList.get(i).getSummary());

        if (viewsList.get(i).getPicList().size() > 0) {
            String picURL = viewsList.get(i).getPicList().get(0).getPicUrl();
            Picasso.with(context).load(picURL).into(background);


        }

        return view;
    }
}
