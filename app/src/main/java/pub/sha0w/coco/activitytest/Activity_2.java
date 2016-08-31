package pub.sha0w.coco.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by coco1 on 2016/8/27.
 */
public class Activity_2 extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.test_layout_2);
        Intent intent = getIntent();

        final String data = intent.getStringExtra("extradata");
        Log.d("ActivityTest Said", data);

        Button button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Activity_2.this , data , Toast.LENGTH_SHORT).show();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
                Intent intent = new Intent(Activity_2.this , Activity_3.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("datareturn" , "Hello ActivityTest");
                setResult(RESULT_OK, intent1);
                finish();
            }
        }
        );
    }
    @Override
    public void onBackPressed(){
        Intent intent3 = new Intent();
        intent3.putExtra("datareturn","Hello ActivityTest! This message is from the backPress");
        setResult(RESULT_OK , intent3);
        finish();
    }
}
