package com.cancha.gateway.security;

import org.springframework.stereotype.Component;

@Component
public class EncrypterUtil {

    private static final int ITERATION_COUNT = 50;
    private static final int KEY_SIZE = 128;
    private static final String IV = "F27D5C9927726BCEFE7510B1BDD3D137";
    private static final String SALT = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
    private static final String PASSPHRASE = "_M1_TRIBUNA_9O";

    public String encript(String value) {
        AesUtil util = new AesUtil(this.KEY_SIZE, this.ITERATION_COUNT);
        String encrypted = util.encrypt(this.SALT, this.IV, this.PASSPHRASE, value);
        return encrypted;
    }

    public String decript(String value) {
        AesUtil util = new AesUtil(this.KEY_SIZE, this.ITERATION_COUNT);
        String decrypted = util.decrypt(this.SALT, this.IV, this.PASSPHRASE, value);
        return decrypted;
    }
}
