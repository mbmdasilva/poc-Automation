package com.tr.testfw.stepdef;

import com.tr.risk.wco.Command;
import com.tr.risk.wco.Domain;
import com.tr.testfw.util.Context;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;


public class GivenStepDef {

    //TODO: inject context
    @Autowired
    public Context context;

   @Given("^there is a \\(([^\"]*)\\) \"([^\"]*)\"$")
    public void there_is_a_domain_with_reference(String domainConceptClass, String reference) throws Throwable {
        there_is_a_domain_with_reference_and_attributes(domainConceptClass, reference, DataTable.create(Collections.emptyList()));
    }

    @Given("^there is a \\((.*)\\) \"([^\"]*)\" with attributes$")
    public void there_is_a_domain_with_reference_and_attributes(String domainConceptClass, String reference, DataTable data) throws Throwable {
        try{
        Object instance = Domain.Factory.tryCreate(domainConceptClass, data.asMap(String.class, String.class)).get();
            System.out.println("Object before execute: " + instance);
        Command createCommand = Command.Factory.tryToInstantiateCreateCommandFor(instance).get();
        createCommand.execute();
        instance = createCommand.getResult();
            System.out.println("Object after execute: " + instance);

        context = new Context();
        context.put(reference,instance);

      } catch (Exception e) {
        System.out.println("exception thrown");
        throw e;
      }



    }

//
//   public static void main(String[] args) throws Throwable {
//
//        new GivenStepDef().there_is_a_domain_with_reference("User", "ref");
//    }


}
