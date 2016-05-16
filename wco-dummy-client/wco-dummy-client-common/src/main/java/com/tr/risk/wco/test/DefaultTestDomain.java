package com.tr.risk.wco.test;

import com.tr.risk.wco.BaseDomainFactory;
import com.tr.risk.wco.Domain;
import com.tr.risk.wco.admin.User;

import java.util.Map;


public class DefaultTestDomain implements TestDomain {

    private String id;
    private String name;

    public DefaultTestDomain() {

    }

    public DefaultTestDomain(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getID() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestDomain{name:"+name+", id:"+id+"}";
    }

    public static class Factory extends BaseDomainFactory<TestDomain> {

        @Override
        public boolean accepts(String domainName) {
            return TestDomain.class.getSimpleName().equals(domainName);
        }

        @Override
        public Class getDomainClass() {
            return DefaultTestDomain.class;
        }

    }


}
