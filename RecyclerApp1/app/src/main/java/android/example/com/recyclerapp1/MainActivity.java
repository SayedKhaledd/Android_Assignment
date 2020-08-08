package android.example.com.recyclerapp1;

import android.example.com.recyclerapp1.RecyclerItemClickListener.OnItemClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewEvent {
    EditText editText;
    private List<RecycleViewItem> list;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add(new RecycleViewItem("Mohamed"));
//        list = getRecyclerViewItems();
         recycleView =(RecyclerView)findViewById(R.id.recycler_view);
        recyclerViewAdapter= new RecyclerViewAdapter(this, list,  this
//          {  @Override
//            public void onRecyclerViewClick(int position) {
//                RecycleViewItem recycleViewItem = list.get(position);
//                Toast.makeText(getApplicationContext(),recycleViewItem.getTitle(),Toast.LENGTH_LONG).show();
//
//
//            }
//
//            @Override
//            public void update(int position) {
//                RecycleViewItem recycleViewItem = list.get(position);
//                Toast.makeText(getApplicationContext(),"updated :"+recycleViewItem.getTitle(),Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void delete(int position) {
//                RecycleViewItem recycleViewItem = list.get(position);
//                Toast.makeText(getApplicationContext(),"deleted :"+recycleViewItem.getTitle(),Toast.LENGTH_LONG).show();
//                list.remove(position);
//                recyclerViewAdapter.notifyDataSetChanged();
//
//
//            }
//        }
        );

        recycleView.setAdapter(recyclerViewAdapter);

        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

//        recycleView.addOnItemTouchListener(new RecyclerItemClickListener(this,recycleView, new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                RecycleViewItem recycleViewItem = list.get(position);
//                Toast.makeText(MainActivity.this,recycleViewItem.getTitle(),Toast.LENGTH_LONG).show();
//
//
//            }
//
//            @Override
//            public void onLongItemClick(View view, int position) {
//                list.remove(position);
//                recyclerViewAdapter.notifyDataSetChanged();
//
//
//
//            }
//        }));


    }


//    private List<RecycleViewItem> getRecyclerViewItems(){
//         list=new ArrayList<>();
//
//        for (int i =1;i<=12;i++)
//            list.add(new RecycleViewItem("Item"+i));
//        return list;
//    }

    public void addItem(View view) {
        editText=(EditText)findViewById(R.id.editText);
        String addstr = editText.getText().toString();
        if(!addstr.isEmpty()){
            list.add(new  RecycleViewItem(addstr));
            recyclerViewAdapter.notifyDataSetChanged();
            editText.setText("");


        }
    }

    @Override
    public void onRecyclerViewClick(int position) {
                        RecycleViewItem recycleViewItem = list.get(position);
                Toast.makeText(getApplicationContext(),recycleViewItem.getTitle(),Toast.LENGTH_LONG).show();


    }

    @Override
    public void update(int position) {
                        RecycleViewItem recycleViewItem = list.get(position);
                Toast.makeText(getApplicationContext(),"updated : "+recycleViewItem.getTitle(),Toast.LENGTH_LONG).show();


    }

    @Override
    public void delete(int position) {
        RecycleViewItem recycleViewItem = list.get(position);
                Toast.makeText(getApplicationContext(),"deleted : "+recycleViewItem.getTitle(),Toast.LENGTH_LONG).show();
                list.remove(position);
                recyclerViewAdapter.notifyDataSetChanged();

    }
}
