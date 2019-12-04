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
	  
	  Input in1 = dmnHelper.addInput("T1_input_1", "Param1", dt1);
	  dmnHelper.addInputExpression("InExpression_T1_1", "string", "T1_参数1", in1);
	  
	  dmnHelper.addOutput("T1_output_1", "Psum1", "T1_民丰长阳铺3台主变功率之和", "double", dt1);
	  dmnHelper.addOutput("T1_output_2", "Psum2", "T1_民丰2台主变功率之和", "double", dt1);
    
	  Rule rule1 = dmnHelper.addRule("Rule_T1_1", "T1 Rule 1", "T1 Rule 1", dt1);
	  dmnHelper.addInputEntry("ExpreTests_rule_T1_1_1", "\"正常方式\"", rule1);
	  dmnHelper.addOutputEntry("OutputEntry_Rule_T1_1_1", "1400", rule1);
	  dmnHelper.addOutputEntry("OutputEntry_Rule_T1_1_2", "1000", rule1);

	  Rule rule2 = dmnHelper.addRule("Rule_T1_2", "T1 Rule 2", "T1 Rule 2", dt1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T1_R2_1", "\"民丰任一台主变停运\"", rule2);
	  dmnHelper.addOutputEntry("OutputEntry_rs_T1_R2_1", "950", rule2);
	  dmnHelper.addOutputEntry("OutputEntry_rs_T1_R2_2", "500", rule2);
	  
	  Rule rule3 = dmnHelper.addRule("Rule_T1_3", "T1 Rule 3", "T1 Rule 3", dt1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T1_R3_1", "\"长阳铺主变停运\"", rule3);
	  dmnHelper.addOutputEntry("OutputEntry_rs_T1_R3_1", "null", rule3);
	  dmnHelper.addOutputEntry("OutputEntry_rs_T1_R3_2", "950", rule3);
	  
	  /*
	   * DTable Decision_T2
	   */
	  Decision d2 = dmnHelper.createDecision("Decision_T2", "T2 RuleSet");
	  
	  DecisionTable dt2 = dmnHelper.addDecisionTable("DTable_T2", HitPolicy.FIRST, d2);
	  
	  in1 = dmnHelper.addInput("input_rs_T2_1", "Param1", dt2);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T2_1", "string", "T2_参数1", in1);

	  dmnHelper.addOutput("output_rs_T2_1", "Psum3", "T2_长阳铺2台主变功率之和", "double", dt2);
	  dmnHelper.addOutput("output_rs_T2_2", "Psum4", "T2_民丰2台主变功率之和", "double", dt2);
	  
	  rule1 = dmnHelper.addRule("Rule_T2_1", "T2 Rule 1", "T2 Rule 1", dt2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T2_R1_1", "\"正常方式\"", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T2_R1_1", "900", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T2_R1_2", "1000", rule1);

	  rule2 = dmnHelper.addRule("Rule_T2_2", "T2 Rule 2", "T2 Rule 2", dt2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T2_R2_1", "\"民丰任一台主变停运\"", rule2);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T2_R2_1", "900", rule2);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T2_R2_2", "500", rule2);
	  
	  
	  rule3 = dmnHelper.addRule("Rule_T2_3", "T2 Rule 3", "T2 Rule 3", dt2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T2_R3_1", "\"长阳铺任一台主变停运\"", rule3);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T2_R3_1", "600", rule3);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T2_R3_2", "1000", rule3);
	  
	  
	  /*
	   * DTable Decision_T3
	   */
	  Decision d3 = dmnHelper.createDecision("Decision_T3", "T3 RuleSet");
	  
	  DecisionTable dt3 = dmnHelper.addDecisionTable("DTable_T3", HitPolicy.FIRST, d3);
	  
	  in1 = dmnHelper.addInput("input_rs_T3_1", "Param1", dt3);
	  Input in2 = dmnHelper.addInput("input_rs_T3_2", "Param2", dt3);
	  Input in3 = dmnHelper.addInput("input_rs_T3_3", "Param3", dt3);
	  Input in4 = dmnHelper.addInput("input_rs_T3_4", "Param4", dt3);
	  
	  dmnHelper.addInputExpression("LiteralExpression_rs_T3_1", "string", "T2_参数1", in1);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T3_2", "double", "T3_长阳铺变下网", in2);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T3_3", "double", "T3_湍宝线送宝庆潮流", in3);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T3_4", "double", "T3_吉永线送永丰潮流", in4);

	  dmnHelper.addOutput("output_rs_T3_1", "Psum5", "T3_限额1", "boolean", dt3);
	  dmnHelper.addOutput("output_rs_T3_2", "Psum6", "T3_限额2", "boolean", dt3);
	  
	  rule1 = dmnHelper.addRule("Rule_T3_1", "T3 Rule 1", "T3 Rule 1", dt3);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R1_1", "\'正常方式\'", rule1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R1_2", "", rule1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R1_3", "", rule1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R1_4", "", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T3_R1_1", "T3_长阳铺变下网*0.1+T3_湍宝线送宝庆潮流<=260?true:false", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T3_R1_2", "T3_长阳铺变下网 *0.07+T3_吉永线送永丰潮流<=260?true:false", rule1);

	  rule2 = dmnHelper.addRule("Rule_T3_2", "T3 Rule 2", "T3 Rule 2", dt3);
	  
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R2_1", "\'民丰任一台主变停运\'", rule2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R2_2", "", rule2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R2_3", "", rule2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R2_4", "", rule2);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T3_R2_1", "T3_长阳铺变下网*0.1 + T3_湍宝线送宝庆潮流<=260?true:false", rule2);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T3_R2_2", "T3_长阳铺变下网 *0.07 + T3_吉永线送永丰潮流<=260?true:false", rule2);
	  
	  
	  rule3 = dmnHelper.addRule("Rule_T3_3", "T3 Rule 3", "T3 Rule 3", dt3);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R3_1", "\'长阳铺任一台主变停运\'", rule3);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R3_2", "", rule3);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R3_3", "", rule3);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R3_4", "", rule3);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T3_R3_1", "T3_长阳铺变下网*0.35 + T3_湍宝线送宝庆潮流<=260?true:false", rule3);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T3_R3_2", "T3_长阳铺变下网 *0.23 + T3_吉永线送永丰潮流<=260?true:false", rule3);
	 
	  /*
	   * DTable Decision_StabilityLimit
	   */	  
	  Decision dStab = dmnHelper.createDecision("Decision_TransformerAdjust", "Decision TransformerAdjust RuleSet");
	  
	  // informationRequirement section
	  dmnHelper.addInfoRequirement(d1, dStab);
	  dmnHelper.addInfoRequirement(d2, dStab);
	  dmnHelper.addInfoRequirement(d3, dStab);
	  
	  DecisionTable dtStab = dmnHelper.addDecisionTable("DTable_Stab", HitPolicy.FIRST, dStab);

	  in1 = dmnHelper.addInput("input_rs_SL_1", "DateTime", dtStab);
	  dmnHelper.addInputExpression("LiteralExpression_rs_SL_1", "date", "当前时间", in1);

	  dmnHelper.addOutput("output_rs_SL_1", "Psum1", "民丰长阳铺3台主变功率之和<", "double", dtStab);
	  dmnHelper.addOutput("output_rs_SL_2", "Psum2", "民丰2台主变功率之和<", "double", dtStab);
	  dmnHelper.addOutput("output_rs_SL_3", "Psum3", "长阳铺2台主变功率之和<", "double", dtStab);
	  dmnHelper.addOutput("output_rs_SL_4", "Psum4", "长阳铺#2主变投运后民丰2台主变功率之和<", "double", dtStab);
	  dmnHelper.addOutput("output_rs_SL_5", "Psum5", "限额1", "boolean", dtStab);
	  dmnHelper.addOutput("output_rs_SL_6", "Psum6", "限额2", "boolean", dtStab);

	  rule1 = dmnHelper.addRule("Rule_SL_1", "SL Rule 1", "SL Rule 1", dtStab);
	  dmnHelper.addInputEntry("ExpreTests_rs_SL_R1_1", 
			       "[date and time(\"2019-01-01T12:00:00\")..date and time(\"2019-12-31T12:00:00\")]", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_1", "T1_民丰长阳铺3台主变功率之和", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_2", "T1_民丰2台主变功率之和", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_3", "T2_长阳铺2台主变功率之和", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_4", "T2_民丰2台主变功率之和", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_5", "T3_限额1", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_6", "T3_限额2", rule1);
	  
	  /*
	   * 
	   */
	  dmnHelper.validateModel();
	  
	  System.out.println(dmnHelper.toString());
	  
	  dmnHelper.writeModelToFile("temp/out1.xml");
	}
}