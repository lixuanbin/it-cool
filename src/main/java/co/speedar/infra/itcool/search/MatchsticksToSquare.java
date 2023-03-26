package co.speedar.infra.itcool.search;

import java.util.*;

public class MatchsticksToSquare {
	private boolean found = false;

	public boolean makesquare(int[] matchsticks) {
		long perimeter = 0;
		for (int i : matchsticks) {
			perimeter += i;
		}
		if (perimeter == 0 || perimeter % 4 != 0) {
			return false;
		}
		int side = (int) (perimeter / 4);
		List<LinkedList<Integer>> edges = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			edges.add(new LinkedList<>());
		}
		int[] sums = new int[4];
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> matches = new ArrayList<>();
		for (int i : matchsticks) {
			if (i > side) {
				return false;
			}
			matches.add(i);
		}
		Collections.sort(matches);
		Collections.reverse(matches);
		search(matches, 0, side, edges, sums, result);
		return !result.isEmpty();
	}
	private void search(List<Integer> matchsticks, int index, int side, List<LinkedList<Integer>> edges, int[] sums,
			List<List<Integer>> result) {
		if (found) {
			return;
		}
		if (index > matchsticks.size() - 1) {
			/*for (int i = 0; i < 4; i++) {
				System.out.println(edges.get(i));
			}
			System.out.println("----------------------------------------");*/
			if (sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3] && sums[0] == side) {
				for (int i = 0; i < 4; i++) {
					result.add(new LinkedList<>(edges.get(i)));
				}
				found = true;
			}
			return;
		}
		int hasCount = 0;
		for (int i = 0; i < 4; i++) {
			if (edges.get(i).size() > 0) {
				hasCount++;
			}
		}
		if ((matchsticks.size() - index) < (4 - hasCount)) {
			return;
		}
		int current = matchsticks.get(index++);
		for (int i = 0; i < 4; i++) {
			if (sums[i] < side) {
				edges.get(i).add(current);
				sums[i] += current;
				search(matchsticks, index, side, edges, sums, result);
				sums[i] -= current;
				edges.get(i).removeLast();
			}
		}
	}

	public static void main(String[] args) {
		// int[] matches = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
		int[] matches = {7215807, 6967211, 5551998, 6632092, 2802439, 821366, 2465584, 9415257, 8663937, 3976802,
				2850841, 803069, 2294462, 8242205, 9922998};
		long start = System.currentTimeMillis();
		System.out.println(new MatchsticksToSquare().makesquare(matches));
		System.out.println("time consumed: " + (System.currentTimeMillis() - start) + " ms...");
	}
}
