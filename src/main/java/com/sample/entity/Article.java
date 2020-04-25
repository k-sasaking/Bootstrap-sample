package com.sample.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Article")
public class Article {

    /* Columnの定義 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Integer id;

    @Column(name = "post_name", length = 30)
    @NotEmpty
	private String postName;
    
    @Column(name = "post_date")
    private Date postDate;
	
    @Column(name = "post_text", length = 200)
    @NotNull
	private String postText;
	
    @Column(name = "is_published")
    @NotNull
	private boolean isPublished;
    
	public Article() {

	}
	
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getPostText() {
		return postText;
	}
	public void setPostText(String postText) {
		this.postText = postText;
	}
	public boolean getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}
	
}
