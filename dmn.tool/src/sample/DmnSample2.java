package sample;

import org.camunda.bpm.model.dmn.HitPolicy;
import org.camunda.bpm.model.dmn.instance.Decision;
import org.camunda.bpm.model.dmn.instance.DecisionTable;
import org.camunda.bpm.model.dmn.instance.Input;
import org.camunda.bpm.model.dmn.instance.Rule;

import cn.sg.dmn.tool.DmnXmlModelHelper;

public class DmnSample2 {

	public static void main(String[] args) {
		DmnXmlModelHelper dmnHelper = new DmnXmlModelHelper();

		/*
		 * DTable Decision_T1
		 */
		Decision d1 = dmnHelper.createDecision("Decision_T1", "T1 RuleSet");

		DecisionTable dt1 = dmnHelper.addDecisionTable("DTable_T1", HitPolicy.FIRST, d1);

		Input d1_in1 = dmnHelper.addInput("T1_����1", "���з�ʽ", dt1);
		Input d1_in2 = dmnHelper.addInput("T1_P1", "�������1����", dt1);
		Input d1_in3 = dmnHelper.addInput("T1_P2", "�������2����", dt1);
		Input d1_in4 = dmnHelper.addInput("T1_P3", "���������书��", dt1);
		Input d1_in5 = dmnHelper.addInput("T1_Input1", "Խ���ж�", dt1);

		dmnHelper.addInputExpression("InExpression_T1_1", "string", "T1_���з�ʽ", d1_in1);
		dmnHelper.addInputExpression("InExpression_T1_2", "double", "T1_�������1����", d1_in2);
		dmnHelper.addInputExpression("InExpression_T1_3", "double", "T1_�������2����", d1_in3);
		dmnHelper.addInputExpression("InExpression_T1_4", "double", "T1_���������书��", d1_in4);
		dmnHelper.addInputExpression("InExpression_T1_5", "double", "T1_Խ���ж�", d1_in5);

		dmnHelper.addOutput("T1_output1", "Խ����", "T1_Խ����", "string", dt1);

		d1_in5.setCamundaInputVariable("T1_�������1���� + T1_�������2���� + T1_���������书��");
		
		Rule d1_rule1 = dmnHelper.addRule("Rule_T1_1", "T1 Rule 1", "T1 Rule 1", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R1_1", "\'������ʽ\'", d1_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R1_2", "", d1_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R1_3", "", d1_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R1_4", "", d1_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R1_5", ">1400", d1_rule1);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R1_1", "\'��ᡢ������3̨���书��֮��Խ��\'", d1_rule1);

		d1_in5.setCamundaInputVariable("T1_�������1���� + T1_�������2���� ");
		
		Rule d1_rule2 = dmnHelper.addRule("Rule_T1_2", "T1 Rule 2", "T1 Rule 2", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R2_1", "\'������ʽ\'", d1_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R2_2", "", d1_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R2_3", "", d1_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R2_4", "", d1_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R2_5", ">1000", d1_rule2);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R2_1", "\'���2̨���书��֮��Խ��\'", d1_rule2);

		d1_in5.setCamundaInputVariable("T1_�������1���� + T1_�������2���� + T1_���������书��");
		
		Rule d1_rule3 = dmnHelper.addRule("Rule_T1_3", "T1 Rule 3", "T1 Rule 3", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R3_1", "\'�����һ̨����ͣ��\'", d1_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R3_2", "", d1_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R3_3", "", d1_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R3_4", "", d1_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R3_5", ">950", d1_rule3);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R3_1", "\'��ᡢ������3̨���书��֮��Խ��\'", d1_rule3);

		d1_in5.setCamundaInputVariable("T1_�������1���� + T1_�������2���� ");
		
		Rule d1_rule4 = dmnHelper.addRule("Rule_T1_4", "T1 Rule 4", "T1 Rule 4", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R4_1", "\'�����һ̨����ͣ��\'", d1_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R4_2", "", d1_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R4_3", "", d1_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R4_4", "", d1_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R4_5", ">500", d1_rule4);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R4_1", "\'���2̨���书��֮��Խ��\'", d1_rule4);
		
		d1_in5.setCamundaInputVariable("T1_�������1���� + T1_�������2���� ");

		Rule d1_rule5 = dmnHelper.addRule("Rule_T1_5", "T1 Rule 5", "T1 Rule 5", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R5_1", "\'����������ͣ��\'", d1_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R5_2", "", d1_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R5_3", "", d1_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R5_4", "", d1_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R5_5", ">950", d1_rule5);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R5_1", "\'���2̨���书��֮��Խ��\'", d1_rule5);
		
		d1_in5.setCamundaInputVariable("T1_�������1���� + T1_�������2���� + T1_���������书��");
		
		Rule d1_rule6 = dmnHelper.addRule("Rule_T1_6", "T1 Rule 6", "T1 Rule 6", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R6_1", "", d1_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R6_2", "", d1_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R6_3", "", d1_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R6_4", "", d1_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R6_5", "", d1_rule6);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R6_1", "\'��������\'", d1_rule6);

		/*
		 * DTable Decision_T2
		 */
		Decision d2 = dmnHelper.createDecision("Decision_T2", "T2 RuleSet");

		DecisionTable dt2 = dmnHelper.addDecisionTable("DTable_T2", HitPolicy.FIRST, d2);

		Input d2_in1 = dmnHelper.addInput("T2_����1", "���з�ʽ", dt2);
		Input d2_in2 = dmnHelper.addInput("T2_P1", "�������1����", dt2);
		Input d2_in3 = dmnHelper.addInput("T2_P2", "�������2����", dt2);
		Input d2_in4 = dmnHelper.addInput("T2_P3", "����������1����", dt2);
		Input d2_in5 = dmnHelper.addInput("T2_P4", "����������2����", dt2);
		Input d2_in6 = dmnHelper.addInput("T2_P5", "�����̱�����", dt2);
		Input d2_in7 = dmnHelper.addInput("T2_P6", "�ı����ͱ��쳱��", dt2);
		Input d2_in8 = dmnHelper.addInput("T2_P7", "�����������ᳱ��", dt2);
		Input d2_in9 = dmnHelper.addInput("T2_Input1", "Խ���ж�", dt2);

		dmnHelper.addInputExpression("InExpression_T2_1", "string", "T2_���з�ʽ", d2_in1);
		dmnHelper.addInputExpression("InExpression_T2_2", "double", "T2_�������1����", d2_in2);
		dmnHelper.addInputExpression("InExpression_T2_3", "double", "T2_�������2����", d2_in3);
		dmnHelper.addInputExpression("InExpression_T2_4", "double", "T2_����������1����", d2_in4);
		dmnHelper.addInputExpression("InExpression_T2_5", "double", "T2_����������2����", d2_in5);
		dmnHelper.addInputExpression("InExpression_T2_6", "double", "T2_�����̱�����", d2_in6);
		dmnHelper.addInputExpression("InExpression_T2_7", "double", "T2_�ı����ͱ��쳱��", d2_in7);
		dmnHelper.addInputExpression("InExpression_T2_8", "double", "T2_�����������ᳱ��", d2_in8);
		dmnHelper.addInputExpression("InExpression_T2_9", "double", "T2_Խ���ж�", d2_in9);

		dmnHelper.addOutput("T2_output1", "Խ����", "T2_Խ����", "string", dt2);

		d2_in9.setCamundaInputVariable("T2_�������1���� + T2_�������2����");
		
		Rule d2_rule1 = dmnHelper.addRule("Rule_T2_1", "T2 Rule 1", "T2 Rule 1", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_1", "\'������ʽ\'", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_2", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_3", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_4", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_5", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_6", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_7", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_8", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_9", ">1000", d2_rule1);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R1_1", "\'���2̨���书��֮��Խ��\'", d2_rule1);

		d2_in9.setCamundaInputVariable("T2_����������1���� + T2_����������2����");
		
		Rule d2_rule2 = dmnHelper.addRule("Rule_T2_2", "T2 Rule 2", "T2 Rule 2", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_1", "\'������ʽ\'", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_2", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_3", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_4", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_5", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_6", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_7", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_8", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_9", ">900", d2_rule2);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R2_1", "\'������2̨���书��֮��Խ��\'", d2_rule2);

		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.1 + T2_�ı����ͱ��쳱��");
		
		Rule d2_rule3 = dmnHelper.addRule("Rule_T2_3", "T2 Rule 3", "T2 Rule 3", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_1", "\'������ʽ\'", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_2", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_3", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_4", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_5", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_6", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_7", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_8", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_9", ">260", d2_rule3);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R3_1", "\'�����̱���������������10%+�ı����ͱ��죨�Ľ�����������֮��Խ��\'", d2_rule3);

		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.07 + T2_�����������ᳱ��");
		
		Rule d2_rule4 = dmnHelper.addRule("Rule_T2_4", "T2 Rule 4", "T2 Rule 4", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_1", "\'������ʽ\'", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_2", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_3", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_4", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_5", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_6", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_7", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_8", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_9", ">260", d2_rule4);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R4_1", "\'�����̱���������������7%+�����������ᣨ���ǣ���������֮��Խ��\'", d2_rule4);

		d2_in9.setCamundaInputVariable("T2_�������1���� + T2_�������2����");
		
		Rule d2_rule5 = dmnHelper.addRule("Rule_T2_5", "T2 Rule 5", "T2 Rule 5", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_1", "\'�����һ̨����ͣ��\'", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_2", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_3", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_4", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_5", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_6", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_7", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_8", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_9", ">500", d2_rule5);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R5_1", "\'���2̨���书��֮��Խ��\'", d2_rule5);

		d2_in9.setCamundaInputVariable("T2_����������1���� + T2_����������2����");
		
		Rule d2_rule6 = dmnHelper.addRule("Rule_T2_6", "T2 Rule 6", "T2 Rule 6", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_1", "\'�����һ̨����ͣ��\'", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_2", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_3", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_4", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_5", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_6", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_7", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_8", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_9", ">900", d2_rule6);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R6_1", "\'������2̨���书��֮��Խ��\'", d2_rule6);

		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.1 + T2_�ı����ͱ��쳱��");
		
		Rule d2_rule7 = dmnHelper.addRule("Rule_T2_7", "T2 Rule 7", "T2 Rule 7", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_1", "\'�����һ̨����ͣ��\'", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_2", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_3", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_4", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_5", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_6", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_7", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_8", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_9", ">260", d2_rule7);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R7_1", "\'�����̱���������������10%+�ı����ͱ��죨�Ľ�����������֮��Խ��\'", d2_rule7);

		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.07 + T2_�����������ᳱ��");
		
		Rule d2_rule8 = dmnHelper.addRule("Rule_T2_8", "T2 Rule 8", "T2 Rule 8", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_1", "\'�����һ̨����ͣ��\'", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_2", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_3", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_4", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_5", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_6", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_7", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_8", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_9", ">260", d2_rule8);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R8_1", "\'�����̱���������������7%+�����������ᣨ���ǣ���������֮��Խ��\'", d2_rule8);

		d2_in9.setCamundaInputVariable("T2_�������1���� + T2_�������2����");
		
		Rule d2_rule9 = dmnHelper.addRule("Rule_T2_9", "T2 Rule 9", "T2 Rule 9", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_1", "\'��������һ̨����ͣ��\'", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_2", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_3", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_4", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_5", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_6", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_7", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_8", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_9", ">1000", d2_rule9);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R9_1", "\'���2̨���书��֮��Խ��\'", d2_rule9);

		d2_in9.setCamundaInputVariable("T2_����������1���� + T2_����������2����");
		
		Rule d2_rule10 = dmnHelper.addRule("Rule_T2_10", "T2 Rule 10", "T2 Rule 10", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_1", "\'��������һ̨����ͣ��\'", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_2", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_3", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_4", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_5", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_6", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_7", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_8", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_9", ">600", d2_rule10);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R10_1", "\'������2̨���书��֮��Խ��\'", d2_rule10);

		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.35 + T2_�ı����ͱ��쳱��");
		
		Rule d2_rule11 = dmnHelper.addRule("Rule_T2_11", "T2 Rule 11", "T2 Rule 11", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_1", "\'��������һ̨����ͣ��\'", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_2", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_3", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_4", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_5", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_6", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_7", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_8", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_9", ">260", d2_rule11);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R11_1", "\'�����̱���������������35%+�ı����ͱ��죨�Ľ�����������֮��Խ��\'", d2_rule11);

		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.23 + T2_�����������ᳱ��");
		
		Rule d2_rule12 = dmnHelper.addRule("Rule_T2_12", "T2 Rule 12", "T2 Rule 12", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_1", "\'��������һ̨����ͣ��\'", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_2", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_3", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_4", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_5", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_6", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_7", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_8", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_9", ">260", d2_rule12);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R12_1", "\'�����̱���������������23%+�����������ᣨ���ǣ���������֮��Խ��\'", d2_rule12);
		
		d2_in9.setCamundaInputVariable("T2_�������1���� + T2_�������2����");
		
		Rule d2_rule13 = dmnHelper.addRule("Rule_T2_13", "T2 Rule 13", "T2 Rule 13", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_1", "\'������ʽ\'", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_2", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_3", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_4", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_5", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_6", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_7", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_8", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_9", "<=1000", d2_rule13);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R13_1", "\'��������\'", d2_rule13);
		
		d2_in9.setCamundaInputVariable("T2_����������1���� + T2_����������2����");
		
		Rule d2_rule14 = dmnHelper.addRule("Rule_T2_14", "T2 Rule 14", "T2 Rule 14", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R14_1", "\'������ʽ\'", d2_rule14);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R14_2", "", d2_rule14);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R14_3", "", d2_rule14);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R14_4", "", d2_rule14);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R14_5", "", d2_rule14);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R14_6", "", d2_rule14);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R14_7", "", d2_rule14);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R14_8", "", d2_rule14);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R14_9", "<=900", d2_rule14);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R14_1", "\'��������\'", d2_rule14);
		
		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.1 + T2_�ı����ͱ��쳱��");
		
		Rule d2_rule15 = dmnHelper.addRule("Rule_T2_15", "T2 Rule 15", "T2 Rule 15", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R15_1", "\'������ʽ\'", d2_rule15);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R15_2", "", d2_rule15);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R15_3", "", d2_rule15);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R15_4", "", d2_rule15);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R15_5", "", d2_rule15);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R15_6", "", d2_rule15);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R15_7", "", d2_rule15);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R15_8", "", d2_rule15);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R15_9", "<=260", d2_rule15);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R15_1", "\'��������\'", d2_rule15);
		
		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.07 + T2_�����������ᳱ��");
		
		Rule d2_rule16 = dmnHelper.addRule("Rule_T2_16", "T2 Rule 16", "T2 Rule 16", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R16_1", "\'������ʽ\'", d2_rule16);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R16_2", "", d2_rule16);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R16_3", "", d2_rule16);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R16_4", "", d2_rule16);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R16_5", "", d2_rule16);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R16_6", "", d2_rule16);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R16_7", "", d2_rule16);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R16_8", "", d2_rule16);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R16_9", "<=260", d2_rule16);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R16_1", "\'��������\'", d2_rule16);
		
		d2_in9.setCamundaInputVariable("T2_�������1���� + T2_�������2����");
		
		Rule d2_rule17 = dmnHelper.addRule("Rule_T2_17", "T2 Rule 17", "T2 Rule 17", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R17_1", "\'�����һ̨����ͣ��\'", d2_rule17);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R17_2", "", d2_rule17);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R17_3", "", d2_rule17);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R17_4", "", d2_rule17);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R17_5", "", d2_rule17);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R17_6", "", d2_rule17);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R17_7", "", d2_rule17);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R17_8", "", d2_rule17);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R17_9", "<=500", d2_rule17);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R17_1", "\'��������\'", d2_rule17);
		
		d2_in9.setCamundaInputVariable("T2_����������1���� + T2_����������2����");
		
		Rule d2_rule18 = dmnHelper.addRule("Rule_T2_18", "T2 Rule 18", "T2 Rule 18", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R18_1", "\'�����һ̨����ͣ��\'", d2_rule18);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R18_2", "", d2_rule18);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R18_3", "", d2_rule18);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R18_4", "", d2_rule18);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R18_5", "", d2_rule18);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R18_6", "", d2_rule18);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R18_7", "", d2_rule18);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R18_8", "", d2_rule18);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R18_9", "<=900", d2_rule18);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R18_1", "\'��������\'", d2_rule18);
		
		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.1 + T2_�ı����ͱ��쳱��");
		
		Rule d2_rule19 = dmnHelper.addRule("Rule_T2_19", "T2 Rule 19", "T2 Rule 19", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R19_1", "\'�����һ̨����ͣ��\'", d2_rule19);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R19_2", "", d2_rule19);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R19_3", "", d2_rule19);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R19_4", "", d2_rule19);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R19_5", "", d2_rule19);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R19_6", "", d2_rule19);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R19_7", "", d2_rule19);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R19_8", "", d2_rule19);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R19_9", "<=260", d2_rule19);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R19_1", "\'��������\'", d2_rule19);
		
		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.07 + T2_�����������ᳱ��");
		
		Rule d2_rule20 = dmnHelper.addRule("Rule_T2_20", "T2 Rule 20", "T2 Rule 20", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R20_1", "\'�����һ̨����ͣ��\'", d2_rule20);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R20_2", "", d2_rule20);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R20_3", "", d2_rule20);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R20_4", "", d2_rule20);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R20_5", "", d2_rule20);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R20_6", "", d2_rule20);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R20_7", "", d2_rule20);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R20_8", "", d2_rule20);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R20_9", "<=260", d2_rule20);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R20_1", "\'��������\'", d2_rule20);
		
		d2_in9.setCamundaInputVariable("T2_�������1���� + T2_�������2����");
		
		Rule d2_rule21 = dmnHelper.addRule("Rule_T2_21", "T2 Rule 21", "T2 Rule 21", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R21_1", "\'��������һ̨����ͣ��\'", d2_rule21);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R21_2", "", d2_rule21);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R21_3", "", d2_rule21);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R21_4", "", d2_rule21);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R21_5", "", d2_rule21);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R21_6", "", d2_rule21);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R21_7", "", d2_rule21);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R21_8", "", d2_rule21);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R21_9", "<=1000", d2_rule21);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R21_1", "\'��������\'", d2_rule21);
		
		d2_in9.setCamundaInputVariable("T2_����������1���� + T2_����������2����");
		
		Rule d2_rule22 = dmnHelper.addRule("Rule_T2_22", "T2 Rule 22", "T2 Rule 22", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R22_1", "\'��������һ̨����ͣ��\'", d2_rule22);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R22_2", "", d2_rule22);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R22_3", "", d2_rule22);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R22_4", "", d2_rule22);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R22_5", "", d2_rule22);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R22_6", "", d2_rule22);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R22_7", "", d2_rule22);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R22_8", "", d2_rule22);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R22_9", "<=600", d2_rule22);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R22_1", "\'��������\'", d2_rule22);
		
		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.35 + T2_�ı����ͱ��쳱��");
		
		Rule d2_rule23 = dmnHelper.addRule("Rule_T2_23", "T2 Rule 23", "T2 Rule 23", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R23_1", "\'��������һ̨����ͣ��\'", d2_rule23);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R23_2", "", d2_rule23);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R23_3", "", d2_rule23);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R23_4", "", d2_rule23);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R23_5", "", d2_rule23);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R23_6", "", d2_rule23);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R23_7", "", d2_rule23);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R23_8", "", d2_rule23);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R23_9", "<=260", d2_rule23);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R23_1", "\'��������\'", d2_rule23);
		
		d2_in9.setCamundaInputVariable("T2_�����̱�����*0.23 + T2_�����������ᳱ��");
		
		Rule d2_rule24 = dmnHelper.addRule("Rule_T2_24", "T2 Rule 24", "T2 Rule 24", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R24_1", "\'��������һ̨����ͣ��\'", d2_rule24);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R24_2", "", d2_rule24);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R24_3", "", d2_rule24);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R24_4", "", d2_rule24);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R24_5", "", d2_rule24);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R24_6", "", d2_rule24);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R24_7", "", d2_rule24);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R24_8", "", d2_rule24);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R24_9", "<=260", d2_rule24);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R24_1", "\'��������\'", d2_rule24);
		
		d2_in9.setCamundaInputVariable("");

		/*
		 * DTable Decision_StabilityLimit
		 */
		Decision dStab = dmnHelper.createDecision("Decision_TransformerAdjust", "Decision TransformerAdjust RuleSet");

		// informationRequirement section
		dmnHelper.addInfoRequirement(d1, dStab);
		dmnHelper.addInfoRequirement(d2, dStab);

		DecisionTable dtStab = dmnHelper.addDecisionTable("DTable_Stab", HitPolicy.FIRST, dStab);

		Input in1 = dmnHelper.addInput("input_rs_SL_1", "DateTime", dtStab);
		dmnHelper.addInputExpression("LiteralExpression_rs_SL_1", "date", "��ǰʱ��", in1);

		dmnHelper.addOutput("output_rs_SL_1", "Խ����", "T1Խ����", "string", dtStab);
		dmnHelper.addOutput("output_rs_SL_2", "Խ����", "T2Խ����", "string", dtStab);

		Rule rule_out = dmnHelper.addRule("Rule_SL_1", "SL Rule 1", "SL Rule 1", dtStab);
		dmnHelper.addInputEntry("ExpreTests_rs_SL_R1_1",
				"[date and time(\"2019-01-01T12:00:00\")..date and time(\"2019-12-31T12:00:00\")]", rule_out);
		dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_1", "T1_Խ����", rule_out);
		dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_2", "T2_Խ����", rule_out);

		/*
		 * 
		 */
		dmnHelper.validateModel();

		System.out.println(dmnHelper.toString());

		dmnHelper.writeModelToFile("testdata/out2.xml");
	}
}