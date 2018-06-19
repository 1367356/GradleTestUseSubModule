package chapter04;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 车辆追踪
 */
public class MonitorVehicleTracker {

    private final Map<String,MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    /**
     * 读取到位置坐标，设置点位置
     * @param id
     * @param x
     * @param y
     */
    public synchronized void setLocations(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such Id+" + id);
        }
        loc.x=x;
        loc.y=y;
    }

    private Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locations) {
        Map<String, MutablePoint> result = new HashMap<>();
        for (String id : locations.keySet()) {
            result.put(id, new MutablePoint(locations.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }
}

class MutablePoint{
    public int x,y;

    public MutablePoint() {
        x=0;
        y=0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
