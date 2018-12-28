package proj.punit;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;

import com.hazelcast.core.HazelcastInstance;

import cn.sgepri.cep.core.common.CEPEngineException;
import cn.sgepri.cep.core.esb.IESBAdapter;
import cn.sgepri.cep.core.event.BaseEvent;
import cn.sgepri.cep.core.event.TimerEvent;
import cn.sgepri.cep.core.punit.hz.CacheEventProcessingUnit;
import cn.sgepri.cep.core.rule.BaseCEPRule;
import proj.esb.ESBAdapter;
import proj.rule.HNNewRuleDemo3;

public class HunanCheckProUnitVerticleDemo3 extends CacheEventProcessingUnit {
	protected HazelcastInstance client;
	private Rules rules = new Rules(new HNNewRuleDemo3(this));
	
	public HunanCheckProUnitVerticleDemo3(IESBAdapter adapter, HazelcastInstance client) {
		super(adapter, client);
		this.client = client;
	}

	@Override
	protected void configRulesEngine() {
		super.configRulesEngine();
	}
	
	@Override
	public void start() {
		super.start();
		this.vertx.setPeriodic(20000L, event ->  {
			this.logEvent(new TimerEvent());
		});
	}

	@Override public String[] getInQueueNames() {
		// map the ESB queue to the local event queue
		return new String[] {ESBAdapter.Q_Test};
	};
	
	public void processAppEvent(BaseEvent e) throws CEPEngineException {
		Facts facts = new Facts();
		facts.put(BaseCEPRule.RFact_Event, e);
		client.getMap("Facts").forEach((k, v) -> {
			facts.put(k.toString(), v);
		});
		
		if (e instanceof TimerEvent) {
			this.rulesEngine.fire(this.rules, facts);
		} else
			throw new CEPEngineException("Event not handled, wrong event type: " + e.getClass().getSimpleName());
	}
}
