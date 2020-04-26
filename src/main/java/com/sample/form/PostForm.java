package com.sample.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class PostForm {

	@NotBlank
	private String postName;
	@NotEmpty
	private String postText;
	private boolean isPublished;
	
	PostForm() {
		this.isPublished = true;
	}
	
	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
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
