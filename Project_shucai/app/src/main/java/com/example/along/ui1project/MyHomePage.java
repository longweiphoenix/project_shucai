package com.example.along.ui1project;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Long on 2016/10/25.
 */
public class MyHomePage extends Activity {
    ListView myList;
    List<HashMap<String, Object>> list;
    LayoutInflater layoutInflater;
    TextView homePage,
            shop,
            me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_home_page);
        myList = (ListView) findViewById(R.id.home_list_view);
        layoutInflater = LayoutInflater.from(this);
        setListView();
    }

    public void getData() {
        String[] myText = getResources().getStringArray(R.array.myListText);
        Integer[] img = new Integer[]{R.mipmap.my_order, R.mipmap.food_stamps, R.mipmap.my_collections,
                R.mipmap.my_collections, R.mipmap.address_manager, R.mipmap.customer_service
        };
        for (int i = 0; i < myText.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("list_text", myText[i]);
            map.put("list_img", img[i]);
            list.add(map);
        }
    }

    public void setListView() {
        list = new ArrayList<>();
        getData();
        myList.setAdapter(new MyHomeAdapter(this, list));
        /*View view = layoutInflater.inflate(R.layout.home_list_view_footer, null);
        view.setLayoutParams(new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        homePage= (TextView) view.findViewById(R.id.home);
        shop= (TextView) view.findViewById(R.id.shop);
        me= (TextView) findViewById(R.id.user);
        myList.addFooterView(view);*/
    }
}
