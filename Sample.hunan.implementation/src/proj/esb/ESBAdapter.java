package proj.esb;

import com.hazelcast.core.HazelcastInstance;

import cn.sgepri.platform.core.esb.hz.HazelcastESBAdapter;

public class ESBAdapter extends HazelcastESBAdapter {
	public static final String Q_Test 	= "esb.ft.queue.test";
	
	public ESBAdapter(HazelcastInstance client) {
		super(client, 
				new String[] {Q_Test}, 
				new String[] {});
	}
}
