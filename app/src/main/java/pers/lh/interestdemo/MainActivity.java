package pers.lh.interestdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pers.lh.interestdemo.animationDemo.AnimationJavaActivity;
import pers.lh.interestdemo.animationDemo.AnimationResActivity;
import pers.lh.interestdemo.animationListDemo.AnimationListActivity;
import pers.lh.interestdemo.animatorDemo.AnimatorJavaActivity;
import pers.lh.interestdemo.animatorDemo.AnimatorResActivity;


public class MainActivity extends AppCompatActivity {

    private List<ClassModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lt = findViewById(R.id.lt);
        list.add(new ClassModel("帧动画", AnimationListActivity.class));
        list.add(new ClassModel("补间动画(资源文件引用)", AnimationResActivity.class));
        list.add(new ClassModel("补间动画(Java)", AnimationJavaActivity.class));
        list.add(new ClassModel("属性动画(资源文件引用)", AnimatorResActivity.class));
        list.add(new ClassModel("属性动画(Java)", AnimatorJavaActivity.class));
        lt.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int i) {
                return list.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ViewHolder holder = null;
                if (view == null) {
                    view = LayoutInflater.from(MainActivity.this).inflate(android.R.layout.simple_expandable_list_item_1, viewGroup,false);
                    holder = new ViewHolder();
                    holder.name = view.findViewById(android.R.id.text1);
                    view.setTag(holder);
                } else {
                    holder = (ViewHolder) view.getTag();
                }
                Log.e("========", list.get(i).getName() + "==========");
                holder.name.setText(list.get(i).getName());
                return view;
            }
        });
        lt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this,list.get(i).getCls()));
            }
        });
    }

    static class ViewHolder {
        TextView name;
    }

    class ClassModel {
        public ClassModel(String name, Class cls) {
            this.cls = cls;
            this.name = name;
        }

        private String name;
        private Class cls;

        public String getName() {
            return name;
        }

        public Class getCls() {
            return cls;
        }
    }
}
