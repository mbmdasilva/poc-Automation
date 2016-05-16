package com.tr.risk.wco.admin;


import com.tr.risk.wco.BaseDomainFactory;
import com.tr.risk.wco.Domain;

import java.util.Map;



public class DefaultUser implements User {

    private String id;
    private String name;

    public DefaultUser() {
    }

    public DefaultUser(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public DefaultUser(com.thomsonreuters.grc.fsp.ums.domain.User user) {
        this.id = user.getId();
        this.name = user.getFullName();
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Factory extends BaseDomainFactory<User> {

        @Override
        public boolean accepts(String domainName) {
            return User.class.getSimpleName().equals(domainName);
        }

        @Override
        public Class getDomainClass() {
            return DefaultUser.class;
        }
    }

    @Override
    public String toString() {
        return "User{name:"+name+", id:"+id+"}";
    }

}
