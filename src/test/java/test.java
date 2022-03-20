import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Slf4j
public class test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String redirectUrl ="http://225h70r656.wicp.vip/wechat/invoke";
        String encoder = encoder(redirectUrl);
        log.info(encoder);
    }


    public static String encoder(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url, "UTF-8");
    }


}
