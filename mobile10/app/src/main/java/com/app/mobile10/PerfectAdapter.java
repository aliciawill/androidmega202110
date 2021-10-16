package com.app.mobile10;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PerfectAdapter extends BaseAdapter {
    Context context; //GridActivity2
    PerfectAdapter(Context c){ //GridActivity2
        context = c;
    }

    int[] posterID = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
            R.drawable.pic8,
            R.drawable.pic9
    };

    String[] title = {
            "그림1",
            "그림2",
            "그림3",
            "그림4",
            "그림5",
            "그림6",
            "그림7",
            "그림8",
            "그림9"
    };

    @Override
    public int getCount() {
        return posterID.length;
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
    public View getView(int index, View view, ViewGroup viewGroup) {
        //반복되는 하나의 View객체를 만들어주어 함.
//        Button button = new Button(context);
//        button.setText("버튼글자야...");
//        return button;
        View one = View.inflate(context, R.layout.one, null);
        TextView top = one.findViewById(R.id.topText);
        ImageView iv = one.findViewById(R.id.imageView4);
        iv.setImageResource(posterID[index]);
        top.setText(title[index]);
        one.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
        one.setPadding(5,5,5,10);
        return one;
    }
}
