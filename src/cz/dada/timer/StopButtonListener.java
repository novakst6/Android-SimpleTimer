package cz.dada.timer;

import android.view.View;
import android.view.View.OnClickListener;

public class StopButtonListener implements OnClickListener {

	private MainActivity ma;
	
	public StopButtonListener(MainActivity ma) {
		this.ma = ma;
	}
	
	@Override
	public void onClick(View v) {
		ma.stopTimer();
		ma.resetTimer();
	}

}
