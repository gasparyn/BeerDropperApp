package com.BeerDropper.www;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
 
public class Photo extends Activity {
  
 ImageView imageiewImageCaptured;
  
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);
       Button buttonImageCapture = (Button)findViewById(R.id.captureimage);
       imageiewImageCaptured = (ImageView)findViewById(R.id.imagecaptured);
       
       buttonImageCapture.setOnClickListener(buttonImageCaptureOnClickListener);
   }
   
   Button.OnClickListener buttonImageCaptureOnClickListener= new Button.OnClickListener(){
 
	  @Override
	  public void onClick(View arg0) {
	   // TODO Auto-generated method stub
	   Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	   startActivityForResult(intent, 0);
	    
	  }};
 
 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  // TODO Auto-generated method stub
  super.onActivityResult(requestCode, resultCode, data);
   
  if (resultCode == RESULT_OK)
  {
   Bundle extras = data.getExtras();
   Bitmap bmp = (Bitmap) extras.get("data");
   imageiewImageCaptured.setImageBitmap(bmp); 
  }
   
 }
}