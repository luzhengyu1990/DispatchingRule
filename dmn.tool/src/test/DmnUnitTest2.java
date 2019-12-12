package test;

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

public class DmnUnitTest2 {
	@Rule
	public DmnEngineRule dmnEngineRule = new DmnEngineRule();

	public DmnEngine dmnEngine;
	public List<DmnDecision> decisionSet;
	  
	@Before
	public void parseDecision() throws Exception {
		InputStream inputStream = new FileInputStream("testdata/out2.xml");
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
				.putValue("T1_民丰主变1功率", 600)
				.putValue("T1_民丰主变2功率", 500)
				.putValue("T1_长阳铺主变功率", 100)
				.putValue("T1_越界判断", true)
				.putValue("T2_运行方式", "正常方式")
				.putValue("T2_民丰主变1功率", 500)
				.putValue("T2_民丰主变2功率", 400)
				.putValue("T2_长阳铺主变1功率", 500)
				.putValue("T2_长阳铺主变2功率", 400)
				.putValue("T2_长阳铺变下网", 100)
				.putValue("T2_湍宝线送宝庆潮流", 160)
				.putValue("T2_吉永线送永丰潮流", 260)
				.putValue("T2_越界判断", true);
						     
		
		// evaluate decision
		DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(ruleSet, variables);	
		System.out.println(result.getSingleResult().getEntryMap());
		
	}
}
