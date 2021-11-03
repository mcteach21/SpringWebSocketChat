package mc.apps.springboot.modele;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

@Component
public class ChatUsersManager {

    private final Map<String, Object> activeUsers;
//    private final List<ActiveUserChangeListener> listeners;
//    private final ThreadPoolExecutor notifyPool;

    private ChatUsersManager() {
        activeUsers = new ConcurrentHashMap<>();
//        listeners = new CopyOnWriteArrayList<>();
//        notifyPool = new ThreadPoolExecutor(1, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
    }

    public void addUser(String userName, String remoteAddress){
        activeUsers.put(userName, remoteAddress);

        //notify all listeners
//        notifyPool.submit(() -> listeners.forEach(ActiveUserChangeListener::notifyActiveUserChange));
    }
    public void removeUser(String userName){
        activeUsers.remove(userName);

        //notify all listeners
//        notifyPool.submit(() -> listeners.forEach(ActiveUserChangeListener::notifyActiveUserChange));
    }
    public Set<String> getAllUsers(){
        return activeUsers.keySet();
    }
}
