package com.tr.testfw.stepdef;


import com.tr.risk.wco.Command;
import com.tr.testfw.util.Context;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class WhenStepDef {
    @Autowired
    public Context context;

    @When("^the \\((.*)\\) \"([^\"]*)\" executes \\((.*)\\) \"([^\"]*)\" with attributes$")
    public void the_User_executes_CreateTestCommand_with_attributes(String userClass, String userRef, String actionClass, String actionRef, DataTable data) throws Throwable {


        System.out.println("WHEEENNN");
//            GivenStepDef.context.get(actionRef);
        Optional<Command<Object>> command = Command.Factory.tryCreate(actionClass, data.asMap(String.class, String.class));
        if (command.isPresent()) {
            System.out.println("command found");
            command.get().execute();
            System.out.println("Object after execute: " + command);
            //context.put(userRef,command);
        } else {
            System.out.println("command not found");
//            Optional<Command<Object>> query = Query.Factory.tryCreate(actionClass, data.asMap(String.class, String.class));
//            if (query.isPresent()) {
//                query.get().execute();
//                GivenStepDef.context.put(actionRef, query);


        }

    }


}



