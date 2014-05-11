package dolmisani.android.toys.sillytunes;

import android.app.Activity;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements AccelerometerListener {

	private MediaPlayer mediaPlayer = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new AudioClipHandler(this, (ImageButton) findViewById(R.id.cowButton), R.raw.cow_moo);
		new AudioClipHandler(this, (ImageButton) findViewById(R.id.catButton), R.raw.cat_meow);
		new AudioClipHandler(this, (ImageButton) findViewById(R.id.pigButton), R.raw.pig_oink);
		new AudioClipHandler(this, (ImageButton) findViewById(R.id.horseButton), R.raw.horse_neigh);
		new AudioClipHandler(this, (ImageButton) findViewById(R.id.roosterButton), R.raw.rooster);
		new AudioClipHandler(this, (ImageButton) findViewById(R.id.sheepButton), R.raw.sheep_bleat);

		mediaPlayer = MediaPlayer.create(this, R.raw.ship_bell);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
        Toast.makeText(getBaseContext(), "onResume Accelerometer Started", 
                Toast.LENGTH_SHORT).show();
         
        //Check device supported Accelerometer senssor or not
        if (AccelerometerManager.isSupported(this)) {
             
            //Start Accelerometer Listening
            AccelerometerManager.startListening(this);
        }
	}

	@Override
	protected void onStop() {
        //Check device supported Accelerometer senssor or not
        if (AccelerometerManager.isListening()) {
             
            //Start Accelerometer Listening
            AccelerometerManager.stopListening();
             
            Toast.makeText(getBaseContext(), "onStop Accelerometer Stoped", 
                     Toast.LENGTH_SHORT).show();
        }
	}

	@Override
	protected void onDestroy() {
		Log.i("Sensor", "Service  distroy");
        
        //Check device supported Accelerometer senssor or not
        if (AccelerometerManager.isListening()) {
             
            //Start Accelerometer Listening
            AccelerometerManager.stopListening();
             
            Toast.makeText(getBaseContext(), "onDestroy Accelerometer Stoped", 
                   Toast.LENGTH_SHORT).show();
        }
	}

	@Override
	public void onAccelerationChanged(float x, float y, float z) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onShake(float force) {
		 // Called when Motion Detected
		
		mediaPlayer.start();
		
        Toast.makeText(getBaseContext(), "Motion detected", 
                Toast.LENGTH_SHORT).show();
		
	}

}
