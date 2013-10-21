package com.OMBAdatabase.ItemFiles;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

@Entity
public class SecurityQuestion {
   
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Key id;
	
	private String questionId;
    private String answer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    
    
    public Key getKey() 
	{
		return id;
	}

	public void setKey(Key id) 
	{
		this.id = id;
	}

	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}
	
    public SecurityQuestion(String questionId,String answer){
    	this.questionId=questionId;
    	this.answer=answer;
    }
    
    public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
    public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
