package cn.edu.hfut.rbac.backend.util;

import cn.edu.hfut.rbac.backend.entity.StaffPassword;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author xuewenG
 * @date 2019/8/12 13:05
 */
final public class PasswordUtil {

    private PasswordUtil() {
    }

    /**
     * @author xuewenG
     * @date 2019/8/12 13:05
     * 将传入的明文加密并返回
     */
    public static String encode(String plainPassword) {
        return encodeSha_256(plainPassword);
    }

    /**
     * @author xuewenG
     * @date 2019/8/12 13:05
     * 检查明文与密文是否匹配
     */
    public static boolean check(String plainPassword, String encodePassword) {
        return encodeSha_256(plainPassword).equals(encodePassword);
    }

    /**
     * @return str 加密后的报文
     * @author xuewenG
     * @date 2019/8/12 13:05
     * 利用java原生的摘要实现SHA256加密
     */
    private static String encodeSha_256(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        if (str == null) {
            str = "";
        }
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * @author xuewenG
     * @date 2019/8/12 13:05
     * 将byte转为16进制
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }

    /**
     * @author xuewenG
     * @date 2019/8/14 20:04
     */
    public static Boolean isActive(StaffPassword staffPassword) {
        /**
         * TODO 完成检查密码是否过期
         */
        //String validEnd = staffPassword.getValidEnd().toString();
        //String cur = TimeUtil.getFormatTime();
        //return TimeUtil.compareTime(cur, validEnd);
        return true;
    }
}
