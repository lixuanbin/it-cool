package co.speedar.infra.itcool.recursion.k_th_symbol_in_grammar;

import java.util.PriorityQueue;

class Solution {
/*
0
01
0110
01101001
recurrsive
f(n,k) can be inferred by f(n-1,k/2)
*/
    public int kthGrammar(int n, int k) {
        if (n == 1 && k == 1) {
            return 0;
        } else {
        	int newk = k % 2 == 0 ? k/2 : (k/2)+1;
            int a = kthGrammar(n-1, newk);
            int[] arr = new int[2];
            if (a == 0) {
                arr[0] = 0;
                arr[1] = 1;
            } else {
                arr[0] = 1;
                arr[1] = 0;
            }
            if (k % 2 == 1) {
                return arr[0];
            } else {
                return arr[1];
            }
        }
    }

	public static void main(String[] args) {
		System.out.println(new Solution().kthGrammar(3,4));
	}
}