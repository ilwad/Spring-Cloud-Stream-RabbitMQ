package io.spring.dataflow.sample.usagecostlogger;

import io.spring.dataflow.sample.domain.UsageCostDetail;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsageCostLoggerApplicationTests {
	@Autowired
	protected Sink sink;

	@Autowired
	protected UsageCostLogger usageCostLogger;

	@Ignore
	@Test
	public void testUsageCostLogger() throws Exception {
		ArgumentCaptor<UsageCostDetail> captor = ArgumentCaptor.forClass(UsageCostDetail.class);
		this.sink.input().send(MessageBuilder.withPayload("{\"userId\":\"user3\",\"callCost\":10.100000000000001,\"dataCost\":25.1}").build());
		verify(this.usageCostLogger).process(captor.capture());
	}

	@Test
	public void contextLoads() {
	}

}
