package cz.dada.timer;

import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class BreakSeekBarListener implements OnSeekBarChangeListener {

	private MainActivity ma;
	
	public BreakSeekBarListener(MainActivity ma){
		this.ma = ma;
	}
	
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		TextView bt = (TextView) ma.findViewById(R.id.label_break_time_value);
		String minutes = "";
		String seconds = "";
		minutes = Integer.toString(progress/60);
		if(minutes.length() == 1){
			minutes = "0"+minutes;
		}
		seconds = Integer.toString(progress%60);
		if(seconds.length() == 1){
			seconds = "0"+seconds;
		}
		bt.setText(minutes+":"+seconds);
		

		ma.setBreak_time(progress);
		if(ma.getActual_time() > progress){
			if(ma.getState() == 1)
			ma.setActual_time(progress);
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

}
