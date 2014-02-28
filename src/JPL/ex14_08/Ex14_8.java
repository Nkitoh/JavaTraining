package ex14_08;

//yieldなし
//1回目
//Thread1injareth.hug() trying to invokecory.hugBack()
//Thread2incory.hug() trying to invokejareth.hugBack()
//デッドロック

//2回目
//Thread1injareth.hug() trying to invokecory.hugBack()
//Thread1incory.hugBack()
//Thread2incory.hug() trying to invokejareth.hugBack()
//Thread2injareth.hugBack()

//3回目
//Thread1injareth.hug() trying to invokecory.hugBack()
//Thread2incory.hug() trying to invokejareth.hugBack()
//デッドロック

//yieldあり
//1回目
//Thread1injareth.hug() trying to invokecory.hugBack()
//Thread1incory.hugBack()
//Thread2incory.hug() trying to invokejareth.hugBack()
//Thread2injareth.hugBack()

//2回目
//Thread1injareth.hug() trying to invokecory.hugBack()
//Thread2incory.hug() trying to invokejareth.hugBack()
//デッドロック

//3回目
//Thread1injareth.hug() trying to invokecory.hugBack()
//Thread2incory.hug() trying to invokejareth.hugBack()
//デッドロック

public class Ex14_8 {
	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");

		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);

		new Thread(new Runnable() {
			public void run() {
				jareth.hug();
			}
		}, "Thread1").start();

		new Thread(new Runnable() {
			public void run() {
				cory.hug();
			}
		}, "Thread2").start();

	}
}
