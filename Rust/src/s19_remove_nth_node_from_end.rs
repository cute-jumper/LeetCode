use crate::list_node::ListNode;

struct Solution;

impl Solution {
    pub fn remove_nth_from_end(head: Option<Box<ListNode>>, n: i32) -> Option<Box<ListNode>> {
        let mut vhead = Some(Box::new(ListNode::new(0)));
        vhead.as_mut().unwrap().next = head;
        let mut fast = &vhead.as_ref().unwrap().next;
        for _ in 0..n {
            fast = &fast.as_ref().unwrap().next;
        }
        let mut count = 0;
        while let Some(node) = fast {
            fast = &node.next;
            count += 1;
        }
        let mut slow = &mut vhead;
        for _ in 0..count {
            slow = &mut slow.as_mut().unwrap().next;
        }
        let next = &slow.as_ref().unwrap().next.as_ref().unwrap().next;
        slow.as_mut().unwrap().next = next.clone();
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
