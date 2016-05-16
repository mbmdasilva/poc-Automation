package com.tr.risk.wco;

import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;


public interface Command<T> extends Action<T> {


    interface  Factory <T,C extends Command<T>> {

        boolean accepts(Object something);

        C create(Map<String, String> arguments);

        C instantiateCreateCommandFor(T instance);

        static <T,C extends Command<T>> Optional<C> tryToInstantiateCreateCommandFor(T instance) {
            //noinspection unchecked
            return Factory.get(instance).map(f -> (C) f.instantiateCreateCommandFor(instance));
        }


        static <T, C extends Command<T>> Optional<C> tryCreate(String commandClass, Map<String, String> arguments) {
            //noinspection unchecked
            return Factory.get(commandClass).map(f -> (C) f.create(arguments));
        }

        static <T,C extends Command<T>> Optional<Factory<T,C>> get(Object something) {
            for (Factory f : ServiceLoader.load(Factory.class))
                if (f.accepts(something)) {
                    //noinspection unchecked
                    return Optional.of(f);
                }

            return Optional.empty();
        }
    }
}
