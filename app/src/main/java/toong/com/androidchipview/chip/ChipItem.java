package toong.com.androidchipview.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import toong.com.androidchipview.R;

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
    }

    public void setStyle(ChipStyle style) {
        configureTitle(style);
    }

    private void configureTitle(ChipStyle style) {
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
        textTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, style.getItemTextSize());
        textTitle.setTextColor(style.getItemTextColor());
    }

    private Drawable getPressedDrawable(ChipStyle style) {
        GradientDrawable gradientDrawable = (GradientDrawable) getNormalDrawable(style);
        gradientDrawable.setColor(style.getItemBgPressedColor());
        return gradientDrawable;
    }

    private Drawable getSelectedDrawable(ChipStyle style) {
        GradientDrawable gradientDrawable = (GradientDrawable) getNormalDrawable(style);
        gradientDrawable.setColor(style.getItemBgSelectedColor());
        return gradientDrawable;
    }


    private Drawable getNormalDrawable(ChipStyle style) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setStroke(style.getItemBorderWidth(), style.getItemBorderColor());
        gradientDrawable.setCornerRadius(style.getItemCorner());
        gradientDrawable.setColor(style.getItemBgColor());
        return gradientDrawable;
    }

    public void setTitle(String title) {
        ((TextView) findViewById(R.id.text_title)).setText(title);
    }
}
