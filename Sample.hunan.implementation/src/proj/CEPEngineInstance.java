package proj;


import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;

import cn.sgepri.platform.core.cep.engine.vertx.CacheCEPEngineApp;
import proj.cache.CacheAdapter;
import proj.esb.ESBAdapter;
import proj.punit.HunanCheckProUnitVerticleDemo2;
import proj.punit.HunanCheckProUnitVerticleDemo3;
import proj.punit.HunanCheckProUnitVerticleDemo4;

public class CEPEngineInstance {
		
	public static void main(String[] args) {
		HazelcastInstance client = HazelcastClient.newHazelcastClient();
		CacheCEPEngineApp engine = new CacheCEPEngineApp("Timer", new CacheAdapter(client));
		engine.register(new HunanCheckProUnitVerticleDemo4(new ESBAdapter(client), client));
//		engine.register(new HunanCheckProUnitVerticleDemo3(new ESBAdapter(client), client));
//		engine.register(new HunanCheckProUnitVerticleDemo2(new ESBAdapter(client), client));
//		engine.register(new HunanCheckProUnitVerticleDemo(new ESBAdapter(client), client));
		engine.start();
	}
}
