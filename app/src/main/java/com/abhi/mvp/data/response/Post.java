package com.abhi.mvp.data.response;

/**
 * The type Post.
 */
public class Post {
	private int id;
	private String title;
	private String body;
	private int userId;

	/**
	 * Get id int.
	 *
	 * @return the int
	 */
	public int getId(){
		return id;
	}

	/**
	 * Get title string.
	 *
	 * @return the string
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * Get body string.
	 *
	 * @return the string
	 */
	public String getBody(){
		return body;
	}

	/**
	 * Get user id int.
	 *
	 * @return the int
	 */
	public int getUserId(){
		return userId;
	}
}
