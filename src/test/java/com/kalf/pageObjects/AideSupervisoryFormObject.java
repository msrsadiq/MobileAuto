package com.kalf.pageObjects;

import java.util.Random;

public class AideSupervisoryFormObject {
	String changesText = "";
	String commentsText = "";
	
	//Setters
	public void setChangesText(String changes){
		this.changesText = changes;
	}
	
	public void setCommentsText(String comments){
		this.commentsText = comments;
	}
	
	//Getters
	public String getChangesText(){
		return this.changesText;
	}
	
	public String getCommentsText(){
		return this.commentsText;
	}
	
	
}
