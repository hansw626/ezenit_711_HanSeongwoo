package lms;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lms {	// Learning Management System

	private String name;
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	FileManager fm = new FileManager("students.txt");
	private ArrayList<Student> list = new ArrayList<>();
	private String[] subjectTitles = {"국어", "영어", "수학"};
	private int stuCnt;
	private int subCnt = subjectTitles.length;
	
	Lms(String name) {
		this.name = name;
	}
	
	int MainMenu() {
		System.out.println("[메인 메뉴]");
		System.out.println("1) 추가");
		System.out.println("2) 삭제");
		System.out.println("3) 정렬");
		System.out.println("4) 출력");
		System.out.println("5) 저장");
		System.out.println("6) 로드");
		System.out.println("0) 종료");
		System.out.print("선택 : ");
		int sel = scan.nextInt();
		
		return sel;
	}
	
	int printAddSubMenu() {
		System.out.println("1) 학생 등록");
		System.out.println("2) 수강 신청");
		System.out.println("3) 점수 입력");
		System.out.println("0) 뒤로가기");
		System.out.print("선택 : ");
		int sel = scan.nextInt();
		
		return sel;
	}
	
	int getStudent(int num) {
		int idx = -1;
		for(int i=0;i<stuCnt;i++) {
			int studentNum = this.list.get(i).getNumber();
			if(studentNum == num)
				idx = i;
		}
		
		return idx;
	}
	
	int getSubject(int stuIdx, String title) {
		int idx = -1;
		Student student = list.get(stuIdx);
		for(int i=0;i<student.getSubCnt();i++) {
			Subject subject = student.getSubjects().get(i);
			if(subject.getTitle().equals(title))
				idx = i;
		}
		
		return idx;
	}
	
	int ranNumGenerator() {
		int num = 0;
		// 중복 예외
		while(true) {
			num = ran.nextInt(9000)+1000;	// 4자리 학번
			
			if(getStudent(num)==-1)
				break;
		}
		
		return num;
	}
	
	void addStudent() {
		int number = ranNumGenerator();
		System.out.print("이름 입력 : ");
		String name = scan.next();
		
		Student student = new Student(number, name);
		System.out.printf("%d) %s\n", number, name);
		this.list.add(student);
		stuCnt++;
	}
	
	void printAllStudent() {
		System.out.print("[");
		for(Student s : list)
			System.out.print(s.getName() + " ");
		System.out.println("]");
	}
	
	void printAllSubject() {
		System.out.print("[");
		for(String s : subjectTitles)
			System.out.print(s + " ");
		System.out.println("]");
	}
	
	void addSubject() {
		System.out.println("학번 입력 : ");
		int num = scan.nextInt();
		int idx = getStudent(num);
		int idx2 = 0;
		String title = "";
		if(idx!=-1) {
			printAllSubject();
			System.out.print("수강할 과목 : ");
			title = scan.next();
			for(int i=0;i<subCnt;i++) {
				if(subjectTitles[i].equals(title))
					idx2 = i;
			}
			
			if(idx2!=-1 && getSubject(idx, title)==-1) {
				Subject subject = new Subject(title);
				list.get(idx).getSubjects().add(subject);
				list.get(idx).setSubCnt(list.get(idx).getSubCnt()+1);
			}else {
				System.out.println("신청 가능한 과목이 아닙니다.");
			}
		}else {
			System.out.println("해당 학생을 찾지 못했습니다.");
		}
	}
	
	void updateScore() {
		System.out.println("학번 입력 : ");
		int num = scan.nextInt();
		int idx = getStudent(num);
		String title = "";
		
		if(idx!=-1) {
			printAllSubject();
			System.out.print("과목명 : ");
			title = scan.next();
			int idx2 = getSubject(idx, title);
			if(idx2!=-1) {
				System.out.print("점수 입력 : ");
				int score = scan.nextInt();
				
				if(score>=0 && score<=100) {
					list.get(idx).getSubjects().get(idx2).setScore(score);
				}else {
					System.out.println("점수 범위를 초과한 값입니다.");
				}
			}else {
				System.out.println("해당 과목을 찾지 못했습니다.");
			}
		}else {
			System.out.println("해당 학생을 찾지 못했습니다.");
		}
	}
	
	
	void addSubMenu() {
		while(true) {
			int sel = printAddSubMenu();
			
			if(sel==1) {
				addStudent();
			}else if(sel==2) {
				addSubject();
			}else if(sel==3) {
				updateScore();
			}else if(sel==0) {
				break;
			}
		}
	}
	
	int printDelSubMenu() {
		System.out.println("1) 학생 삭제");
		System.out.println("2) 수강 취소");
		System.out.println("0) 돌아가기");
		int sel = scan.nextInt();
		
		return sel;
	}
	
	void delStudent() {
		System.out.print("학번 입력 : ");
		int num = scan.nextInt();
		int idx = getStudent(num);
		if(idx!=-1) {
			list.remove(idx);
			stuCnt--;
		}else {
			System.out.println("해당 학생을 찾지 못했습니다.");
		}
	}
	
	void delSubject() {
		System.out.print("학번 입력 : ");
		int num = scan.nextInt();
		int idx = getStudent(num);
		if(idx!=-1) {
			System.out.print("취소할 과목명 : ");
			String title = scan.next();
			Student student = this.list.get(idx);
			for(int i=0;i<student.getSubCnt();i++) {
				Subject subject = student.getSubjects().get(i);
				if(title.equals(subject.getTitle())) {
					student.getSubjects().remove(i);
					student.setSubCnt(student.getSubCnt()-1);
				}
			}
		}else {
			System.out.println("해당 학생을 찾지 못했습니다.");
		}
	}
	
	void delSubMenu() {
		while(true) {
			int sel = printDelSubMenu();
			
			if(sel==1) {
				delStudent();
			}else if(sel==2) {
				delSubject();
			}else if(sel==0) {
				break;
			}
		}
	}
	
	void sortName() {
		for(int i=stuCnt-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(list.get(j).getName().compareTo(list.get(j+1).getName())>0) {	// 이름순 오름차순 정렬
					Student temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
	}
	
	void printAll() {
		for(int i=0;i<stuCnt;i++) {
			Student student = list.get(i);
			System.out.printf("%s(%d) : ", student.getName(), student.getNumber());
			for(int j=0;j<student.getSubCnt();j++) {
				Subject subject = student.getSubjects().get(j);
				String title = subject.getTitle();
				int score = subject.getScore();
				System.out.printf("%s(%d)", title, score);
				if(j<student.getSubCnt()-1)
					System.out.print(", ");
			}
			System.out.println();
		}
	}
	
	
	void run() {
		while(true) {
			int sel = MainMenu();
			
			if(sel==1) {
				addSubMenu();
			}else if(sel==2) {
				delSubMenu();
			}else if(sel==3) {
				sortName();
			}else if(sel==4) {
				printAll();
			}else if(sel==5) {
				fm.saveData(list);
			}else if(sel==6) {
				this.list = fm.loadData();
				stuCnt = list.size();
			}else if(sel==0) {
				break;
			}
		}
	}
}
