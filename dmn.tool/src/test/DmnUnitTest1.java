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
		InputStream inputStream = new FileInputStream("testdata/out1.xml");
	    dmnEngine = dmnEngineRule.getDmnEngine();
	    decisionSet = dmnEngine.parseDecisions(inputStream);
	}
	  
	@Test
	public void testRuleSetSL() {
		DmnDecision ruleSet = DMNDecisionHelper.getDecision("Decision_TransformerAdjust", decisionSet);
		//System.out.println("RuleSet: " + ruleSet.getKey());
		
		VariableMap variables = Variables
				.putValue("当前时间", "2019-11-30T12:00:00")
				.putValue("T1_运行方式", "正常方式")
				.putValue("T1_民丰长阳铺3台主变功率之和", 1400)
				.putValue("T1_民丰2台主变功率之和", 1000)
				.putValue("T2_运行方式", "正常方式")
				.putValue("T2_长阳铺2台主变功率之和", 900)
				.putValue("T2_民丰2台主变功率之和", 1000)
				.putValue("T3_长阳铺变下网", 50)
				.putValue("T3_湍宝线送宝庆潮流", 20)
				.putValue("T3_吉永线送永丰潮流", 30);			     
		
		// evaluate decision
		DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(ruleSet, variables);	
		System.out.println("Test1 [T1越界结果=正常运行, T5越界结果=正常运行] => " + result.getSingleResult().getEntryMap());
		
		assertTrue("", result.getSingleResult().getEntry("T5越界结果").toString().equals("正常运行"));
	
	}
}
