package org.e4s;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.e4s.module.CommonModule;
import org.e4s.module.ServiceModule;
import org.e4s.util.SequentialServiceRunner;

import java.util.stream.IntStream;

public class App {


    public static void main(String[] args) {
        // main injector
        Injector mainInjector = Guice.createInjector(new CommonModule());
        // children
        IntStream.range(0, 2).forEach(i -> {
            Injector childInjector = mainInjector.createChildInjector(new ServiceModule(100 ));
            SequentialServiceRunner runner = childInjector.getInstance(SequentialServiceRunner.class);
            runner.run();
        });

        // injector for each
//        IntStream.range(0,2).forEach(i -> {
//            Injector injector = Guice.createInjector(new CommonModule(), new ServiceModule(100 ));
//            SequentialServiceRunner runner = injector.getInstance(SequentialServiceRunner.class);
//            runner.run();
//        });


    }


}
