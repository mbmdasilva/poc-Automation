package com.tr.risk.wco;

import java.util.*;

public interface Domain {

    /**
     * Factory interface for creating objects out of maps with information about them.
     */
    interface Factory<T extends Domain> {

        boolean accepts(String domainName);

        Class getDomainClass();

        /**
         * Parses tables that contain object data and returns objects of the related class populated with its contents
         *
         * @param table a list of maps containing pairs <fieldName, fieldValue> with the contents of the objects
         * @return a collection of objects populated with the information of the table
         */
        default Collection<T> create(final List<Map<String, Object>> table) {
            Collection<T> instances = new ArrayList<>();
            for(Map<String, Object> m : table)
                instances.add(create(m));

            return instances;
        }

        /**
         * Creates an object and populates it with the content of a map
         *
         * @param data a map that contains pairs <fieldName, fieldValue> with the content of the object
         * @return an object populated with the information of the map
         */
        T create(Map<String, Object> data);

        static <T> Optional<T> tryCreate(String domainName, Map<String, ?> data) {
            return Factory.get(domainName).map(f -> (T) f.create(data));
        }

        static Optional<Factory> get(String domainName) {
            for (Factory f : ServiceLoader.load(Factory.class))
                if (f.accepts(domainName))
                    return Optional.of(f);

            return Optional.empty();
        }
    }
}

