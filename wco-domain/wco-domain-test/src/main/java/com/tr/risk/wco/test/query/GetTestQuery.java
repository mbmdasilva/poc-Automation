package com.tr.risk.wco.test.query;


import com.tr.risk.wco.Query;
import com.tr.risk.wco.test.TestDomain;


public interface GetTestQuery extends Query<TestDomain> {

    String getId();

}
