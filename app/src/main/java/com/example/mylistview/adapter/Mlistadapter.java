package com.example.mylistview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.mylistview.Bean.Mdata;
import com.example.mylistview.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by 李韦 on 2016/11/2 08:14
 */

public class Mlistadapter extends BaseAdapter {

    private ArrayList<Mdata> list = new ArrayList<>();
    private Context context;
    private boolean fl;
    private ArrayList<Mdata> listall;

   public Mlistadapter(ArrayList<Mdata> listmain,Context context){
//      listall = listmain 和list.addAll(listall) 两种方法的区别
//    listall持有了主mainactivity中的集合引用,两个集合是同步的，"一荣俱荣，一损俱损"
//    而addAll方法是将listall集合中的元素拷贝了一份给list不存在引用，所以可以自由对list
//   集合进行增删改查不影响mainactivity中的集合
        listall = listmain;
       list.addAll(listall);
       this.context = context;



   }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void setHide(boolean fl){
        this.fl = fl;

    }


    @Override
    public void notifyDataSetChanged() {
        list.clear();
        list.addAll(listall);
        ArrayList<Mdata> list_del = new ArrayList<>();
        if(fl){
            for(Mdata data:listall){
                if(data.flag==true){
                    list_del.add(data);
                }


            }
            for(Mdata data : list_del){
                list.remove(data);

            }


        }


        super.notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.lvitem,null);
            holder = new ViewHolder();
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.cb = (CheckBox) convertView.findViewById(R.id.cb);
            holder.indexall = (TextView) convertView.findViewById(R.id.index);
            holder.curr_pos = (TextView) convertView.findViewById(R.id.create);
            holder.curr_pos.setText(position+"");
            convertView.setTag(holder);
        }else{
           holder = (ViewHolder) convertView.getTag();
        }
        Log.e(TAG, "getView: "+convertView.toString() );
//        holder.cb.setOnCheckedChangeListener(null);
           holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   list.get(position).flag = isChecked;
               }
           });
//可以将此监听事件放在设置cb的上面这样索引就会读到上面的索引值方法一
             holder.cb.setChecked(list.get(position).flag);
            holder.indexall.setText(list.get(position).index);
            holder.content.setText(list.get(position).pos);
//            holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    list.get(position).flag = isChecked;
//                }
//            });


        return convertView;
    }
    class ViewHolder{
        TextView content;
        TextView indexall;
        TextView curr_pos;
        CheckBox cb;




    }





}
