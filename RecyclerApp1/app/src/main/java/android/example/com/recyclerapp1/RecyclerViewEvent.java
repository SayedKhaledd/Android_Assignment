package android.example.com.recyclerapp1;

public interface RecyclerViewEvent {
    void onRecyclerViewClick(int position);
    void update(int position);
    void delete(int position);

}
