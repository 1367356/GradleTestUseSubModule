package chapter17.class07;

import java.util.PriorityQueue;

/**
 * 模仿优先级队列
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem> {  //ToDoList中的元素实现了，Comparable
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        @Override
        public int compareTo(ToDoItem toDoItem) {
            if (primary > toDoItem.primary) {
                return +1;
            }
            if (primary == toDoItem.primary) {
                if (secondary > toDoItem.secondary) {
                    return +1;
                } else if (secondary == toDoItem.secondary) {
                    return 0;
                }
            }
            return -1;
        }
    }

    public void add(String td, char pri, int sec) {
        super.add(new ToDoItem(pri, sec, td));
    }

    public static void main(String[] args){
        ToDoList toDoList=new ToDoList();
        toDoList.add("Empty trash", 'c', 4);  //添加了实现Comparable 的元素，
    }
}
