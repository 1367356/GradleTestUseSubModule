package chapter18.class14;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Preferences  用于配置一些信息。用于较小的数据
 *
 */
public class PerferencesDemo {
    public static void main(String[] args) throws BackingStoreException {
        Preferences pres = Preferences.userNodeForPackage(PerferencesDemo.class);
        pres.put("Locaiton","Oz");
        pres.putInt("companions",4);
        pres.putBoolean("boolean",true);

        //获取
        int companions = pres.getInt("companions", 0);

        for (String key : pres.keys()) {

        }
    }
}
