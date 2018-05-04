package game.memory.com.memory_game.recycler;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import game.memory.com.memory_game.R;
import game.memory.com.memory_game.models.Cell;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Cell> cellList;
    private View.OnClickListener onClickListener;
    private LayoutInflater layoutInflater;


    public RecyclerViewAdapter(Context context, List<Cell> bookList) {
        this.onClickListener = ((View.OnClickListener) context);
        this.cellList = bookList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cardView = layoutInflater.inflate(R.layout.item_card, parent, false);
        cardView.setOnClickListener(onClickListener);
        return new RecyclerViewHolder(cardView);
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.itemView.setTag(position);
        Cell bookAtPosition = cellList.get(position);
        switch (bookAtPosition.getModeCell()) {
            case IsImage:
                Picasso.get().load(bookAtPosition.getImageRes()).into(holder.image);
                break;
            case IsText:
                holder.tvText.setText(bookAtPosition.getAnimal());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return cellList.size();
    }


     class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView tvText;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.card_image);
            tvText = itemView.findViewById(R.id.tvText);
        }

    }

}