package com.tr.testfw.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope ("cucumber-glue")
public class Context {


    private Map<String, Object> context = new HashMap<>();


   // @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) context.get(key);
    }

    /**
     * @return unmodifiable copy of the context
     */
    public Map<String, Object> getAll(){
        return Collections.unmodifiableMap(context);
    }

    public <T> Context put(String key, T value) {
        context.put(key, value);
        return this;
    }
}
