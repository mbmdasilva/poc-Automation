package com.tr.risk.wco.action;

import com.tr.risk.wco.Action;


import java.util.Map;

public class DefaultAction implements Action {

    private final String id;
    private final String name;

    public DefaultAction(String id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public void execute() {

    }

    @Override
    public Object getResult() {
        return null;
    }

    public static class Factory {

        public boolean accepts(String actionName) {
            return actionName.equals(Action.class.getSimpleName());
        }

        public Action create(Map<String, ?> data) {
            return new DefaultAction("tr", "Mateus");
        }

    }

    @Override
    public String toString() {
        return "User{name:" + name + ", id:" + id + "}";
    }
}