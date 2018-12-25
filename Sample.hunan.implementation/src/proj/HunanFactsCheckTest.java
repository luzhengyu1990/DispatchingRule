package proj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.interpss.SEObjectFactory;
import org.interpss.numeric.util.PerformanceTimer;
import org.interpss.se.SENetwork;
import org.interpss.se.algo.SEAlgorithm;
import org.junit.Test;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfGen;
import com.interpss.core.aclf.AclfLoad;
import com.interpss.core.aclf.AclfNetwork;

import cn.sgepri.adapter.lmodel.BaseAclfNetworkModelHelper;
import cn.sgepri.adapter.lmodel.rdbase.PModel2SENetAdapter;
import cn.sgepri.adapter.pmodel.rdbase.PModelFileAdapter;
import cn.sgepri.model.common.RTModelException;
import cn.sgepri.model.physical.PModelContainer;

public class HunanFactsCheckTest{

	@Test
	public void test() throws IOException, RTModelException, InterpssException {
		PModelFileAdapter adapter = new PModelFileAdapter();
		adapter.readData2PModel("testdata/dist/scada/");
		PModelContainer container = adapter.getContainer();
		
		// 拓扑分析
		PerformanceTimer timer = new PerformanceTimer(IpssLogger.getLogger());
		timer.start();
	
		timer.logStd("updated");
		PModel2SENetAdapter ipssadapter = new PModel2SENetAdapter(container);
		ipssadapter.map2modle();
		SENetwork seNet = (SENetwork) ipssadapter.net;
		BaseAclfNetworkModelHelper.getNet(seNet, "0");
	
		SEAlgorithm se = SEObjectFactory.createSEAlgorithm(seNet);
		se.se();
		AclfNetwork alcfNet = BaseAclfNetworkModelHelper.getAclfNetwrok(seNet);
		List<AclfGen> genList1 = new ArrayList<AclfGen>();
		List<AclfGen> genList2 = new ArrayList<AclfGen>();
		List<AclfGen> genList3 = new ArrayList<AclfGen>();
		List<AclfGen> genList4 = new ArrayList<AclfGen>();
		List<AclfGen> genList5 = new ArrayList<AclfGen>();
		
		List<AclfLoad> loadList = new ArrayList<AclfLoad>();
		List<AclfLoad> loadList2 = new ArrayList<AclfLoad>();
		alcfNet.getBusList().forEach(bus -> {
			if (bus.getName().contains("长沙") || bus.getName().contains("湘潭") || bus.getName().contains("株洲")
					|| bus.getName().contains("攸县") || bus.getName().contains("耒阳") || bus.getName().contains("金竹山B2")
					|| bus.getName().contains("宝庆A2") || bus.getName().contains("涟源")
					|| bus.getName().contains("华能岳阳B2") || bus.getName().contains("华能岳阳A2")
					|| bus.getName().contains("益阳B5")) {

				genList1.addAll(bus.getContributeGenList().stream().filter(gen -> gen.getName().contains("#"))
						.filter(acticvComsumer).collect(Collectors.toList()));
			}
			if (bus.getName().contains("长沙") || bus.getName().contains("湘潭") || bus.getName().contains("株洲")
					|| bus.getName().contains("攸县") || bus.getName().contains("耒阳") || bus.getName().contains("金竹山B")
					|| bus.getName().contains("宝庆A") || bus.getName().contains("涟源") || bus.getName().contains("华能岳阳")
					|| bus.getName().contains("益阳") || bus.getName().contains("大唐石门") || bus.getName().contains("华电石门")
					|| bus.getName().contains("常德")) {
				genList2.addAll(bus.getContributeGenList().stream().filter(gen -> gen.getName().contains("#"))
						.filter(acticvComsumer).collect(Collectors.toList()));
			}
			if (bus.getName().contains("长沙") || bus.getName().contains("湘潭") || bus.getName().contains("株洲")
					|| bus.getName().contains("攸县A2")) {
				genList3.addAll(bus.getContributeGenList().stream().filter(gen -> gen.getName().contains("#"))
						.filter(acticvComsumer).collect(Collectors.toList()));
			}
			bus.getContributeLoadList().stream().forEach(load -> {
				if (load.getName().contains("韶山")) {
					loadList.add(load);
				}
			});
			bus.getContributeLoadList().stream().forEach(load -> {
				if (load.getLoadCP().getReal() > 0) {
					loadList2.add(load);
				}
			});
			
			
			genList4.addAll(bus.getContributeGenList().stream().filter(gen -> gen.getName().contains("#"))
					.filter(acticvComsumer).collect(Collectors.toList()));
			
//			if(bus.getName().contains("韶山")) {
//				genList5.addAll(bus.getContributeGenList().stream()
//						.collect(Collectors.toList()));
//			}
		});
		List<AclfBranch> branchList1 = alcfNet.getBranchList().stream()
				.filter(branch -> branch.getName().contains("江孱")).collect(Collectors.toList());
		List<AclfBranch> branchList2 = alcfNet.getBranchList().stream()
				.filter(branch -> branch.getName().contains("孱澧")).collect(Collectors.toList());
		List<AclfBranch> branchList3 = alcfNet.getBranchList().stream()
				.filter(branch -> branch.getName().contains("澧复")).collect(Collectors.toList());
		List<AclfBranch> branchList4 = alcfNet.getBranchList().stream()
				.filter(branch -> branch.getName().contains("葛岗")).collect(Collectors.toList());
		System.out.println(genList1.size());
		System.out.println(genList2.size());
		System.out.println(genList3.size());
		System.out.println(genList4.size());
		System.out.println(loadList.size());
		System.out.println(branchList1.size());
		System.out.println(branchList2.size());
		System.out.println(branchList3.size());
		System.out.println(branchList4.size());
		HazelcastInstance client = HazelcastClient.newHazelcastClient(new ClientConfig());
		client.getMap("Facts").put("unitsInProvince", genList2);
		client.getMap("Facts").put("unitsInCentral", genList3);
		client.getMap("Facts").put("unitsInLoadCenter", genList1);
		client.getMap("Facts").put("units220OrAbove", genList4);
		client.getMap("Facts").put("loads", loadList2);
		client.getMap("Facts").put("qishaoLoads", loadList);
		client.getMap("Facts").put("jiangcanBranchList1", branchList1);
		client.getMap("Facts").put("canliBranchList1", branchList2);
		client.getMap("Facts").put("lifuBranchList1", branchList3);
		client.getMap("Facts").put("gegangBranchList1", branchList4);
	}

	Predicate<AclfGen> acticvComsumer = gen -> gen.getGen().getReal() > 0.1;
}
