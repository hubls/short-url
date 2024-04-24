package sangcompany.shortenurl.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import sangcompany.shortenurl.utils.latelimit.ClientIpUtil;


@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();

        // 정적 리소스 경로를 제외
        if (path.startsWith("/static") || path.startsWith("/resources") || path.startsWith("/js") || path.startsWith("/css") || path.startsWith("/assets")) {
            return true; // 로그 기록하지 않고 계속 진행
        }

        String clientIp = ClientIpUtil.getClientIp(request);

        log.info("[{}][{}][{}]", clientIp, path, request.getMethod());

        return true;
    }
}
