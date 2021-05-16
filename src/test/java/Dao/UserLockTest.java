package Dao;

import p.doctor.utils.UserLock;

public class UserLockTest {
    public static void main(String[] args) {
        UserLock userLock = UserLock.getInstance();
        String userName = "kriw";
        Boolean used = true;
        userLock.put(userName,used);
        userLock.put(userName,used);
        userLock.put(userName,used);
        userLock.put(userName,used);
        userLock.put(userName,used);
        userLock.put(userName,used);

        System.out.println(userLock.get(userName));
        System.out.println(userLock.size());

    }
}
