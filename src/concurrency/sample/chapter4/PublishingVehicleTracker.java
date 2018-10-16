package concurrency.sample.chapter4;

import com.sun.org.apache.regexp.internal.RE;
import concurrency.annotations.ThreadSafe;
import datastructure.Collection;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class PublishingVehicleTracker {

    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    public SafePoint getLocations(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (!locations.containsKey(id))
            throw new IllegalArgumentException("invalid vehicle name : " + id);
        locations.get(id).set(x, y);
    }

}
