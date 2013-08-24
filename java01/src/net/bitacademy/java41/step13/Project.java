package net.bitacademy.java41.step13;

import java.io.Serializable;
import java.sql.Date;

public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int 		no;
	protected String 	managerEmail;
	protected String 	title;
	protected String 	content;
	protected Date 		startDate;
	protected Date 		endDate;
	protected Date 		createdDate;
	
	public int getNo() {
		return no;
	}
	public Project setNo(int no) {
		this.no = no;
		return this;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public Project setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Project setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Project setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Project setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Project setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Project setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	
	public Project clone() {
		Project obj = new Project();
		obj.no = this.no;
		obj.managerEmail = this.managerEmail;
		obj.title = this.title;
		obj.content = this.content;
		obj.startDate = this.startDate;
		obj.endDate = this.endDate;
		obj.createdDate = this.createdDate;
		
		return obj;
	}
	
}
