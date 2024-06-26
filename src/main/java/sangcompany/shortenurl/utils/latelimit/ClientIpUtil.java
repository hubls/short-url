package sangcompany.shortenurl.utils.latelimit;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;

public class ClientIpUtil {
    private static final String[] IP_HEADER_CANDIDATES = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
    };

    /**
     * @param request current HTTP request
     * @return (String) client Ip
     * @apiNote 'X-Forwarded-For' 참고: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Forwarded-For
     */
    public static String getClientIp(HttpServletRequest request) {
        return Arrays.stream(IP_HEADER_CANDIDATES)
                .map(request::getHeader)

                .filter(ipAddress -> ipAddress != null && !ipAddress.isEmpty() && !"unknown".equalsIgnoreCase(ipAddress))
                .map(ipAddress -> ipAddress.split(",")[0])
                .findFirst()

                .orElseGet(request::getRemoteAddr);
    }
}
