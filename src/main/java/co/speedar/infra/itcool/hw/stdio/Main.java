package co.speedar.infra.itcool.hw.stdio;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// sc.next();
		System.out.println(Integer.highestOneBit(255));
		System.out.println(255 >> Integer.bitCount(255));
		System.out.println(Integer.bitCount(255));
		System.out.println(Integer.toBinaryString(255));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(0xffffffffL);
		System.out.println(Long.rotateLeft(255, 24) + Integer.rotateLeft(255, 16) + Integer.rotateLeft(255, 8) + 255L);
		System.out.println(0xffff);
		List<String> list = new ArrayList<>();
		// String a = "sdf sdfsdf";
		// Scanner cin2 = new Scanner(new BufferedInputStream(System.in));
		// 输入
		/*
		读一个整数： int n = sc.nextInt();
		读一个字符串：String s = sc.next();
		读一个浮点数：double t = sc.nextDouble();
		读一整行： String s = sc.nextLine();
		判断是否有下一个输入
		sc.hasNext()
		sc.hasNextInt()
		sc.hasNextDouble()
		sc.hasNextLine()
		 */

		// 输出
		/*
		System.out.print();
		System.out.println();
		System.out.format();
		System.out.printf();
		//0指一位数字，#指除0以外的数字(如果是0，则不显示)
		DecimalFormat fd = new DecimalFormat("#.00#");
		DecimalFormat gd = new DecimalFormat("0.000");
		System.out.println("x =" + fd.format(x));
		System.out.println("x =" + gd.format(x));
		 */

		// 高精度运算
		/*
		涉及到两个类BigDecimal（表示浮点数）和BigInteger（表示整数）
		使用这两个类的时候需要加上import java.math.*;
		valueOf(parament); 将参数转换为指定类型
		add(); //大数加法
		substract(); //减法
		multiply(); //乘法
		divided(); //相除取整
		remainder(); //取余
		pow(); //a.pow(b) = a ^ b
		gcd(); //最大公约数
		abs(); //绝对值
		negate(); //取反数
		mod(); //a.mod(b) = a % b = a.remainder(b)
		max(); min();
		public int compareTo(); //比较
		boolean equals(); //比较是否相等
		 */

		// 浮点数输出
		float f = 10.0f;
		double d = 345.678;

    /*
        'f' 浮点 结果被格式化为十进制数
        'e', 'E' 浮点 结果被格式化为用计算机科学记数法表示的十进制数
        'g', 'G' 浮点 根据精度和舍入运算后的值，使用计算机科学记数形式或十进制格式对结果进行格式化。
        'a', 'A' 浮点 结果被格式化为带有效位数和指数的十六进制浮点数
    */

		System.out.printf("%f %e %g %a \n", f, f, f, f);

		System.out.printf("%9.2f \n", d);//"9.2"中的9表示输出的长度，2表示小数点后的位数。
		System.out.printf("%+9.2f \n", d);//"+"表示输出的数带正负号。
		System.out.printf("%-9.4f \n", d);//"-"表示输出的数左对齐（默认为右对齐）。
		System.out.printf("%+-9.3f \n", d);//"+-"表示输出的数带正负号且左对齐。

		//可以输出多个变量，注意顺序。
		System.out.printf("字符串：%2$s，%1$d的十六进制数：%1$#x", 10, "你好");

		// 多进制输出（8、16进制）
		int i = 10;

    /*
        'd' 整数 结果被格式化为十进制整数
        'o' 整数 结果被格式化为八进制整数
        'x', 'X' 整数 结果被格式化为十六进制整数
    */

		//直接输出
		System.out.printf("%d %o %x \n", i, i, i);

		//带前缀输出
		System.out.printf("%d %#o %#x \n", i, i, i);

		//带前缀，控制宽度输出（宽度应该把前缀字符考虑在内，即：宽度=空格+前缀字符+数字）
		System.out.printf("%d %#4o %#4x \n", i, i, i);

		//带前缀，控制宽度，0补齐输出（宽度应该把前缀字符考虑在内，即：宽度=前缀字符+0补齐+数字）
		System.out.printf("%d %#04o %#04x \n", i, i, i);

		// 进制转换
		/*
		String st = Integer.toString(num, base); // 把num当做10进制的数转成base进制的st(base <= 35).

		int num = Integer.parseInt(st, base); // 把st当做base进制，转成10进制的int(parseInt有两个参数,第一个为要转的字符串,第二个为说明是什么进制).

		BigInter m = new BigInteger(st, base); // st是字符串，base是st的进制.

		System.out.println("十进制10转16进制为"+Integer.toHexString(10));
		System.out.println("十进制10转二进制为"+Integer.toBinaryString(10));
		*/

		// 四舍五入
		/*
		System.out.println("2.5的四舍五入值：" + Math.round(12.5));
		System.out.println("-2.5的四舍五入值：" + Math.round(-12.5));
		System.out.println("舍掉小数取整:Math.floor(-2.5)=" + (int)Math.floor(-i));
		System.out.println("凑整:Math.ceil(-2.5)=" + (int)Math.ceil(-i));

		BigDecimal i = num.setScale(2,RoundingMode.HALF_EVEN);

		1、 ROUND_UP：远离零方向舍入。向绝对值最大的方向舍入，只要舍弃位非0即进位。
		2、 ROUND_DOWN：趋向零方向舍入。向绝对值最小的方向输入，所有的位都要舍弃，不存在进位情况。
		3、 ROUND_CEILING：向正无穷方向舍入。向正最大方向靠拢。若是正数，舍入行为类似于ROUND_UP，      若为负数，舍入行为类似于ROUND_DOWN。Math.round()方法就是使用的此模式。
		4、 ROUND_FLOOR：向负无穷方向舍入。向负无穷方向靠拢。若是正数，舍入行为类似于ROUND_DOWN；若为负数，舍入行为类似于ROUND_UP。
		5、 HALF_UP：最近数字舍入(5进)。这是我们最经典的四舍五入。
		6、 HALF_DOWN：最近数字舍入(5舍)。在这里5是要舍弃的。
		7、 HAIL_EVEN：银行家舍入法。
		*/

		/*
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		//StreamTokenizer.TT_EOF这个是个参数，就是EOF
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) in.nval;
			int appears[] = new int[32768];// 记录出现次数
			int max = 0;
			for (int i = 0; i < n; i++) {
				in.nextToken();//指向下一个
				int num = (int) in.nval;//scanner.nextInt();
				appears[num]++;
				if (appears[num] >= (n + 1) / 2) {
					max = num;
				}
			}
			out.println(max);
			out.flush();//刷新，不然max会留在缓冲区
		}
		*/

		int a = 1, b = 3, c = 10;

		BigInteger x, y, z, ans;

		x = BigInteger.valueOf(a);
		y = BigInteger.valueOf(b);
		z = BigInteger.valueOf(c);

		ans = x.add(y);
		System.out.println(ans);

		ans = z.divide(y);
		System.out.println(ans);

		ans = x.mod(z);
		System.out.println(ans);
	}
}