import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 王宁 on 2017/4/19.
 */
public class SocketDemo {
    public static void main(String [] args) throws UnknownHostException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost() ;
        String ip = host.getHostAddress();
        String ipRange = ip.substring(0,ip.lastIndexOf('.'));
        System.out.print(ip);
        System.out.print(ipRange);

        List<String> ips = Collections.synchronizedList(new ArrayList<>());
        //线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,15,60,
                TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        AtomicInteger number = new AtomicInteger();
        for(int i =0;i<255;i++){
            String testIP = ipRange+"."+(i+1);
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    boolean reachable = isReachable(testIP);
                    if (reachable){
                        ips.add(testIP);
                        synchronized (number){
                            System.out.println("success"+number.incrementAndGet()+"个ip测试");
                        }
                    }
                }
            });
        }
        threadPool.shutdown();
        if(threadPool.awaitTermination(1, TimeUnit.HOURS)){
            System.out.println("以下ip可以连接");
            for (String thip : ips){
                System.out.println(thip);
            }
            System.out.println("总共有:" + ips.size() + " 个地址");
        }


    }
    private static boolean isReachable(String ip) {
        try {
            boolean reachable = false;

            Process p = Runtime.getRuntime().exec("ping " + ip);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.length() != 0)
                    sb.append(line + "\r\n");
            }

            //当有time出现的时候，就表示连通了
            reachable = sb.toString().contains("time<");
            br.close();
            return reachable;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }



}
