package cz.dada.timer;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class StartButtonListener implements OnClickListener {

	private MainActivity ma;
	
	public StartButtonListener(MainActivity ma) {
		this.ma = ma;
	}
	
	@Override
	public void onClick(View v) {
		Log.i("START", ma.isStart()+"");
		if(!ma.isStart()){
			ma.startTimer();
		}
	}

}
