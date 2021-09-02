package co.speedar.infra.itcool.hw.move_server;

import java.util.Arrays;

public class Main {
	public static int findMoveCount(int[] servers) {
		if (servers == null || servers.length == 0) {
			return 0;
		}
		int[] sortedServers = new int[servers.length];
		for (int i = 0; i < servers.length; i++) {
			sortedServers[i] = servers[i];
		}
		Arrays.sort(sortedServers);
		int count = 0;
		for (int i = 0; i < servers.length; i++) {
			if (sortedServers[i] != servers[i]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] servers1 = {1, 1, 1, 2, 4, 3};
		int count1 = findMoveCount(servers1);
		System.out.println("moved: " + count1); // NOSONAR
		assert count1 == 2;

		int[] servers2 = {1, 1, 4, 2, 1, 3};
		int count2 = findMoveCount(servers2);
		System.out.println("moved: " + count2); // NOSONAR
		assert count2 == 3;

		int[] servers3 = new int[0];
		int count3 = findMoveCount(servers3);
		System.out.println("moved: " + count3); // NOSONAR
		assert count3 == 0;
	}
}
