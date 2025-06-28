package com.mathan.neetcode.stack.day09;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(2);
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0,0,n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if(cur.length()==max*2){
            ans.add(cur.toString());
            return;
        }
//        ! important condition below
        if(open<max){
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
//            !backtrack and check
            cur.deleteCharAt(cur.length()-1);
        }
        //! this is also valid condition
        if(close<open){
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}