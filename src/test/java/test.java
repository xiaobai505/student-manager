import com.agoni.dgy.model.po.Menu;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class test {
    public static final String DEFAULT_FORMAT = "#,###.##########";
    private static final int TWO_SCALE = 2;
    private static final double MAX = 1;
    private static final double MIN = -1;
    
    public static String toPrice(BigDecimal price) {
        if (price == null) {
            return BigDecimal.ZERO.setScale(TWO_SCALE, RoundingMode.HALF_UP).toString();
        }
        // 2：    price > 1 ,    -1  > price
        if (new BigDecimal(MAX).compareTo(price) == MAX && new BigDecimal(MIN).compareTo(price) == MIN) {
            // (ps: 1 ~ -1 之前的数字有问题)   EG: 0.21 会变成 .21
            return price.toString();
        }
        // 3：转换千分位
        DecimalFormat df = new DecimalFormat(DEFAULT_FORMAT);
        return df.format(price.doubleValue());
    }
    
    public static void main(String[] args) {
        List<CompletableFuture<Menu>> list = new ArrayList<>();
        CompletableFuture<Menu> one = CompletableFuture.supplyAsync(() -> {
            System.out.println("方法1");
            return Menu.builder().name("方法1").build();
        });
        list.add(one);
        CompletableFuture<Menu> two = CompletableFuture.supplyAsync(() -> {
            System.out.println("方法2");
            return Menu.builder().name("方法2").build();
        });
        list.add(two);
    
        CompletableFuture<Void> future = CompletableFuture.allOf(list.toArray(new CompletableFuture[0]));
    
        CompletableFuture<List> apply = future.thenApply((Menu) -> {
            System.out.printf(Menu.toString());
            return Arrays.asList();
        });
        List list1 = apply.join();
        System.out.printf(list1.toString());
    
    
        //extracted();
    }
    
    private static void extracted() {
        List<Long> list = new ArrayList<>(3);
        list.add(1000l);
        list.add(2000l);
        list.add(3000l);
        FutureTaskWorker<Long,Menu> futureTaskWorker = new FutureTaskWorker<>(list,(e)->getThreadName(e));
        
        long start = System.currentTimeMillis();
        List<Menu> allResult = futureTaskWorker.getAllResult();
        long end = System.currentTimeMillis();
        System.out.println(allResult.toString());
        System.out.println("future(): 耗时" + (end - start) + "ms");
    }
    
    private static CompletableFuture<Menu> getThreadName(long sleepTime) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(sleepTime);
                System.out.println(Thread.currentThread().getName()+"已经睡眠"+sleepTime+"毫秒");
                return Menu.builder().name(sleepTime+"毫秒").build();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
    }
    
    
    
    
    private static CompletableFuture<String> getThreadName() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
                System.out.println(Thread.currentThread().getName()+"已经睡眠"+2000L+"毫秒");
                return Thread.currentThread().getName();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s";
        });
    }
}
