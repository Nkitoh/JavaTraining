package ex09_04;

public class Ex09_04 {
	 public static void main(String[] args) {
	      System.out.println(3 << 2L - 1);
	      /*
	       * 3 << 1
	       * 答え:6
	       * int型
	       */
	      
	      System.out.println((3L << 2) - 1);
	      /*
	       *12 - 1
	       *答え:11
	       *long型 
	       */
	      
	      System.out.println(10 < 12 == 6 > 17);
	      /*
	       * true == false
	       * 答え:false
	       * boolean型
	       */
	      
	      System.out.println(10 << 12 == 6 >> 17);
	      /*
	       * 1010000000000000 == 0
	       * 答え:false
	       * boolean型
	       */
	      
	      System.out.println(13.5e-1 % Float.POSITIVE_INFINITY);
	      /*
	       * 1.35 % Infinity
	       * 答え:1.35
	       * float型
	       */
	      
	      System.out.println(Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY);
	      /*
	       * 答え:Nan
	       */
	      
	      System.out.println(Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY);
	      /*
	       * 答え:Infinity
	       */
	      
	      System.out.println(0.0 / -0.0 == -0.0 / 0.0);
	     /*
	      * Nan == Nan
	      * 答え:false
	      * boolean型
	      */
	      
	      System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);
	      /*
	       * 7fffffff + 80000000
	       * 答え:-1
	       * Integer型
	       */
	      
	      System.out.println(Long.MAX_VALUE + 5);
	      /*
	       * 7fffffffffffffff + 5
	       *  0x8000000000000004
	       *  -9223372036854775808 + 4
	       *  -9223372036854775804
	       *  答え:-9223372036854775804
	       *  long型
	       */
	      
	      System.out.println((short) 5 * (byte) 10);
	      /*
	       * 50
	       */
	      int i1 = 16;
	      System.out.println(i1 < 15 ? 1.72e3f : 0);
	      /*
	       * 答え:
	       * i < 15の時
	       * 1720
	       * float型
	       * i > 15の時
	       * 0
	       * float型
	       */
	      
	      int i2 = 3;
	      System.out.println(i2++ + i2++ + --i2);
	      /*
	       * 3 + 4 + 4 = 11
	       * 答え:11
	       * int型
	       */
	}
}
