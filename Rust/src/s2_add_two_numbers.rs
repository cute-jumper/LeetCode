struct Solution;
// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }
}

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

fn to_list(numbers: Vec<i32>) -> Option<Box<ListNode>> {
    let mut head = Some(Box::new(ListNode::new(0)));
    let mut current = &mut head;
    for i in numbers {
        let node = Some(Box::new(ListNode::new(i)));
        current.as_mut().unwrap().next = node;
        current = &mut current.as_mut().unwrap().next;
    }
    head.unwrap().next
}

fn to_vec(list: Option<Box<ListNode>>) -> Vec<i32> {
    let mut result = vec![];
    let mut current = &list;
    while *current != None {
        result.push(current.as_ref().unwrap().val);
        current = &current.as_ref().unwrap().next;
    }
    result
}

#[test]
fn test() {
    let list1 = to_list(vec![2, 4, 3]);
    let list2 = to_list(vec![5, 6, 4]);
    assert_eq!(
        vec![7, 0, 8],
        to_vec(Solution::add_two_numbers(list1, list2))
    );
}
