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

    /*
    private SeekBar[] seekBars = new SeekBar[4];
    private int[] colors = new int[4];
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        color_view = findViewById(R.id.color_view);

        /*
        seekBars[0] = (SeekBar)findViewById(R.id.red);
        seekBars[1] = (SeekBar)findViewById(R.id.green);
        seekBars[2] = (SeekBar)findViewById(R.id.blue);
        seekBars[3] = (SeekBar)findViewById(R.id.alpha);

        for (int i = 0;i < seekBars.length;i++) {
            seekBars[i].setMax(255);
            seekBars[i].setOnSeekBarChangeListener(this);
        }
        seekBars[3].setProgress(255);
        */

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

        /*
        switch (seekBar.getId()) {
            case R.id.red:
                colors[1] = progress;
                break;
            case R.id.green:
                colors[2] = progress;
                break;
            case R.id.blue:
                colors[3] = progress;
                break;
            case R.id.alpha:
                colors[0] = progress;
                break;
        }
        */

        setView();
        setText();
    }

    private void setView() {
        //int color = Color.argb(colors[0], colors[1], colors[2], colors[3]);
        int color = Color.argb(_alpha, _red, _green, _blue);
        color_view.setBackgroundColor(color);
    }

    private String getTextString() {
        //return getString(R.string.result, colors[0], colors[1], colors[2], colors[3]);
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
        /*
        for (int i = 0;i < seekBars.length;i++) {
            colors[i] = seekBars[i].getProgress();
        }
        */
        result.setText(getTextString());
    }
}
