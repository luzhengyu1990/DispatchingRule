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

		Input d1_in1 = dmnHelper.addInput("T1_参数1", "运行方式", dt1);
		Input d1_in2 = dmnHelper.addInput("T1_P1", "民丰主变1功率", dt1);
		Input d1_in3 = dmnHelper.addInput("T1_P2", "民丰主变2功率", dt1);
		Input d1_in4 = dmnHelper.addInput("T1_P3", "长阳铺主变功率", dt1);
		Input d1_in5 = dmnHelper.addInput("T1_Input1", "越界判断", dt1);

		dmnHelper.addInputExpression("InExpression_T1_1", "string", "T1_运行方式", d1_in1);
		dmnHelper.addInputExpression("InExpression_T1_2", "double", "T1_民丰主变1功率", d1_in2);
		dmnHelper.addInputExpression("InExpression_T1_3", "double", "T1_民丰主变2功率", d1_in3);
		dmnHelper.addInputExpression("InExpression_T1_4", "double", "T1_长阳铺主变功率", d1_in4);
		dmnHelper.addInputExpression("InExpression_T1_5", "boolean", "T1_越界判断", d1_in5);

		dmnHelper.addOutput("T1_output1", "越界结果", "T1_越界结果", "string", dt1);

		Rule d1_rule1 = dmnHelper.addRule("Rule_T1_1", "T1 Rule 1", "T1 Rule 1", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R1_1", "\'正常方式\'", d1_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R1_2", "", d1_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R1_3", "", d1_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R1_4", "", d1_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R1_5", "T1_民丰主变1功率 + T1_民丰主变2功率 + T1_长阳铺主变功率>1400", d1_rule1);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R1_1", "\'民丰、长阳铺3台主变功率之和越界\'", d1_rule1);

		Rule d1_rule2 = dmnHelper.addRule("Rule_T1_2", "T1 Rule 2", "T1 Rule 2", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R2_1", "\'正常方式\'", d1_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R2_2", "", d1_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R2_3", "", d1_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R2_4", "", d1_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R2_5", "T1_民丰主变1功率 + T1_民丰主变2功率>1000", d1_rule2);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R2_1", "\'民丰2台主变功率之和越界\'", d1_rule2);

		Rule d1_rule3 = dmnHelper.addRule("Rule_T1_3", "T1 Rule 3", "T1 Rule 3", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R3_1", "\'民丰任一台主变停运\'", d1_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R3_2", "", d1_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R3_3", "", d1_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R3_4", "", d1_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R3_5", "T1_民丰主变1功率 + T1_民丰主变2功率 + T1_长阳铺主变功率>950", d1_rule3);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R3_1", "\'民丰、长阳铺3台主变功率之和越界\'", d1_rule3);

		Rule d1_rule4 = dmnHelper.addRule("Rule_T1_4", "T1 Rule 4", "T1 Rule 4", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R4_1", "\'民丰任一台主变停运\'", d1_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R4_2", "", d1_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R4_3", "", d1_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R4_4", "", d1_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R4_5", "T1_民丰主变1功率 + T1_民丰主变2功率>500", d1_rule4);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R4_1", "\'民丰2台主变功率之和越界\'", d1_rule4);
		
		Rule d1_rule5 = dmnHelper.addRule("Rule_T1_5", "T1 Rule 5", "T1 Rule 5", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R5_1", "\'长阳铺主变停运\'", d1_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R5_2", "", d1_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R5_3", "", d1_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R5_4", "", d1_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R5_5", "T1_民丰主变1功率 + T1_民丰主变2功率>950", d1_rule5);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R5_1", "\'民丰2台主变功率之和越界\'", d1_rule5);
		
		Rule d1_rule6 = dmnHelper.addRule("Rule_T1_6", "T1 Rule 6", "T1 Rule 6", dt1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R6_1", "", d1_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R6_2", "", d1_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R6_3", "", d1_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R6_4", "", d1_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T1_R6_5", "", d1_rule6);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R6_1", "\'正常运行\'", d1_rule6);

		/*
		 * DTable Decision_T2
		 */
		Decision d2 = dmnHelper.createDecision("Decision_T2", "T2 RuleSet");

		DecisionTable dt2 = dmnHelper.addDecisionTable("DTable_T2", HitPolicy.FIRST, d2);

		Input d2_in1 = dmnHelper.addInput("T2_参数1", "运行方式", dt2);
		Input d2_in2 = dmnHelper.addInput("T2_P1", "民丰主变1功率", dt2);
		Input d2_in3 = dmnHelper.addInput("T2_P2", "民丰主变2功率", dt2);
		Input d2_in4 = dmnHelper.addInput("T2_P3", "长阳铺主变1功率", dt2);
		Input d2_in5 = dmnHelper.addInput("T2_P4", "长阳铺主变2功率", dt2);
		Input d2_in6 = dmnHelper.addInput("T2_P5", "长阳铺变下网", dt2);
		Input d2_in7 = dmnHelper.addInput("T2_P6", "湍宝线送宝庆潮流", dt2);
		Input d2_in8 = dmnHelper.addInput("T2_P7", "吉永线送永丰潮流", dt2);
		Input d2_in9 = dmnHelper.addInput("T2_Input1", "越界判断", dt2);

		dmnHelper.addInputExpression("InExpression_T2_1", "string", "T2_运行方式", d2_in1);
		dmnHelper.addInputExpression("InExpression_T2_2", "double", "T2_民丰主变1功率", d2_in2);
		dmnHelper.addInputExpression("InExpression_T2_3", "double", "T2_民丰主变2功率", d2_in3);
		dmnHelper.addInputExpression("InExpression_T2_4", "double", "T2_长阳铺主变1功率", d2_in4);
		dmnHelper.addInputExpression("InExpression_T2_5", "double", "T2_长阳铺主变2功率", d2_in5);
		dmnHelper.addInputExpression("InExpression_T2_6", "double", "T2_长阳铺变下网", d2_in6);
		dmnHelper.addInputExpression("InExpression_T2_7", "double", "T2_湍宝线送宝庆潮流", d2_in7);
		dmnHelper.addInputExpression("InExpression_T2_8", "double", "T2_吉永线送永丰潮流", d2_in8);
		dmnHelper.addInputExpression("InExpression_T2_9", "boolean", "T2_越界判断", d2_in9);

		dmnHelper.addOutput("T2_output1", "越界结果", "T2_越界结果", "string", dt2);

		Rule d2_rule1 = dmnHelper.addRule("Rule_T2_1", "T2 Rule 1", "T2 Rule 1", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_1", "\'正常方式\'", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_2", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_3", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_4", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_5", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_6", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_7", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_8", "", d2_rule1);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R1_9", "T2_民丰主变1功率 + T2_民丰主变2功率>1000", d2_rule1);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R1_1", "\'民丰2台主变功率之和越界\'", d2_rule1);

		Rule d2_rule2 = dmnHelper.addRule("Rule_T2_2", "T2 Rule 2", "T2 Rule 2", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_1", "\'正常方式\'", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_2", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_3", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_4", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_5", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_6", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_7", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_8", "", d2_rule2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R2_9", "T2_长阳铺主变1功率 + T2_长阳铺主变2功率>900", d2_rule2);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R2_1", "\'长阳铺2台主变功率之和越界\'", d2_rule2);

		Rule d2_rule3 = dmnHelper.addRule("Rule_T2_3", "T2 Rule 3", "T2 Rule 3", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_1", "\'正常方式\'", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_2", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_3", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_4", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_5", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_6", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_7", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_8", "", d2_rule3);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R3_9", "T2_长阳铺变下网*0.1 + T2_湍宝线送宝庆潮流>260", d2_rule3);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R3_1", "\'长阳铺变下网（上网）的10%+湍宝线送宝庆（湍江）潮流功率之和越界\'", d2_rule3);

		Rule d2_rule4 = dmnHelper.addRule("Rule_T2_4", "T2 Rule 4", "T2 Rule 4", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_1", "\'正常方式\'", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_2", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_3", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_4", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_5", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_6", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_7", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_8", "", d2_rule4);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R4_9", "T2_长阳铺变下网*0.07 + T2_吉永线送永丰潮流>260", d2_rule4);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R4_1", "\'长阳铺变下网（上网）的7%+吉永线送永丰（吉星）潮流功率之和越界\'", d2_rule4);

		Rule d2_rule5 = dmnHelper.addRule("Rule_T2_5", "T2 Rule 5", "T2 Rule 5", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_1", "\'民丰任一台主变停运\'", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_2", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_3", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_4", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_5", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_6", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_7", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_8", "", d2_rule5);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R5_9", "T2_民丰主变1功率 + T2_民丰主变2功率>500", d2_rule5);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R5_1", "\'民丰2台主变功率之和越界\'", d2_rule5);

		Rule d2_rule6 = dmnHelper.addRule("Rule_T2_6", "T2 Rule 6", "T2 Rule 6", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_1", "\'民丰任一台主变停运\'", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_2", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_3", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_4", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_5", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_6", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_7", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_8", "", d2_rule6);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R6_9", "T2_长阳铺主变1功率 + T2_长阳铺主变2功率>900", d2_rule6);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R6_1", "\'长阳铺2台主变功率之和越界\'", d2_rule6);

		Rule d2_rule7 = dmnHelper.addRule("Rule_T2_7", "T2 Rule 7", "T2 Rule 7", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_1", "\'民丰任一台主变停运\'", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_2", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_3", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_4", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_5", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_6", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_7", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_8", "", d2_rule7);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R7_9", "T2_长阳铺变下网*0.1 + T2_湍宝线送宝庆潮流>260", d2_rule7);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R7_1", "\'长阳铺变下网（上网）的10%+湍宝线送宝庆（湍江）潮流功率之和越界\'", d2_rule7);

		Rule d2_rule8 = dmnHelper.addRule("Rule_T2_8", "T2 Rule 8", "T2 Rule 8", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_1", "\'民丰任一台主变停运\'", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_2", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_3", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_4", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_5", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_6", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_7", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_8", "", d2_rule8);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R8_9", "T2_长阳铺变下网*0.07 + T2_吉永线送永丰潮流>260", d2_rule8);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R8_1", "\'长阳铺变下网（上网）的7%+吉永线送永丰（吉星）潮流功率之和越界\'", d2_rule8);

		Rule d2_rule9 = dmnHelper.addRule("Rule_T2_9", "T2 Rule 9", "T2 Rule 9", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_1", "\'长阳铺任一台主变停运\'", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_2", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_3", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_4", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_5", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_6", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_7", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_8", "", d2_rule9);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R9_9", "T2_民丰主变1功率 + T2_民丰主变2功率>1000", d2_rule9);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R9_1", "\'民丰2台主变功率之和越界\'", d2_rule9);

		Rule d2_rule10 = dmnHelper.addRule("Rule_T2_10", "T2 Rule 10", "T2 Rule 10", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_1", "\'长阳铺任一台主变停运\'", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_2", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_3", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_4", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_5", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_6", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_7", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_8", "", d2_rule10);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R10_9", "T2_长阳铺主变1功率 + T2_长阳铺主变2功率>600", d2_rule10);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R10_1", "\'长阳铺2台主变功率之和越界\'", d2_rule10);

		Rule d2_rule11 = dmnHelper.addRule("Rule_T2_11", "T2 Rule 11", "T2 Rule 11", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_1", "\'长阳铺任一台主变停运\'", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_2", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_3", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_4", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_5", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_6", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_7", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_8", "", d2_rule11);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R11_9", "T2_长阳铺变下网*0.35 + T2_湍宝线送宝庆潮流>260", d2_rule11);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R11_1", "\'长阳铺变下网（上网）的35%+湍宝线送宝庆（湍江）潮流功率之和越界\'", d2_rule11);

		Rule d2_rule12 = dmnHelper.addRule("Rule_T2_12", "T2 Rule 12", "T2 Rule 12", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_1", "\'长阳铺任一台主变停运\'", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_2", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_3", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_4", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_5", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_6", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_7", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_8", "", d2_rule12);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R12_9", "T2_长阳铺变下网*0.23 + T2_吉永线送永丰潮流>260", d2_rule12);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R12_1", "\'长阳铺变下网（上网）的23%+吉永线送永丰（吉星）潮流功率之和越界\'", d2_rule12);
		
		Rule d2_rule13 = dmnHelper.addRule("Rule_T2_13", "T2 Rule 13", "T2 Rule 13", dt2);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_1", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_2", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_3", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_4", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_5", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_6", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_7", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_8", "", d2_rule13);
		dmnHelper.addInputEntry("ExpreTests_Rule_T2_R13_9", "", d2_rule13);
		dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R13_1", "\'正常运行\'", d2_rule13);

		/*
		 * DTable Decision_StabilityLimit
		 */
		Decision dStab = dmnHelper.createDecision("Decision_TransformerAdjust", "Decision TransformerAdjust RuleSet");

		// informationRequirement section
		dmnHelper.addInfoRequirement(d1, dStab);
		dmnHelper.addInfoRequirement(d2, dStab);

		DecisionTable dtStab = dmnHelper.addDecisionTable("DTable_Stab", HitPolicy.FIRST, dStab);

		Input in1 = dmnHelper.addInput("input_rs_SL_1", "DateTime", dtStab);
		dmnHelper.addInputExpression("LiteralExpression_rs_SL_1", "date", "当前时间", in1);

		dmnHelper.addOutput("output_rs_SL_1", "越界结果", "T1越界结果", "string", dtStab);
		dmnHelper.addOutput("output_rs_SL_2", "越界结果", "T2越界结果", "string", dtStab);

		Rule rule_out = dmnHelper.addRule("Rule_SL_1", "SL Rule 1", "SL Rule 1", dtStab);
		dmnHelper.addInputEntry("ExpreTests_rs_SL_R1_1",
				"[date and time(\"2019-01-01T12:00:00\")..date and time(\"2019-12-31T12:00:00\")]", rule_out);
		dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_1", "T1_越界结果", rule_out);
		dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_2", "T2_越界结果", rule_out);

		/*
		 * 
		 */
		dmnHelper.validateModel();

		System.out.println(dmnHelper.toString());

		dmnHelper.writeModelToFile("testdata/out2.xml");
	}
}