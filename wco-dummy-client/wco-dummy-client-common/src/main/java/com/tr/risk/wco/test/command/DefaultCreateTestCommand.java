package com.tr.risk.wco.test.command;

import com.tr.risk.wco.Command;
import com.tr.risk.wco.test.DefaultTestDomain;
import com.tr.risk.wco.test.TestDomain;

import javax.transaction.NotSupportedException;
import java.util.Map;
import java.util.ServiceLoader;

public class DefaultCreateTestCommand implements CreateTestCommand {


    private TestDomain testDomain;

    public DefaultCreateTestCommand(TestDomain testDomain) {
        this.testDomain = testDomain;
    }

    public DefaultCreateTestCommand(Map<String, String> arguments, TestDomain testDomain) {
        throw new RuntimeException(new NotSupportedException());
    }

    public void execute() {
    testDomain =new DefaultTestDomain("14225","mmmeme");
    }


    public TestDomain getResult() {
        return testDomain;
    }



    public static class Factory implements Command.Factory<TestDomain, CreateTestCommand> {

        private TestDomain td;

        public Factory() {
            for (TestDomain t  : ServiceLoader.load(TestDomain.class)){
                td=t;
            }

        }

        public boolean accepts(Object something) {
            return something instanceof TestDomain || CreateTestCommand.class.getSimpleName().equals(something);
        }

        @Override
        public CreateTestCommand create(Map<String, String> arguments) {
            //TestDomainConcept instance = // DataTable to Object instance (generic code / Muhammad)


            return new DefaultCreateTestCommand(new DefaultTestDomain("XXXX", "YYYYY"));

        }




        public CreateTestCommand instantiateCreateCommandFor(TestDomain testDomain) {
            return new DefaultCreateTestCommand(testDomain);
        }
    }
}
