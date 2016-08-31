package pub.sha0w.coco.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by coco1 on 2016/8/27.
 */
public class ActivityTest extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.test_layout);//在这里注册layout
        Button button1 = (Button)findViewById(R.id.button_1);//通过findViewById获取按钮的ID，再通过Button的转义将View型数据转换成Button型
        Button button2 = (Button)findViewById(R.id.button_2);//通过findViewById获取按钮的ID，再通过Button的转义将View型数据转换成Button型
        Button button3 = (Button)findViewById(R.id.button3);//通过findViewById获取按钮的ID，再通过Button的转义将View型数据转换成Button型
//设置Button的Onclick监听事件
        button1.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityTest.this , "You Click It!" , Toast.LENGTH_SHORT).show();

              }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String data = new String("Hi Activity_2");
                Intent intent = new Intent("pub.sha0w.coco.activitytest.ACTION_START");
                intent.addCategory("pub.sha0w.coco.activitytest.MY_CATEGORY");
                intent.putExtra("extradata" , data);//putExtra接受两个变量，一个是key，用于在后面从Intent取值，第二个参数才是我们想要的值
                startActivityForResult(intent,1);//用这个方法你就会很想要回复！
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String data = new String("Hi Activity_2");
                Intent intent = new Intent(ActivityTest.this,Activity_2.class);
                intent.putExtra("extradata" , data);//putExtra接受两个变量，一个是key，用于在后面从Intent取值，第二个参数才是我们想要的值
                startActivity(intent);//用这个方法你就会很想要回复！
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test , menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You Click Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remoce_item:
                Toast.makeText(this, "You Click Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true ;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("datareturn");
                    Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}

