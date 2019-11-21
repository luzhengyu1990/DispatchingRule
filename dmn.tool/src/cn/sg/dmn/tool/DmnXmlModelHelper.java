package cn.sg.dmn.tool;

import java.io.File;

import org.camunda.bpm.model.dmn.Dmn;
import org.camunda.bpm.model.dmn.DmnModelInstance;
import org.camunda.bpm.model.dmn.HitPolicy;
import org.camunda.bpm.model.dmn.instance.Decision;
import org.camunda.bpm.model.dmn.instance.DecisionTable;
import org.camunda.bpm.model.dmn.instance.Definitions;
import org.camunda.bpm.model.dmn.instance.Description;
import org.camunda.bpm.model.dmn.instance.InformationRequirement;
import org.camunda.bpm.model.dmn.instance.Input;
import org.camunda.bpm.model.dmn.instance.InputData;
import org.camunda.bpm.model.dmn.instance.InputEntry;
import org.camunda.bpm.model.dmn.instance.InputExpression;
import org.camunda.bpm.model.dmn.instance.Output;
import org.camunda.bpm.model.dmn.instance.OutputEntry;
import org.camunda.bpm.model.dmn.instance.Rule;
import org.camunda.bpm.model.dmn.instance.Text;
import org.camunda.bpm.model.xml.ModelValidationException;

/**
 * DMN model helper for creating DMN XML documents.
 * 
 * @author Mike
 *
 */
public class DmnXmlModelHelper {
	public static String TypeRef_String  = "string";
	public static String TypeRef_Double  = "double";
	public static String TypeRef_Integer = "integer";
	public static String TypeRef_Date    = "date";

	private static String Namespace = "http://camunda.org/schema/1.0/dmn";
	private static String DefId = "definitions";
	private static String DefName = "definitions";
	
	private DmnModelInstance modelInstance;
	private Definitions definitions;
	
	/**
	 * default constructor
	 */
	public DmnXmlModelHelper() {
		this(DefId, DefName);
	}
	
	/**
	 * constructor
	 * 
	 * @param defId
	 * @param defName
	 */
	public DmnXmlModelHelper(String defId, String defName) {
	    this.modelInstance = Dmn.createEmptyModel();
	    
	    this.definitions = modelInstance.newInstance(Definitions.class);
	    this.modelInstance.setDefinitions(this.definitions);	

	    this.definitions.setNamespace(Namespace);
	    this.definitions.setName(defName);
	    this.definitions.setId(defId);
	}

	/**
	 * create an InputData element
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public InputData createInputData(String id, String name) {
		InputData inData = this.modelInstance.newInstance(InputData.class);
	    inData.setId(id);
	    inData.setName(name);

	    /*
	     * There is a problem to call this function
	     */
	    //this.definitions.addChildElement(inData);	   
	    
	    return inData;
	}
	
	/**
	 * create a Decision element
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public Decision createDecision(String id, String name) {
	    Decision decision = this.modelInstance.newInstance(Decision.class);
	    this.definitions.addChildElement(decision);	   
	    
	    decision.setId(id);
	    decision.setName(name);
	    
	    return decision;
	}

	/**
	 * add an InformationRequirement element
	 * 
	 * @param inData
	 * @param parentDecision
	 */
	public void addInfoRequirement(InputData inData, Decision parentDecision) {
		InformationRequirement info = this.modelInstance.newInstance(InformationRequirement.class);
	    parentDecision.getInformationRequirements().add(info);		
	    info.setRequiredInput(inData);
	}

	/**
	 * add an InformationRequirement element
	 * 
	 * @param reqDecision
	 * @param parentDecision
	 */
	public void addInfoRequirement(Decision reqDecision, Decision parentDecision) {
		InformationRequirement info = this.modelInstance.newInstance(InformationRequirement.class);
	    parentDecision.getInformationRequirements().add(info);		
	    info.setRequiredDecision(reqDecision);
	}	
	
	/**
	 * add a DecisionTable element
	 * 
	 * @param id
	 * @param policy
	 * @param parentDecision the parent Decision element
	 * @return
	 */
	public DecisionTable addDecisionTable(String id, HitPolicy policy, Decision parentDecision) {
	    DecisionTable decisionTable = this.modelInstance.newInstance(DecisionTable.class);
	    decisionTable.setId(id);
	    decisionTable.setHitPolicy(policy);
	    parentDecision.addChildElement(decisionTable);		
	    return decisionTable;
	}
	
	/**
	 * create an Input element
	 * 
	 * @param id
	 * @param label
	 * @param parentDTable
	 * @return
	 */
	public Input addInput(String id, String label, DecisionTable parentDTable) {
	    Input input = this.modelInstance.newInstance(Input.class);
	    input.setId(id);
	    input.setLabel(label);
	    parentDTable.addChildElement(input);
	    return input;
	}
	
	/**
	 * add an InputExpression element the parent Input element
	 * 
	 * @param id
	 * @param typeRef
	 * @param text
	 * @param parentInput
	 * @return
	 */
	public void addInputExpression(String id, String typeRef, String text, Input parentInput) {
	    InputExpression inputExp = this.modelInstance.newInstance(InputExpression.class);
	    inputExp.setId(id);
	    inputExp.setTypeRef(typeRef);
	    parentInput.addChildElement(inputExp);
	    
	    Text textObj = this.modelInstance.newInstance(Text.class);
	    textObj.setTextContent(text);
	    inputExp.setText(textObj);
	}
	
	/**
	 * add an Output element the parent DecisionTable element 
	 * 
	 * @param id
	 * @param label
	 * @param name
	 * @param typeRef
	 * @param parentDTable
	 */
	public void addOutput(String id, String label, String name, String typeRef, DecisionTable parentDTable) {
	    Output output = modelInstance.newInstance(Output.class);
	    output.setId(id);
	    output.setLabel(label);
	    output.setName(name);
	    output.setTypeRef(typeRef);
	    parentDTable.addChildElement(output);
	}
	
	/**
	 * add a Rule element to the parent DecisionTable element
	 * 
	 * @param id
	 * @param parentDTable
	 * @return
	 */
	public Rule addRule(String id, DecisionTable parentDTable) {
	    Rule rule = modelInstance.newInstance(Rule.class);
	    rule.setId(id);
	    parentDTable.addChildElement(rule);	
	    return rule;
	}
	
	/**
	 * add a Rule element to the parent DecisionTable element
	 * 
	 * @param id
	 * @param label
	 * @param parentDTable
	 * @return
	 */
	public Rule addRule(String id, String label, DecisionTable parentDTable) {
	    Rule rule = addRule(id, parentDTable);
	    rule.setLabel(label);
	    return rule;
	}	
	
	/**
	 * add a Rule element to the parent DecisionTable element
	 * 
	 * @param id
	 * @param label
	 * @param parentDTable
	 * @return
	 */
	public Rule addRule(String id, String label, String desc, DecisionTable parentDTable) {
	    Rule rule = addRule(id, parentDTable);
	    Description descObj = this.modelInstance.newInstance(Description.class);
	    descObj.setTextContent(desc);
	    rule.setDescription(descObj);
	    return rule;
	}	
	
	/**
	 * add an InputEntry element to the parent Rule element
	 * 
	 * @param id
	 * @param textContent
	 * @param parentRule the parent Rule element
	 */
	public void addInputEntry(String id, String textContent, Rule parentRule) {
	    InputEntry inputEntry = this.modelInstance.newInstance(InputEntry.class);
	    inputEntry.setId(id);
	    parentRule.addChildElement(inputEntry);	
	    
	    Text text = this.modelInstance.newInstance(Text.class);
	    text.setTextContent(textContent);
	    inputEntry.addChildElement(text);
	}
	
	/**
	 * add an OutputEntry element to the parent Rule element
	 * 
	 * @param id
	 * @param textContent
	 * @param parentRule the parent Rule element
	 */
	public OutputEntry addOutputEntry(String id, String textContent, Rule parentRule) {
	    OutputEntry outputEntry = modelInstance.newInstance(OutputEntry.class);
	    outputEntry.setId(id);
	    parentRule.addChildElement(outputEntry);
	    
	    Text text = modelInstance.newInstance(Text.class);
	    text.setTextContent(textContent);
	    outputEntry.addChildElement(text);
	    
	    return outputEntry;
	}

	/**
	 * add an OutputEntry element to the parent Rule element
	 * 
	 * @param id
	 * @param textContent
	 * @param parentRule the parent Rule element
	 */
	public OutputEntry addOutputEntry(String id, String textContent, String expLang, Rule parentRule) {
	    OutputEntry outputEntry = addOutputEntry(id, textContent, parentRule);
	    outputEntry.setExpressionLanguage(expLang);
	    return outputEntry;
	}	
	/**
	 * validate the DMN model
	 * 
	 * @throws ModelValidationException
	 */
	public void validateModel() throws ModelValidationException {
	    Dmn.validateModel(this.modelInstance);		
	}

	/**
	 * write to DMN model to a file
	 * 
	 * @param filename
	 */
	public void writeModelToFile(String filename) {
	    Dmn.writeModelToFile(new File(filename), this.modelInstance);		
	}
	
	public String toString() {
		return Dmn.convertToString(this.modelInstance);
	}
}