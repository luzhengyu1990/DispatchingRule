package proj.rule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.rules.api.Facts;

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
	
	private int unitsInProvinceSizeLimit = 0;
	private int unitsInCentralSizeLimit= 0;
	private int unitsInLoadCenterSizeLimit= 0;
	private double minSpinningReserveOfUnitsInLoadCentereLimit= 0;
	private int spinningReserveOfUnits220OrAboveLimit= 0;
	
	public HNNewRuleDemo4(IEventProcessingUnit punit) {
		super("test.HNNewRuleDemo4", punit);
	}

	@Override
	public boolean evaluate(Facts facts) {
		BaseEvent event = getEvent(facts);
		return event instanceof TimerEvent;
	}

	@Override
	public void execute(Facts facts) throws Exception {
		double loadP = facts.get("load");
		double powerOfQishao = facts.get("qishao");
		int unitsInProvinceSize = facts.get("unitsInProvinceSize");
		int unitsInCentralSize = facts.get("unitsInCentralSize");
		int unitsInLoadCenterSize = facts.get("unitsInLoadCenterSize");
		double spinningReserveOfUnits220OrAbove = facts.get("spinningReserveOfUnits220OrAbove");
		double minSpinningReserveOfUnitsInLoadCentere = facts.get("minSpinningReserveOfUnitsInLoadCentere");
		int jiangcanBranchSize = facts.get("jiangcanBranchSize");
		int canliBranchSize = facts.get("canliBranchSize");
		int lifuBranchSize = facts.get("lifuBranchSize");
		int gegangBranchSize = facts.get("gegangBranchSize");
		long qishaoGenListSize = facts.get("qishaoGenListSize");
		double pailouPower = facts.get("pailou");
		double xiangxinanInterface = facts.get("xiangxinanInterface");
		
		if (jiangcanBranchSize == 2 && canliBranchSize == 2 && lifuBranchSize == 2
				&& gegangBranchSize == 1) {
			System.out.println("状态 ：正常状态");
			if (loadP <= 1300) {
				if (powerOfQishao < 80) {
					setLimit(8, 4, 8, 0.4, 120);
				} else if (powerOfQishao < 140) {
					setLimit(11, 4, 11, 0.35, 150);
				} else if (powerOfQishao < 200) {
					setLimit(15, 4, 15, 0.4, 280);
				} else if (powerOfQishao < 240) {
					setLimit(17, 4, 15, 0.45, 300);
				} else if (powerOfQishao < 300) {
					setLimit(18, 4, 16, 0.45, 330);
				}
			} else if (loadP < 1600) {
				if (powerOfQishao < 80) {
					setLimit(10, 4, 10, 0.25, 120);
				} else if (powerOfQishao < 140) {
					setLimit(13, 4, 13, 0.25, 150);
				} else if (powerOfQishao < 200) {
					setLimit(16, 4, 16, 0.3, 250);
				} else if (powerOfQishao < 240) {
					setLimit(17, 5, 17, 0.35, 250);
				} else if (powerOfQishao < 300) {
					setLimit(18, 5, 17, 0.35, 280);
				}
			} else if (loadP < 1900) {
				if (powerOfQishao < 80) {
					setLimit(16, 5, 12, 0.15, 120);
				} else if (powerOfQishao < 140) {
					setLimit(17, 5, 13, 0.25, 180);
				} else if (powerOfQishao < 200) {
					setLimit(18, 5, 15, 0.3, 250);
				} else if (powerOfQishao < 240) {
					setLimit(18, 5, 17, 0.3, 250);
				} else if (powerOfQishao < 300) {
					setLimit(20, 6, 18, 0.35, 280);
				} else if (powerOfQishao < 340) {
					setLimit(21, 6, 18, 0.35, 300);
				} else if (powerOfQishao < 400) {
					setLimit(23, 6, 18, 0.35, 320);
				}
			} else if (loadP < 2200) {
				if (powerOfQishao < 80) {
					setLimit(21, 6, 15, 0.15, 100);
				} else if (powerOfQishao < 140) {
					setLimit(22, 6, 15, 0.20, 180);
				} else if (powerOfQishao < 200) {
					setLimit(23, 6, 16, 0.25, 250);
				} else if (powerOfQishao < 240) {
					setLimit(23, 7, 18, 0.25, 280);
				} else if (powerOfQishao < 300) {
					setLimit(24, 7, 20, 0.25, 280);
				} else if (powerOfQishao < 340) {
					setLimit(26, 7, 21, 0.3, 300);
				} else if (powerOfQishao < 400) {
					setLimit(26, 7, 21, 0.3, 330);
				}
			} else if (loadP < 2500) {
				if (powerOfQishao < 80) {
					setLimit(27, 8, 19, 0.1, 150);
				} else if (powerOfQishao < 140) {
					setLimit(28, 8, 19, 0.15, 200);
				} else if (powerOfQishao < 200) {
					setLimit(28, 8, 21, 0.2, 250);
				} else if (powerOfQishao < 240) {
					setLimit(28, 9, 22, 0.25, 250);
				} else if (powerOfQishao < 300) {
					setLimit(29, 9, 22, 0.25, 280);
				} else if (powerOfQishao < 340) {
					setLimit(30, 9, 23, 0.25, 280);
				} else if (powerOfQishao < 400) {
					setLimit(30, 9, 23, 0.3, 320);
				} else if (powerOfQishao < 450) {
					setLimit(30, 9, 23, 0.3, 340);
				}
			} else if (loadP > 2500 && loadP < 2800) {
				if (powerOfQishao < 80) {
					setLimit(33, 9, 20, 0.1, 80);
				} else if (powerOfQishao < 140) {
					setLimit(34, 9, 21, 0.1, 150);
				} else if (powerOfQishao < 200) {
					setLimit(34, 9, 21, 0.2, 200);
				} else if (powerOfQishao < 240) {
					setLimit(35, 9, 23, 0.2, 230);
				} else if (powerOfQishao < 300) {
					setLimit(35, 9, 24, 0.2, 250);
				} else if (powerOfQishao < 340) {
					setLimit(34, 9, 24, 0.2, 250);
				} else if (powerOfQishao < 400) {
					setLimit(35, 9, 24, 0.2, 300);
				} else if (powerOfQishao < 450) {
					setLimit(35, 9, 24, 0.2, 320);
				}
			} else if (loadP > 2800) {
				if (powerOfQishao < 80) {
					setLimit(34, 9, 23, 0.05, 80);
				} else if (powerOfQishao < 140) {
					setLimit(34, 9, 23, 0.05, 180);
				} else if (powerOfQishao < 200) {
					setLimit(35, 9, 23, 0.1, 230);
				} else if (powerOfQishao < 240) {
					setLimit(35, 9, 23, 0.15, 250);
				} else if (powerOfQishao < 300) {
					setLimit(36, 9, 24, 0.15, 250);
				} else if (powerOfQishao < 340) {
					setLimit(36, 9, 24, 0.15, 280);
				} else if (powerOfQishao < 400) {
					setLimit(36, 9, 24, 0.2, 310);
				} else if (powerOfQishao < 450) {
					setLimit(36, 9, 24, 0.2, 330);
				}
			} else if (gegangBranchSize == 0) {
				System.out.println("状态 ：葛岗检修");
				if (loadP <= 1300) {
					if (powerOfQishao < 80) {
						setLimit(11, 4, 11, 0.35, 180);
					} else if (powerOfQishao < 140) {
						setLimit(16, 4, 16, 0.35, 250);
					} else if (powerOfQishao < 200) {
						setLimit(18, 4, 18, 0.4, 330);
					} else if (powerOfQishao < 240) {
						setLimit(19, 5, 19, 0.5, 400);
					}
				} else if (loadP < 1600) {
					if (powerOfQishao < 80) {
						setLimit(13, 4, 12, 0.25, 150);
					} else if (powerOfQishao < 140) {
						setLimit(17, 4, 17, 0.25, 200);
					} else if (powerOfQishao < 200) {
						setLimit(19, 4, 19, 0.35, 300);
					} else if (powerOfQishao < 240) {
						setLimit(20, 5, 20, 0.35, 330);
					}
				} else if (loadP < 1900) {
					if (powerOfQishao < 80) {
						setLimit(19, 5, 14, 0.2, 180);
					} else if (powerOfQishao < 140) {
						setLimit(20, 5, 16, 0.3, 250);
					} else if (powerOfQishao < 200) {
						setLimit(21, 5, 18, 0.35, 300);
					} else if (powerOfQishao < 240) {
						setLimit(20, 6, 19, 0.3, 300);
					} else if (powerOfQishao < 300) {
						setLimit(22, 6, 20, 0.35, 330);
					}
				} else if (loadP < 2200) {
					if (powerOfQishao < 80) {
						setLimit(26, 6, 17, 0.2, 150);
					} else if (powerOfQishao < 140) {
						setLimit(26, 6, 17, 0.25, 200);
					} else if (powerOfQishao < 200) {
						setLimit(27, 6, 18, 0.25, 280);
					} else if (powerOfQishao < 240) {
						setLimit(27, 7, 20, 0.3, 300);
					} else if (powerOfQishao < 300) {
						setLimit(27, 7, 22, 0.3, 330);
					}
				} else if (loadP < 2500) {
					if (powerOfQishao < 80) {
						setLimit(32, 7, 20, 0.15, 200);
					} else if (powerOfQishao < 140) {
						setLimit(32, 7, 20, 0.2, 300);
					} else if (powerOfQishao < 200) {
						setLimit(32, 7, 22, 0.25, 320);
					} else if (powerOfQishao < 240) {
						setLimit(32, 8, 23, 0.25, 320);
					} else if (powerOfQishao < 300) {
						setLimit(32, 8, 24, 0.25, 340);
					}
				} else if (loadP < 2800) {
					if (powerOfQishao < 80) {
						setLimit(33, 8, 20, 0.05, 120);
					} else if (powerOfQishao < 140) {
						setLimit(34, 8, 21, 0.1, 200);
					} else if (powerOfQishao < 200) {
						setLimit(35, 8, 22, 0.2, 280);
					} else if (powerOfQishao < 240) {
						setLimit(36, 9, 23, 0.2, 300);
					} else if (powerOfQishao < 300) {
						setLimit(36, 9, 24, 0.2, 320);
					}
				} else {
					if (powerOfQishao < 80) {
						setLimit(36, 9, 24, 0.05, 50);
					} else if (powerOfQishao < 140) {
						setLimit(36, 9, 24, 0.05, 50);
					} else if (powerOfQishao < 200) {
						setLimit(36, 9, 24, 0.1, 100);
					} else if (powerOfQishao < 240) {
						setLimit(36, 9, 24, 0.15, 150);
					} else if (powerOfQishao < 300) {
						setLimit(36, 9, 24, 0.15, 200);
					}
				}
			}

			else if (jiangcanBranchSize + canliBranchSize + lifuBranchSize < 6) {
				if (jiangcanBranchSize < 2) {
					System.out.println("状态 ：江孱线检修");
				} else if (canliBranchSize < 2) {
					System.out.println("状态 ：孱澧线检修");
				} else if (lifuBranchSize  < 2) {
					System.out.println("状态 ：澧复线检修");
				}
				if (loadP <= 1300) {
					if (powerOfQishao < 80) {
						setLimit(9, 4, 9, 0.4, 150);
					} else if (powerOfQishao < 140) {
						setLimit(12, 4, 12, 0.4, 180);
					} else if (powerOfQishao < 200) {
						setLimit(15, 4, 15, 0.45, 300);
					} else if (powerOfQishao < 240) {
						setLimit(17, 4, 16, 0.45, 300);
					}
				} else if (loadP < 1600) {
					if (powerOfQishao < 80) {
						setLimit(12, 4, 10, 0.25, 150);
					} else if (powerOfQishao < 140) {
						setLimit(15, 4, 14, 0.25, 180);
					} else if (powerOfQishao < 200) {
						setLimit(17, 4, 15, 0.35, 250);
					} else if (powerOfQishao < 240) {
						setLimit(19, 5, 19, 0.35, 300);
					}
				} else if (loadP < 1900) {
					if (powerOfQishao < 80) {
						setLimit(19, 5, 13, 0.2, 150);
					} else if (powerOfQishao < 140) {
						setLimit(19, 5, 14, 0.3, 230);
					} else if (powerOfQishao < 200) {
						setLimit(20, 5, 15, 0.35, 280);
					} else if (powerOfQishao < 240) {
						setLimit(21, 6, 19, 0.35, 280);
					} else if (powerOfQishao < 300) {
						setLimit(21, 6, 19, 0.35, 300);
					}
				} else if (loadP < 2200) {
					if (powerOfQishao < 80) {
						setLimit(25, 6, 15, 0.15, 130);
					} else if (powerOfQishao < 140) {
						setLimit(26, 6, 15, 0.2, 200);
					} else if (powerOfQishao < 200) {
						setLimit(26, 6, 16, 0.25, 280);
					} else if (powerOfQishao < 240) {
						setLimit(27, 7, 19, 0.25, 300);
					} else if (powerOfQishao < 300) {
						setLimit(27, 7, 21, 0.25, 300);
					}

				} else if (loadP < 2500) {
					if (powerOfQishao < 80) {
						setLimit(31, 7, 19, 0.15, 180);
					} else if (powerOfQishao < 140) {
						setLimit(31, 7, 19, 0.2, 250);
					} else if (powerOfQishao < 200) {
						setLimit(32, 7, 21, 0.25, 320);
					} else if (powerOfQishao < 240) {
						setLimit(32, 8, 22, 0.25, 300);
					} else if (powerOfQishao < 300) {
						setLimit(32, 8, 23, 0.25, 320);
					}
				} else if (loadP < 2800) {
					if (powerOfQishao < 80) {
						setLimit(32, 8, 19, 0.05, 120);
					} else if (powerOfQishao < 140) {
						setLimit(31, 8, 21, 0.1, 200);
					} else if (powerOfQishao < 200) {
						setLimit(34, 8, 21, 0.1, 200);
					} else if (powerOfQishao < 240) {
						setLimit(36, 8, 23, 0.2, 280);
					} else if (powerOfQishao < 300) {
						setLimit(36, 9, 24, 0.2, 300);
					}

				} else {
					if (powerOfQishao < 80) {
						setLimit(36, 9, 24, 0.05, 80);
					} else if (powerOfQishao < 140) {
						setLimit(36, 9, 24, 0.05, 100);
					} else if (powerOfQishao < 200) {
						setLimit(36, 9, 24, 0.1, 150);
					} else if (powerOfQishao < 240) {
						setLimit(36, 9, 24, 0.15, 180);
					} else if (powerOfQishao < 300) {
						setLimit(36, 9, 24, 0.15, 200);
					}
				}	
			}
		}else {
			System.err.println("error status!");
		}
		if (jiangcanBranchSize == 2 && canliBranchSize == 2 && lifuBranchSize == 2 && gegangBranchSize == 1) {
			if ((loadP <= 2200 && pailouPower < 40) || xiangxinanInterface < 160) {
				this.unitsInLoadCenterSizeLimit -= 1;
			}
		}
		this.unitsInLoadCenterSizeLimit -= qishaoGenListSize;
		this.unitsInCentralSizeLimit -= qishaoGenListSize;
		this.unitsInProvinceSizeLimit -= qishaoGenListSize;
		System.out.println("负荷水平(万千瓦)：" + String.format("%.2f", loadP));
		System.out.println("祁韶直流(万千瓦)： " + String.format("%.2f", powerOfQishao));
		
		limitAction(unitsInProvinceSize, this.unitsInProvinceSizeLimit, "省内发电机组数");
		limitAction(unitsInCentralSize, this.unitsInCentralSizeLimit, "湘中发电机组数");
		limitAction(unitsInLoadCenterSize, this.unitsInLoadCenterSizeLimit, "负荷中心发电机组数");
//		limitAction(minSpinningReserveOfUnitsInLoadCentere, this.minSpinningReserveOfUnitsInLoadCentereLimit, "负荷中心机组最小旋转备用百分比");
		
		limitAction(spinningReserveOfUnits220OrAbove, this.spinningReserveOfUnits220OrAboveLimit, "220及以上机组旋转备用(万千瓦)");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		System.out.println("[当前时间]"+date);
	}
	
	private void setLimit(int unitsInProvinceSizeLimit, int unitsInCentralSizeLimit, int unitsInLoadCenterSizeLimit,
			double minSpinningReserveOfUnitsInLoadCentereLimit, int spinningReserveOfUnits220OrAboveLimit) {
		this.unitsInProvinceSizeLimit = unitsInProvinceSizeLimit;
		this.unitsInCentralSizeLimit = unitsInCentralSizeLimit;
		this.unitsInLoadCenterSizeLimit = unitsInLoadCenterSizeLimit;
		this.minSpinningReserveOfUnitsInLoadCentereLimit = minSpinningReserveOfUnitsInLoadCentereLimit;
		this.spinningReserveOfUnits220OrAboveLimit = spinningReserveOfUnits220OrAboveLimit;
	}
	
	private void limitAction(double status, double limit, String name) {
		if (status < limit) {
			System.err.println("[" + name + " : " + String.format("%.2f",status) + "]" + " Is over-limit,  current limit:" + limit);
		} else {
			System.out.println("[" + name + " : " + String.format("%.2f",status) + "]" + " In a safe state ,  current limit:" + limit);
		}
	}

}
