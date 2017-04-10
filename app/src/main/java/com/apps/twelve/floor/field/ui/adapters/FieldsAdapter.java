package com.apps.twelve.floor.field.ui.adapters;

import android.os.Handler;
import android.support.constraint.ConstraintLayout;
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

  private static final long AUTO_BACK_ANIMATION_DELAY = 2000L;

  private ArrayList<Field> mFieldsList = new ArrayList<>();

  @Override public FieldViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filed_list, parent, false);
    return new FieldViewHolder(view);
  }

  @Override public void onBindViewHolder(FieldViewHolder holder, int position) {
    updateHolder(holder, position);
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

  private void updateHolder(FieldViewHolder holder, int position) {
    Field field = mFieldsList.get(position);

    holder.mNameText.setText(field.getName());
    holder.mAreaText.setText(String.valueOf((int) field.getArea()));

    holder.mCancelBtn.setOnClickListener(v -> setBackgroundClickable(holder, false));
    holder.mDeleteBtn.setOnClickListener(v -> {
      setBackgroundClickable(holder, false);

      // TODO: need to cancel animation on delete
      holder.mSwipeActionView.clearAnimation(); // this doesn't work

      mFieldsList.remove(position);
      notifyDataSetChanged();
    });

    holder.mButtonsBackgroundConstraintLayout.setOnClickListener(
        v -> setBackgroundClickable(holder, false));

    holder.mSwipeActionView.setSwipeGestureListener(new SwipeGestureListener() {
      @Override public boolean onSwipedLeft(@NotNull SwipeActionView swipeActionView) {
        return onSwipe(holder, swipeActionView);
      }

      @Override public boolean onSwipedRight(@NotNull SwipeActionView swipeActionView) {
        return onSwipe(holder, swipeActionView);
      }
    });

    setBackgroundClickable(holder, false);
  }

  private boolean onSwipe(FieldViewHolder holder, SwipeActionView swipeActionView) {
    swipeActionView.moveToOriginalPosition(AUTO_BACK_ANIMATION_DELAY);
    (new Handler()).postDelayed(() -> setBackgroundClickable(holder, false),
        AUTO_BACK_ANIMATION_DELAY);
    setBackgroundClickable(holder, true);
    return false;
  }

  private void setBackgroundClickable(FieldViewHolder holder, boolean isClickable) {
    holder.mCancelBtn.setClickable(isClickable);
    holder.mDeleteBtn.setClickable(isClickable);
    holder.mButtonsBackgroundConstraintLayout.setClickable(isClickable);
  }

  public static class FieldViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_name) TextView mNameText;
    @BindView(R.id.text_area) TextView mAreaText;
    @BindView(R.id.button_delete) Button mDeleteBtn;
    @BindView(R.id.button_cancel) Button mCancelBtn;
    @BindView(R.id.constraint_layout_background) ConstraintLayout
        mButtonsBackgroundConstraintLayout;
    @BindView(R.id.swipe_action_view) SwipeActionView mSwipeActionView;

    public FieldViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
