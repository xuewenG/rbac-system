package cn.edu.hfut.rbac.backend.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author xuewenG
 * @date 2019/8/14 20:42
 */
public class RequestUtil {
    public static String getBody(HttpServletRequest httpServletRequest) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = httpServletRequest.getReader();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
