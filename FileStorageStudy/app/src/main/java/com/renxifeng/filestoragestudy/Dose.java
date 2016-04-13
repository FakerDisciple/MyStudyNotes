package com.renxifeng.filestoragestudy;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by Rxf on 2016/4/13 0013.
 */
public class Dose extends Activity {
    /**
     * 这个活动是为了演示三种不同获得SharedPreferences的方式
     */
    private SharedPreferences preferences;

    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         1. Context 类中的 getSharedPreferences()方法
         此方法接收两个参数，第一个参数用于指定 SharedPreferences文件的名称，如果指
         定的文件不存在则会创建一个，SharedPreferences 文件都是存放在/data/data/<packagename>/shared_prefs/目录下的。
         第二个参数用于指定操作模式，主要有两种模式可以选择，
         MODE_PRIVATE 和 MODE_MULTI_PROCESS。
         MODE_PRIVATE 仍然是默认的操作模式，和直接传入 0 效果是相同的，表示只有当前的应用程序才可以对这个
         SharedPreferences文件进行读写。 MODE_MULTI_PROCESS则一般是用于会有多个进程中
         对同一个 SharedPreferences文件进行读写的情况。类似地，MODE_WORLD_READABLE
         和 MODE_WORLD_WRITEABLE 这两种模式已在 Android 4.2 版本中被废弃。
         */
        preferences = getSharedPreferences("my_shared",MODE_PRIVATE);

        /**
         2. Activity 类中的 getPreferences()方法
         这个方法和 Context 中的 getSharedPreferences()方法很相似，不过它只接收一个操
         作模式参数，因为使用这个方法时会自动将当前活动的类名作为 SharedPreferences 的文
         件名。
         */
        preferences = getPreferences(MODE_PRIVATE);

        /**
         3. PreferenceManager 类中的 getDefaultSharedPreferences()方法
         这是一个静态方法，它接收一个 Context 参数，并自动使用当前应用程序的包名作
         为前缀来命名 SharedPreferences 文件。
         */
        preferences = PreferenceManager.getDefaultSharedPreferences(this);


        /**
         得到了 SharedPreferences对象之后， 就可以开始向 SharedPreferences文件中存储数据了，
         主要可以分为三步实现。
         1. 调用 SharedPreferences 对象的 edit()方法来获取一个 SharedPreferences.Editor 对象。
         2. 向 SharedPreferences.Editor 对象中添加数据，比如添加一个布尔型数据就使用
         putBoolean 方法，添加一个字符串则使用 putString()方法，以此类推。
         3. 调用 commit()方法将添加的数据提交，从而完成数据存储操作。
         */

        //生成并且提交共享参数
        editor = preferences.edit();
        editor.putBoolean("key",false); //第一个字段是key 第二个字段是默认值
        editor.commit();

        //从共享参数中获取数据
       preferences.getBoolean("key",false); //第一个字段是key，第二个字段是默认值
    }
}
