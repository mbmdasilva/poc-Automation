package com.tr.risk.wco;

import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;

public interface Action<T>{

    void execute();

    T  getResult();


    interface Factory<T, E extends Action<T>> {

        boolean accepts(String actionName);

        E create(Map<String, ?> data);

        static <T, E extends Action<T>> Optional<E> tryCreate(String actionName, Map<String, ?> data) {
            return Factory.get(actionName).map(f -> (E) f.create(data));
        }

        static Optional<Factory> get(String actionName) {
            for (Factory f : ServiceLoader.load(Factory.class))
                if (f.accepts(actionName))
                    return Optional.of(f);

            return Optional.empty();
        }
    }



}
