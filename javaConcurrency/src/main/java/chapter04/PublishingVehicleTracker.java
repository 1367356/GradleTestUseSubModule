package chapter04;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 安全发布底层状态的车辆追踪器
 */
public class PublishingVehicleTracker {
    private final Map<String, SafePoint> locations;  //不可变对象
    private final Map<String,SafePoint> unmodifiableMap;  //不可修改Map

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        unmodifiableMap = Collections.unmodifiableMap(locations);  //不可修改map
    }

    public Map<String, SafePoint> getLocations() {  //得到视图
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id) {  //得到位置
        return locations.get(id);
    }

    public void setLocation(String id,int x,int y){
        if (!locations.containsKey(id)) {
            throw new IllegalArgumentException("invalid vehicle name:" + id);
        }
        locations.get(id).set(x,y);
    }


}

