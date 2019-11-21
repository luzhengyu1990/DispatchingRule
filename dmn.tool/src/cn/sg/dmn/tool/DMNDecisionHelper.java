package cn.sg.dmn.tool;

import java.util.List;

import org.camunda.bpm.dmn.engine.DmnDecision;

/**
 * DMN Decision Table utility helper class
 * 
 * @author mikez
 *
 */
public class DMNDecisionHelper {
	/**
	 * get the decision from the decision set
	 * 
	 * @param ruleId DMN decision id
	 * @param decisionSets DMN decision list
	 * @return
	 */
	public static DmnDecision getDecision(String decisionId, List<DmnDecision> decisionSet) {
		for (DmnDecision d : decisionSet) {
			if (d.getKey().equals(decisionId))
				return d;
		}
		return null;
	}

}
