import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String redirectUrl ="http://225h70r656.wicp.vip/wechat/invoke";
        String encode = URLEncoder.encode(redirectUrl, "UTF-8");
        System.out.printf(encode);
    }
}
