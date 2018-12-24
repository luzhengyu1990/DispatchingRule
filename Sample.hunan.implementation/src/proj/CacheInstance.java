package proj;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.interpss.numeric.exp.IpssNumericException;

import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.DistributedObject;
import com.hazelcast.core.DistributedObjectEvent;
import com.hazelcast.core.DistributedObjectListener;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.exp.IpssCacheException;

public class CacheInstance {
	public static void main(String[] args)
			throws IOException, InterpssException, IpssNumericException, IpssCacheException {
		HazelcastInstance hz = startServer(args);

	}

	@SuppressWarnings("unchecked")
	public static HazelcastInstance startServer(String[] args) throws FileNotFoundException {
		Config config = new Config();
		NetworkConfig network = config.getNetworkConfig();
		HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);
		hz.addDistributedObjectListener(new DistributedObjectListener() {
			@Override
			public void distributedObjectCreated(DistributedObjectEvent event) {
				DistributedObject instance = event.getDistributedObject();
				System.out.println("Created " + instance.getName() + ", " + instance.getServiceName());
			}

			@Override
			public void distributedObjectDestroyed(DistributedObjectEvent event) {
				DistributedObject instance = event.getDistributedObject();
				System.out.println("Destroyed " + instance.getName() + ", " + instance.getServiceName());
			}
		});
		return hz;
	}

}