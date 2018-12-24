package proj.rule;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.mvel.MVELCondition;

import cn.sgepri.cep.core.event.BaseEvent;
import cn.sgepri.cep.core.event.TimerEvent;
import cn.sgepri.cep.core.punit.IEventProcessingUnit;
import cn.sgepri.cep.core.rule.BaseCEPRule;

public class HNNewRuleDemo extends BaseCEPRule {
	/**
	 * constructor
	 * 
	 * @param punit
	 */
	public HNNewRuleDemo(IEventProcessingUnit punit) {
		super("test.HNNewRuleDemo", punit);
	}

	@Override
	public boolean evaluate(Facts facts) {
		BaseEvent event = getEvent(facts);
		return event instanceof TimerEvent;
	}

	@Override
	public void execute(Facts facts) throws Exception {
		facts.asMap().forEach((k, v) -> {
			System.out.println(k +"  :"+ v);
		});
		if (new MVELCondition("load > 2200 && load < 2500").evaluate(facts)) {
			if (new MVELCondition("powerOfQishao < 80").evaluate(facts)) {
				if (new MVELCondition("numberOfUnitsInProvince < 27").evaluate(facts)) {
					System.out.println("numberOfUnitsInProvince < 27");
				}
				if (new MVELCondition("numberOfUnitsInCentral < 8").evaluate(facts)) {
					System.out.println("numberOfUnitsInCentral < 8");
				}
				if (new MVELCondition("numberOfUnitsInLoadCenter< 19 ").evaluate(facts)) {
					System.out.println("numberOfUnitsInLoadCenter< 19");
				}
				if (new MVELCondition("minSpinningReserveOfUnitsInLoadCentere<0.1").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.1");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 150").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 150");
				}
			} else if (new MVELCondition("powerOfQishao < 140").evaluate(facts)) {
				if (new MVELCondition("numberOfUnitsInProvince < 28").evaluate(facts)) {
					System.out.println("numberOfUnitsInProvince < 28");
				}
				if (new MVELCondition("numberOfUnitsInCentral < 8").evaluate(facts)) {
					System.out.println("numberOfUnitsInCentral < 8");
				}
				if (new MVELCondition("numberOfUnitsInLoadCenter< 19 ").evaluate(facts)) {
					System.out.println("numberOfUnitsInLoadCenter< 19");
				}
				if (new MVELCondition("minSpinningReserveOfUnitsInLoadCentere<0.15").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.15");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 200").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 200");
				}
			} else if (new MVELCondition("powerOfQishao < 200").evaluate(facts)) {
				if (new MVELCondition("numberOfUnitsInProvince < 28").evaluate(facts)) {
					System.out.println("numberOfUnitsInProvince < 28");
				}
				if (new MVELCondition("numberOfUnitsInCentral < 8").evaluate(facts)) {
					System.out.println("numberOfUnitsInCentral < 8");
				}
				if (new MVELCondition("numberOfUnitsInLoadCenter< 21").evaluate(facts)) {
					System.out.println("numberOfUnitsInLoadCenter< 21");
				}
				if (new MVELCondition("minSpinningReserveOfUnitsInLoadCentere<0.2").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 250").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 250");
				}
			} else if (new MVELCondition("powerOfQishao < 240").evaluate(facts)) {
				if (new MVELCondition("numberOfUnitsInProvince < 28").evaluate(facts)) {
					System.out.println("numberOfUnitsInProvince < 28");
				}
				if (new MVELCondition("numberOfUnitsInCentral < 9").evaluate(facts)) {
					System.out.println("numberOfUnitsInCentral < 9");
				}
				if (new MVELCondition("numberOfUnitsInLoadCenter< 22").evaluate(facts)) {
					System.out.println("numberOfUnitsInLoadCenter< 22");
				}
				if (new MVELCondition("minSpinningReserveOfUnitsInLoadCentere<0.25").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 250").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 250");
				}
			} else if (new MVELCondition("powerOfQishao < 300").evaluate(facts)) {
				if (new MVELCondition("numberOfUnitsInProvince < 29").evaluate(facts)) {
					System.out.println("numberOfUnitsInProvince < 29");
				}
				if (new MVELCondition("numberOfUnitsInCentral < 9").evaluate(facts)) {
					System.out.println("numberOfUnitsInCentral < 9");
				}
				if (new MVELCondition("numberOfUnitsInLoadCenter< 22").evaluate(facts)) {
					System.out.println("numberOfUnitsInLoadCenter< 22");
				}
				if (new MVELCondition(" minSpinningReserveOfUnitsInLoadCentere<0.25").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 280").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 280");
				}
			} else if (new MVELCondition("powerOfQishao < 340").evaluate(facts)) {
				if (new MVELCondition("numberOfUnitsInProvince < 30").evaluate(facts)) {
					System.out.println("numberOfUnitsInProvince < 30");
				}
				if (new MVELCondition("numberOfUnitsInCentral < 9").evaluate(facts)) {
					System.out.println("numberOfUnitsInCentral < 9");
				}
				if (new MVELCondition("numberOfUnitsInLoadCenter< 23").evaluate(facts)) {
					System.out.println("numberOfUnitsInLoadCenter< 23");
				}
				if (new MVELCondition(" minSpinningReserveOfUnitsInLoadCentere<0.25").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 280").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 280");
				}
			} else if (new MVELCondition("powerOfQishao < 400").evaluate(facts)) {
				if (new MVELCondition("numberOfUnitsInProvince < 30").evaluate(facts)) {
					System.out.println("numberOfUnitsInProvince < 30");
				}
				if (new MVELCondition("numberOfUnitsInCentral < 9").evaluate(facts)) {
					System.out.println("numberOfUnitsInCentral < 9");
				}
				if (new MVELCondition("numberOfUnitsInLoadCenter< 23").evaluate(facts)) {
					System.out.println("numberOfUnitsInLoadCenter< 23");
				}
				if (new MVELCondition("minSpinningReserveOfUnitsInLoadCentere<0.3").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.3");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 320").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 320");
				}
			} else if (new MVELCondition("powerOfQishao < 450").evaluate(facts)) {
				if (new MVELCondition("numberOfUnitsInProvince < 30").evaluate(facts)) {
					System.out.println("numberOfUnitsInProvince < 30");
				}
				if (new MVELCondition("numberOfUnitsInCentral < 9").evaluate(facts)) {
					System.out.println("numberOfUnitsInCentral < 9");
				}
				if (new MVELCondition("numberOfUnitsInLoadCenter< 23").evaluate(facts)) {
					System.out.println("numberOfUnitsInLoadCenter< 23");
				}
				if (new MVELCondition("numberOfUnitsInLoadCenter< 23").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.3");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 340").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 340");
				}
			}
		} else {

		}
		
	}
}