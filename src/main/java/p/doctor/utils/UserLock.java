package p.doctor.utils;

import java.util.HashMap;

public class UserLock extends HashMap<String,Boolean>{
    private UserLock(){};
    private volatile static UserLock userLock;
    public static UserLock getInstance(){
        if (userLock==null){
            synchronized (UserLock.class){
                if (userLock==null) userLock = new UserLock();
                return userLock;
            }
        }
        return  userLock;
    }
}
