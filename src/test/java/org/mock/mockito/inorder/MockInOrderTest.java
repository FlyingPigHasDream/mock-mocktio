package org.mock.mockito.inorder;

import org.junit.Assert;
import org.junit.Test;
import org.mock.mockito.method.Class1Mocked;
import org.mockito.InOrder;
import org.mockito.Mockito;

/**
 * @author rainyday
 * @createTime 2019/1/12.
 */
public class MockInOrderTest {

    @Test
    public void testMockMethodInOrder() {
        Class1Mocked objOther = Mockito.mock(Class1Mocked.class);
        Class1Mocked objCn = Mockito.mock(Class1Mocked.class);

        Mockito.when(objOther.hello("z3")).thenReturn("hello l4");
        Mockito.when(objCn.hello("z3")).thenReturn("hello 张三");

        String other = objOther.hello("z3");  //这里决定了 objOther在先
        Assert.assertEquals("hello l4", other);
        String cn = objCn.hello("z3");          //这里决定了 objCn在后
        Assert.assertEquals("hello 张三", cn);

        InOrder inOrder = Mockito.inOrder(objOther, objCn); //此行并不决定顺序，下面的两行才开始验证顺序
        inOrder.verify(objOther).hello("z3");
        inOrder.verify(objCn).hello("z3");
    }
}
