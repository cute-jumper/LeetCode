struct Solution;

use std::cmp::max;
use std::collections::HashMap;

impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut start = 0;
        let mut char_to_index = HashMap::new();
        let mut longest = 0;
        for (i, c) in s.chars().into_iter().enumerate() {
            match char_to_index.insert(c, i) {
                Some(prev) if prev >= start => {
                    longest = max(longest, i - start);
                    start = prev + 1;
                }
                _ => {}
            }
        }
        max(longest, s.len() - start) as i32
    }
}

#[test]
fn test() {
    assert_eq!(
        3,
        Solution::length_of_longest_substring(String::from("abcabcbb"))
    );
    assert_eq!(
        1,
        Solution::length_of_longest_substring(String::from("bbbbb"))
    );
    assert_eq!(
        3,
        Solution::length_of_longest_substring(String::from("pwwkew"))
    );
    assert_eq!(0, Solution::length_of_longest_substring(String::from("")));
    assert_eq!(
        2,
        Solution::length_of_longest_substring(String::from("cdd"))
    );
    assert_eq!(
        2,
        Solution::length_of_longest_substring(String::from("abba"))
    );
}
