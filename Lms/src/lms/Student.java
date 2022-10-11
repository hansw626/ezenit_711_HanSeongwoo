package lms;

import java.util.ArrayList;

public class Student {

	// 모든 멤버변수는 private가 원칙
	private int number;
	private String name;
	private int subCnt;
	private ArrayList<Subject> subjects = new ArrayList<>();
	
	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	// Getter & Setter	// 모든 Getter & Setter는 pubilc이 원칙
	public int getNumber() {	// number는 조회만 가능
		return this.number;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSubCnt() {
		return this.subCnt;
	}
	
	public void setSubCnt(int subCnt) {
		this.subCnt = subCnt;
	}
	
	public ArrayList<Subject> getSubjects() {
		return this.subjects;
	}
	
	public void setSubjects(int idx, Subject subjects) {
		this.subjects.set(idx, subjects);
	}
	
	public void addSubjects(Subject subjects) {
		this.subjects.add(subjects);
	}
	// 그 외 기능 메소드는 용도에 맞게 public 또는 private로 처리
}
