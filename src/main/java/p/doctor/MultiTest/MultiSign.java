package p.doctor.MultiTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MultiSign {
    public static void main(String[] args) throws InterruptedException {
        //测试前记得把RelationController当中的doSignNewExam方法的@PostMapping改为@GetMapping
    CountDownLatch countDownLatch = new CountDownLatch(1);
    for (int i = 0; i < 10; i++) {
        new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + "准备开始更新！");
                String answer = "";
                //两个参数
                String userName = "kriw";
                String examName = "";
                Random random = new Random();
                if (random.nextInt()%2==0) examName="英语四级";
                else examName="英语六级";
                String param = "userName="+ userName +"&examName="+examName;
                //去申请链接
                URL url = new URL("http://localhost:4000/relation/signNewExam.do?" + param);
                URLConnection urlConnection = url.openConnection();
                urlConnection.connect();

                //读取返回的结果
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    answer += line;
                }
                reader.close();
                System.out.println(Thread.currentThread().getName() + "更新啦！结果为：" + answer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    Thread.sleep(2000);
    countDownLatch.countDown();
}
}

