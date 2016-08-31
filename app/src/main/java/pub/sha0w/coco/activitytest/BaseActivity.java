package pub.sha0w.coco.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by coco1 on 2016/8/31.
 */
public class BaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGC.add(this);
        Log.d("BaseActivity" , getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ActivityGC.finishAll();
    }
}
