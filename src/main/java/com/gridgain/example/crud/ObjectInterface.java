package com.gridgain.example.crud;

import java.util.Collection;

public interface ObjectInterface {
    Collection<Object> getObjects();

    Object modifyObject(long id, Object object);

    Object getObject(long id);

    boolean deleteObject(long id);
}
