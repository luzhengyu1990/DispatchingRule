package proj.rule;

import java.util.List;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.mvel.MVELCondition;

import com.interpss.core.aclf.AclfGen;
import com.interpss.core.aclf.AclfLoad;

import cn.sgepri.cep.core.event.BaseEvent;
import cn.sgepri.cep.core.event.TimerEvent;
import cn.sgepri.cep.core.punit.IEventProcessingUnit;
import cn.sgepri.cep.core.rule.BaseCEPRule;

public class HNNewRuleDemo2 extends BaseCEPRule {
	/**
	 * constructor
	 * 
	 * @param punit
	 */
	public HNNewRuleDemo2(IEventProcessingUnit punit) {
		super("test.HNNewRuleDemo", punit);
	}

	@Override
	public boolean evaluate(Facts facts) {
		BaseEvent event = getEvent(facts);
		return event instanceof TimerEvent;
	}

	@Override
	public void execute(Facts facts) throws Exception {
		List<AclfLoad> loads = facts.get("loads");
		List<AclfLoad> qishaoLoads = facts.get("qishaoLoads");
		List<AclfGen> unitsInLoadCenter = facts.get("unitsInLoadCenter");
		List<AclfGen> units220OrAbove = facts.get("units220OrAbove");
		facts.put("loadP", loads.stream().mapToDouble(load -> load.getLoadCP().getReal()).sum());
		facts.put("powerOfQishao", qishaoLoads.stream().mapToDouble(load -> load.getLoadCP().getReal()).sum());
		facts.put("minSpinningReserveOfUnitsInLoadCentere",
				unitsInLoadCenter.stream().mapToDouble(
						gen -> (gen.getPGenLimit().getMax() - gen.getGen().getReal()) / gen.getPGenLimit().getMax())
						.min().getAsDouble());
		facts.put("spinningReserveOfUnits220OrAbove", units220OrAbove.stream()
				.mapToDouble(gen -> gen.getPGenLimit().getMax() - gen.getGen().getReal()).sum());
		if (new MVELCondition("loadP > 2200 && loadP < 2500").evaluate(facts)) {
			if (new MVELCondition("powerOfQishao < 80").evaluate(facts)) {
				if (new MVELCondition("unitsInProvince.size < 27").evaluate(facts)) {
					System.out.println("unitsInProvince.size < 27");
				}
				if (new MVELCondition("unitsInCentral.size < 8").evaluate(facts)) {
					System.out.println("unitsInCentral.size < 8");
				}
				if (new MVELCondition("unitsInLoadCenter.size< 19 ").evaluate(facts)) {
					System.out.println("unitsInLoadCenter.size< 19");
				}
				if (new MVELCondition("minSpinningReserveOfUnitsInLoadCentere<0.1").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.1");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 150").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 150");
				}
			} else if (new MVELCondition("powerOfQishao < 140").evaluate(facts)) {
				if (new MVELCondition("unitsInProvince.size < 28").evaluate(facts)) {
					System.out.println("unitsInProvince.size < 28");
				}
				if (new MVELCondition("unitsInCentral.size < 8").evaluate(facts)) {
					System.out.println("unitsInCentral.size < 8");
				}
				if (new MVELCondition("unitsInLoadCenter.size< 19 ").evaluate(facts)) {
					System.out.println("unitsInLoadCenter.size< 19");
				}
				if (new MVELCondition("minSpinningReserveOfUnitsInLoadCentere<0.15").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.15");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 200").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 200");
				}
			} else if (new MVELCondition("powerOfQishao < 200").evaluate(facts)) {
				if (new MVELCondition("unitsInProvince.size < 28").evaluate(facts)) {
					System.out.println("unitsInProvince.size < 28");
				}
				if (new MVELCondition("unitsInCentral.size < 8").evaluate(facts)) {
					System.out.println("unitsInCentral.size < 8");
				}
				if (new MVELCondition("unitsInLoadCenter.size< 21").evaluate(facts)) {
					System.out.println("unitsInLoadCenter.size< 21");
				}
				if (new MVELCondition("minSpinningReserveOfUnitsInLoadCentere<0.2").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 250").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 250");
				}
			} else if (new MVELCondition("powerOfQishao < 240").evaluate(facts)) {
				if (new MVELCondition("unitsInProvince.size < 28").evaluate(facts)) {
					System.out.println("unitsInProvince.size < 28");
				}
				if (new MVELCondition("unitsInCentral.size < 9").evaluate(facts)) {
					System.out.println("unitsInCentral.size < 9");
				}
				if (new MVELCondition("unitsInLoadCenter.size< 22").evaluate(facts)) {
					System.out.println("unitsInLoadCenter.size< 22");
				}
				if (new MVELCondition("minSpinningReserveOfUnitsInLoadCentere<0.25").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 250").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 250");
				}
			} else if (new MVELCondition("powerOfQishao < 300").evaluate(facts)) {
				if (new MVELCondition("unitsInProvince.size < 29").evaluate(facts)) {
					System.out.println("unitsInProvince.size < 29");
				}
				if (new MVELCondition("unitsInCentral.size < 9").evaluate(facts)) {
					System.out.println("unitsInCentral.size < 9");
				}
				if (new MVELCondition("unitsInLoadCenter.size< 22").evaluate(facts)) {
					System.out.println("unitsInLoadCenter.size< 22");
				}
				if (new MVELCondition(" minSpinningReserveOfUnitsInLoadCentere<0.25").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 280").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 280");
				}
			} else if (new MVELCondition("powerOfQishao < 340").evaluate(facts)) {
				if (new MVELCondition("unitsInProvince.size < 30").evaluate(facts)) {
					System.out.println("unitsInProvince.size < 30");
				}
				if (new MVELCondition("unitsInCentral.size < 9").evaluate(facts)) {
					System.out.println("unitsInCentral.size < 9");
				}
				if (new MVELCondition("unitsInLoadCenter.size< 23").evaluate(facts)) {
					System.out.println("unitsInLoadCenter.size< 23");
				}
				if (new MVELCondition(" minSpinningReserveOfUnitsInLoadCentere<0.25").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 280").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 280");
				}
			} else if (new MVELCondition("powerOfQishao < 400").evaluate(facts)) {
				if (new MVELCondition("unitsInProvince.size < 30").evaluate(facts)) {
					System.out.println("unitsInProvince.size < 30");
				}
				if (new MVELCondition("unitsInCentral.size < 9").evaluate(facts)) {
					System.out.println("unitsInCentral.size < 9");
				}
				if (new MVELCondition("unitsInLoadCenter.size< 23").evaluate(facts)) {
					System.out.println("unitsInLoadCenter.size< 23");
				}
				if (new MVELCondition("minSpinningReserveOfUnitsInLoadCentere<0.3").evaluate(facts)) {
					System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.3");
				}
				if (new MVELCondition("spinningReserveOfUnits220OrAbove< 320").evaluate(facts)) {
					System.out.println("spinningReserveOfUnits220OrAbove< 320");
				}
			} else if (new MVELCondition("powerOfQishao < 450").evaluate(facts)) {
				if (new MVELCondition("unitsInProvince.size < 30").evaluate(facts)) {
					System.out.println("unitsInProvince.size < 30");
				}
				if (new MVELCondition("unitsInCentral.size < 9").evaluate(facts)) {
					System.out.println("unitsInCentral.size < 9");
				}
				if (new MVELCondition("unitsInLoadCenter.size< 23").evaluate(facts)) {
					System.out.println("unitsInLoadCenter.size< 23");
				}
				if (new MVELCondition("minSpinningReserveOfUnitsInLoadCentere<0.3").evaluate(facts)) {
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