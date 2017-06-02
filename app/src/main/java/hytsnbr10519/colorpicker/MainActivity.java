package hytsnbr10519.colorpicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnSeekBarChangeListener {

    private View color_view;
    private SeekBar red, green, blue, alpha;
    private int _red, _green, _blue, _alpha;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        color_view = findViewById(R.id.color_view);
        red = (SeekBar)findViewById(R.id.red);
        green = (SeekBar)findViewById(R.id.green);
        blue = (SeekBar)findViewById(R.id.blue);
        alpha = (SeekBar)findViewById(R.id.alpha);

        red.setMax(255);
        red.setOnSeekBarChangeListener(this);

        green.setMax(255);
        green.setOnSeekBarChangeListener(this);

        blue.setMax(255);
        blue.setOnSeekBarChangeListener(this);

        alpha.setMax(255);
        alpha.setProgress(255);
        alpha.setOnSeekBarChangeListener(this);

        result = (TextView)findViewById(R.id.result);

        setView();
        setText(true);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.red:
               _red = progress;
                break;
            case R.id.green:
                _green = progress;
                break;
            case R.id.blue:
               _blue = progress;
                break;
            case R.id.alpha:
                _alpha = progress;
                break;
        }

        setView();
        setText();
    }

    private void setView() {
        int color = Color.argb(_alpha, _red, _green, _blue);
        color_view.setBackgroundColor(color);
    }

    private String getTextString() {
        return getString(R.string.result, _red, _green, _blue, _alpha);
    }

    private void setText() {
        result.setText(getTextString());
    }

    private void setText(Boolean onCallOnlyBeginning) {
        if (!onCallOnlyBeginning) return;
        _red = red.getProgress();
        _green = green.getProgress();
        _blue = blue.getProgress();
        _alpha = alpha.getProgress();
        
        result.setText(getTextString());
    }
}
