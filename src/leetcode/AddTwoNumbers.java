package leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ans = addTwoNumbers(l1, l2);
        ListNode cur = ans;
        StringBuffer sb = new StringBuffer();
        while (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
        }
        System.out.println(sb.reverse());
    }


    /*
        leecode solution reference
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;

        int carry = 0;
        while (p != null || q != null) {

            int a = (p != null) ? p.val : 0;
            int b = (q != null) ? q.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
