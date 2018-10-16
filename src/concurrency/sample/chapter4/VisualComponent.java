package concurrency.sample.chapter4;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * VisualComponent 使用 CopyOnWriteArrayList 来保存各个监听器列表。它是一个线程安全的链表，特别适用于管理监听器列表。
 */
public class VisualComponent {

    private final List<KeyListener> keyListeners
            = new CopyOnWriteArrayList<>();

    private final List<MouseListener> mouseListeners
            = new CopyOnWriteArrayList<>();

    public void addKeyListener(KeyListener listener) {
        keyListeners.add(listener);
    }

    public void addMouseListener(MouseListener listener) {
        mouseListeners.add(listener);
    }

    public void removeKeyListener(KeyListener listener) {
        keyListeners.remove(listener);
    }

    public void removeMouseListener(MouseListener listener) {
        mouseListeners.remove(listener);
    }

}
