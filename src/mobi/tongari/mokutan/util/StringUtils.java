package mobi.tongari.mokutan.util;

import java.io.UnsupportedEncodingException;


public class StringUtils {

    /**
     * 引数の文字列のバイト数を返す。Shift_jisとして評価します。
     * @param target 評価対象
     * @return Shift-JIS形式で評価した場合のバイト数
     */
    public static int getShiftJISByteLength(String target) {
        try {
            if (target != null)
                return target.getBytes("Shift_JIS").length;

        } catch (UnsupportedEncodingException e) {
        	ExLog.e(e,"文字バイト数判定エラー:%s",e.getMessage());
        }
        return 0;
    }
}
