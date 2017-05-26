package site.zido.brush.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * description:
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/26 0026
 */
public class StringUtils {
    public static String toString(InputStream inputStream) throws IOException {
        StringBuilder out = new StringBuilder();
        byte[] b = new byte[4096];
        for (int n; (n = inputStream.read(b)) != -1;) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

    public static InputStream toInputStream(String str){
        return new ByteArrayInputStream(str.getBytes());
    }
}
