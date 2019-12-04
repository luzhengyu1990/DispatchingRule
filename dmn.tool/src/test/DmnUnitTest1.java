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

public class DmnUnitTest1 {
	@Rule
	public DmnEngineRule dmnEngineRule = new DmnEngineRule();

	public DmnEngine dmnEngine;
	public List<DmnDecision> decisionSet;
	  
	@Before
	public void parseDecision() throws Exception {
		InputStream inputStream = new FileInputStream("temp/out1.xml");
	    dmnEngine = dmnEngineRule.getDmnEngine();
	    decisionSet = dmnEngine.parseDecisions(inputStream);
	}
	  
	@Test
	public void testRuleSetSL() {
		DmnDecision ruleSet = DMNDecisionHelper.getDecision("Decision_TransformerAdjust", decisionSet);
		//System.out.println("RuleSet: " + ruleSet.getKey());
		
		VariableMap variables = Variables
				.putValue("当前时间", "2019-11-30T12:00:00")
				.putValue("T1_参数1", "正常方式")
			    .putValue("T2_参数1", "正常方式")
				.putValue("T3_长阳铺变下网", 20)
				.putValue("T3_湍宝线送宝庆潮流", 20)
				.putValue("T3_吉永线送永丰潮流", 30);
			     
		
		// evaluate decision
		DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(ruleSet, variables);	
		System.out.println("Test1 [民丰长阳铺3台主变功率之和<=1400.0, 民丰2台主变功率之和<=1000.0, 长阳铺2台主变功率之和<=900.0, 长阳铺#2主变投运后民丰2台主变功率之和<=1000.0,限额1=true, 限额2=true] => " + result.getSingleResult().getEntryMap());
		
		assertTrue("", (boolean)result.getSingleResult().getEntry("限额1") == true);
	
	}
}
