package ex07_02;

public class Ex07_02 {
	

	public static void main(String[] args) {
		Literal Test = new Literal();
		
		//boolean
		//Test.bo = '3';//型の不一致: char から boolean には変換できません
		//Test.bo = 3;//型の不一致: int から boolean には変換できません
		//Test.bo = 3f;//型の不一致: float から boolean には変換できません
		
		//char
		//Test.c = 3.5f;//型の不一致: float から char には変換できません
		//Test.c = 3.5d;//型の不一致: double から char には変換できません
		//Test.c = 200l;//型の不一致: long から char には変換できません
		Test.c = 0x2d;
		
		//byte
		//Test.by = 300;//型の不一致: int から byte には変換できません
		//Test.by = 3.0f;//型の不一致: float から byte には変換できません
		Test.by = 120;
		
		
		//short
		//Test.s = 2e15;//型の不一致: double から short には変換できません
		Test.s = (short)0x1p14;//16384
		Test.s = (short)1e4;//10000
		Test.s = (short)0x1p20;//0
		Test.s = (short)30000000000.0f;//-1
		//Test.s = 1000000;//型の不一致: int から short には変換できません

		//int
		//Test.i = 3.5f;//型の不一致: float から int には変換できません
		Test.i = (int)3.5f;//3
		
		//long
		Test.lo = (long)0x1p20;//1048576
		//Test.lo = 3.5f;//型の不一致: float から long には変換できません
		
		//float
		//Test.f = 3.5d;//型の不一致: double から float には変換できません
		//Test.f = 3e10;//型の不一致: double から float には変換できません
		Test.f = 3e7f;//3.0E7

		//double
		Test.d = 3.5f;//3.5
		Test.d = 3l;//3.0
		//Test.d = true;//boolean から double には変換できません
		Test.d = 'd';//100.0
	}
}

class Literal {
	boolean bo;
	char c;
	byte by;
	short s;
	int i;
	long lo;
	float f;
	double d;
}
