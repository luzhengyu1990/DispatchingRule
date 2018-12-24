package proj.cache;

import com.hazelcast.core.HazelcastInstance;

import cn.sgepri.cep.core.cache.hz.HazelcastCacheAdapter;

public class CacheAdapter extends HazelcastCacheAdapter {
	
	public CacheAdapter(HazelcastInstance client) {
		super(client, new String[] {});
	}	
	
	@Override public void config() {
		// do nothing
	}
}
