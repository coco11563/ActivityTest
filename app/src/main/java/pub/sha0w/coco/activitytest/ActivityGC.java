package pub.sha0w.coco.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coco1 on 2016/8/31.
 */
public class ActivityGC {
    public static List<Activity> gclist = new ArrayList<Activity>();
    public static void  add(Activity activity){
        gclist.add(activity);
    }
    public static void remove(Activity activity){
        gclist.remove(activity);
    }
    public static void finishAll(){
        for (Activity act : gclist
             ) {
            if(!act.isFinishing()){
                act.finish();
            }
        }
    }
}
