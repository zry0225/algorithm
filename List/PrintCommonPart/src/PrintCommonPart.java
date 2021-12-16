/**
 * @author zry
 * @Date 2021/12/16
 * @ApiNote
 * 有序链表，打印两个链表相同的节点，所以从链表的头开始进行如下判断
 * 1.head1的值小于head2 --- 则head1往后移动
 * 2.head2的值小于head1 --- 则head2往后移动
 * 3.如果head1和2的值相同，则打印并同时向后移动
 */
public class PrintCommonPart {
    public static void printCommonPart(Node head1,Node head2){
        //两个链表都不是空 进入循环
        while (head1.next!=null && head2.next!=null){
            //head1的值小于head2 --- 则head1往后移动
            if (head1.value<head2.value){
                //指针后移
                head1 = head1.next;
            }else if (head2.value<head1.value){
                head2 = head2.next;
            }else {
                System.out.println("head1.value = " + head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }

    }
}
