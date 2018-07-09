package toong.com.androidchipview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChipItem extends RelativeLayout {
    private TextView textTitle;

    public ChipItem(Context context) {
        this(context, null);
    }

    public ChipItem(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChipItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_chipitem, this, true);
        textTitle = findViewById(R.id.text_title);
        setStyle(new ChipItemStyle());
    }

    private void setStyle(ChipItemStyle style) {
        if (!textTitle.isDuplicateParentStateEnabled()) {
            setClickable(true);
        }
        Drawable pressedDrawable = getPressedDrawable(style);
        Drawable selectedDrawable = getSelectedDrawable(style);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, selectedDrawable);
        stateListDrawable.addState(new int[]{},
                getNormalDrawable(style)); // must add it at last of all state

        textTitle.setBackground(stateListDrawable);
    }

    private Drawable getPressedDrawable(ChipItemStyle style) {
        GradientDrawable gradientDrawable = (GradientDrawable) getNormalDrawable(style);
        gradientDrawable.setColor(style.itemBgPressedColor);
        return gradientDrawable;
    }

    private Drawable getSelectedDrawable(ChipItemStyle style) {
        GradientDrawable gradientDrawable = (GradientDrawable) getNormalDrawable(style);
        gradientDrawable.setColor(style.itemBgSelectedColor);
        return gradientDrawable;
    }


    private Drawable getNormalDrawable(ChipItemStyle style) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setStroke(style.itemBorderWidth, style.itemBorderColor);
        gradientDrawable.setCornerRadius(style.itemCorner);
        gradientDrawable.setColor(style.itemBgColor);
        return gradientDrawable;
    }

    public void setTitle(String title) {
        ((TextView) findViewById(R.id.text_title)).setText(title);
    }

    public final class ChipItemStyle {
        final int itemBgColor = Color.RED;
        final int itemBgPressedColor = ContextCompat.getColor(getContext(), R.color.colorAccent);
        final int itemBgSelectedColor = Color.BLUE;
        final int itemBorderColor = Color.BLACK;
        final int itemBorderWidth = getResources().getDimensionPixelOffset(R.dimen.dp_1);
        final float itemCorner = getResources().getDimensionPixelOffset(R.dimen.dp_10);
    }
}
