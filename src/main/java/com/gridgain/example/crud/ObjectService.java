package com.gridgain.example.crud;

import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.cache.Cache;
import java.util.Collection;

@Service
@Slf4j
public class ObjectService implements ObjectInterface {

    private Ignite ignite;

    @Override
    public Collection<Object> getObjects() {
        log.info("getObjects");
        return null;
    }

    @Override
    public Object modifyObject(long id, Object object) {
        log.info("modifyObject {} with id = {}", object, id);
        Cache<Long, Object> cache = ignite.getOrCreateCache("object_cache");
        cache.put(id, object);
        return cache.get(id);
    }

    @Override
    public Object getObject(long id) {
        log.info("getObject with id = {}", id);
        Cache<Long, Object> cache = ignite.getOrCreateCache("object_cache");
        return cache.get(id);
    }

    @Override
    public boolean deleteObject(long id) {
        log.info("deleteObject with id = {}", id);
        Cache<Long, Object> cache = ignite.getOrCreateCache("object_cache");
        return cache.remove(id);
    }

    @Autowired
    public void setIgnite(Ignite ignite) {
        this.ignite = ignite;
    }
}
