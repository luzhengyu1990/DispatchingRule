package proj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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
import com.hazelcast.core.IMap;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfGen;
import com.interpss.core.aclf.AclfLoad;
import com.interpss.core.aclf.AclfNetwork;

import cn.sgepri.adapter.lmodel.BaseAclfNetworkModelHelper;
import cn.sgepri.adapter.lmodel.rdbase.PModel2LModeltHelper;
import cn.sgepri.adapter.lmodel.rdbase.PModel2SENetAdapter;
import cn.sgepri.adapter.pmodel.rdbase.PModelFileAdapter;
import cn.sgepri.model.common.RTModelException;
import cn.sgepri.model.physical.PModelContainer;
import cn.sgepri.model.physical.impl.PModelContainerHelper;

public class HunanFactsCheckTest{
	double p = 0;
	@Test
	public void test() throws IOException, RTModelException, InterpssException {
		HashSet<String> nameSet = new HashSet<String>();
		PModelFileAdapter adapter = new PModelFileAdapter();
		adapter.readData2PModel("testdata/dist/scada/");
		PModelContainer container = adapter.getContainer();
		PModelContainerHelper helper = new PModelContainerHelper(adapter.getContainer());
		helper.visitSubstation(sub -> {
			if (sub.getBaseVoltage(sub.getDataRec().getBv_id()) != null) {
				if (sub.getBaseVoltage(sub.getDataRec().getBv_id()).getDataRec().getNomvol() > 200) {
					nameSet.add(sub.getObjName());
				}
			}
		});
		// ���˷���
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
		List<AclfGen> genList6 = new ArrayList<AclfGen>();
		
		List<AclfLoad> loadList = new ArrayList<AclfLoad>();
		List<AclfLoad> loadList2 = new ArrayList<AclfLoad>();
		alcfNet.getBusList().forEach(bus -> {
			if (bus.getName().contains("��ɳ") || bus.getName().contains("��̶") || bus.getName().contains("����")
					|| bus.getName().contains("����") || bus.getName().contains("����") || bus.getName().contains("����ɽB2")
					|| bus.getName().contains("����A2") || bus.getName().contains("��Դ")
					|| bus.getName().contains("��������B2") || bus.getName().contains("��������A2")
					|| bus.getName().contains("����B5")) {

				genList1.addAll(bus.getContributeGenList().stream().filter(gen -> gen.getName().contains("#"))
						.filter(acticvComsumer).collect(Collectors.toList()));
			}
			if (bus.getName().contains("��ɳ") || bus.getName().contains("��̶") || bus.getName().contains("����")
					|| bus.getName().contains("����") || bus.getName().contains("����") || bus.getName().contains("����ɽB")
					|| bus.getName().contains("����A") || bus.getName().contains("��Դ") || bus.getName().contains("��������")
					|| bus.getName().contains("����") || bus.getName().contains("����ʯ��") || bus.getName().contains("����ʯ��")
					|| bus.getName().contains("����")) {
				genList2.addAll(bus.getContributeGenList().stream().filter(gen -> gen.getName().contains("#"))
						.filter(acticvComsumer).collect(Collectors.toList()));
			}
			if (bus.getName().contains("��ɳ") || bus.getName().contains("��̶") || bus.getName().contains("����")
					|| bus.getName().contains("����A2")) {
				genList3.addAll(bus.getContributeGenList().stream().filter(gen -> gen.getName().contains("#"))
						.filter(acticvComsumer).collect(Collectors.toList()));
			}
			bus.getContributeLoadList().stream().forEach(load -> {
				if (load.getName().contains("��ɽ")) {
					loadList.add(load);
				}
			});
			bus.getContributeLoadList().stream().forEach(load -> {
				if (load.getLoadCP().getReal() > 0) {
					loadList2.add(load);
				}
			});
			
			if (nameSet.contains(PModel2LModeltHelper.getSubName(bus.getId()))) {
				genList4.addAll(bus.getContributeGenList().stream().filter(gen -> gen.getName().contains("#"))
						.filter(acticvComsumer).collect(Collectors.toList()));
			}
			
			if(bus.getName().contains("��ɽ")) {
				genList5.addAll(bus.getContributeGenList().stream()
						.collect(Collectors.toList()));
			}
			if (!bus.getId().contains("���ް�") && !bus.getId().contains("����վ") && !bus.getId().contains("����վ")
					&& !bus.getId().contains("����վ")) {
				genList6.addAll(bus.getContributeGenList());
			}
		});
		
		List<AclfBranch> branchList1 = alcfNet.getBranchList().stream()
				.filter(branch -> branch.getName().contains("����")).collect(Collectors.toList());
		List<AclfBranch> branchList2 = alcfNet.getBranchList().stream()
				.filter(branch -> branch.getName().contains("���")).collect(Collectors.toList());
		List<AclfBranch> branchList3 = alcfNet.getBranchList().stream()
				.filter(branch -> branch.getName().contains("墸�")).collect(Collectors.toList());
		List<AclfBranch> branchList4 = alcfNet.getBranchList().stream()
				.filter(branch -> branch.getName().contains("���")).collect(Collectors.toList());
		System.out.println(genList1.size());
		System.out.println(genList2.size());
		System.out.println(genList3.size());
		System.out.println(genList4.size());
		System.out.println(genList5.size());
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
		client.getMap("Facts").put("jiangcanBranchList", branchList1);
		client.getMap("Facts").put("canliBranchList", branchList2);
		client.getMap("Facts").put("lifuBranchList", branchList3);
		client.getMap("Facts").put("gegangBranchList", branchList4);
		IMap<Object, Object> facts = client.getMap("Facts");
		List<AclfLoad> loads = (List<AclfLoad>) facts.get("loads");
		List<AclfLoad> qishaoLoads = (List<AclfLoad>) facts.get("qishaoLoads");
		List<AclfGen> unitsInLoadCenter = (List<AclfGen>) facts.get("unitsInLoadCenter");
		List<AclfGen> units220OrAbove = (List<AclfGen>) facts.get("units220OrAbove");
		List<AclfGen> unitsInProvince = (List<AclfGen>) facts.get("unitsInProvince");
		List<AclfGen> unitsInCentral = (List<AclfGen>) facts.get("unitsInCentral");
		List<AclfGen> jiangcanBranchList = (List<AclfGen>) facts.get("jiangcanBranchList");
		List<AclfGen> canliBranchList = (List<AclfGen>) facts.get("canliBranchList");
		List<AclfGen> lifuBranchList = (List<AclfGen>) facts.get("lifuBranchList");
		List<AclfGen> gegangBranchList = (List<AclfGen>) facts.get("gegangBranchList");
		double powerOfQishao = qishaoLoads.stream().mapToDouble(load -> -load.getLoadCP().getReal()).sum()*10;
		double loadP = genList6.stream().mapToDouble(gen->gen.getGen().getReal()).sum();
		double minSpinningReserveOfUnitsInLoadCentere = unitsInLoadCenter.stream()
				.mapToDouble(
						gen -> (gen.getPGenLimit().getMax() - gen.getGen().getReal()) / gen.getPGenLimit().getMax())
				.min().getAsDouble();
		double spinningReserveOfUnits220OrAbove = units220OrAbove.stream()
				.mapToDouble(gen -> gen.getPGenLimit().getMax() - gen.getGen().getReal()).filter(d -> d < 10).sum()
				* 10;
//		units220OrAbove.forEach(gen->{
//			if((gen.getPGenLimit().getMax() - gen.getGen().getReal())<10)
//			System.out.println(gen.getName()+(gen.getPGenLimit().getMax() - gen.getGen().getReal()));
//		});
		
		System.out.println(powerOfQishao/0.963);
		System.out.println(minSpinningReserveOfUnitsInLoadCentere);
		System.out.println(spinningReserveOfUnits220OrAbove);
//		units220OrAbove.forEach(gen->{
//			System.out.println(gen.getName()+(gen.getPGenLimit().getMax() - gen.getGen().getReal())*10);
//		});
		
		alcfNet.getBusList().forEach(bus -> {
			bus.getContributeGenList().forEach(gen -> {
				if (gen.getGen().getReal() > 0) {
					p += gen.getGen().getReal()*10;
				}
			});
		});
		System.out.println(p);
		p=0;
		p -= BaseAclfNetworkModelHelper.GetBranch(seNet, "����.��墢���").powerTo2From().getReal();
		p -= BaseAclfNetworkModelHelper.GetBranch(seNet, "����.��墢���").powerTo2From().getReal();
		p -= BaseAclfNetworkModelHelper.GetBranch(seNet, "����.�����").powerTo2From().getReal();
		System.out.println(p*10);
		System.out.println(p*100+powerOfQishao*10);
		loadP = loadP*100+p*100+powerOfQishao*10;
		System.out.println(loadP);
		System.out.println(genList6.size());
	}

	Predicate<AclfGen> acticvComsumer = gen -> gen.getGen().getReal() > 0.1;
}
