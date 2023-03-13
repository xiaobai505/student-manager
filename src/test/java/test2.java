import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * test2
 *
 * @author dgy
 * @date 2023/02/16
 */
public class test2 {
    /**
     * 主要
     *
     * @param args arg游戏
     */
    public static void main(String args[]) {
        String str = "fileIds14";
        String pattern = "^[a-z][a-zA-Z0-9]*$";
    
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }
}
