struct Solution;

impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        if x < 0 {
            return false;
        }
        let (mut div, mut n) = (1, x);
        while div <= x / 10 {
            div *= 10;
        }
        while div > 9 {
            if n / div != n % 10 {
                return false;
            }
            n = (n % div) / 10;
            div /= 100;
        }
        true
    }
}

#[test]
fn test() {
    assert_eq!(true, Solution::is_palindrome(121));
    assert_eq!(false, Solution::is_palindrome(-121));
    assert_eq!(false, Solution::is_palindrome(10));
    assert_eq!(true, Solution::is_palindrome(11));
    assert_eq!(true, Solution::is_palindrome(1));
}
