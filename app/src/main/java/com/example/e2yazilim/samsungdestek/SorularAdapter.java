package com.example.e2yazilim.samsungdestek;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SorularAdapter extends BaseAdapter {
    ArrayList<Soru> sorular;
    Context context;

    public SorularAdapter(Context context, ArrayList<Soru> sorular) {
        this.context = context;
        this.sorular = sorular;
    }

    @Override
    public int getCount() {
        return sorular.size();
    }

    @Override
    public Soru getItem(int position) {
        return sorular.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.soru_list_view_item, null, false);

        TextView tvPuan = (TextView) view.findViewById(R.id.txtPuan);
        TextView tvCevapSayi = (TextView) view.findViewById(R.id.txtCevapSayisi);
        TextView tvSoru = (TextView) view.findViewById(R.id.txtSoru);
        TextView tvIsim = (TextView) view.findViewById(R.id.txtKisi);

        tvPuan.setText(Integer.toString(getItem(position).getPuan()));
        tvCevapSayi.setText(Integer.toString(getItem(position).getCevapSayi()));
        tvSoru.setText(getItem(position).getBaslik());
        tvIsim.setText(getItem(position).getUyeAd());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Soru soru = getItem(position);
                Bundle bundle=new Bundle();
                bundle.putSerializable("soru",soru);
                Intent intent = new Intent(context, QuestionActivity.class);
                intent.putExtra("bundle", bundle);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
