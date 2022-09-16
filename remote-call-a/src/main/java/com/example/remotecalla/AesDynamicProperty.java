package com.example.remotecalla;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author johnny.liu
 * @version 1.0
 * @date 2020/7/6 23:50
 */
@Configuration
@RefreshScope
@Data
public class AesDynamicProperty {

    public static String encryptKey;

    public static String ivParameterSpecKey;

    @Value("${trading.encryption.aes.iv-parameter}")
    public void setIvParameterSpecKey(String ivParameterSpecKey) {
        AesDynamicProperty.ivParameterSpecKey = ivParameterSpecKey;
    }

    @Value("${trading.encryption.aes.aes-key}")
    public void setEncryptKey(String encryptKey) {
        AesDynamicProperty.encryptKey = encryptKey;
    }
}
