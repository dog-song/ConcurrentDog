package com.dogsong.a.linkedlist;

import java.util.HashMap;

/**
 * 146. LRU 缓存
 *
 * https://leetcode-cn.com/problems/lru-cache/
 *
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/29
 */
public class Solution_146 {

    private HashMap<Integer, Node> map;

    private DoubleLinkedList cache;

    private int cap;

    public Solution_146(int capacity) {
        map = new HashMap<>();
        cache = new DoubleLinkedList();
        this.cap = capacity;
    }

    public void put(int key, int val) {
        Node newNode = new Node(key, val);

        if (map.containsKey(key)) {
            cache.delete(map.get(key));
            cache.addFirst(newNode);
            map.put(key, newNode);
        } else {
            if (map.size() == cap) {
                int k = cache.deleteLast();
                map.remove(k);
            }
            cache.addFirst(newNode);
            map.put(key, newNode);

        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        int val = map.get(key).val;
        put(key, val);
        return val;
    }

}

/**
 * head: recently used
 * tail: LRU
 */
class DoubleLinkedList {
    public Node head;
    public Node tail;

    public DoubleLinkedList() {
        this.head = new Node(0 ,0);
        this.tail = new Node(0 ,0);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int delete(Node node) {
        int key = node.key;

        node.next.prev = node.prev;
        node.prev.next = node.next;

        return key;
    }
    public int deleteLast() {
        if (head.next == tail) {
            return -1;
        }
        return delete(tail.prev);
    }
}

class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
