package com.example.bimg;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{
	ImageView iv;
	ImageButton ib;
    Button b;
    Intent i;
    int cemaradata=0;
    Bitmap bmp;
    TextView t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initialize();
       InputStream is=getResources().openRawResource(R.drawable.dt);
       bmp=BitmapFactory.decodeStream(is);
	}
	private void initialize(){
		iv=(ImageView) findViewById(R.id.getpic);
		ib=(ImageButton) findViewById(R.id.takepic);
		b=(Button) findViewById(R.id.backpic);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
		t1=(TextView)findViewById(R.id.tv1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.backpic:
			try {
				Toast.makeText(getApplicationContext(), "walpaper has setted", Toast.LENGTH_LONG).show();
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.takepic:
			i=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i,cemaradata);
		break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode== RESULT_OK){
			Bundle extras=data.getExtras();
			bmp=(Bitmap) extras.get("data");
			iv.setImageBitmap(bmp);
			
		}
	}

}
