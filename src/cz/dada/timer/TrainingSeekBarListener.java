package cz.dada.timer;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class TrainingSeekBarListener implements OnSeekBarChangeListener {

	private MainActivity ma;
	
	public TrainingSeekBarListener(MainActivity ma) {
		this.ma = ma;
	}
	
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		TextView tt = (TextView) ma.findViewById(R.id.label_training_time_value);
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
		tt.setText(minutes+":"+seconds);
		
		ma.setTraining_time(progress);
		if(ma.getActual_time() > progress){
			if(ma.getState() == 0)
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
