package lambda.example.chapter4;

import lambda.example.chapter4.defaultmethod.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultMethodTest {

    @Test
    public void parentDefaultTest() {
        Parent parent = new ParentImpl();
        parent.welcome();
        assertEquals("Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void childDefaultTest(){
        Child child = new ChildImpl();
        child.welcome();
        assertEquals("Child: Hi!",child.getLastMessage());
    }

    @Test
    public void overridingParentDefaultTest(){
        Parent parent = new OverridingParent();
        parent.welcome();
        assertEquals("Class Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void overridingChildDefaultTest(){
        Child child = new OverridingChild();
        child.welcome();
        assertEquals("Class Parent: Hi!", child.getLastMessage());
    }
}
