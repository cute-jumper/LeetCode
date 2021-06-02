struct Solution;

impl Solution {
    pub fn longest_valid_parentheses(s: String) -> i32 {
        let chars: Vec<char> = s.chars().collect();
        let mut stack = Vec::<usize>::new();
        let mut longest = 0;
        for i in 0..chars.len() {
            if chars[i] == ')' && stack.last().filter(|index| chars[**index] == '(').is_some() {
                stack.pop();
                longest = std::cmp::max(
                    longest,
                    i as i32 - stack.last().map(|index| *index as i32).unwrap_or(-1),
                );
            } else {
                stack.push(i);
            }
        }
        longest
    }
}

#[test]
fn test() {
    assert_eq!(2, Solution::longest_valid_parentheses("(()".to_owned()));
    assert_eq!(4, Solution::longest_valid_parentheses(")()())".to_owned()));
    assert_eq!(0, Solution::longest_valid_parentheses("".to_owned()));
}
