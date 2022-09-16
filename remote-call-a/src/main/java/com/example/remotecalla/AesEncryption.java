package com.example.remotecalla;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * AES加解密工具
 * 
 * @author xuxulong
 * @date 2020-05-07aa
 * 
 */
@Component
public class AesEncryption {

    private final static String ALGORITHM = "AES/CBC/PKCS5Padding";

    /**
     * AES加密
     *
     * @param content
     *            需要加密的内容
     * @return 加密后内容，已由2进制转为base64编码
     */
    public static String encryptData(String content) throws Exception {
        if (content == null || AesDynamicProperty.encryptKey == null || AesDynamicProperty.ivParameterSpecKey == null) {
            return null;
        }
        SecretKeySpec keySpec = new SecretKeySpec(AesDynamicProperty.encryptKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(AesDynamicProperty.ivParameterSpecKey.getBytes()));
        byte[] result = cipher.doFinal(content.getBytes());
        return base64Encoder(result);
    }

    /**
     * AES解密
     *
     * 密钥
     * 
     * @param content
     *            待解密内容，必须为经AES加密后转为base64编码的字符串
     * @return 解密后的内容
     * @throws Exception
     */
    public static String decryptData(String content) throws Exception {
        if (content == null || AesDynamicProperty.encryptKey == null || AesDynamicProperty.ivParameterSpecKey == null) {
            return null;
        }
        SecretKeySpec keySpec = new SecretKeySpec(AesDynamicProperty.encryptKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(AesDynamicProperty.ivParameterSpecKey.getBytes()));
        byte[] result = cipher.doFinal(base64Decoder(content));
        return new String(result);
    }


    /**
     * 取得Key
     *
     * @param encryptKey
     *            密钥
     *
     * @return 解密后的内容
     * @throws Exception
     */
    public static SecretKey getSecretKey(String encryptKey) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(encryptKey.getBytes(), "AES");
        return skeySpec;
    }

    /**
     * 将二进制转换成base64编码
     *
     * @param buf
     * @return
     */
    private static String base64Encoder(byte buf[]) {
        return Base64.getEncoder().encodeToString(buf);
    }

    /**
     * 将base64进制转换为二进制
     *
     * @param base64Str
     * @return
     */
    private static byte[] base64Decoder(String base64Str) {
        return Base64.getDecoder().decode(base64Str);
    }
}