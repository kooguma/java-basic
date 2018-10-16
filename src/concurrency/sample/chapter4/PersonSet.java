package concurrency.sample.chapter4;

import concurrency.annotations.GuardedBy;
import concurrency.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * 实例封闭是构建线程安全类的一个最简单的方式
 */
@ThreadSafe
public class PersonSet {

    private class Person {

    }

    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }


}
