package concurrency.sample.chapter4;

import concurrency.annotations.GuardedBy;
import concurrency.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 虽然类 MutablePoint 不是线程安全的，但追踪器类是线程安全的。它所包含的Map对象和可变的Point都未曾发布。
 * 在车辆容器非常大都情况下将极大地降低性能。此外，由于每次调用 getLocation 就要复制数据，因此将出现一种错误情况————虽然车辆都实际位置发生了变化，
 * 但返回但信息却保持不变。这种情况是好是坏取决于你的需求。
 */
@ThreadSafe
public class MonitorVehicleTracker {

    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = locations;
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null)
            throw new IllegalArgumentException("No such ID: " + id);
        loc.x = x;
        loc.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<>();
        for (String id : m.keySet())
            result.put(id, new MutablePoint(m.get(id)));
        return Collections.unmodifiableMap(result);
    }
}
