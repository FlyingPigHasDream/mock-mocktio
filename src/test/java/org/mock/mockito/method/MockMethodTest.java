package org.mock.mockito.method;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author rainyday
 * @createTime 2019/1/12.
 */
public class MockMethodTest {

    @Test
    public void testMockMethod() {
        Class1Mocked obj = mock(Class1Mocked.class);

        Mockito.when(obj.hello("z3")).thenReturn("hello l4");

        String actual=obj.hello("z3");
        assertEquals("hello l4",actual);

        verify(obj).hello("z3");
        //verify(obj,times(1)).hello("z3"); //可以加参数验证次数
    }
}
