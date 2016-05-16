package com.tr.testfw.stepdef;

import cucumber.api.java.en.Then;

public class ThenStepDef {


   @Then("^the \\(.*\\) \"([^\"]*)\" outcome is \"([^\"]*)\"$")
    public void the_CreateTestCommand_outcome_is(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions



    }

   @Then("^the \\(.*\\) \"([^\"]*)\" result (.*) is equals to \"([^\"]*)\"$")
   public void the_CreateTestCommand_result_name_is_equals_to(String command, String id,String assertResult) throws Throwable {

   }



}

