package mobi.tongari.mokutan.util;

import java.io.File;

public class EnvironmentUtil {

    private static String[] mDirectories = {
            "/mnt/ext_sdcard" //
            , "/mnt/sdcard/external_sd" //
            , System.getenv("EXTERNAL_STORAGE2") //
            , System.getenv("EXTERNAL_ALT_STORAGE") //
            , System.getenv("EXTERNAL_STORAGE") //
            // , Environment.getExternalStorageDirectory().getPath()//
            , "/mnt/sdcard" //
            , "/"
    };

    public String[] getDirectories() {
        return mDirectories;
    }

    // �X�g���[�W�̃f�B�N�g����Ԃ��BSD�J�[�h�D��B
    public static String getStoragePath() {
        String path = "";

        for (String p : mDirectories) {
            if (exists(p)) {
                path = p;
                break;
            }
        }
        return path;
    }

    private static boolean exists(String path) {
        if (path == null || path.isEmpty()) {
            return false;
        } else {
            return new File(path).canRead();
        }
    }
}
