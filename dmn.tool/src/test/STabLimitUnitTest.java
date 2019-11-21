package test;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.test.DmnEngineRule;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import cn.sg.dmn.tool.DMNDecisionHelper;

public class STabLimitUnitTest {
	@Rule
	public DmnEngineRule dmnEngineRule = new DmnEngineRule();

	public DmnEngine dmnEngine;
	public List<DmnDecision> decisionSet;
	  
	@Before
	public void parseDecision() throws Exception {
		InputStream inputStream = new FileInputStream("testdata/StabilityLimits.xml");
	    dmnEngine = dmnEngineRule.getDmnEngine();
	    decisionSet = dmnEngine.parseDecisions(inputStream);
	}
	  
	@Test
	public void testRuleSetSL() {
		DmnDecision ruleSet = DMNDecisionHelper.getDecision("Decision_StabilityLimit", decisionSet);
		//System.out.println("RuleSet: " + ruleSet.getKey());
		
		VariableMap variables = Variables
			      .putValue("当前时间", "2019-11-30T12:00:00")
			      .putValue("T1_参数1", "9.0")       // T1.OptState "Õý³£ÔËÐÐ", T1.Limit1 200
			      .putValue("T1_参数2", "1.0")
			      .putValue("T2_参数1", "120")       // T2.Limit2 5
			      .putValue("T3_参数1", "90.0")      // T3.Limit2 4
			      .putValue("T3_参数2", "4")
			      .putValue("T4_参数1", "8.0")       // T4.Limit3 300
			      .putValue("T4_参数2", "1.1")
			      .putValue("T5_参数1", "16.0")      // T5.Limit3 400
			      .putValue("T5_参数2", "1.0");      // T6.Limit3 400
		
		// evaluate decision
		DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(ruleSet, variables);	
		assertTrue("", result.getSingleResult() != null);
		System.out.println("Test1 [运行状态=正常运行, 限额3=400.0, 限额1=200.0, 限额2=4] => " + result.getSingleResult().getEntryMap());
		
		assertTrue("", result.getSingleResult().getEntry("运行状态").toString().equals("正常运行"));
		assertTrue("", result.getSingleResult().getEntry("限额1").toString().equals("200.0"));
		assertTrue("", result.getSingleResult().getEntry("限额2").toString().equals("4"));
		assertTrue("", result.getSingleResult().getEntry("限额3").toString().equals("400.0"));
	}
}
