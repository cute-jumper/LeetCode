struct Solution;

impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        let (mut start, mut longest) = (0, 1);
        let mut dp = vec![vec![false; s.len()]; s.len()];
        let chars: Vec<char> = s.chars().collect();
        for i in (0..s.len()).rev() {
            for j in i..s.len() {
                dp[i][j] = chars[i] == chars[j] && (j - i <= 1 || dp[i + 1][j - 1]);
                if dp[i][j] && j - i + 1 > longest {
                    start = i;
                    longest = j - i + 1;
                }
            }
        }
        String::from(&s[start..start+longest])
    }
}

#[test]
fn test() {
    assert_eq!(String::from("aba"), Solution::longest_palindrome(String::from("babad")));
    assert_eq!(String::from("bb"), Solution::longest_palindrome(String::from("cbbd")));
    assert_eq!(String::from("a"), Solution::longest_palindrome(String::from("a")));
    assert_eq!(String::from("a"), Solution::longest_palindrome(String::from("ac")));
}