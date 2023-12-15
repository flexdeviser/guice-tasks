package org.e4s.services;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.inject.Inject;

import java.util.Random;

public class PrintService extends AbstractExecutionThreadService {

    private DeviceService deviceService;


    private final int count;

    public PrintService(int count) {
        this.count = count;
    }

    @Inject
    public void setDeviceService(final DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @Override
    protected void startUp() throws Exception {
        System.out.println("print service starting.....");
    }

    @Override
    protected void run() throws Exception {
        deviceService.generateNumbers(count);
        System.out.printf("count: %d, total size: %d %n", count, deviceService.getNumbers().size());
    }

    @Override
    protected void shutDown() throws Exception {
        System.out.println("print service stopped");
    }
}
