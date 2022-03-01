package vo;

import java.sql.Date;

public class RequestBean {
	int re_idx;
	String id;
	String re_locate;
	String re_content;
	Date re_date;
	int re_count;
	String re_btype;
	String re_blood;
	String re_rh;
	String image;
	String re_status;
	Date re_wri_date;
	String re_image;
	
	public String getRe_image() {
		return re_image;
	}
	public void setRe_image(String re_image) {
		this.re_image = re_image;
	}
	public int getRe_idx() {
		return re_idx;
	}
	public void setRe_idx(int re_idx) {
		this.re_idx = re_idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRe_locate() {
		return re_locate;
	}
	public void setRe_locate(String re_locate) {
		this.re_locate = re_locate;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public Date getRe_date() {
		return re_date;
	}
	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}
	public int getRe_count() {
		return re_count;
	}
	public void setRe_count(int re_count) {
		this.re_count = re_count;
	}
	public String getRe_btype() {
		return re_btype;
	}
	public void setRe_btype(String re_btype) {
		this.re_btype = re_btype;
	}
	public String getRe_blood() {
		return re_blood;
	}
	public void setRe_blood(String re_blood) {
		this.re_blood = re_blood;
	}
	public String getRe_rh() {
		return re_rh;
	}
	public void setRe_rh(String re_rh) {
		this.re_rh = re_rh;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRe_status() {
		return re_status;
	}
	public void setRe_status(String re_status) {
		this.re_status = re_status;
	}
	public Date getRe_wri_date() {
		return re_wri_date;
	}
	public void setRe_wri_date(Date re_wri_date) {
		this.re_wri_date = re_wri_date;
	}
	
}
