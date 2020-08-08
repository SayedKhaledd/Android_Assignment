package android.example.com.recyclerapp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List <RecycleViewItem> list;
    private RecyclerViewEvent recyclerViewEvent;


    public RecyclerViewAdapter(Context context,List <RecycleViewItem> list ,RecyclerViewEvent recyclerViewEvent) {
        this.context=context;
        this.list=list;
        this.recyclerViewEvent=recyclerViewEvent;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        RecycleViewItem recyclerViewItem =list.get(position);
        holder.item.setText(recyclerViewItem.getTitle());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }


    public class  MyViewHolder extends RecyclerView

            .ViewHolder{
        TextView item;
        Button update,delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item=itemView.findViewById(R.id.item);
            update=itemView.findViewById(R.id.update);
            delete=itemView.findViewById(R.id.delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition()!=-1){
                        recyclerViewEvent.onRecyclerViewClick(getAdapterPosition());
                    }
                }
            });
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition()!=-1){
                        recyclerViewEvent.update(getAdapterPosition());
                    }

                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition()!=-1){
                        recyclerViewEvent.delete(getAdapterPosition());
                    }
                }
            });

        }
    }
}
