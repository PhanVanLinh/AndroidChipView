package toong.com.androidchipview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

public class ChipView extends FlexboxLayout {
    public List<String> selectedItems = new ArrayList<>();

    public ChipView(Context context) {
        this(context, null);
    }

    public ChipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void addItem(String[] items) {
        for (final String item : items) {
            final ChipItem chipItem = new ChipItem(getContext());
            chipItem.setTitle(item);
            chipItem.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedItems.contains(item)) {
                        selectedItems.remove(item);
                    } else {
                        selectedItems.add(item);
                    }
                    chipItem.setSelected(!chipItem.isSelected());
                }
            });
            this.addView(chipItem);
        }
    }

    public List<String> getSelectedItems() {
        return selectedItems;
    }
}
