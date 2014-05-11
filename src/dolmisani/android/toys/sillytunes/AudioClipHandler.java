package dolmisani.android.toys.sillytunes;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class AudioClipHandler {
	
	
	private MediaPlayer mediaPlayer = null;

	public AudioClipHandler(Context context, ImageButton button, int audioClipId) {
		
		mediaPlayer = MediaPlayer.create(context, audioClipId);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				mediaPlayer.start();
			}
		});
		
	}

}
