package com.test.companyname.seg2505;


import java.util.HashMap;

public class Dataset<E> {
    private HashMap<String,E> map = new HashMap<String,E>();

    public E get(String name) {return map.get(name);}

    public void edit(String name, E entry) {
        map.remove(name);
        map.put(name,entry);
    }

    public boolean create(String name, E entry) {
        if (map.containsKey(name))
            return false;
        map.put(name,entry);
        return true;
    }

    public void remove(String name) {
        map.remove(name);
    }
}
