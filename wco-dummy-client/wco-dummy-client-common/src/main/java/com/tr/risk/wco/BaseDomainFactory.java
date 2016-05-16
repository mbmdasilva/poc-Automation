package com.tr.risk.wco;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

//TODO: find out a better place for this code. This has nothing to do with product/WCO code at all
// so it should not be in the domain modules
public abstract class BaseDomainFactory<T extends Domain> implements Domain.Factory<T> {

    /**
     * Creates an object and populates it with the content of a map
     *
     * @param data a map that contains pairs <fieldName, fieldValue> with the content of the object
     * @return an object populated with the information of the map
     */
    public T create(Map<String, Object> data) {
        try {
            return dataTableRowToObject(data, getDomainClass());

        } catch (IOException e) { //TODO: better ways to handle exceptions ;-)
            throw new RuntimeException(e);
        }
    }

    <T> T dataTableRowToObject(Map<String, ?> m, Class clazz) throws IOException {
        Map<String, Object> to = new HashMap<>();
        m.entrySet().stream().filter(e -> e.getKey().startsWith(clazz.getSimpleName() + ".")).forEach(e -> dataTableRowToObject(e.getKey().substring(e.getKey().indexOf('.') + 1), e.getValue(), to));
        ObjectMapper mapper = new ObjectMapper();
        //mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = mapper.writeValueAsString(to);
        //noinspection unchecked
        return (T) mapper.readValue(json, clazz);
    }

    Map<String, Object> dataTableRowToObject(String key, Object value, Map<String, Object> m) {
        if (key.indexOf('.') > 0) {
            String k = key.substring(0, key.indexOf('.'));
            if (k.indexOf('[') > 0) {
                k = key.substring(0, key.indexOf('['));
                int i = Integer.parseInt(key.substring(key.indexOf('[') + 1, key.indexOf(']')));
                List<Object> v = (List<Object>) m.getOrDefault(k, new ArrayList<>());
                IntStream.range(v.size() - 1, i).forEach(x -> v.add(new HashMap<>())); // grow the list if required
                v.set(i, dataTableRowToObject(key.substring(key.indexOf('.') + 1), value, (Map<String, Object>) v.get(i)));
                m.put(k, v);
            } else {
                Map<String, Object> v = (Map<String, Object>) m.getOrDefault(k, new HashMap<>());
                m.put(k, dataTableRowToObject(key.substring(key.indexOf('.') + 1), value, v));
            }
        } else
            m.put(key, value);
        return m;
    }

    //INFO: these following methods are not strictly necessary, but here for testing purposes ;-)
    Map<String, Object> objectToDataTableRow(String prefix, Collection<Object> c) {
        Map<String, Object> m = new HashMap<>();
        Iterator it = c.iterator();
        for (int i = 0; it.hasNext(); i++) {
            Object o = it.next();
            if (o instanceof Map)
                m.putAll(objectToDataTableRow(prefix + "[" + i + "].", (Map<String, Object>) o));
        }
        if (m.isEmpty()) // collection of primitivies
            m.put(prefix, c);
        return m;
    }

    Map<String, Object> objectToDataTableRow(String prefix, Map<String, Object> map) {
        Map<String, Object> m = new HashMap<>();
        map.entrySet().stream().forEach(e -> {
            if (e.getValue() instanceof Map)
                objectToDataTableRow(e.getKey() + ".", (Map<String, Object>) e.getValue()).forEach((k, v) -> m.put(prefix + k, v));
            else if (e.getValue() instanceof Collection) {
                Map<String, Object> flatten = objectToDataTableRow(e.getKey(), (Collection) e.getValue());
                for (Map.Entry entry : flatten.entrySet())
                    m.put(prefix + entry.getKey(), entry.getValue());
            } else
                m.put(prefix + e.getKey(), e.getValue());
        });
        return m;
    }

}
