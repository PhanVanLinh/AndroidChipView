package toong.com.androidchipview.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

import toong.com.androidchipview.R;

public class ChipView extends FlexboxLayout {
    private List<String> selectedItems = new ArrayList<>();
    private ChipStyle style;

    public ChipView(Context context) {
        this(context, null);
    }

    public ChipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        setFlexWrap(FlexWrap.WRAP);
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.ChipView);
        style = new ChipStyle();
        try {
            style.setItemTextColor(ta.getColor(R.styleable.ChipView_chip_item_text_color, style.getItemTextColor()));
            style.setItemTextSize(ta.getDimensionPixelSize(R.styleable.ChipView_chip_item_text_size, style.getItemTextSize()));

            style.setItemBgColor(ta.getColor(R.styleable.ChipView_chip_item_bg_color, style.getItemBgColor()));
            style.setItemBgPressedColor(ta.getColor(R.styleable.ChipView_chip_item_bg_pressed_color, style.getItemBgPressedColor()));
            style.setItemBgSelectedColor(ta.getColor(R.styleable.ChipView_chip_item_bg_selected_color, style.getItemBgSelectedColor()));

            style.setItemBorderColor(ta.getColor(R.styleable.ChipView_chip_item_border_color, style.getItemBorderColor()));
            style.setItemBorderWidth(ta.getDimensionPixelSize(R.styleable.ChipView_chip_item_border_width, style.getItemBorderWidth()));

            style.setItemCorner(ta.getDimension(R.styleable.ChipView_chip_item_corner, style.getItemCorner()));
        } finally {
            ta.recycle();
        }
    }

    public void addItem(String[] items) {
        for (final String item : items) {
            final ChipItem chipItem = new ChipItem(getContext());
            chipItem.setStyle(style);
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
