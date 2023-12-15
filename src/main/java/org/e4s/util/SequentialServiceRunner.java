package org.e4s.util;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
import com.google.inject.Inject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SequentialServiceRunner {

    private final ServiceManager manager;

    private final List<Service> services;

    @Inject
    public SequentialServiceRunner(final Map<Integer, Service> serviceMap) {
        this.services = serviceMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();

        manager = new ServiceManager(services);

    }

    public void run(){
        services.forEach(Service::startAsync);
        manager.awaitStopped();
    }

}
