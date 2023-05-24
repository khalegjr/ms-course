package org.khaled.hrpayroll.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import reactor.core.publisher.Flux;

public class HrWorkerConfiguration {

	@Bean
	@Primary
	ServiceInstanceListSupplier serviceInstanceListSupplier() {
		return new DemoServiceInstanceListSuppler("hr-worker");
	}
}

class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {
	private final String serviceId;
	
	DemoServiceInstanceListSuppler(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public Flux<List<ServiceInstance>> get() {
		
		return Flux.just(Arrays
				.asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8090, false),
						new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8091, false),
						new DefaultServiceInstance(serviceId + "3", serviceId, "localhost", 8092, false))
				);
	}

	@Override
	public String getServiceId() {
		return serviceId;
	}
	
	
}
