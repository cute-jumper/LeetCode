struct Solution;

impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        let mut res = Vec::<String>::new();
        Self::generate(&mut res, "".to_owned(), n, 0);
        res
    }

    fn generate(res: &mut Vec<String>, prefix:String, left: i32, right: i32) {
        if left == 0 && right == 0 {
            res.push(prefix);
            return;
        }
        if left > 0 {
            Self::generate(res, prefix.to_owned() + "(", left - 1, right + 1);
        }
        if right > 0 {
            Self::generate(res, prefix.to_owned() + ")", left, right - 1);
        
        }
    }
}

#[test]
fn test() {
    assert_eq!(vec!["((()))","(()())","(())()","()(())","()()()"], Solution::generate_parenthesis(3));
    assert_eq!(vec!["()"], Solution::generate_parenthesis(1));
}