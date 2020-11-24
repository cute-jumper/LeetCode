struct Solution;

use std::collections::VecDeque;
impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        if digits.is_empty() || digits.chars().any(|c| c < '2' || c > '9') {
            return Vec::new();
        }
        let map = ["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];
        let mut result = VecDeque::new();
        result.push_back("".to_owned());
        for d in digits.chars() {
            let length = result.len();
            for _ in 0..length {
                if let Some(s) = result.pop_front() {
                    for c in map[(d as usize) - ('2' as usize)].chars() {
                        result.push_back(format!("{}{}", s, c));
                    }
                }
            }
        }
        Vec::from(result)
    }
}

#[test]
fn test() {
    assert_eq!(
        Solution::letter_combinations(String::from("23")),
        vec!["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    );
    assert_eq!(
        Solution::letter_combinations(String::from("")),
        Vec::<String>::new()
    );
    assert_eq!(
        Solution::letter_combinations(String::from("2")),
        vec!["a", "b", "c"]
    );
}
