package notice;

import java.sql.Timestamp;

public class NoticeDto {

	// no/title/content/user/password/reqDate/modDate/viewCnt
	private int no;
	private String title;
	private String content;
	private String user;
	private Timestamp regDate;
	private Timestamp modDate;
	private int viewCnt;
	
	// All Arguments Constructor
	public NoticeDto(int no, String title, String content, String user, String password, Timestamp reqDate,
			Timestamp modDate, int viewCnt) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.user = user;
		this.regDate = reqDate;
		this.modDate = modDate;
		this.viewCnt = viewCnt;
	}
	public NoticeDto(int no, String title, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
	}
	
	public NoticeDto(String user, String title, String content) {
		super();
		this.title = title;
		this.content = content;
		this.user = user;
	}

	// Getter & Setter
	public int getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getUser() {
		return user;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
}
