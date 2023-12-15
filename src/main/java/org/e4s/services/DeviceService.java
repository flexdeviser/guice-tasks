package org.e4s.services;

import com.google.inject.Inject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class DeviceService {

    private final Set<Integer> numbers;

    private final Map<Integer, String> mem;

    @Inject
    public DeviceService() {
        this.numbers = new HashSet<>();
        this.mem = new HashMap<>();
    }

    public void generateNumbers(int count) {
        IntStream.range(0, count).forEach(num -> {
            numbers.add(num);
            StringBuilder largeString = new StringBuilder();
            for (int i = 0; i < 10000000; i++) {
                largeString.append("a");
            }
            mem.put(num, largeString.toString());
            System.out.printf("%d 10MB", num);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }


}
