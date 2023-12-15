package org.e4s.module;

import com.google.common.util.concurrent.Service;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.MapBinder;
import org.e4s.services.PrintService;
import org.e4s.util.SequentialServiceRunner;

public class ServiceModule extends AbstractModule {

    private final int count;
    public ServiceModule(int count) {
        this.count = count;
    }

    @Override
    protected void configure() {
        MapBinder<Integer, Service> mapBinder = MapBinder.newMapBinder(binder(), Integer.class, Service.class);
        mapBinder.addBinding(1).toInstance(new PrintService(count));
        binder().bind(SequentialServiceRunner.class).in(Scopes.SINGLETON);
    }
}
