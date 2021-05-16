package p.doctor.MultiTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MultiExamUpdate {
    public static void main(String[] args) throws InterruptedException {
        //测试前记得把RelationController当中的doSignNewExam方法的@PostMapping改为@GetMapping
        CountDownLatch countDownLatch = new CountDownLatch(1);


        countDownLatch.countDown();
    }
}
