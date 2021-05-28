struct Solution;

impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        if needle.is_empty() {
            return 0;
        }
        //haystack.find(&needle[..]).map_or(-1, |v| v as i32)
        let haystack: Vec<char> = haystack.chars().collect();
        let needle: Vec<char> = needle.chars().collect();
        if needle.len() > haystack.len() {
            return -1;
        }
        for i in 0..=(haystack.len() - needle.len()) {
            let mut j = 0;
            while j < needle.len() {
                if haystack[i + j] != needle[j] {
                    break;
                }
                j += 1;
            }
            if j == needle.len() {
                return i as i32;
            }
        }
        -1
    }
}

#[test]
fn test() {
    assert_eq!(2, Solution::str_str("hello".to_owned(), "ll".to_owned()));
    assert_eq!(-1, Solution::str_str("aaaaa".to_owned(), "bba".to_owned()));
    assert_eq!(0, Solution::str_str("".to_owned(), "".to_owned()));
    assert_eq!(-1, Solution::str_str("".to_owned(), "a".to_owned()));
}
