package cz.dada.timer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	private TextView actual_timmer;

	private int training_time = 0;
	private int break_time = 0;
	private int actual_time = -1;
	private int state = 0; //{0 = training, 1 = break}
	
	private boolean start = false;
	
	private Handler timmer = new Handler();
	
	private Runnable timmer_runnable = new Runnable() {
		
		@Override
		public void run() {
			if(training_time == 0){
				Toast t = Toast.makeText(getApplicationContext(), "Èas tréningu nesmí být nulový!", Toast.LENGTH_LONG);
				t.show();
				resetTimer();
				return;
			}
			if(isStart()){
					switch(state){
					case 0:{
						
						String minutes = Integer.toString(actual_time/60);
						if(minutes.length() == 1){
							minutes = "0"+minutes;
						}
						String seconds = Integer.toString(actual_time%60);
						if(seconds.length() == 1){
							seconds = "0"+seconds;
						}
						actual_timmer.setText(minutes+":"+seconds);
						actual_timmer.setBackgroundColor(Color.RED);
						actual_time--;
						if(actual_time < 0){
							state += 1;
							state = state%2;
							actual_time = break_time;
						}
						break;
					}
					case 1:{
						
						String minutes = Integer.toString(actual_time/60);
						if(minutes.length() == 1){
							minutes = "0"+minutes;
						}
						String seconds = Integer.toString(actual_time%60);
						if(seconds.length() == 1){
							seconds = "0"+seconds;
						}
						actual_timmer.setText(minutes+":"+seconds);
						actual_timmer.setBackgroundColor(Color.GREEN);
						actual_time--;
						if(actual_time < 0){
							state += 1;
							state = state%2;
							actual_time = training_time;
						}
						break;
					}
					}
				
				restartTimer();
			} 
		}
	};
	
	public void resetTimer(){
		state = 0;
		actual_time = 0;
		actual_timmer.setText("00:00");
		actual_timmer.setBackgroundColor(Color.RED);
		start = false;
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        SeekBar tsb = (SeekBar) findViewById(R.id.seek_bar_training_time_value);
        tsb.setOnSeekBarChangeListener(new TrainingSeekBarListener(this));
        
        SeekBar bsb = (SeekBar) findViewById(R.id.seek_bar_break_time_value);
        bsb.setOnSeekBarChangeListener(new BreakSeekBarListener(this));
        
        Button startb = (Button) findViewById(R.id.button_start);
        startb.setOnClickListener(new StartButtonListener(this));
        
        Button stopb = (Button) findViewById(R.id.button_stop);
        stopb.setOnClickListener(new StopButtonListener(this));
        
        actual_timmer = (TextView) findViewById(R.id.time_value);
        if(isStart()){
        	startTimer();
        }
    }

    public void restartTimer(){
    	setStart(true);
    	timmer.postDelayed(timmer_runnable, 1000);
    }
    
    public void startTimer(){
    	setStart(true);
    	actual_time = training_time;
    	timmer.postDelayed(timmer_runnable, 1000);
    }
    
    public void stopTimer(){
    	setStart(false);
    }
    
	public Integer getTraining_time() {
		return training_time;
	}

	public void setTraining_time(Integer training_time) {
		this.training_time = training_time;
	}

	public Integer getBreak_time() {
		return break_time;
	}

	public void setBreak_time(Integer break_time) {
		this.break_time = break_time;
	}

	public Integer getActual_time() {
		return actual_time;
	}

	public void setActual_time(Integer actual_time) {
		this.actual_time = actual_time;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

    
}
