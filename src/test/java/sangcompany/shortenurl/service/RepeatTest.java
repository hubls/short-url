package sangcompany.shortenurl.service;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class RepeatTest {

    @Test
    void 반복테스트() {
        // RestTemplate 생성
        RestTemplate restTemplate = new RestTemplate();

        // 반복 횟수 및 요청 간 간격
        int repeatCount = 2;
        long intervalInMillis = 1000; // 1초 간격
        String url = "http://localhost:8080"; // 예시 URL

        for (int j = 0; j < 50; j++) {
            // 반복적으로 요청을 보내고 응답을 출력
            for (int i = 0; i < repeatCount; i++) {
                try {
                    // GET 요청 실행 및 응답 수신
                    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

                    if (response.getStatusCode().is2xxSuccessful()) {
                        System.out.println("Response " + (i + 1) + ": " + response.getBody());
                    } else {
                        System.out.println("Request " + (i + 1) + " failed with status code: " + response.getStatusCode());
                    }

                } catch (HttpClientErrorException e) {
                    System.out.println("Request " + (i + 1) + " failed: " + e.getMessage());
                }
            }

            try {
                Thread.sleep(intervalInMillis); // 1초 대기
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted: " + e.getMessage());
            }

        }
    }
}
