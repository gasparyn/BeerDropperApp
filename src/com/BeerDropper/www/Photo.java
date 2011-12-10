package com.BeerDropper.www;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Photo extends Activity {

	ImageView imageCaptured;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//Camera Button
		Button buttonImageCapture = (Button)findViewById(R.id.get_image);
		imageCaptured = (ImageView)findViewById(R.id.imagecaptured);
		buttonImageCapture.setOnClickListener(camerabutton);

		//Navigation Button
		Button nav = (Button)findViewById(R.id.get_directions);
		nav.setOnClickListener(navigation);

		//Call Button
		Button call = (Button)findViewById(R.id.get_call);
		call.setOnClickListener(phone);


	}

	//Executes when the camera button is clicked
	Button.OnClickListener camerabutton= new Button.OnClickListener(){
		@Override
		public void onClick(View arg0) {
			Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, 0);

		}
	};

	//This method saves the picture on the screen
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK)
		{
			Bundle extras = data.getExtras();
			Bitmap bmp = (Bitmap) extras.get("data");
			imageCaptured.setImageBitmap(bmp);
		}

	}
	//Executes when the navigation button is pressed
	Button.OnClickListener navigation = new Button.OnClickListener(){
		@Override
		public void onClick(View arg0) {
			Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=Boston+MA")); startActivity(i);
		}
	};
	//Executes when the call button is pressed
	Button.OnClickListener phone = new Button.OnClickListener(){
		@Override
		public void onClick(View arg0) {
			Uri number = Uri.parse("tel:" + "6172493645");
			Intent dial = new Intent(Intent.ACTION_DIAL, number);
			startActivity(dial);
			startActivity(Intent.createChooser(dial, "select dialer"));
		}
	};
}




