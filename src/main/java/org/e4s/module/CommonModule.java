package org.e4s.module;

import com.google.inject.AbstractModule;
import org.e4s.services.DeviceService;

public class CommonModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DeviceService.class).asEagerSingleton();
    }
}
