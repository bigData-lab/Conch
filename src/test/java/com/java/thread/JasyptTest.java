package com.java.thread;


import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;

public class JasyptTest {

    final String algorithm = "PBEWithMD5AndDES";// 加密的算法，这个算法是默认的
    final String password = "hVO0O2NeySpANQUk"; // 加密的密钥 配置文件中  jasypt.encryptor.password
    StandardPBEStringEncryptor standardPBEStringEncryptor;

    {
        standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();
        config.setAlgorithm(algorithm);
        config.setPassword(password);
        standardPBEStringEncryptor.setConfig(config);
    }

    public String encrypt(String plainText) {
       return standardPBEStringEncryptor.encrypt(plainText);
    }

    //解密
    public String decrypt(String encryptedText) {
        return standardPBEStringEncryptor.decrypt(encryptedText);
    }

    public static void main(String[] args) {
        JasyptTest test = new JasyptTest();
//        System.out.println(test.decrypt("k6vl6SNCrZ8hyTcK4ew+pQ=="));
        System.out.println(test.decrypt("QDy4nSyBTUmWcvEIgKaotmGFGAZNqIImgCXkw9K18EY="));
    }

}
