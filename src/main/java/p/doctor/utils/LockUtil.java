package p.doctor.utils;

import java.util.concurrent.ConcurrentHashMap;

public final class LockUtil {
    private static final ConcurrentHashMap<String,Object[]> lockMap = new ConcurrentHashMap<>();

    public static Object[] getLockObject(String key){
        Object[] lock = lockMap.get(key);
        if (lock==null){//需要初始化
            lock = new Object[0];
            if (lockMap.putIfAbsent(key,lock)==null){//发生了并发
                return lockMap.get(key);
            };
        }
        return lockMap.get(key);
    }

}

