import com.agoni.dgy.model.po.Menu;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class test {
    public static void main(String[] args) {
        List res=new ArrayList();
        List<CompletableFuture<Menu>> list = new ArrayList<>();
        CompletableFuture<Menu> one = CompletableFuture.supplyAsync(() -> {
            printimeAndThread("方法1");
            return Menu.builder().name("方法1").build();
        }).thenApply(Menu -> {
            printimeAndThread("方法1");
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
    
    public static void printimeAndThread(String tag){
        String res=new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(res);
    }
}
