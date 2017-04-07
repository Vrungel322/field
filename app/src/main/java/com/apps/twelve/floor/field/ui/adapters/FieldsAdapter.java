package com.apps.twelve.floor.field.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import java.util.ArrayList;
import java.util.List;
import me.thanel.swipeactionview.SwipeActionView;
import me.thanel.swipeactionview.SwipeGestureListener;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Yaroslav on 28 03 2017.
 */

public class FieldsAdapter extends RecyclerView.Adapter<FieldsAdapter.FieldViewHolder> {

  private ArrayList<Field> mFieldsList = new ArrayList<>();

  @Override public FieldViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filed_list, parent, false);
    return new FieldViewHolder(view);
  }

  @Override public void onBindViewHolder(FieldViewHolder holder, int position) {
    Field field = mFieldsList.get(position);
    holder.mNameText.setText(field.getName());
    holder.mAreaText.setText(String.valueOf((int) field.getArea()));
    holder.mDeleteBtn.setOnClickListener(v -> {
      mFieldsList.remove(position);
      notifyDataSetChanged();
    });
    holder.mSwipeActionView.setSwipeGestureListener(new SwipeGestureListener() {
      @Override public boolean onSwipedLeft(@NotNull SwipeActionView swipeActionView) {
        swipeActionView.moveToOriginalPosition(2000);
        return false;
      }

      @Override public boolean onSwipedRight(@NotNull SwipeActionView swipeActionView) {
        swipeActionView.moveToOriginalPosition(2000);
        return false;
      }
    });
  }

  @Override public int getItemCount() {
    return mFieldsList.size();
  }

  public void addAllFields(List<Field> fields) {
    mFieldsList.addAll(fields);
    notifyDataSetChanged();
  }

  public Field getFieldAt(int position) {
    return mFieldsList.get(position);
  }

  public static class FieldViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_name) TextView mNameText;
    @BindView(R.id.text_area) TextView mAreaText;
    @BindView(R.id.button_delete) Button mDeleteBtn;
    @BindView(R.id.swipe_action_view) SwipeActionView mSwipeActionView;

    public FieldViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
