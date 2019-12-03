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
			      .putValue("T2_参数1", "正常方式");
			     
		
		// evaluate decision
		DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(ruleSet, variables);	
		assertTrue("", result.getSingleResult() != null);
		System.out.println("Test1 [民丰长阳铺3台主变功率之和<=1400.0, 民丰2台主变功率之和<=1000.0, 长阳铺2台主变功率之和<=900.0, 长阳铺#2主变投运后民丰2台主变功率之和<=1000.0] => " + result.getSingleResult().getEntryMap());
		
		/*assertTrue("", result.getSingleResult().getEntry("运行状态").toString().equals("正常运行"));
		assertTrue("", result.getSingleResult().getEntry("限额1").toString().equals("200.0"));
		assertTrue("", result.getSingleResult().getEntry("限额2").toString().equals("4"));
		assertTrue("", result.getSingleResult().getEntry("限额3").toString().equals("400.0"));*/
	}
}
