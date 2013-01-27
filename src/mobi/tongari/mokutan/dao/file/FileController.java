package mobi.tongari.mokutan.dao.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

final public class FileController {

	public final static String CHARACTER_CODE_SJIS = "SJIS";

	public final static String CHARACTER_CODE_UTF8 = "UTF-8";

	/**
	 * ファイルから文字列を読み込みます。
	 * 
	 * @param is
	 * @return ファイルの文字列
	 * @throws IOException
	 */
	public static String readFile(InputStream is, String characterCode)
			throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(is, characterCode));

			StringBuilder sb = new StringBuilder();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str + " ");
			}
			return sb.toString();
		} finally {
			if (br != null)
				br.close();
		}
	}
}