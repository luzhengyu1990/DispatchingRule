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

public class HNNewRuleDemo4 extends BaseCEPRule {
	/**
	 * constructor
	 * 
	 * @param punit
	 */
	public HNNewRuleDemo4(IEventProcessingUnit punit) {
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
		List<AclfGen> unitsInProvince = facts.get("unitsInProvince");
		List<AclfGen> unitsInCentral = facts.get("unitsInCentral");
		List<AclfGen> jiangcanBranchList = facts.get("jiangcanBranchList");
		List<AclfGen> canliBranchList = facts.get("canliBranchList");
		List<AclfGen> lifuBranchList = facts.get("lifuBranchList");
		List<AclfGen> gegangBranchList = facts.get("gegangBranchList");
		double loadP = loads.stream().mapToDouble(load -> load.getLoadCP().getReal()).sum();
		double powerOfQishao = qishaoLoads.stream().mapToDouble(load -> load.getLoadCP().getReal()).sum();
		double minSpinningReserveOfUnitsInLoadCentere = unitsInLoadCenter.stream()
				.mapToDouble(
						gen -> (gen.getPGenLimit().getMax() - gen.getGen().getReal()) / gen.getPGenLimit().getMax())
				.min().getAsDouble();
		double spinningReserveOfUnits220OrAbove = units220OrAbove.stream()
				.mapToDouble(gen -> gen.getPGenLimit().getMax() - gen.getGen().getReal()).sum();
		if (jiangcanBranchList.size() == 2 && canliBranchList.size() == 2 && lifuBranchList.size() == 2
				&& gegangBranchList.size() == 1) {
			if (loadP > 2200 && loadP < 2500) {
				if (powerOfQishao < 80) {
					if (unitsInProvince.size() < 27) {
						System.out.println("unitsInProvince.size < 27");
					}
					if (unitsInCentral.size() < 8) {
						System.out.println("unitsInCentral.size < 8");
					}
					if (unitsInLoadCenter.size() < 19) {
						System.out.println("unitsInLoadCenter.size()< 19");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.1) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.1");
					}
					if (spinningReserveOfUnits220OrAbove < 150) {
						System.out.println("spinningReserveOfUnits220OrAbove< 150");
					}
				} else if (powerOfQishao < 140) {
					if (unitsInProvince.size() < 28) {
						System.out.println("unitsInProvince.size < 28");
					}
					if (unitsInCentral.size() < 8) {
						System.out.println("unitsInCentral.size < 8");
					}
					if (unitsInLoadCenter.size() < 19) {
						System.out.println("unitsInLoadCenter.size< 19");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.15) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.15");
					}
					if (spinningReserveOfUnits220OrAbove < 200) {
						System.out.println("spinningReserveOfUnits220OrAbove< 200");
					}
				} else if (powerOfQishao < 200) {
					if (unitsInProvince.size() < 28) {
						System.out.println("unitsInProvince.size < 28");
					}
					if (unitsInCentral.size() < 8) {
						System.out.println("unitsInCentral.size < 8");
					}
					if (unitsInLoadCenter.size() < 21) {
						System.out.println("unitsInLoadCenter.size< 21");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
					}
					if (spinningReserveOfUnits220OrAbove < 250) {
						System.out.println("spinningReserveOfUnits220OrAbove< 250");
					}
				} else if (powerOfQishao < 240) {
					if (unitsInProvince.size() < 28) {
						System.out.println("unitsInProvince.size < 28");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 22) {
						System.out.println("unitsInLoadCenter.size< 22");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.25) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
					}
					if (spinningReserveOfUnits220OrAbove < 250) {
						System.out.println("spinningReserveOfUnits220OrAbove< 250");
					}
				} else if (powerOfQishao < 300) {
					if (unitsInProvince.size() < 29) {
						System.out.println("unitsInProvince.size < 29");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 22) {
						System.out.println("unitsInLoadCenter.size< 22");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.25) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
					}
					if (spinningReserveOfUnits220OrAbove < 280) {
						System.out.println("spinningReserveOfUnits220OrAbove< 280");
					}
				} else if (powerOfQishao < 340) {
					if (unitsInProvince.size() < 30) {
						System.out.println("unitsInProvince.size < 30");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 23) {
						System.out.println("unitsInLoadCenter.size< 23");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.25) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
					}
					if (spinningReserveOfUnits220OrAbove < 280) {
						System.out.println("spinningReserveOfUnits220OrAbove< 280");
					}
				} else if (powerOfQishao < 400) {
					if (unitsInProvince.size() < 30) {
						System.out.println("unitsInProvince.size < 30");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 23) {
						System.out.println("unitsInLoadCenter.size< 23");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.3) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.3");
					}
					if (spinningReserveOfUnits220OrAbove < 320) {
						System.out.println("spinningReserveOfUnits220OrAbove< 320");
					}
				} else if (powerOfQishao < 450) {
					if (unitsInProvince.size() < 30) {
						System.out.println("unitsInProvince.size < 30");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 23) {
						System.out.println("unitsInLoadCenter.size< 23");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.3) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.3");
					}
					if (spinningReserveOfUnits220OrAbove < 340) {
						System.out.println("spinningReserveOfUnits220OrAbove< 340");
					}
				}
			} else if (loadP > 2500 && loadP < 2800) {
				if (powerOfQishao < 80) {
					if (unitsInProvince.size() < 33) {
						System.out.println("unitsInProvince.size < 33");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 20) {
						System.out.println("unitsInLoadCenter.size()< 20");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.1) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.1");
					}
					if (spinningReserveOfUnits220OrAbove < 80) {
						System.out.println("spinningReserveOfUnits220OrAbove< 80");
					}
				} else if (powerOfQishao < 140) {
					if (unitsInProvince.size() < 34) {
						System.out.println("unitsInProvince.size < 34");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 21) {
						System.out.println("unitsInLoadCenter.size< 21");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.1) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.1");
					}
					if (spinningReserveOfUnits220OrAbove < 150) {
						System.out.println("spinningReserveOfUnits220OrAbove< 150");
					}
				} else if (powerOfQishao < 200) {
					if (unitsInProvince.size() < 34) {
						System.out.println("unitsInProvince.size < 34");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 21) {
						System.out.println("unitsInLoadCenter.size< 21");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
					}
					if (spinningReserveOfUnits220OrAbove < 200) {
						System.out.println("spinningReserveOfUnits220OrAbove< 200");
					}
				} else if (powerOfQishao < 240) {
					if (unitsInProvince.size() < 35) {
						System.out.println("unitsInProvince.size < 35");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 23) {
						System.out.println("unitsInLoadCenter.size< 23");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
					}
					if (spinningReserveOfUnits220OrAbove < 230) {
						System.out.println("spinningReserveOfUnits220OrAbove< 230");
					}
				} else if (powerOfQishao < 300) {
					if (unitsInProvince.size() < 35) {
						System.out.println("unitsInProvince.size < 35");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 24) {
						System.out.println("unitsInLoadCenter.size< 24");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
					}
					if (spinningReserveOfUnits220OrAbove < 250) {
						System.out.println("spinningReserveOfUnits220OrAbove< 250");
					}
				} else if (powerOfQishao < 340) {
					if (unitsInProvince.size() < 34) {
						System.out.println("unitsInProvince.size < 34");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 24) {
						System.out.println("unitsInLoadCenter.size< 24");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
					}
					if (spinningReserveOfUnits220OrAbove < 250) {
						System.out.println("spinningReserveOfUnits220OrAbove< 250");
					}
				} else if (powerOfQishao < 400) {
					if (unitsInProvince.size() < 35) {
						System.out.println("unitsInProvince.size < 35");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 24) {
						System.out.println("unitsInLoadCenter.size< 24");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
					}
					if (spinningReserveOfUnits220OrAbove < 300) {
						System.out.println("spinningReserveOfUnits220OrAbove< 300");
					}
				} else if (powerOfQishao < 450) {
					if (unitsInProvince.size() < 35) {
						System.out.println("unitsInProvince.size < 35");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 24) {
						System.out.println("unitsInLoadCenter.size< 24");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
					}
					if (spinningReserveOfUnits220OrAbove < 320) {
						System.out.println("spinningReserveOfUnits220OrAbove< 320");
					}
				}
			}
			else if (loadP > 2800) {
				if (powerOfQishao < 80) {
					if (unitsInProvince.size() < 34) {
						System.out.println("unitsInProvince.size < 34");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 23) {
						System.out.println("unitsInLoadCenter.size()< 23");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.05) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.05");
					}
					if (spinningReserveOfUnits220OrAbove < 80) {
						System.out.println("spinningReserveOfUnits220OrAbove< 80");
					}
				} else if (powerOfQishao < 140) {
					if (unitsInProvince.size() < 34) {
						System.out.println("unitsInProvince.size < 34");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 23) {
						System.out.println("unitsInLoadCenter.size< 23");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.05) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.05");
					}
					if (spinningReserveOfUnits220OrAbove < 180) {
						System.out.println("spinningReserveOfUnits220OrAbove< 180");
					}
				} else if (powerOfQishao < 200) {
					if (unitsInProvince.size() < 35) {
						System.out.println("unitsInProvince.size < 35");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 23) {
						System.out.println("unitsInLoadCenter.size< 23");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.1) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.1");
					}
					if (spinningReserveOfUnits220OrAbove < 230) {
						System.out.println("spinningReserveOfUnits220OrAbove< 230");
					}
				} else if (powerOfQishao < 240) {
					if (unitsInProvince.size() < 35) {
						System.out.println("unitsInProvince.size < 35");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 23) {
						System.out.println("unitsInLoadCenter.size< 23");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.15) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.15");
					}
					if (spinningReserveOfUnits220OrAbove < 250) {
						System.out.println("spinningReserveOfUnits220OrAbove< 250");
					}
				} else if (powerOfQishao < 300) {
					if (unitsInProvince.size() < 36) {
						System.out.println("unitsInProvince.size < 36");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 24) {
						System.out.println("unitsInLoadCenter.size< 24");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.15) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.15");
					}
					if (spinningReserveOfUnits220OrAbove < 250) {
						System.out.println("spinningReserveOfUnits220OrAbove< 250");
					}
				} else if (powerOfQishao < 340) {
					if (unitsInProvince.size() < 36) {
						System.out.println("unitsInProvince.size < 36");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 24) {
						System.out.println("unitsInLoadCenter.size< 24");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.15) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.15");
					}
					if (spinningReserveOfUnits220OrAbove < 280) {
						System.out.println("spinningReserveOfUnits220OrAbove< 280");
					}
				} else if (powerOfQishao < 400) {
					if (unitsInProvince.size() < 36) {
						System.out.println("unitsInProvince.size < 36");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 24) {
						System.out.println("unitsInLoadCenter.size< 24");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
					}
					if (spinningReserveOfUnits220OrAbove < 310) {
						System.out.println("spinningReserveOfUnits220OrAbove< 310");
					}
				} else if (powerOfQishao < 450) {
					if (unitsInProvince.size() < 36) {
						System.out.println("unitsInProvince.size < 36");
					}
					if (unitsInCentral.size() < 9) {
						System.out.println("unitsInCentral.size < 9");
					}
					if (unitsInLoadCenter.size() < 24) {
						System.out.println("unitsInLoadCenter.size< 24");
					}
					if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
						System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
					}
					if (spinningReserveOfUnits220OrAbove < 330) {
						System.out.println("spinningReserveOfUnits220OrAbove< 330");
					}
				}
			} else if (jiangcanBranchList.size() + canliBranchList.size() + lifuBranchList.size() < 6) {
				if (loadP <= 1300) {
					if (powerOfQishao < 80) {
						if (unitsInProvince.size() < 9) {
							System.out.println("unitsInProvince.size < 9");
						}
						if (unitsInCentral.size() < 4) {
							System.out.println("unitsInCentral.size < 4");
						}
						if (unitsInLoadCenter.size() < 9) {
							System.out.println("unitsInLoadCenter.size()< 9");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.4) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.4");
						}
						if (spinningReserveOfUnits220OrAbove < 150) {
							System.out.println("spinningReserveOfUnits220OrAbove< 150");
						}
					} else if (powerOfQishao < 140) {
						if (unitsInProvince.size() < 12) {
							System.out.println("unitsInProvince.size < 12");
						}
						if (unitsInCentral.size() < 4) {
							System.out.println("unitsInCentral.size < 4");
						}
						if (unitsInLoadCenter.size() < 12) {
							System.out.println("unitsInLoadCenter.size< 12");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.4) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.4");
						}
						if (spinningReserveOfUnits220OrAbove < 180) {
							System.out.println("spinningReserveOfUnits220OrAbove< 180");
						}
					} else if (powerOfQishao < 200) {
						if (unitsInProvince.size() < 15) {
							System.out.println("unitsInProvince.size < 15");
						}
						if (unitsInCentral.size() < 4) {
							System.out.println("unitsInCentral.size < 4");
						}
						if (unitsInLoadCenter.size() < 15) {
							System.out.println("unitsInLoadCenter.size< 15");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.45) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.45");
						}
						if (spinningReserveOfUnits220OrAbove < 300) {
							System.out.println("spinningReserveOfUnits220OrAbove< 300");
						}
					} else if (powerOfQishao < 240) {
						if (unitsInProvince.size() < 17) {
							System.out.println("unitsInProvince.size < 17");
						}
						if (unitsInCentral.size() < 4) {
							System.out.println("unitsInCentral.size < 4");
						}
						if (unitsInLoadCenter.size() < 16) {
							System.out.println("unitsInLoadCenter.size< 16");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.45) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.45");
						}
						if (spinningReserveOfUnits220OrAbove < 300) {
							System.out.println("spinningReserveOfUnits220OrAbove< 300");
						}
					}
				}

				if (loadP > 1300 && loadP < 1600) {
					if (powerOfQishao < 80) {
						if (unitsInProvince.size() < 12) {
							System.out.println("unitsInProvince.size < 12");
						}
						if (unitsInCentral.size() < 4) {
							System.out.println("unitsInCentral.size < 4");
						}
						if (unitsInLoadCenter.size() < 10) {
							System.out.println("unitsInLoadCenter.size()< 10");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.25) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
						}
						if (spinningReserveOfUnits220OrAbove < 150) {
							System.out.println("spinningReserveOfUnits220OrAbove< 150");
						}
					} else if (powerOfQishao < 140) {
						if (unitsInProvince.size() < 15) {
							System.out.println("unitsInProvince.size < 15");
						}
						if (unitsInCentral.size() < 4) {
							System.out.println("unitsInCentral.size < 4");
						}
						if (unitsInLoadCenter.size() < 14) {
							System.out.println("unitsInLoadCenter.size< 14");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.25) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
						}
						if (spinningReserveOfUnits220OrAbove < 180) {
							System.out.println("spinningReserveOfUnits220OrAbove< 180");
						}
					} else if (powerOfQishao < 200) {
						if (unitsInProvince.size() < 17) {
							System.out.println("unitsInProvince.size <17");
						}
						if (unitsInCentral.size() < 4) {
							System.out.println("unitsInCentral.size < 4");
						}
						if (unitsInLoadCenter.size() < 15) {
							System.out.println("unitsInLoadCenter.size< 15");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.35) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.35");
						}
						if (spinningReserveOfUnits220OrAbove < 250) {
							System.out.println("spinningReserveOfUnits220OrAbove< 250");
						}
					} else if (powerOfQishao < 240) {
						if (unitsInProvince.size() < 19) {
							System.out.println("unitsInProvince.size < 19");
						}
						if (unitsInCentral.size() < 5) {
							System.out.println("unitsInCentral.size < 5");
						}
						if (unitsInLoadCenter.size() < 19) {
							System.out.println("unitsInLoadCenter.size< 19");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.35) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.35");
						}
						if (spinningReserveOfUnits220OrAbove < 300) {
							System.out.println("spinningReserveOfUnits220OrAbove< 300");
						}
					}
				}

				if (loadP > 1600 && loadP < 1900) {
					if (powerOfQishao < 80) {
						if (unitsInProvince.size() < 19) {
							System.out.println("unitsInProvince.size < 19");
						}
						if (unitsInCentral.size() < 5) {
							System.out.println("unitsInCentral.size < 5");
						}
						if (unitsInLoadCenter.size() < 13) {
							System.out.println("unitsInLoadCenter.size()< 13");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
						}
						if (spinningReserveOfUnits220OrAbove < 150) {
							System.out.println("spinningReserveOfUnits220OrAbove< 150");
						}
					} else if (powerOfQishao < 140) {
						if (unitsInProvince.size() < 19) {
							System.out.println("unitsInProvince.size < 19");
						}
						if (unitsInCentral.size() < 5) {
							System.out.println("unitsInCentral.size < 5");
						}
						if (unitsInLoadCenter.size() < 14) {
							System.out.println("unitsInLoadCenter.size< 14");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.3) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.3");
						}
						if (spinningReserveOfUnits220OrAbove < 230) {
							System.out.println("spinningReserveOfUnits220OrAbove< 230");
						}
					} else if (powerOfQishao < 200) {
						if (unitsInProvince.size() < 20) {
							System.out.println("unitsInProvince.size < 20");
						}
						if (unitsInCentral.size() < 5) {
							System.out.println("unitsInCentral.size < 5");
						}
						if (unitsInLoadCenter.size() < 15) {
							System.out.println("unitsInLoadCenter.size< 15");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.35) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.35");
						}
						if (spinningReserveOfUnits220OrAbove < 280) {
							System.out.println("spinningReserveOfUnits220OrAbove< 280");
						}
					} else if (powerOfQishao < 240) {
						if (unitsInProvince.size() < 21) {
							System.out.println("unitsInProvince.size < 21");
						}
						if (unitsInCentral.size() < 6) {
							System.out.println("unitsInCentral.size < 6");
						}
						if (unitsInLoadCenter.size() < 19) {
							System.out.println("unitsInLoadCenter.size< 19");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.35) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.35");
						}
						if (spinningReserveOfUnits220OrAbove < 280) {
							System.out.println("spinningReserveOfUnits220OrAbove< 280");
						}
					} else if (powerOfQishao < 300) {
						if (unitsInProvince.size() < 21) {
							System.out.println("unitsInProvince.size < 21");
						}
						if (unitsInCentral.size() < 6) {
							System.out.println("unitsInCentral.size < 6");
						}
						if (unitsInLoadCenter.size() < 19) {
							System.out.println("unitsInLoadCenter.size< 19");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.35) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.35");
						}
						if (spinningReserveOfUnits220OrAbove < 300) {
							System.out.println("spinningReserveOfUnits220OrAbove< 300");
						}
					}
				}

				if (loadP > 1900 && loadP < 2200) {
					if (powerOfQishao < 80) {
						if (unitsInProvince.size() < 25) {
							System.out.println("unitsInProvince.size < 25");
						}
						if (unitsInCentral.size() < 6) {
							System.out.println("unitsInCentral.size < 6");
						}
						if (unitsInLoadCenter.size() < 15) {
							System.out.println("unitsInLoadCenter.size()< 15");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.15) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.15");
						}
						if (spinningReserveOfUnits220OrAbove < 130) {
							System.out.println("spinningReserveOfUnits220OrAbove< 130");
						}
					} else if (powerOfQishao < 140) {
						if (unitsInProvince.size() < 26) {
							System.out.println("unitsInProvince.size < 26");
						}
						if (unitsInCentral.size() < 6) {
							System.out.println("unitsInCentral.size < 6");
						}
						if (unitsInLoadCenter.size() < 15) {
							System.out.println("unitsInLoadCenter.size< 15");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
						}
						if (spinningReserveOfUnits220OrAbove < 200) {
							System.out.println("spinningReserveOfUnits220OrAbove< 200");
						}
					} else if (powerOfQishao < 200) {
						if (unitsInProvince.size() < 26) {
							System.out.println("unitsInProvince.size < 26");
						}
						if (unitsInCentral.size() < 6) {
							System.out.println("unitsInCentral.size < 6");
						}
						if (unitsInLoadCenter.size() < 16) {
							System.out.println("unitsInLoadCenter.size< 16");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.25) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
						}
						if (spinningReserveOfUnits220OrAbove < 280) {
							System.out.println("spinningReserveOfUnits220OrAbove< 280");
						}
					} else if (powerOfQishao < 240) {
						if (unitsInProvince.size() < 27) {
							System.out.println("unitsInProvince.size < 27");
						}
						if (unitsInCentral.size() < 7) {
							System.out.println("unitsInCentral.size < 7");
						}
						if (unitsInLoadCenter.size() < 19) {
							System.out.println("unitsInLoadCenter.size< 19");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.25) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
						}
						if (spinningReserveOfUnits220OrAbove < 300) {
							System.out.println("spinningReserveOfUnits220OrAbove< 300");
						}
					} else if (powerOfQishao < 300) {
						if (unitsInProvince.size() < 27) {
							System.out.println("unitsInProvince.size < 27");
						}
						if (unitsInCentral.size() < 7) {
							System.out.println("unitsInCentral.size < 7");
						}
						if (unitsInLoadCenter.size() < 21) {
							System.out.println("unitsInLoadCenter.size< 21");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.25) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
						}
						if (spinningReserveOfUnits220OrAbove < 300) {
							System.out.println("spinningReserveOfUnits220OrAbove< 300");
						}
					}
				}
				if (loadP > 2200 && loadP < 2500) {
					if (powerOfQishao < 80) {
						if (unitsInProvince.size() < 31) {
							System.out.println("unitsInProvince.size < 31");
						}
						if (unitsInCentral.size() < 7) {
							System.out.println("unitsInCentral.size < 7");
						}
						if (unitsInLoadCenter.size() < 19) {
							System.out.println("unitsInLoadCenter.size()< 19");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.15) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.15");
						}
						if (spinningReserveOfUnits220OrAbove < 180) {
							System.out.println("spinningReserveOfUnits220OrAbove< 180");
						}
					} else if (powerOfQishao < 140) {
						if (unitsInProvince.size() < 31) {
							System.out.println("unitsInProvince.size < 31");
						}
						if (unitsInCentral.size() < 7) {
							System.out.println("unitsInCentral.size < 7");
						}
						if (unitsInLoadCenter.size() < 19) {
							System.out.println("unitsInLoadCenter.size< 19");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
						}
						if (spinningReserveOfUnits220OrAbove < 250) {
							System.out.println("spinningReserveOfUnits220OrAbove< 250");
						}
					} else if (powerOfQishao < 200) {
						if (unitsInProvince.size() < 32) {
							System.out.println("unitsInProvince.size < 32");
						}
						if (unitsInCentral.size() < 7) {
							System.out.println("unitsInCentral.size < 7");
						}
						if (unitsInLoadCenter.size() < 21) {
							System.out.println("unitsInLoadCenter.size< 21");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.25) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
						}
						if (spinningReserveOfUnits220OrAbove < 300) {
							System.out.println("spinningReserveOfUnits220OrAbove< 320");
						}
					} else if (powerOfQishao < 240) {
						if (unitsInProvince.size() < 32) {
							System.out.println("unitsInProvince.size < 32");
						}
						if (unitsInCentral.size() < 8) {
							System.out.println("unitsInCentral.size < 8");
						}
						if (unitsInLoadCenter.size() < 22) {
							System.out.println("unitsInLoadCenter.size< 22");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.25) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
						}
						if (spinningReserveOfUnits220OrAbove < 300) {
							System.out.println("spinningReserveOfUnits220OrAbove< 300");
						}
					} else if (powerOfQishao < 300) {
						if (unitsInProvince.size() < 32) {
							System.out.println("unitsInProvince.size < 32");
						}
						if (unitsInCentral.size() < 8) {
							System.out.println("unitsInCentral.size < 8");
						}
						if (unitsInLoadCenter.size() < 23) {
							System.out.println("unitsInLoadCenter.size< 23");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.25) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.25");
						}
						if (spinningReserveOfUnits220OrAbove < 320) {
							System.out.println("spinningReserveOfUnits220OrAbove< 320");
						}
					}

				}

				else if (loadP > 2500 && loadP < 2800) {
					if (powerOfQishao < 80) {
						if (unitsInProvince.size() < 32) {
							System.out.println("unitsInProvince.size < 32");
						}
						if (unitsInCentral.size() < 8) {
							System.out.println("unitsInCentral.size < 8");
						}
						if (unitsInLoadCenter.size() < 19) {
							System.out.println("unitsInLoadCenter.size()< 19");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.05) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.05");
						}
						if (spinningReserveOfUnits220OrAbove < 120) {
							System.out.println("spinningReserveOfUnits220OrAbove< 120");
						}
					} else if (powerOfQishao < 140) {
						if (unitsInProvince.size() < 31) {
							System.out.println("unitsInProvince.size < 31");
						}
						if (unitsInCentral.size() < 8) {
							System.out.println("unitsInCentral.size < 8");
						}
						if (unitsInLoadCenter.size() < 21) {
							System.out.println("unitsInLoadCenter.size< 21");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.1) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.1");
						}
						if (spinningReserveOfUnits220OrAbove < 200) {
							System.out.println("spinningReserveOfUnits220OrAbove< 200");
						}
					} else if (powerOfQishao < 200) {
						if (unitsInProvince.size() < 34) {
							System.out.println("unitsInProvince.size < 34");
						}
						if (unitsInCentral.size() < 8) {
							System.out.println("unitsInCentral.size < 8");
						}
						if (unitsInLoadCenter.size() < 21) {
							System.out.println("unitsInLoadCenter.size< 21");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.1) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.1");
						}
						if (spinningReserveOfUnits220OrAbove < 200) {
							System.out.println("spinningReserveOfUnits220OrAbove< 200");
						}
					} else if (powerOfQishao < 240) {
						if (unitsInProvince.size() < 36) {
							System.out.println("unitsInProvince.size < 36");
						}
						if (unitsInCentral.size() < 8) {
							System.out.println("unitsInCentral.size < 8");
						}
						if (unitsInLoadCenter.size() < 23) {
							System.out.println("unitsInLoadCenter.size< 23");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
						}
						if (spinningReserveOfUnits220OrAbove < 280) {
							System.out.println("spinningReserveOfUnits220OrAbove< 280");
						}
					} else if (powerOfQishao < 300) {
						if (unitsInProvince.size() < 36) {
							System.out.println("unitsInProvince.size < 36");
						}
						if (unitsInCentral.size() < 9) {
							System.out.println("unitsInCentral.size < 9");
						}
						if (unitsInLoadCenter.size() < 24) {
							System.out.println("unitsInLoadCenter.size< 24");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.2) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.2");
						}
						if (spinningReserveOfUnits220OrAbove < 300) {
							System.out.println("spinningReserveOfUnits220OrAbove< 300");
						}
					}
				}

				else if (loadP > 2800) {
					if (powerOfQishao < 80) {
						if (unitsInProvince.size() < 36) {
							System.out.println("unitsInProvince.size < 36");
						}
						if (unitsInCentral.size() < 9) {
							System.out.println("unitsInCentral.size < 9");
						}
						if (unitsInLoadCenter.size() < 24) {
							System.out.println("unitsInLoadCenter.size()< 24");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.05) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.05");
						}
						if (spinningReserveOfUnits220OrAbove < 80) {
							System.out.println("spinningReserveOfUnits220OrAbove< 80");
						}
					} else if (powerOfQishao < 140) {
						if (unitsInProvince.size() < 36) {
							System.out.println("unitsInProvince.size < 36");
						}
						if (unitsInCentral.size() < 9) {
							System.out.println("unitsInCentral.size < 9");
						}
						if (unitsInLoadCenter.size() < 24) {
							System.out.println("unitsInLoadCenter.size< 24");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.05) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.05");
						}
						if (spinningReserveOfUnits220OrAbove < 100) {
							System.out.println("spinningReserveOfUnits220OrAbove< 100");
						}
					} else if (powerOfQishao < 200) {
						if (unitsInProvince.size() < 36) {
							System.out.println("unitsInProvince.size < 36");
						}
						if (unitsInCentral.size() < 9) {
							System.out.println("unitsInCentral.size < 9");
						}
						if (unitsInLoadCenter.size() < 24) {
							System.out.println("unitsInLoadCenter.size< 24");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.1) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.1");
						}
						if (spinningReserveOfUnits220OrAbove < 150) {
							System.out.println("spinningReserveOfUnits220OrAbove< 150");
						}
					} else if (powerOfQishao < 240) {
						if (unitsInProvince.size() < 36) {
							System.out.println("unitsInProvince.size < 36");
						}
						if (unitsInCentral.size() < 9) {
							System.out.println("unitsInCentral.size < 9");
						}
						if (unitsInLoadCenter.size() < 24) {
							System.out.println("unitsInLoadCenter.size< 24");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.15) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.15");
						}
						if (spinningReserveOfUnits220OrAbove < 180) {
							System.out.println("spinningReserveOfUnits220OrAbove< 180");
						}
					} else if (powerOfQishao < 300) {
						if (unitsInProvince.size() < 36) {
							System.out.println("unitsInProvince.size < 36");
						}
						if (unitsInCentral.size() < 9) {
							System.out.println("unitsInCentral.size < 9");
						}
						if (unitsInLoadCenter.size() < 24) {
							System.out.println("unitsInLoadCenter.size< 24");
						}
						if (minSpinningReserveOfUnitsInLoadCentere < 0.15) {
							System.out.println("minSpinningReserveOfUnitsInLoadCentere<0.15");
						}
						if (spinningReserveOfUnits220OrAbove < 200) {
							System.out.println("spinningReserveOfUnits220OrAbove< 200");
						}
					}
				}
			}
		}
	}
}
				
			

