package co.speedar.infra.itcool.hw.matrix;

import java.util.*;

public class Main {
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Point point = (Point) o;
			return x == point.x && y == point.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public String toString() {
			final StringBuffer sb = new StringBuffer();
			sb.append("(").append(x);
			sb.append(", ").append(y);
			sb.append(')');
			return sb.toString();
		}
	}

	static class Move {
		Point pre;
		Point current;

		Move(Point current, Point pre) {
			this.current = current;
			this.pre = pre;
		}

		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Move move = (Move) o;
			return Objects.equals(pre, move.pre) && Objects.equals(current, move.current);
		}

		public int hashCode() {
			return Objects.hash(pre, current);
		}
	}

	static class MoveNext extends Move {
		Point next;

		MoveNext(Point current, Point pre, Point next) {
			super(current, pre);
			this.next = next;
		}

		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			MoveNext move = (MoveNext) o;
			return Objects.equals(pre, move.pre) && Objects.equals(current, move.current) && Objects
					.equals(next, move.next);
		}

		public int hashCode() {
			return Objects.hash(pre, current, next);
		}
	}

	/**
	 * 迷宫搜索工具类
	 */
	static class MazeSearcher {
		/**
		 * 迷宫
		 */
		private int[][] maze;

		/**
		 * 入口
		 */
		private Point entry;

		/**
		 * 出口
		 */
		private Point exit;

		/**
		 * 当前路径
		 */
		private Deque<Move> dequeOfCurrentPathMoves = new ArrayDeque<>();

		/**
		 * 保存当前候选位置以供回溯使用：
		 * [currentPoint, previousPoint, nextPoint]
		 */
		private Stack<MoveNext> stackOfOptionalMoves = new Stack<>();

		/**
		 * 所有可能的路径
		 */
		private List<List<Move>> paths = new LinkedList<>();

		private boolean isFound = false;

		MazeSearcher(int[][] maze, int startX, int startY, int endX, int endY) {
			this.maze = maze;
			entry = new Point(startX, startY);
			exit = new Point(endX, endY);
		}

		MazeSearcher(int[][] maze, Point entry, Point exit) {
			this.maze = maze;
			this.entry = entry;
			this.exit = exit;
		}

		/**
		 * 从所有路径中返回最短路径
		 *
		 * @return
		 */
		public List<Point> getShortestPath() {
			if (isFound) {
				int shortest = paths.get(0).size();
				List<Point> shortestPath = getCurrentPathFromPaths(paths.get(0));
				for (List<Move> tmpPath : paths) {
					if (tmpPath.size() < shortest) {
						shortest = tmpPath.size();
						shortestPath = getCurrentPathFromPaths(tmpPath);
					}
				}
				return shortestPath;
			} else {
				return null;
			}
		}

		private List<Point> getCurrentPathFromPaths(List<Move> path) {
			List<Point> shortestPath = new LinkedList<>();
			for (Move points : path) {
				shortestPath.add(points.current);
			}
			return shortestPath;
		}

		/**
		 * 基于栈的DFS路径搜索<br/>
		 * 1. 初始化三个点：current-当前位置，pre-前一个位置，next-下一个位置；<br/>
		 * 2. 搜索所有当前点相邻的可行点并保存到movables；<br/>
		 * 3. 从movables中删除一个点作为next，移动指针：pre指向current，current指向next；<br/>
		 * 4. 把剩余的movables元素放到一个栈中以供回溯；<br/>
		 * 5. 如果当前位置无路可走，则从stack中pop一个元素出来并回溯至其对应的位置，然后尝试使用其他可行的位置；<br/>
		 * 6. 循环上述步骤直至所有路径搜索完毕；<br/>
		 */
		public void findAllPaths() {
			Point current = new Point(entry.x, entry.y);
			Point pre = null;
			Point next = null;
			dequeOfCurrentPathMoves.offer(new Move(current, pre));
			List<Point> movables = searchNext(current, pre);
			do {
				if (isNotEmpty(movables)) { // 先尝试继续往下走
					next = movables.remove(0);
					while (isNotEmpty(movables)) {
						Point tmp = movables.remove(0);
						stackOfOptionalMoves.push(new MoveNext(current, pre, tmp));
					}
					pre = current;
					current = next;
					dequeOfCurrentPathMoves.offer(new Move(current, pre));
				} else { // 再尝试是否可以回溯
					if (!stackOfOptionalMoves.isEmpty() && !dequeOfCurrentPathMoves.isEmpty()) {
						MoveNext optionalMove = stackOfOptionalMoves.pop();
						while (!dequeOfCurrentPathMoves.isEmpty()) {
							Move currentMove = dequeOfCurrentPathMoves.removeLast(); // LIFO
							if (Objects.equals(currentMove.current, optionalMove.current) && Objects
									.equals(currentMove.pre, optionalMove.pre)) { // 回退到正确的位置
								dequeOfCurrentPathMoves.offer(currentMove);
								break;
							}
						}
						// 在最近的一个分叉节点选择一个不同的位置继续搜索
						next = optionalMove.next;
						current = optionalMove.current;
						pre = current;
						current = next;
						dequeOfCurrentPathMoves.offer(new Move(current, pre));
					}
				}
				if (isExit(current)) { // 检查出口
					rememberCurrentPath();
				}
				movables = searchNext(current, pre); // 继续搜索可行位置
			} while (isNotEmpty(movables) || !stackOfOptionalMoves.isEmpty()); // 直至不可移动或者不可回溯
		}

		// 记住当前路径
		private void rememberCurrentPath() {
			List<Move> currentPoints = new LinkedList<>(dequeOfCurrentPathMoves);
			paths.add(currentPoints);
			isFound = true;
		}

		private boolean isExit(Point current) {
			return exit.equals(current);
		}

		private boolean isNotEmpty(List<Point> movables) {
			return movables != null && !movables.isEmpty();
		}

		/**
		 * 返回当前位置可以跳转的点
		 *
		 * @param current
		 * @param pre
		 * @return
		 */
		private List<Point> searchNext(Point current, Point pre) {
			Point next;
			List<Point> movables = new LinkedList<>();
			if (isExit(current)) {
				return movables;
			}
			next = searchUp(current);
			checkAndSaveNext(pre, next, movables);
			next = searchDown(current);
			checkAndSaveNext(pre, next, movables);
			next = searchLeft(current);
			checkAndSaveNext(pre, next, movables);
			next = searchRight(current);
			checkAndSaveNext(pre, next, movables);
			return movables;
		}

		/**
		 * 检查非空；
		 * 检查是否可行；
		 * 排除上一跳；
		 * 检查是否有环；
		 *
		 * @param pre
		 * @param next
		 * @param movables
		 */
		private void checkAndSaveNext(Point pre, Point next, List<Point> movables) {
			if (next != null && isAvailable(next) && !next.equals(pre) && !containsCircle(next)) {
				movables.add(next);
			}
		}

		private boolean containsCircle(Point next) {
			for (Move path : dequeOfCurrentPathMoves) {
				if (path.current.equals(next)) {
					return true;
				}
			}
			return false;
		}

		private boolean isAvailable(Point next) {
			if (maze[next.x][next.y] == 0) {
				return true;
			}
			return false;
		}

		private Point searchUp(Point current) {
			Point next = null;
			if (current.x - 1 >= 0) {
				next = new Point(current.x - 1, current.y);
			}
			return next;
		}

		private Point searchRight(Point current) {
			Point next = null;
			if (current.y + 1 < maze[current.x].length) {
				next = new Point(current.x, current.y + 1);
			}
			return next;
		}

		private Point searchLeft(Point current) {
			Point next = null;
			if (current.y - 1 >= 0) {
				next = new Point(current.x, current.y - 1);
			}
			return next;
		}

		private Point searchDown(Point current) {
			Point next = null;
			if (current.x + 1 < maze.length) {
				next = new Point(current.x + 1, current.y);
			}
			return next;
		}
	}

	// 变1为0
	public static List<int[][]> mutateMaze(int[][] maze) {
		List<int[][]> result = new LinkedList<>();
		result.add(maze);
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j] == 1) {
					int[][] copied = cloneMaze(maze);
					copied[i][j] = 0;
					result.add(copied);
				}
			}
		}
		return result;
	}

	public static int[][] cloneMaze(int[][] maze) {
		int[][] copied = new int[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				copied[i][j] = maze[i][j];
			}
		}
		return copied;
	}

	public static List<Point> findShortest(int[][] maze, Point start, Point end) {
		List<int[][]> mazes = mutateMaze(maze);
		List<List<Point>> results = new LinkedList<>();
		for (int[][] m : mazes) {
			MazeSearcher searcher = new MazeSearcher(m, start.x, start.y, end.x, end.y);
			searcher.findAllPaths();
			if (searcher.isFound) {
				results.add(searcher.getShortestPath());
			}
		}
		List<Point> result = new LinkedList<>();
		int shortest = -1;
		if (!results.isEmpty()) {
			for (List<Point> list : results) {
				if (shortest == -1 || shortest > list.size()) {
					shortest = list.size();
					result = list;
				}
			}
		}
		return result;
	}

	public static void printPath(List<Point> path) {
		int i = 0;
		if (path != null && !path.isEmpty()) {
			for (Point point : path) {
				System.out.print(point); // NOSONAR
				if (++i < path.size()) {
					System.out.print(" -> "); // NOSONAR
				} else {
					System.out.println(); // NOSONAR
				}
			}
		} else {
			System.out.println("∞"); // NOSONAR
		}
	}

	public static int getPathLength(List<Point> path) {
		return path != null && !path.isEmpty() ? path.size() - 1 : -1;
	}

	public static void main(String[] args) {
		int[][] maze = new int[2][4];
		int[] tmp = new int[]{0, 0, 1, 0};
		maze[0] = tmp;
		tmp = new int[]{1, 0, 0, 0};
		maze[1] = tmp;
		Point start = new Point(0, 0);
		Point end = new Point(0, 3);
		List<Point> result = findShortest(maze, start, end);
		int length = getPathLength(result);
		System.out.println(length); // NOSONAR
		printPath(result);
		assert length == 3;

		tmp = new int[]{0, 1, 1, 0};
		maze[0] = tmp;
		tmp = new int[]{1, 1, 0, 0};
		maze[1] = tmp;
		result = findShortest(maze, start, end);
		length = getPathLength(result);
		System.out.println(length); // NOSONAR
		printPath(result);
		assert length == -1;
	}
}
