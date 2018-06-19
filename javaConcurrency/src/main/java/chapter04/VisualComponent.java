package chapter04;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VisualComponent {
    private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();//线程安全的List
    private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<>();

    public void addKeyListener(KeyListener listener) {
        keyListeners.add(listener);  //添加，是线程安全的，将keyListeners拷贝一份进行添加，添加完成后，将引用指向拷贝的那一份
    }

    public void removeKeyListener(MouseListener listener) {
        mouseListeners.remove(listener);
    }

}
class KeyListener{

}
class MouseListener{

}
