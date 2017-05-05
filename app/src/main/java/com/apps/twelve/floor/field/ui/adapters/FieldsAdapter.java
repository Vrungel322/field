package com.apps.twelve.floor.field.ui.adapters;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.apps.twelve.floor.field.App;
import com.apps.twelve.floor.field.R;
import com.apps.twelve.floor.field.mvp.data.model.Field;
import com.apps.twelve.floor.field.utils.RxBus;
import com.apps.twelve.floor.field.utils.RxBusHelper;
import com.daimajia.swipe.SwipeLayout;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by Yaroslav on 28 03 2017.
 */

public class FieldsAdapter extends RecyclerView.Adapter<FieldsAdapter.FieldViewHolder> {

  @Inject RxBus mRxBus;

  public FieldsAdapter() {
    super();
    App.getAppComponent().inject(this);
  }

  private ArrayList<Field> mFieldsList = new ArrayList<>();

  @Override public FieldViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_field_list, parent, false);
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

  public void addField(Field field) {
    mFieldsList.add(field);
    notifyItemInserted(mFieldsList.size() - 1);
  }

  public void updateField(Field field) {
    int position = mFieldsList.indexOf(field);
    if (position >= 0) {
      mFieldsList.set(position, field);
      notifyItemChanged(position);
    }
  }

  public void removeField(Field field, int position) {
    if (position < 0 && field == null) {
      Timber.e(new Throwable("Trying to remove incorrect field"));
      return;
    }
    if (position < 0) position = mFieldsList.indexOf(field);

    if (position >= 0) {
      mFieldsList.remove(position);
      notifyItemRemoved(position);
      notifyItemRangeChanged(position, mFieldsList.size());
    }
  }

  public Field getFieldAt(int position) {
    return mFieldsList.get(position);
  }

  private void updateHolder(FieldViewHolder holder, int position) {
    Field field = mFieldsList.get(position);

    holder.mNameText.setText(field.getName());
    // TODO: get crop name by id
    //holder.mCropText.setText(field.getCrop());
    holder.mAreaText.setText(field.getArea() != null ? String.valueOf(field.getArea()) : "");

    setupSwipeLayout(holder, position);
  }

  private void setupSwipeLayout(FieldViewHolder holder, int position) {
    holder.mDeleteButton.setOnClickListener(v -> mRxBus.post(
        new RxBusHelper.FieldDeletedFromList(mFieldsList.get(position), position)));

    holder.mCancelButton.setOnClickListener(v -> holder.mSwipeLayout.close());

    //set show mode.
    holder.mSwipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
    //add drag edge.(If the BottomView has 'layout_gravity' attribute, this line is unnecessary)
    holder.mSwipeLayout.addDrag(SwipeLayout.DragEdge.Left, holder.mSwipeBackground);
    // add swipe listener
    holder.mSwipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
      @Override public void onStartOpen(SwipeLayout layout) {
        layout.setClickable(false);
      }

      @Override public void onOpen(SwipeLayout layout) {
      }

      @Override public void onStartClose(SwipeLayout layout) {
      }

      @Override public void onClose(SwipeLayout layout) {
        layout.setClickable(true);
      }

      @Override public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
      }

      @Override public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
      }
    });
  }

  static class FieldViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_name) TextView mNameText;
    @BindView(R.id.text_crop) TextView mCropText;
    @BindView(R.id.text_area) TextView mAreaText;
    @BindView(R.id.swipe_layout) SwipeLayout mSwipeLayout;
    @BindView(R.id.swipe_background) ConstraintLayout mSwipeBackground;
    @BindView(R.id.btn_delete) Button mDeleteButton;
    @BindView(R.id.btn_cancel) Button mCancelButton;

    FieldViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
