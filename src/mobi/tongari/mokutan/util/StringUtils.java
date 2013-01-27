package mobi.tongari.mokutan.util;

import java.io.UnsupportedEncodingException;

import mobi.tongari.mokutan.util.Log.ExLog;

public class StringUtils {

    /**
     * �����̕�����̃o�C�g����Ԃ��܂��BShift_JIS�Ƃ��ĕ]�����܂��B
     * @param target �]���Ώ�
     * @return Shift-JIS�`���ŕ]�������ꍇ�̃o�C�g��
     */
    public static int getShiftJISByteLength(String target) {
        try {
            if (target != null)
                return target.getBytes("Shift_JIS").length;

        } catch (UnsupportedEncodingException e) {
        	ExLog.e(e,"�����o�C�g������G���[�F%s",e.getMessage());
        }
        return 0;
    }
}
