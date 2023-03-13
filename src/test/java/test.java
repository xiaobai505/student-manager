import com.agoni.dgy.model.po.Menu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;


/**
 * 测试
 *
 * @author dgy
 * @date 2023/02/16
 */
@Slf4j
@SpringBootTest
public class test {
    
    /**
     * 主要
     *
     * @param args arg游戏
     */
    public static void main(String[] args) {
        List res=new ArrayList();
        List<CompletableFuture<Menu>> list = new ArrayList<>();
        CompletableFuture<Menu> one = CompletableFuture.supplyAsync(() -> {
            printimeAndThread("方法1");
            printimeAndThread("方法2");
            printimeAndThread("方法13");
            printimeAndThread("方法14");
            printimeAndThread("方法15");
            return Menu.builder().name("方法1").build();
        }).thenApply(Menu -> {
            res.add(Menu);
            return Menu;
        });
        list.add(one);
        CompletableFuture<Menu> two = CompletableFuture.supplyAsync(() -> {
            printimeAndThread("方法2");
            return Menu.builder().name("方法2").build();
        }).thenApply(Menu -> {
            printimeAndThread("方法2");
            res.add(Menu);
            return Menu;
        });
        list.add(two);
    
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        printimeAndThread(res.toString());
        
    }
    
    
    /**
     * printime和线程
     *
     * @param tag 标签
     */
    public static void printimeAndThread(String tag){
        String res=new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(res);
    
        extracted();
    }
    
    private static void extracted() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("i"+i);
        }
    }
    
    
    
}
