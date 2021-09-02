package co.speedar.infra.itcool.recursion;

import java.util.*;

public class NQueen {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		if (n == 1) {
			result.add(Arrays.asList("Q"));
		} else if (n > 3) {
			int[][] board = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = 0;
				}
			}
			solve(board, result, 0, 0, new LinkedList<>());
		}
		return result;
	}
	private void solve(int[][] board, List<List<String>> resultList, int row, int col,
			LinkedList<Pair<Integer, Integer>> selected) {
		if (selected.size() == board.length) {
			addToResult(selected, resultList);
			return;
		}
		if (row == board.length - 1 && col == board.length - 1) {
			return;
		}
		int newRow = row;
		int newCol = col + 1;
		if (newCol == board.length) {
			newCol = 0;
			newRow += 1;
		}
		if (board[row][col] == 0) {
			// select
			++board[row][col];
			queenExclude(board, row, col, 1);
			selected.addLast(new Pair<>(row, col));
			solve(board, resultList, newRow, newCol, selected);
			// deselect and pass
			--board[row][col];
			queenExclude(board, row, col, -1);
			selected.removeLast();
		}
		solve(board, resultList, newRow, newCol, selected);
	}
	private void queenExclude(int[][] board, int row, int col, int delta) {
		/*System.out.println("row: " + row + ", col: " + col + ", delta: "
				+ delta + ", board before exclude: ");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}*/
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i == row && j != col) {
					board[i][j] += delta;
				} else if (j == col && i != row) {
					board[i][j] += delta;
				} else if (i != row && j != col) {
					int a = col - row;
					int b = row + col;
					if (j == i + a || j == b - i) {
						board[i][j] += delta;
					}
				}
			}
		}
		/*System.out.println("board after exclude: ");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}*/
	}
	private void addToResult(LinkedList<Pair<Integer, Integer>> selected, List<List<String>> resultList) {
		List<String> lines = new ArrayList<>();
		for (Pair<Integer, Integer> point: selected) {
			lines.add(printLineByPoint(point, selected.size()));
		}
		resultList.add(lines);
	}
	private String printLineByPoint(Pair<Integer, Integer> point, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (i == point.right) {
				sb.append("Q");
			} else {
				sb.append(".");
			}
		}
		return sb.toString();
	}
	class Pair<L, R> {
		L left;
		R right;
		Pair(L l, R r) {
			this.left = l;
			this.right = r;
		}
		public String toString() {
			return "{" + left + "," + right + "}";
		}
		public int hashCode() {
			return Objects.hash(left, right);
		}
		public boolean equals(Object other) {
			if (other instanceof Pair) {
				Pair o = (Pair) other;
				return Objects.equals(this.left, o.left) && Objects.equals(this.right, o.right);
			} else {
				return false;
			}
		}
	}
	public static void main(String[] args) {
		NQueen nQueen = new NQueen();
		/*int[][] board = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
		int row = 2;
		int col = 1;
		nQueen.queenExclude(board, row, col, 1);
		nQueen.queenExclude(board, row, col, -1);*/
		System.out.println(nQueen.solveNQueens(4));
	}
}
