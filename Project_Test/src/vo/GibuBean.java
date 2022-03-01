package vo;

import java.sql.Date;

public class GibuBean {

	int do_idx;
	String id;
	String do_coment;
	String do_status;
	Date do_date;
	


	public Date getDo_date() {
		return do_date;
	}
	public void setDo_date(Date do_date) {
		this.do_date = do_date;
	}
	public int getDo_idx() {
		return do_idx;
	}
	public void setDo_idx(int do_idx) {
		this.do_idx = do_idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDo_coment() {
		return do_coment;
	}
	public void setDo_coment(String do_coment) {
		this.do_coment = do_coment;
	}

	public String getDo_status() {
		return do_status;
	}
	public void setDo_status(String do_status) {
		this.do_status = do_status;
	}
	
	
}
