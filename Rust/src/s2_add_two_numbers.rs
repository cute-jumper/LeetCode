struct Solution;

use crate::list_node::ListNode;

impl Solution {
    pub fn add_two_numbers(
        l1: Option<Box<ListNode>>,
        l2: Option<Box<ListNode>>,
    ) -> Option<Box<ListNode>> {
        let mut carry = 0;
        let mut result = Some(Box::new(ListNode::new(0)));
        let mut current = &mut result;
        let (mut l1, mut l2) = (l1, l2);
        while l1 != None || l2 != None || carry != 0 {
            let val = match l1 {
                Some(node) => {
                    l1 = node.next;
                    node.val
                }
                _ => 0,
            } + match l2 {
                Some(node) => {
                    l2 = node.next;
                    node.val
                }
                _ => 0,
            } + carry;
            let next = Some(Box::new(ListNode::new(val % 10)));
            carry = val / 10;
            current.as_mut().unwrap().next = next;
            current = &mut current.as_mut().unwrap().next;
        }
        result.unwrap().next
    }
}



#[test]
fn test() {
    let list1 = ListNode::from_vec(vec![2, 4, 3]);
    let list2 = ListNode::from_vec(vec![5, 6, 4]);
    assert_eq!(
        vec![7, 0, 8],
        ListNode::to_vec(Solution::add_two_numbers(list1, list2))
    );
}
