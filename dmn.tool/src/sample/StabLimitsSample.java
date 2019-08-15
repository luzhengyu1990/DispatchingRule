package sample;

import org.camunda.bpm.model.dmn.HitPolicy;
import org.camunda.bpm.model.dmn.instance.Decision;
import org.camunda.bpm.model.dmn.instance.DecisionTable;
import org.camunda.bpm.model.dmn.instance.Input;
import org.camunda.bpm.model.dmn.instance.InputData;
import org.camunda.bpm.model.dmn.instance.Rule;

import cn.sg.dmn.tool.DmnModelHelper;

public class StabLimitsSample {

	public static void main(String[] args) {
	  DmnModelHelper dmnHelper = new DmnModelHelper();
	  
	  /*
	   * inputData section
	   */
	  InputData inData1  = dmnHelper.createInputData("InputData_ST_01", "当前时间");
	  InputData inData2  = dmnHelper.createInputData("InputData_T1_01", "T1_参数1");
	  InputData inData3  = dmnHelper.createInputData("InputData_T1_02", "T1_参数2");
	  InputData inData4  = dmnHelper.createInputData("InputData_T2_01", "T2_参数1");
	  InputData inData5  = dmnHelper.createInputData("InputData_T3_01", "T3_参数1");
	  InputData inData6  = dmnHelper.createInputData("InputData_T3_01", "T3_参数2");
	  InputData inData7  = dmnHelper.createInputData("InputData_T4_01", "T4_参数1");
	  InputData inData8  = dmnHelper.createInputData("InputData_T4_01", "T4_参数2");
	  InputData inData9  = dmnHelper.createInputData("InputData_T4_01", "T5_参数1");
	  InputData inData10 = dmnHelper.createInputData("InputData_T4_01", "T5_参数2");
	  
	  /*
	   * DTable Decision_T1
	   */
	  Decision d1 = dmnHelper.createDecision("Decision_T1", "T1 RuleSet");
	  
	  // informationRequirement section
	  //dmnHelper.addInfoRequirement(inData1, d1);
	  //dmnHelper.addInfoRequirement(inData2, d1);
	  
	  DecisionTable dt1 = dmnHelper.addDecisionTable("DTable_T1", HitPolicy.FIRST, d1);
	  
	  Input in1 = dmnHelper.addInput("T1_input_1", "Param1", dt1);
	  dmnHelper.addInputExpression("InExpression_T1_1", "double", "T1_参数1", in1);
	  
	  Input in2 = dmnHelper.addInput("T1_input_2", "Param2", dt1);
	  dmnHelper.addInputExpression("InExpression_T1_2", "double", "T1_参数2", in2);

	  dmnHelper.addOutput("T1_output_1", "OptState", "T1_运行状态", "string", dt1);
	  dmnHelper.addOutput("T1_output_2", "Limit1", "T1_限额1", "double", dt1);
    
	  Rule rule1 = dmnHelper.addRule("Rule_T1_1", "T1 Rule 1", "T1 Rule 1", dt1);
	  dmnHelper.addInputEntry("ExpreTests_rule_T1_1_1", "<=10.0", rule1);
	  dmnHelper.addInputEntry("ExpreTests_rule_T1_1_2", "<=1.0", rule1);
	  dmnHelper.addOutputEntry("OutputEntry_Rule_T1_1_1", "正常运行", rule1);
	  dmnHelper.addOutputEntry("OutputEntry_Rule_T1_1_2", "200", rule1);

	  Rule rule2 = dmnHelper.addRule("Rule_T1_2", "T1 Rule 2", "T1 Rule 2", dt1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T1_R2_1", "<=10.0", rule2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T1_R2_2", ">1.0", rule2);
	  dmnHelper.addOutputEntry("OutputEntry_rs_T1_R2_1", "正常运行", rule2);
	  dmnHelper.addOutputEntry("OutputEntry_rs_T1_R2_2", "300", rule2);
	  
	  Rule rule3 = dmnHelper.addRule("Rule_T1_3", "T1 Rule 3", "T1 Rule 3", dt1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T1_R3_1", ">10.0", rule3);
	  dmnHelper.addInputEntry("ExpreTests_rs_T1_R3_2", "<=1.1", rule3);
	  dmnHelper.addOutputEntry("OutputEntry_rs_T1_R3_1", "单回运行", rule3);
	  dmnHelper.addOutputEntry("OutputEntry_rs_T1_R3_2", "400", rule3);
	  
	  Rule rule4 = dmnHelper.addRule("Rule_T1_4", "T1 Rule 4", "T1 Rule 4", dt1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T1_R4_1", ">10.0", rule4);
	  dmnHelper.addInputEntry("ExpreTests_rs_T1_R4_2", ">1.1", rule4);
	  dmnHelper.addOutputEntry("OutputEntry_rs_T1_R4_1", "单回运行", rule4);
	  dmnHelper.addOutputEntry("OutputEntry_rs_T1_R4_2", "500", rule4);
	  
	  /*
	   * DTable Decision_T2
	   */
	  Decision d2 = dmnHelper.createDecision("Decision_T2", "T2 RuleSet");
	  
	  // informationRequirement section
	  //dmnHelper.addInfoRequirement(inData3, d2);

	  DecisionTable dt2 = dmnHelper.addDecisionTable("DTable_T2", HitPolicy.FIRST, d2);
	  
	  in1 = dmnHelper.addInput("input_rs_T2_1", "Param1", dt2);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T2_1", "double", "T2_参数1", in1);

	  dmnHelper.addOutput("output_rs_T2_1", "Limit2", "T2_限额2", "integer", dt2);
	  
	  rule1 = dmnHelper.addRule("Rule_T2_1", "T2 Rule 1", "T2 Rule 1", dt2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T2_R1_1", "<=100.0", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T2_R1_1", "4", rule1);

	  rule2 = dmnHelper.addRule("Rule_T2_2", "T2 Rule 2", "T2 Rule 2", dt2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T2_R2_1", ">100.0", rule2);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T2_R2_1", "5", rule2);
	  
	  /*
	   * DTable Decision_T3
	   */	  
	  Decision d3 = dmnHelper.createDecision("Decision_T3", "T3 RuleSet");
	  
	  // informationRequirement sectiond3
	  dmnHelper.addInfoRequirement(d2, d3);
	  
	  DecisionTable dt3 = dmnHelper.addDecisionTable("DTable_T3", HitPolicy.FIRST, d3);
	  
	  in1 = dmnHelper.addInput("input_rs_T3_1", "Param1", dt3);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T3_1", "double", "T3_参数1", in1);

	  in2 = dmnHelper.addInput("input_rs_T3_2", "Param2", dt3);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T3_2", "double", "T3_参数2", in2);

	  dmnHelper.addOutput("output_rs_T3_1", "Limit2", "T3_限额2", "integer", dt3);

	  rule1 = dmnHelper.addRule("Rule_T3_1", "T3 Rule 1", "T3 Rule 1", dt3);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R1_1", "<=100.0", rule1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R1_2", "<=5", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T3_R1_1", "T2_限额2-1", rule1);

	  rule2 = dmnHelper.addRule("Rule_T3_2", "T3 Rule 2", "T3 Rule 2", dt3);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R2_1", "", rule2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T3_R2_2", "", rule2);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T3_R2_1", "T2_限额2", rule2);

	  /*
	   * DTable Decision_T4
	   */	  
	  Decision d4 = dmnHelper.createDecision("Decision_T4", "T4 RuleSet");

	  // informationRequirement section
	  
	  DecisionTable dt4 = dmnHelper.addDecisionTable("DTable_T4", HitPolicy.FIRST, d4);

	  in1 = dmnHelper.addInput("input_rs_T4_1", "Param1", dt4);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T4_1", "double", "T4_参数1", in1);

	  in2 = dmnHelper.addInput("input_rs_T4_2", "Param2", dt4);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T4_2", "double", "T4_参数2", in2);

	  dmnHelper.addOutput("output_rs_T4_1", "Limit3", "T4_限额3", "double", dt4);
	  
	  rule1 = dmnHelper.addRule("Rule_T4_1", "T4 Rule 1", "T4 Rule 1", dt4);
	  dmnHelper.addInputEntry("ExpreTests_rs_T4_R1_1", "<=10.0", rule1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T4_R1_2", "<=1.0", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T4_R1_1", "200", rule1);

	  rule2 = dmnHelper.addRule("Rule_T4_2", "T4 Rule 2", "T4 Rule 2", dt4);
	  dmnHelper.addInputEntry("ExpreTests_rs_T4_R2_1", "<=10.0", rule2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T4_R2_2", ">1.0", rule2);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T4_R2_1", "300", rule2);

	  rule3 = dmnHelper.addRule("Rule_T4_3", "T4 Rule 3", "T4 Rule 3", dt4);
	  dmnHelper.addInputEntry("ExpreTests_rs_T4_R3_1", ">10.0", rule3);
	  dmnHelper.addInputEntry("ExpreTests_rs_T4_R3_2", "<=1.1", rule3);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T4_R3_1", "400", rule3);

	  rule4 = dmnHelper.addRule("Rule_T4_4", "T4 Rule 4", "T4 Rule 4", dt4);
	  dmnHelper.addInputEntry("ExpreTests_rs_T4_R4_1", ">10.0", rule4);
	  dmnHelper.addInputEntry("ExpreTests_rs_T4_R4_2", ">1.1", rule4);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T4_R4_1", "500", rule4);
	  
	  /*
	   * DTable Decision_T5
	   */	  
	  Decision d5 = dmnHelper.createDecision("Decision_T5", "T5 RuleSet");
	  
	  // informationRequirement section
	  
	  DecisionTable dt5 = dmnHelper.addDecisionTable("DTable_T5", HitPolicy.FIRST, d5);

	  in1 = dmnHelper.addInput("input_rs_T5_1", "Param1", dt5);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T5_1", "double", "T5_参数1", in1);

	  in2 = dmnHelper.addInput("input_rs_T5_2", "Param2", dt5);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T5_2", "double", "T5_参数2", in2);

	  dmnHelper.addOutput("output_rs_T5_1", "Limit3", "T5_限额3", "double", dt5);
	  
	  rule1 = dmnHelper.addRule("Rule_T5_1", "T5 Rule 1", "T5 Rule 1", dt5);
	  dmnHelper.addInputEntry("ExpreTests_rs_T5_R1_1", "<=15.0", rule1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T5_R1_2", "<=0.9", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T5_R1_1", "250", rule1);	  
	  
	  rule2 = dmnHelper.addRule("Rule_T5_2", "T5 Rule 2", "T5 Rule 2", dt5);
	  dmnHelper.addInputEntry("ExpreTests_rs_T5_R2_1", "<=15.0", rule2);
	  dmnHelper.addInputEntry("ExpreTests_rs_T5_R2_2", ">0.9", rule2);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T5_R2_1", "300", rule2);	  

	  rule3 = dmnHelper.addRule("Rule_T5_3", "T5 Rule 3", "T5 Rule 3", dt5);
	  dmnHelper.addInputEntry("ExpreTests_rs_T5_R3_1", ">15.0", rule3);
	  dmnHelper.addInputEntry("ExpreTests_rs_T5_R3_2", "<=1.1", rule3);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T5_R3_1", "400", rule3);	  

	  rule4 = dmnHelper.addRule("Rule_T5_4", "T5 Rule 4", "T5 Rule 4", dt5);
	  dmnHelper.addInputEntry("ExpreTests_rs_T5_R4_1", ">15.0", rule4);
	  dmnHelper.addInputEntry("ExpreTests_rs_T5_R4_2", ">1.1", rule4);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T5_R4_1", "550", rule4);	  

	  /*
	   * DTable Decision_T6
	   */	  
	  Decision d6 = dmnHelper.createDecision("Decision_T6", "T6 RuleSet");

	  // informationRequirement section
	  dmnHelper.addInfoRequirement(d4, d6);
	  dmnHelper.addInfoRequirement(d5, d6);
	  
	  DecisionTable dt6 = dmnHelper.addDecisionTable("DTable_T6", HitPolicy.FIRST, d6);
	  
	  in1 = dmnHelper.addInput("input_rs_T6_1", "T4_Limit3", dt6);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T6_1", "double", "T4_限额3", in1);

	  in2 = dmnHelper.addInput("input_rs_T6_2", "T5_Limit3", dt6);
	  dmnHelper.addInputExpression("LiteralExpression_rs_T6_2", "double", "T5_限额3", in2);

	  dmnHelper.addOutput("output_rs_T6_1", "Limit3", "T6_限额3", "double", dt6);
	  
	  rule1 = dmnHelper.addRule("Rule_T6_1", "T6 Rule 1", "T6 Rule 1", dt6);
	  dmnHelper.addInputEntry("ExpreTests_rs_T6_R1_1", "", rule1);
	  dmnHelper.addInputEntry("ExpreTests_rs_T6_R1_2", "", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_T6_R1_1", 
			  "T4_限额3 > T5_限额3 ? T4_限额3 : T5_限额3", 
			  "juel", rule1);	  
	  /*
	   * DTable Decision_StabilityLimit
	   */	  
	  Decision dStab = dmnHelper.createDecision("Decision_StabilityLimit", "Decision StabilityLimit RuleSet");
	  
	  // informationRequirement section
	  dmnHelper.addInfoRequirement(d1, dStab);
	  dmnHelper.addInfoRequirement(d3, dStab);
	  dmnHelper.addInfoRequirement(d6, dStab);
	  
	  DecisionTable dtStab = dmnHelper.addDecisionTable("DTable_Stab", HitPolicy.FIRST, dStab);

	  in1 = dmnHelper.addInput("input_rs_SL_1", "DateTime", dtStab);
	  dmnHelper.addInputExpression("LiteralExpression_rs_SL_1", "date", "当前时间", in1);

	  in2 = dmnHelper.addInput("input_rs_SL_2", "DateTime", dtStab);
	  dmnHelper.addInputExpression("LiteralExpression_rs_SL_2", "date", "当前时间", in2);

	  dmnHelper.addOutput("output_rs_SL_1", "OptState", "运行状态", "string", dtStab);
	  dmnHelper.addOutput("output_rs_SL_2", "Limit1", "限额1", "double", dtStab);
	  dmnHelper.addOutput("output_rs_SL_3", "Limit2", "限额2", "integer", dtStab);
	  dmnHelper.addOutput("output_rs_SL_4", "Limit3", "限额3", "double", dtStab);

	  rule1 = dmnHelper.addRule("Rule_SL_1", "SL Rule 1", "SL Rule 1", dtStab);
	  dmnHelper.addInputEntry("ExpreTests_rs_SL_R1_1", 
			       "[date and time(\"2019-01-01T12:00:00\")..date and time(\"2019-12-31T12:00:00\")]", rule1);
	  dmnHelper.addInputEntry("ExpreTests_rs_SL_R1_2", 
			       "not([date and time(\"2019-02-04T12:00:00\")..date and time(\"2019-02-10T12:00:00\")])", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_1", "T1_运行状态", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_2", "T1_限额1", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_3", "T1_限额2", rule1);
	  dmnHelper.addOutputEntry("LiteralExpression_rs_SL_R1_4", "T1_限额3", rule1);
	  
	  /*
	   * 
	   */
	  dmnHelper.validateModel();
	  
	  System.out.println(dmnHelper.toString());
	  
	  dmnHelper.writeModelToFile("temp/out.xml");
	}
}