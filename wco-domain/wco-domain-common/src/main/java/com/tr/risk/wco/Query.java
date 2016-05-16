package com.tr.risk.wco;

import java.util.Optional;
import java.util.ServiceLoader;


public interface Query<T> extends Action<T> {


    interface Factory<T, Q extends Query<T>> {

        boolean accepts(Object instance);

        static <T, Q extends Query<T>> Optional<Factory<T, Q>> get(T instance) {
            for (Factory f : ServiceLoader.load(Factory.class))
                if (f.accepts(instance)) {
                    //noinspection unchecked
                    return Optional.of(f);
                }

            return Optional.empty();
        }
    }
}
