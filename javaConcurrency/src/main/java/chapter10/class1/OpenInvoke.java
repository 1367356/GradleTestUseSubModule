package chapter10.class1;

import chapter04.Point;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 22:20
 * 开放调用
 **/
public class OpenInvoke {
    class Taxi{
        private Point location,destination;
        private final Dispatcher dispatcher;

        public Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public synchronized Point getLocation() {
            return location;
        }

        public void setLocation(Point location) {
            boolean reachedDestination;
            synchronized (this) {  //公开调用，否则和下面的synchronize会有冲突
                this.location=location;
                reachedDestination = location.equals(destination);
            }
            if (reachedDestination) {
                dispatcher.notifyAvailable(this);
            }
        }
    }
    class Dispatcher{
        private final Set<Taxi> taxis;   //final初始化
        private final Set<Taxi> availableTaxes;

        public Dispatcher(Set<Taxi> taxis, Set<Taxi> availableTaxes) {
            this.taxis = taxis;
            this.availableTaxes = availableTaxes;
        }

        public void notifyAvailable(Taxi taxi) {
            availableTaxes.add(taxi);
        }

        public Image getImage() {
            Set<Taxi> copy;
            synchronized (this) {
                copy = new HashSet<>(taxis);
            }
            Image image=new Image();
            for (Taxi t : copy) {
                image.drawMaker(t.getLocation());  //画图
            }
            return image;
        }
    }

    class Image{

        public void drawMaker(Point location) {

        }
    }
}


