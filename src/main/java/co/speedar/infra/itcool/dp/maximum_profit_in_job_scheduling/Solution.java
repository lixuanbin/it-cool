package co.speedar.infra.itcool.dp.maximum_profit_in_job_scheduling;

import java.util.ArrayList;
import java.util.List;

class Solution {
	class Job {
		int index;
		int start;
		int end;
		int profit;

		Job(int i, int s, int e, int p) {
			this.index = i;
			this.start = s;
			this.end = e;
			this.profit = p;
		}

		@Override
		public String toString() {
			return String.format("(i=%d,start=%d,end=%d,profit=%d)", index, start, end, profit);
		}
	}

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		List<Job> list = new ArrayList<>();
		for (int i = 0; i < startTime.length; i++) {
			list.add(new Job(i, startTime[i], endTime[i], profit[i]));
		}
		list.sort((o1, o2) -> {
			if (o1.end > o2.end) {
				return 1;
			} else if (o1.end < o2.end) {
				return -1;
			} else {
				if (o1.start < o2.start) {
					return -1;
				} else if (o1.start > o2.start) {
					return 1;
				} else {
					return 0;
				}
			}
		});
//		System.out.println(list);
//		List[][] paths = new List[startTime.length][2];
//		for (int i = 0; i < startTime.length; i++) {
//			paths[i][0] = new ArrayList();
//			paths[i][1] = new ArrayList();
//		}
		int[][] f = new int[startTime.length][2];
		f[0][1] = list.get(0).profit;
		f[0][0] = 0;
		int[][] t = new int[startTime.length][2];
		t[0][0] = 0;
		t[0][1] = list.get(0).end;
//		paths[0][1].add(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			Job job = list.get(i);
			if (f[i - 1][0] > f[i - 1][1]) {
				f[i][0] = f[i - 1][0];
				t[i][0] = t[i - 1][0];
			} else {
				f[i][0] = f[i - 1][1];
				t[i][0] = t[i - 1][1];
			}
			t[i][1] = job.end;
//			paths[i][0].addAll(f[i - 1][0] > f[i - 1][1] ? paths[i - 1][0] : paths[i - 1][1]);
			int[] j = index(i, job.start, f, t);
			if (j[0] == -1) {
				f[i][1] = job.profit;
			} else {
				f[i][1] = job.profit + f[j[0]][j[1]];
//				paths[i][1].addAll(paths[j[0]][j[1]]);
			}
//			paths[i][1].add(job);
		}
//		System.out.println(paths[startTime.length-1][0]);
//		System.out.println(paths[startTime.length-1][1]);
//		System.out.println(f[startTime.length-1][0]);
//		System.out.println(f[startTime.length-1][1]);
		return Math.max(f[startTime.length-1][0], f[startTime.length-1][1]);
	}

	private int[] index(int i, int startTime, int[][] p, int[][] t) {
		int s = startTime;
		i--;
		int j = 0;
		while (i >= 0) {
			if (t[i][1] <= s && t[i][0] <= s) {
				if (p[i][0] > p[i][1]) {
					j = 0;
				} else {
					j = 1;
				}
				break;
			} else if (t[i][1] <= s) {
				j = 1;
				break;
			} else if (t[i][0] <= s) {
				j = 0;
				break;
			}
			i--;
		}
		return new int[]{i, j};
	}

	public static void main(String[] args) {
		/*
[15,44,15,47,11,18,5,41,38,25,19,25]
[33,48,20,49,37,22,32,48,39,37,38,40]
[18,19,16,1,5,12,17,7,19,9,18,9]
		 */
		int[] start = {15, 44, 15, 47, 11, 18, 5, 41, 38, 25, 19, 25};
		int[] end = {33, 48, 20, 49, 37, 22, 32, 48, 39, 37, 38, 40};
		int[] profit = {18, 19, 16, 1, 5, 12, 17, 7, 19, 9, 18, 9};
		System.out.println(new Solution().jobScheduling(start, end, profit));
	}
}