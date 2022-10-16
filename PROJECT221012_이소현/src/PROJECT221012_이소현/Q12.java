package PROJECT221012_이소현;

import java.util.Scanner;
import java.util.Vector;

class Word1 {
	private String eng, kor;

	Word1(String eng, String kor) {
		this.eng = eng;
		this.kor = kor;
	}

	String Eng() {
		return eng;
	}

	String Kor() {
		return kor;
	}
}

public class Q12 {
	public static void main(String[] args) {
		var v = new Vector<Word1>();
		v.add(new Word1("love", "사랑"));
		v.add(new Word1("animal", "동물"));
		v.add(new Word1("dog", "강아지"));
		v.add(new Word1("cat", "고양이"));
		v.add(new Word1("computer", "컴퓨터"));
		v.add(new Word1("bag", "가방"));
		v.add(new Word1("book", "책"));
		v.add(new Word1("pencil", "연필"));
		v.add(new Word1("cloth", "옷"));
		v.add(new Word1("pants", "바지"));
		v.add(new Word1("head", "머리"));
		v.add(new Word1("hand", "손"));
		v.add(new Word1("foot", "발"));
		v.add(new Word1("arm", "팔"));
		v.add(new Word1("cigarettes", "담배"));
		v.add(new Word1("fire", "불"));
		v.add(new Word1("water", "물"));
		Scanner sc = new Scanner(System.in);
		System.out.println("**** 영어 단어 테스트 프로그램 \"명품영어\" 입니다. ****");
		while (true) {
			System.out.println();
			System.out.print("단어 테스트:1, 단어 삽입:2, 종료:3>> ");
			int b = sc.nextInt();
			if (b == 3)
				break;
			switch (b) {
			case 1:
				System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");
				System.out.println("love, animal, dog, cat, computer");
				System.out.println("bag, book, pencil, cloth, pants");
				System.out.println("head, hand, foot, arm, cigarettes");
				System.out.println("fire, water etc...");
				System.out.println("-1을 입력하면 테스트를 종료합니다.");
				System.out.println();
				int[] example = new int[4];
				while (true) {
					for (int i = 0; i < 4; i++) {
						int r = (int) (Math.random() * v.size());
						example[i] = r;
						if (i > 0 && example[i - 1] == example[i])
							i--;
					}
					int r2 = (int) (Math.random() * 4);
					System.out.println(v.get(example[r2]).Eng() + "?");

					for (int i = 0; i < 4; i++) {
						System.out.print("(" + (i + 1) + ")" + v.get(example[i]).Kor() + " ");
					}
					int answer = 0;
					System.out.print(":>");
					String tmp = sc.next();
					if (tmp.equals("1") || tmp.equals("2") || tmp.equals("3") || tmp.equals("4") || tmp.equals("-1"))
						answer = Integer.parseInt(tmp);
					else {
						System.out.println("숫자를 입력하세요 !!");
						System.out.println();
					}
					if (answer == -1)
						break;
					if (answer >= 1 && answer <= 4) {
						if (v.get(example[answer - 1]).Eng().equals(v.get(example[r2]).Eng())) {
							System.out.println("Excellent  !!");
							System.out.println();
						} else {
							System.out.println("No.  !!");
							System.out.println();
						}
					}
				}
				break;
			case 2:
				System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
				while (true) {
					System.out.print("영어 한글 입력 >> ");
					String eng = sc.next();
					if (eng.equals("그만"))
						break;
					String kor = sc.next();
					int count = 0;
					for (int i = 0; i < v.size(); i++) {
						String tmp = v.get(i).Eng();
						if (tmp.equals(eng))
							System.out.println("이미 있는 단어 입니다.. 다른 단어를 입력하세요!");
						else
							count++;
					}
					if (count == v.size())
						v.add(new Word1(eng, kor));
				}
				break;
			default:
				System.out.println("1, 2, 3중 하나를 입력하세요");
				break;
			}
		}
		sc.close();
	}
}
