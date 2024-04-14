package sangcompany.shortenurl.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class SecureRandomStringGenerator {
    // 영문 대소문자와 숫자를 포함한 문자열
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String generateRandomString(int length) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            // CHARACTERS 문자열에서 무작위 인덱스를 선택하여 해당 문자를 StringBuilder에 추가
            int randomIndex = secureRandom.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
