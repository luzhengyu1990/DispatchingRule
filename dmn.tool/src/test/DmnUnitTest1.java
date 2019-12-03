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
			      .putValue("T2_����1", "������ʽ");
			     
		
		// evaluate decision
		DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(ruleSet, variables);	
		assertTrue("", result.getSingleResult() != null);
		System.out.println("Test1 [��᳤����3̨���书��֮��<=1400.0, ���2̨���书��֮��<=1000.0, ������2̨���书��֮��<=900.0, ������#2����Ͷ�˺����2̨���书��֮��<=1000.0] => " + result.getSingleResult().getEntryMap());
		
		/*assertTrue("", result.getSingleResult().getEntry("����״̬").toString().equals("��������"));
		assertTrue("", result.getSingleResult().getEntry("�޶�1").toString().equals("200.0"));
		assertTrue("", result.getSingleResult().getEntry("�޶�2").toString().equals("4"));
		assertTrue("", result.getSingleResult().getEntry("�޶�3").toString().equals("400.0"));*/
	}
}
