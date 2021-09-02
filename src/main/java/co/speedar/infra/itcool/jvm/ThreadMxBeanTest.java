package co.speedar.infra.itcool.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ThreadMxBeanTest {
	private static String getThreadDump(boolean lockMonitors, boolean lockSynchronizers) {
		StringBuffer threadDump = new StringBuffer(System.lineSeparator());
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		for (ThreadInfo threadInfo : threadMXBean.dumpAllThreads(lockMonitors, lockSynchronizers)) {
			threadDump.append(threadInfo.toString());
		}
		return threadDump.toString();
	}

	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i);
			}
		}).start();
		System.out.println(getThreadDump(true, true));

	}
}
