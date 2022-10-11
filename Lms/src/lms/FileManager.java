package lms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {
	
	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	FileManager(String fileName){
		file = new File(fileName);
	}
	
	void saveData(ArrayList<Student> list) {
		// 학번/학생명,과목명1/성적1,과목명2/성적2
		if(list != null) {
			String data = "";
			for(int i=0;i<list.size();i++) {
				Student student = list.get(i);
				data += student.getNumber() + "/";
				data += student.getName();
				ArrayList<Subject> subject = student.getSubjects();
				for(int j=0;j<student.getSubCnt();j++) {
					data += ",";
					data += subject.get(j).getTitle() + "/";
					data += subject.get(j).getScore();
				}
				data += "\n";
			}
			
			try {
				this.fw = new FileWriter(this.file);
				this.fw.write(data);
				this.fw.close();
				System.out.println("저장 성공");
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("저장 실패");
			}
		}else {
			System.out.println("저장할 데이터가 없습니다.");
		}
	}

	ArrayList<Student> loadData() {
		ArrayList<Student> list = new ArrayList<>();
		try {
			this.fr = new FileReader(this.file);
			this.br = new BufferedReader(this.fr);
			
			while(this.br.ready()) {
				String data = br.readLine();
				String[] info = data.split(",");
				
				int num = Integer.parseInt(info[0].split("/")[0]);
				String name = info[0].split("/")[1];
				Student student = new Student(num, name);
				for(int i=1;i<info.length;i++) {
					String title = info[i].split("/")[0];
					int Score = Integer.parseInt(info[i].split("/")[1]);
					Subject subject = new Subject(title, Score);
					student.addSubjects(subject);
				}
				student.setSubCnt(info.length-1);
				list.add(student);
			}
			this.fr.close();
			this.br.close();
			System.out.println("로드 성공");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("로드 실패");
		}
		
		return list;
	}
}
