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
				.putValue("��ǰʱ��", "2019-11-30T12:00:00")
				.putValue("T1_���з�ʽ", "������ʽ")
				.putValue("T1_�������1����", 600)
				.putValue("T1_�������2����", 500)
				.putValue("T1_���������书��", 100)
				.putValue("T1_Խ���ж�", true)
				.putValue("T2_���з�ʽ", "������ʽ")
				.putValue("T2_�������1����", 500)
				.putValue("T2_�������2����", 400)
				.putValue("T2_����������1����", 500)
				.putValue("T2_����������2����", 400)
				.putValue("T2_�����̱�����", 100)
				.putValue("T2_�ı����ͱ��쳱��", 160)
				.putValue("T2_�����������ᳱ��", 260)
				.putValue("T2_Խ���ж�", true);
						     
		
		// evaluate decision
		DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(ruleSet, variables);	
		System.out.println(result.getSingleResult().getEntryMap());
		
	}
}
