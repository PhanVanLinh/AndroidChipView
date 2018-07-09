package toong.com.androidchipview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChipItem extends RelativeLayout {
    TextView textTitle;

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
        if (!textTitle.isDuplicateParentStateEnabled()) {
            setClickable(true);
        }
        Drawable pressedDrawable = getPressedDrawable();
        Drawable selectedDrawable = getSelectedDrawable();
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, selectedDrawable);
        stateListDrawable.addState(new int[]{},
                getEnabledDrawable()); // must add it at last of all state

        textTitle.setBackground(stateListDrawable);
    }

    private Drawable getPressedDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(1, Color.BLACK);
        gradientDrawable.setCornerRadius(10);
        gradientDrawable.setColor(Color.BLUE);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        return gradientDrawable;
    }

    private Drawable getSelectedDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(1, Color.BLACK);
        gradientDrawable.setCornerRadius(5);
        gradientDrawable.setColor(Color.YELLOW);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        return gradientDrawable;
    }


    private Drawable getEnabledDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(1, Color.BLACK);
        gradientDrawable.setCornerRadius(5);
        gradientDrawable.setColor(Color.RED);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        return gradientDrawable;
    }

    public void setTitle(String title) {
        ((TextView) findViewById(R.id.text_title)).setText(title);
    }
}
