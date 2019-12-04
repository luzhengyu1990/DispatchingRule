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
				.putValue("��ǰʱ��", "2019-11-30T12:00:00")
				.putValue("T1_����1", "������ʽ")
			    .putValue("T2_����1", "������ʽ")
				.putValue("T3_�����̱�����", 20)
				.putValue("T3_�ı����ͱ��쳱��", 20)
				.putValue("T3_�����������ᳱ��", 30);
			     
		
		// evaluate decision
		DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(ruleSet, variables);	
		System.out.println("Test1 [��᳤����3̨���书��֮��<=1400.0, ���2̨���书��֮��<=1000.0, ������2̨���书��֮��<=900.0, ������#2����Ͷ�˺����2̨���书��֮��<=1000.0,�޶�1=true, �޶�2=true] => " + result.getSingleResult().getEntryMap());
		
		assertTrue("", (boolean)result.getSingleResult().getEntry("�޶�1") == true);
	
	}
}
