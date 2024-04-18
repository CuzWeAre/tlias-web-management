package com.cwr.service;

import com.cwr.config.KeyGenerationServiceProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Slf4j
@Service
public class KeyGenerationService {

    private final KeyGenerationServiceProperties keyGenerationServiceProperties;

    private SecretKey secretKey;

    public KeyGenerationService(KeyGenerationServiceProperties keyGenerationServiceProperties) {
        this.keyGenerationServiceProperties = keyGenerationServiceProperties;
    }

    public SecretKey getCurrentKey() {
        return secretKey;
    }

    @Scheduled(fixedRateString = "${key-generate.fixed-rate}") // 10分钟更新一次，单位是毫秒
    public void generateNewKey() {

        String algorithm = keyGenerationServiceProperties.getAlgorithm();
        Integer keySize = keyGenerationServiceProperties.getKeySize();

        try {

            // 实例化 KeyGenerator 对象，并指定使用 AES 算法
            KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);

            // 初始化 KeyGenerator 对象，指定密钥长度（例如 128, 192 或 256 位）
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(keySize, secureRandom);

            // 生成密钥
            this.secretKey = keyGenerator.generateKey();
            log.info("New secret key generated.");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to generate secret key", e);
        }
    }
}
