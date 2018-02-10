package org.zhxie.firstappdemo.repository;


import org.springframework.stereotype.Repository;
import org.zhxie.firstappdemo.domain.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {

    private Map<Integer,User> repository = new ConcurrentHashMap<Integer,User>();
    private final static AtomicInteger idGenerator = new AtomicInteger();

    public boolean save(User user) {
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }
}
