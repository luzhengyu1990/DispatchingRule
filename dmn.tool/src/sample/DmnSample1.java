package sample;

import org.camunda.bpm.model.dmn.HitPolicy;
import org.camunda.bpm.model.dmn.instance.Decision;
import org.camunda.bpm.model.dmn.instance.DecisionTable;
import org.camunda.bpm.model.dmn.instance.Input;
import org.camunda.bpm.model.dmn.instance.Rule;

import cn.sg.dmn.tool.DmnXmlModelHelper;

public class DmnSample1 {

	public static void main(String[] args) {
		DmnXmlModelHelper dmnHelper = new DmnXmlModelHelper();
		  
		  /*
		   * DTable Decision_T1
		   */
		  Decision d1 = dmnHelper.createDecision("Decision_T1", "T1 RuleSet");
		  
		  DecisionTable dt1 = dmnHelper.addDecisionTable("DTable_T1", HitPolicy.FIRST, d1);
		  
		  Input d1_in1 = dmnHelper.addInput("T1_input_1", "Param1", dt1);
		  Input d1_in2 = dmnHelper.addInput("T1_input_2", "Param2", dt1);
		  Input d1_in3 = dmnHelper.addInput("T1_input_3", "Param3", dt1);
		  
		  dmnHelper.addInputExpression("InExpression_T1_1", "string", "T1_运行方式", d1_in1);
		  dmnHelper.addInputExpression("InExpression_T1_2", "double", "T1_民丰长阳铺3台主变功率之和", d1_in2);
		  dmnHelper.addInputExpression("InExpression_T1_3", "double", "T1_民丰2台主变功率之和", d1_in3);

		  dmnHelper.addOutput("T1_output_1", "Psum1", "T1_越界结果", "string", dt1);
	    
		  Rule d1_rule1 = dmnHelper.addRule("Rule_T1_1", "T1 Rule 1", "T1 Rule 1", dt1);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R1_1", "\'正常方式\'", d1_rule1);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R1_2", "<=1400", d1_rule1);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R1_3", "<=1000", d1_rule1);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R1_1", "\'正常运行\'", d1_rule1);
		  
		  Rule d1_rule2 = dmnHelper.addRule("Rule_T1_2", "T1 Rule 2", "T1 Rule 2", dt1);
		  dmnHelper.addInputEntry("ExpreTests_rs_T1_R2_1", "\'正常方式\'", d1_rule2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T1_R2_2", "", d1_rule2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T1_R2_3", "", d1_rule2);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R2_1", "\'Pmax越界告警\'", d1_rule2);
		  
		  Rule d1_rule3 = dmnHelper.addRule("Rule_T1_3", "T1 Rule 3", "T1 Rule 3", dt1);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R3_1", "\'民丰任一台主变停运\'", d1_rule3);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R3_2", "<=950", d1_rule3);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R3_3", "<=500", d1_rule3);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R3_1", "\'正常运行\'", d1_rule3);
		  
		  Rule d1_rule4 = dmnHelper.addRule("Rule_T1_4", "T1 Rule 4", "T1 Rule 4", dt1);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R4_1", "\'民丰任一台主变停运\'", d1_rule4);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R4_2", "", d1_rule4);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R4_3", "", d1_rule4);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R4_1", "\'Pmax越界告警\'", d1_rule4);

		  Rule d1_rule5 = dmnHelper.addRule("Rule_T1_5", "T1 Rule 5", "T1 Rule 5", dt1);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R5_1", "\'长阳铺主变停运\'", d1_rule5);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R5_2", "", d1_rule5);
		  dmnHelper.addInputEntry("ExpreTests_rule_T1_R5_3", "<=950", d1_rule5);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R5_1", "\'正常运行\'", d1_rule5);
		  
		  Rule d1_rule6 = dmnHelper.addRule("Rule_T1_6", "T1 Rule 6", "T1 Rule 6", dt1);
		  dmnHelper.addInputEntry("ExpreTests_rs_T1_R6_1", "\'长阳铺主变停运\'", d1_rule6);
		  dmnHelper.addInputEntry("ExpreTests_rs_T1_R6_2", "", d1_rule6);
		  dmnHelper.addInputEntry("ExpreTests_rs_T1_R6_3", "", d1_rule6);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T1_R6_1", "\'Pmax越界告警'", d1_rule6);
		  
		  
		  /*
		   * DTable Decision_T2
		   */
		  Decision d2 = dmnHelper.createDecision("Decision_T2", "T2 RuleSet");
		  
		  DecisionTable dt2 = dmnHelper.addDecisionTable("DTable_T2", HitPolicy.FIRST, d2);
		  
		  Input d2_in1 = dmnHelper.addInput("T2_input_1", "Param1", dt2);
		  Input d2_in2 = dmnHelper.addInput("T2_input_2", "Param2", dt2);
		  Input d2_in3 = dmnHelper.addInput("T2_input_3", "Param3", dt2);
		  
		  dmnHelper.addInputExpression("InExpression_T2_1", "string", "T2_运行方式", d2_in1);
		  dmnHelper.addInputExpression("InExpression_T2_2", "double", "T2_长阳铺2台主变功率之和", d2_in2);
		  dmnHelper.addInputExpression("InExpression_T2_3", "double", "T2_民丰2台主变功率之和", d2_in3);

		  dmnHelper.addOutput("T2_output_1", "Psum1", "T2_越界结果", "string", dt2);
		  
	    
		  Rule d2_rule1 = dmnHelper.addRule("Rule_T2_1", "T2 Rule 1", "T2 Rule 1", dt2);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R1_1", "\'正常方式\'", d2_rule1);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R1_2", "<=900", d2_rule1);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R1_3", "<=1000", d2_rule1);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R1_1", "\'正常运行\'", d2_rule1);
		  
		  Rule d2_rule2 = dmnHelper.addRule("Rule_T2_2", "T2 Rule 2", "T2 Rule 2", dt2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T2_R2_1", "\'正常方式\'", d2_rule2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T2_R2_2", "", d2_rule2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T2_R2_3", "", d2_rule2);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R2_1", "\'Pmax越界告警\'", d2_rule2);
		  
		  Rule d2_rule3 = dmnHelper.addRule("Rule_T2_3", "T2 Rule 3", "T2 Rule 3", dt2);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R3_1", "\'民丰任一台主变停运\'", d2_rule3);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R3_2", "<=900", d2_rule3);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R3_3", "<=500", d2_rule3);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R3_1", "\'正常运行\'", d2_rule3);
		  
		  Rule d2_rule4 = dmnHelper.addRule("Rule_T2_4", "T2 Rule 4", "T2 Rule 4", dt2);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R4_1", "\'民丰任一台主变停运\'", d2_rule4);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R4_2", "", d2_rule4);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R4_3", "", d2_rule4);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R4_1", "\'Pmax越界告警\'", d2_rule4);

		  Rule d2_rule5 = dmnHelper.addRule("Rule_T2_5", "T2 Rule 5", "T2 Rule 5", dt2);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R5_1", "\'长阳铺任一台主变停运\'", d2_rule5);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R5_2", "<=600", d2_rule5);
		  dmnHelper.addInputEntry("ExpreTests_rule_T2_R5_3", "<=1000", d2_rule5);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R5_1", "\'正常运行\'", d2_rule5);
		  
		  Rule d2_rule6 = dmnHelper.addRule("Rule_T2_6", "T2 Rule 6", "T2 Rule 6", dt2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T2_R6_1", "\'长阳铺任一台主变停运\'", d2_rule6);
		  dmnHelper.addInputEntry("ExpreTests_rs_T2_R6_2", "", d2_rule6);
		  dmnHelper.addInputEntry("ExpreTests_rs_T2_R6_3", "", d2_rule6);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T2_R6_1", "\'Pmax越界告警'", d2_rule6);
		 
		  /*
		   * DTable Decision_T3
		   */
		  Decision d3 = dmnHelper.createDecision("Decision_T3", "T3 RuleSet");
		  dmnHelper.addInfoRequirement(d2, d3);
		  DecisionTable dt3 = dmnHelper.addDecisionTable("DTable_T3", HitPolicy.FIRST, d3);
		  
		  Input d3_in1 = dmnHelper.addInput("input_rs_T3_1", "Param1", dt3);
		  dmnHelper.addInputExpression("LiteralExpression_rs_T3_1", "string", "T2_运行方式", d3_in1);
		  
		  Input d3_in2 = dmnHelper.addInput("input_rs_T3_2", "Param2", dt3);
		  dmnHelper.addInputExpression("LiteralExpression_rs_T3_2", "double", "T3_长阳铺变下网", d3_in2);
		  
		  Input d3_in3 = dmnHelper.addInput("input_rs_T3_3", "Param3", dt3);
		  dmnHelper.addInputExpression("LiteralExpression_rs_T3_3", "double", "T3_湍宝线送宝庆潮流", d3_in3);
		  
		  Input d3_in4 = dmnHelper.addInput("input_rs_T3_4", "Param4", dt3);
		  dmnHelper.addInputExpression("LiteralExpression_rs_T3_4", "double", "T3_吉永线送永丰潮流", d3_in4);
		  
		  dmnHelper.addOutput("output_rs_T3_1", "Psum5", "T3_限额1", "double", dt3);
		  dmnHelper.addOutput("output_rs_T3_2", "Psum6", "T3_限额2", "double", dt3);
		  
		  
		  Rule d3_rule1 = dmnHelper.addRule("Rule_T3_1", "T3 Rule 1", "T3 Rule 1", dt3);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R1_1", "\'正常方式\'", d3_rule1);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R1_2", "", d3_rule1);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R1_3", "", d3_rule1);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R1_4", "", d3_rule1);
		  dmnHelper.addOutputEntry("OutputEntry_rs_T3_R1_1", "T3_长阳铺变下网*0.1+T3_湍宝线送宝庆潮流", d3_rule1);
		  dmnHelper.addOutputEntry("OutputEntry_rs_T3_R1_2", "T3_长阳铺变下网*0.07+T3_吉永线送永丰潮流", d3_rule1);

		  Rule d3_rule2 = dmnHelper.addRule("Rule_T3_2", "T3 Rule 2", "T3 Rule 2", dt3);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R2_1", "\'民丰任一台主变停运\'", d3_rule2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R2_2", "", d3_rule2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R2_3", "", d3_rule2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R2_4", "", d3_rule2);
		  dmnHelper.addOutputEntry("OutputEntry_rs_T3_R2_1", "T3_长阳铺变下网*0.1+T3_湍宝线送宝庆潮流", d3_rule2);
		  dmnHelper.addOutputEntry("OutputEntry_rs_T3_R2_2", "T3_长阳铺变下网 *0.07+T3_吉永线送永丰潮流", d3_rule2);
		  
		  Rule d3_rule3 = dmnHelper.addRule("Rule_T3_3", "T3 Rule 3", "T3 Rule 3", dt3);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R3_1", "\'长阳铺任一台主变停运\'", d3_rule3);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R3_2", "", d3_rule3);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R3_3", "", d3_rule3);
		  dmnHelper.addInputEntry("ExpreTests_rs_T3_R3_4", "", d3_rule3);
		  dmnHelper.addOutputEntry("OutputEntry_rs_T3_R3_1", "T3_长阳铺变下网*0.35+T3_湍宝线送宝庆潮流", d3_rule3);
		  dmnHelper.addOutputEntry("OutputEntry_rs_T3_R3_2", "T3_长阳铺变下网 *0.23+T3_吉永线送永丰潮流", d3_rule3);
		  
		  
		  /*
		   * DTable Decision_T4
		   */
		  Decision d4 = dmnHelper.createDecision("Decision_T4", "T4 RuleSet");
		  dmnHelper.addInfoRequirement(d2, d4);
		  dmnHelper.addInfoRequirement(d3, d4);
		  
		  DecisionTable dt4 = dmnHelper.addDecisionTable("DTable_T4", HitPolicy.FIRST, d4);
		  
		  Input d4_in1 = dmnHelper.addInput("input_rs_T4_1", "Param1", dt4);
		  dmnHelper.addInputExpression("LiteralExpression_rs_T4_1", "string", "T2_运行方式", d4_in1);
		  
		  Input d4_in2 = dmnHelper.addInput("input_rs_T4_2", "Param2", dt4);
		  dmnHelper.addInputExpression("LiteralExpression_rs_T4_2", "double", "T3_限额1", d4_in2);
		  
		  Input d4_in3 = dmnHelper.addInput("input_rs_T4_3", "Param3", dt4);
		  dmnHelper.addInputExpression("LiteralExpression_rs_T4_3", "double", "T3_限额2", d4_in3);
		  
		  dmnHelper.addOutput("output_rs_T4_1", "Param4", "T4_越界结果", "string", dt4);
		  
		  Rule d4_rule1 = dmnHelper.addRule("Rule_T4_1", "T4 Rule 1", "T4 Rule 1", dt4);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R1_1", "\'正常方式\'", d4_rule1);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R1_2", "<=260", d4_rule1);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R1_3", "<=260", d4_rule1);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T4_R1_1", "\'正常运行\'", d4_rule1);
		  
		  Rule d4_rule2 = dmnHelper.addRule("Rule_T4_2", "T4 Rule 2", "T4 Rule 2", dt4);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R2_1", "\'正常方式\'", d4_rule2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R2_2", "", d4_rule2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R2_3", "", d4_rule2);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T4_R2_1", "\'越界告警\'", d4_rule2);
		  
		  Rule d4_rule3 = dmnHelper.addRule("Rule_T4_3", "T4 Rule 3", "T4 Rule 3", dt4);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R3_1", "\'民丰任一台主变停运\'", d4_rule3);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R3_2", "<=260", d4_rule3);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R3_3", "<=260", d4_rule3);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T4_R3_1", "\'正常运行\'", d4_rule3);
		  
		  Rule d4_rule4 = dmnHelper.addRule("Rule_T4_4", "T4 Rule 4", "T4 Rule 4", dt4);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R4_1", "\'民丰任一台主变停运\'", d4_rule4);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R4_2", "", d4_rule4);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R4_3", "", d4_rule4);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T4_R4_1", "\'越界告警\'", d4_rule4);
		  
		  Rule d4_rule5 = dmnHelper.addRule("Rule_T4_5", "T4 Rule 5", "T4 Rule 5", dt4);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R5_1", "\'长阳铺任一台主变停运\'", d4_rule5);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R5_2", "<=260", d4_rule5);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R5_3", "<=260", d4_rule5);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T4_R5_1", "\'正常运行\'", d4_rule5);
		  
		  Rule d4_rule6 = dmnHelper.addRule("Rule_T4_6", "T4 Rule 6", "T4 Rule 6", dt4);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R6_1", "\'长阳铺任一台主变停运\'", d4_rule6);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R6_2", "", d4_rule6);
		  dmnHelper.addInputEntry("ExpreTests_rs_T4_R6_3", "", d4_rule6);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T4_R6_1", "\'越界告警\'", d4_rule6);
		  
		  
		  /*
		   * DTable Decision_T5
		   */
		  Decision d5 = dmnHelper.createDecision("Decision_T5", "T5 RuleSet");
		  dmnHelper.addInfoRequirement(d2, d5);
		  dmnHelper.addInfoRequirement(d4, d5);
		  
		  DecisionTable dt5 = dmnHelper.addDecisionTable("DTable_T5", HitPolicy.FIRST, d5);
		  
		  Input d5_in1 = dmnHelper.addInput("input_rs_T5_1", "Param1", dt5);
		  dmnHelper.addInputExpression("LiteralExpression_rs_T5_1", "string", "T2_运行方式", d5_in1);
		  
		  Input d5_in2 = dmnHelper.addInput("input_rs_T5_2", "Param2", dt5);
		  dmnHelper.addInputExpression("LiteralExpression_rs_T5_2", "string", "T2_越界结果", d5_in2);
		  
		  Input d5_in3 = dmnHelper.addInput("input_rs_T5_3", "Param3", dt5);
		  dmnHelper.addInputExpression("LiteralExpression_rs_T5_3", "string", "T4_越界结果", d5_in3);
		  
		  dmnHelper.addOutput("output_rs_T5_1", "Param4", "T5_越界结果", "string", dt5);
		  
		  Rule d5_rule1 = dmnHelper.addRule("Rule_T5_1", "T5 Rule 1", "T5 Rule 1", dt5);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R1_1", "\'正常方式\'", d5_rule1);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R1_2", "\'正常运行\'", d5_rule1);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R1_3", "\'正常运行\'", d5_rule1);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T5_R1_1", "\'正常运行\'", d5_rule1);
		  
		  Rule d5_rule2 = dmnHelper.addRule("Rule_T5_2", "T5 Rule 2", "T5 Rule 2", dt5);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R2_1", "\'正常方式\'", d5_rule2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R2_2", "", d5_rule2);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R2_3", "", d5_rule2);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T5_R2_1", "\'越界告警\'", d5_rule2);
		  
		  Rule d5_rule3 = dmnHelper.addRule("Rule_T5_3", "T5 Rule 3", "T5 Rule 3", dt5);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R3_1", "\'民丰任一台主变停运\'", d5_rule3);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R3_2", "\'正常运行\'", d5_rule3);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R3_3", "\'正常运行\'", d5_rule3);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T5_R3_1", "\'正常运行\'", d5_rule3);
		  
		  Rule d5_rule4 = dmnHelper.addRule("Rule_T5_4", "T5 Rule 4", "T5 Rule 4", dt5);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R4_1", "\'民丰任一台主变停运\'", d5_rule4);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R4_2", "", d5_rule4);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R4_3", "", d5_rule4);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T5_R4_1", "\'越界告警\'", d5_rule4);
		  
		  Rule d5_rule5 = dmnHelper.addRule("Rule_T5_5", "T5 Rule 5", "T5 Rule 5", dt5);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R5_1", "\'长阳铺任一台主变停运\'", d5_rule5);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R5_2", "\'正常运行\'", d5_rule5);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R5_3", "\'正常运行\'", d5_rule5);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T5_R5_1", "\'正常运行\'", d5_rule5);
		  
		  Rule d5_rule6 = dmnHelper.addRule("Rule_T5_6", "T5 Rule 6", "T5 Rule 6", dt5);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R6_1", "\'长阳铺任一台主变停运\'", d5_rule6);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R6_2", "", d5_rule6);
		  dmnHelper.addInputEntry("ExpreTests_rs_T5_R6_3", "", d5_rule6);
		  dmnHelper.addOutputEntry("OutputEntry_Rule_T5_R6_1", "\'越界告警\'", d5_rule6);
		  
		  /*
		   * DTable Decision_StabilityLimit
		   */	  
		  Decision dStab = dmnHelper.createDecision("Decision_TransformerAdjust", "Decision TransformerAdjust RuleSet");
		  
		  // informationRequirement section
		  dmnHelper.addInfoRequirement(d1, dStab);
		  dmnHelper.addInfoRequirement(d5, dStab);
		  
		  DecisionTable dtStab = dmnHelper.addDecisionTable("DTable_Stab", HitPolicy.FIRST, dStab);

		  Input in1 = dmnHelper.addInput("input_rs_SL_1", "DateTime", dtStab);
		  dmnHelper.addInputExpression("LiteralExpression_rs_SL_1", "date", "当前时间", in1);

		  dmnHelper.addOutput("output_rs_SL_1", "Psum1", "T1越界结果", "string", dtStab);
		  dmnHelper.addOutput("output_rs_SL_2", "Psum2", "T5越界结果", "string", dtStab);

		  Rule rule_out = dmnHelper.addRule("Rule_SL_1", "SL Rule 1", "SL Rule 1", dtStab);
		  dmnHelper.addInputEntry("ExpreTests_rs_SL_R1_1", 
				       "[date and time(\"2019-01-01T12:00:00\")..date and time(\"2019-12-31T12:00:00\")]", rule_out);
		  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_1", "T1_越界结果", rule_out);
		  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_2", "T5_越界结果", rule_out);
		  
		  /*
		   * 
		   */
		  dmnHelper.validateModel();
		  
		  System.out.println(dmnHelper.toString());
		  
		  dmnHelper.writeModelToFile("testdata/out1.xml");
	}
}