package sample;

import java.io.File;

import org.camunda.bpm.model.dmn.Dmn;
import org.camunda.bpm.model.dmn.DmnModelInstance;

public class ReadSample {

	public static void main(String[] args) {
		DmnModelInstance modelInstance = Dmn.readModelFromFile(new File("temp/StabilityLimits.xml"));	
		
		System.out.println(Dmn.convertToString(modelInstance));
	}
}