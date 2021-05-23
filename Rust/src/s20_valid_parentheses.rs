struct Solution;

impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut stack = Vec::<char>::new();
        for c in s.chars() {
            match c {
                '{' => {
                    stack.push('}');
                }
                '[' => {
                    stack.push(']');
                }
                '(' => {
                    stack.push(')');
                }
                _ => {
                    if stack.pop().filter(|v| *v == c).is_none() {
                        return false;
                    }
                }
            }
        }
        stack.is_empty()
    }
}

#[test]
fn test() {
    assert!(Solution::is_valid("()([]{})".to_owned()));
    assert!(!Solution::is_valid("()[".to_owned()));
    assert!(Solution::is_valid("".to_owned()));
}
