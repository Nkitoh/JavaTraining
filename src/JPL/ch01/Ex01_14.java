package ch01;

public class Ex01_14 {
	public static void main(String[] args) {
		Walkman Walkman = new Walkman();
		Walkman2 Walkman2 = new Walkman2();
		Walkman3 Walkman3 = new Walkman3();

		System.out.println("Walkman");
		Walkman.start_listen_music_terminal_one();
		Walkman.start_listen_music_terminal_one();
		Walkman.stop_listen_music_terminal_one();
		Walkman.stop_listen_music_terminal_one();

		System.out.println("Walkman2");
		Walkman2.start_listen_music_terminal_one();
		Walkman2.start_listen_music_terminal_two();
		Walkman2.start_listen_music_terminal_one();
		Walkman2.start_listen_music_terminal_two();
		Walkman2.stop_listen_music_terminal_one();
		Walkman2.stop_listen_music_terminal_two();
		Walkman2.stop_listen_music_terminal_one();
		Walkman2.stop_listen_music_terminal_two();

		System.out.println("Walkman3");
		Walkman3.start_listen_music_terminal_one();
		Walkman3.communicate();
		Walkman3.start_listen_music_terminal_two();
		Walkman3.communicate();
		Walkman3.start_listen_music_terminal_one();
		Walkman3.communicate();
		Walkman3.start_listen_music_terminal_two();
		Walkman3.communicate();
		Walkman3.stop_listen_music_terminal_one();
		Walkman3.communicate();
		Walkman3.stop_listen_music_terminal_two();
		Walkman3.communicate();
		Walkman3.stop_listen_music_terminal_one();
		Walkman3.communicate();
		Walkman3.stop_listen_music_terminal_two();
		Walkman3.communicate();

	}

}

/**
 * 端子１で音楽を聴く 端子１： 音楽を聴き始める ・空き　：音楽を聴く ・使用中：使用中なので聞けない
 * 
 * 音楽を聴くのをやめる ・空き　：誰も聞いていない ・使用中：音楽をやめる
 */
class Walkman {
	public enum Terminal {
		USING, VACANT;
	}

	private Terminal terminal;

	Walkman() {
		terminal = Terminal.VACANT;
	}

	void start_listen_music_terminal_one() {
		if (terminal == Terminal.VACANT) {
			System.out.println("Terminal1:listen Music");
			terminal = Terminal.USING;
		} else if (terminal == Terminal.USING) {
			System.out.println("Terminal1:Now USING.Not listening");
		} else {
			assert false;
		}
	}

	void stop_listen_music_terminal_one() {
		if (terminal == Terminal.VACANT) {
			System.out.println("Terminal1:No one listen music");
		} else if (terminal == Terminal.USING) {
			System.out.println("Terminal1:Stop listen music");
			terminal = Terminal.VACANT;
		} else {
			assert false;
		}
	}

	Terminal get_terminal_condition() {
		return terminal;
	}
}

/**
 * 端子２で音楽を聴く 端子２： 音楽を聴き始める ・空き　：音楽を聴く ・使用中：使用中なので聞けない
 * 
 * 音楽を聴くのをやめる ・空き　：誰も聞いていない ・使用中：音楽をやめる
 */
class Walkman2 extends Walkman {
	private Terminal terminal_two;

	Walkman2() {
		terminal_two = Terminal.VACANT;
	}

	void start_listen_music_terminal_two() {
		if (terminal_two == Terminal.VACANT) {
			System.out.println("Terminal2:Listen Music");
			terminal_two = Terminal.USING;
		} else if (terminal_two == Terminal.USING) {
			System.out.println("Terminal2:Now USING.Not Listening");
		} else {
			assert false;
		}
	}

	void stop_listen_music_terminal_two() {
		if (terminal_two == Terminal.VACANT) {
			System.out.println("Terminal2:No one listen music");
		} else if (terminal_two == Terminal.USING) {
			System.out.println("Terminal2:Stop listen music");
			terminal_two = Terminal.VACANT;
		} else {
			assert false;
		}
	}

	Terminal get_terminal_two_condition() {
		return terminal_two;
	}
}

/**
 * 端子間で通信をする
 * 
 * 端子１：使用中 端子２：使用中 通信できる
 * 
 * それ以外の状態 通信できない
 */
class Walkman3 extends Walkman2 {

	void communicate() {
		if (get_terminal_condition() == Terminal.VACANT
				&& get_terminal_two_condition() == Terminal.VACANT) {
			System.out.println("No one listen music");
		} else if (get_terminal_condition() == Terminal.USING
				&& get_terminal_two_condition() == Terminal.VACANT) {
			System.out.println("Terminal2 isn't listening music");
		} else if (get_terminal_condition() == Terminal.VACANT
				&& get_terminal_two_condition() == Terminal.USING) {
			System.out.println("Terminal1 isn't listening music");
		} else {
			System.out.println("Start communicating!!");
		}
	}

}
