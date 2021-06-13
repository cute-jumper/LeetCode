use crate::list_node::ListNode;

struct Solution;

impl Solution {
    pub fn remove_nth_from_end(head: Option<Box<ListNode>>, n: i32) -> Option<Box<ListNode>> {
        let mut vhead = Some(Box::new(ListNode { val: 0, next: head }));
        let mut fast = &vhead;
        let mut count = 0;
        while let Some(node) = fast {
            fast = &node.next;
            count += 1;
        }
        let mut slow = &mut vhead;
        for _ in 0..(count - n - 1) {
            slow = &mut slow.as_mut().unwrap().next;
        }
        let next = slow.as_mut().unwrap().next.as_mut().unwrap().next.take();
        slow.as_mut().unwrap().next = next;
        vhead.unwrap().next
    }

    pub fn remove_nth_from_end_unsafe(
        head: Option<Box<ListNode>>,
        n: i32,
    ) -> Option<Box<ListNode>> {
        let mut vhead = Some(Box::new(ListNode { val: 0, next: head }));
        let mut slow: *mut Option<Box<ListNode>> = &mut vhead;
        let mut fast = &vhead.as_ref().unwrap().next;
        for _ in 0..n {
            fast = &fast.as_ref().unwrap().next;
        }
        while let Some(node) = fast {
            fast = &node.next;
            slow = unsafe { &mut (*slow).as_mut().unwrap().next as *mut _ };
        }
        unsafe {
            let next = (*slow).as_mut().unwrap().next.as_mut().unwrap().next.take();
            (*slow).as_mut().unwrap().next = next;
        }
        vhead.unwrap().next
    }
}

#[test]
fn test() {
    assert_eq!(
        ListNode::to_vec(Solution::remove_nth_from_end(
            ListNode::from_vec(vec![1, 2, 3, 4, 5]),
            2
        )),
        vec![1, 2, 3, 5]
    );
    assert_eq!(
        ListNode::to_vec(Solution::remove_nth_from_end(
            ListNode::from_vec(vec![1]),
            1
        )),
        vec![]
    );
}
