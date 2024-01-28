package com.example.foodblog.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO/Entity representing a Post
 */
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 3, max = 100)
	private String title;

	@Size(min = 3, max = 1000)
	private String content;

	@Size(min = 5, max = 50)
	@Pattern(regexp = "^\\/([a-z0-9]+-?)+\\/$", message="invalid url format")
	private String url;

	@Size(min = 3, max = 100)
	@JsonProperty("seo_title")
	private String seoTitle;

	@Size(min = 3, max = 500)
	@JsonProperty("seo_description")
	private String seoDescription;

	@JsonProperty("publication_date")
	private Date publicationDate;

	public Post() {

	}

	public Post(String title, String content, String url, String seoTitle, String seoDescription,
			Date publicationDate) {
		this.title = title;
		this.content = content;
		this.url = url;
		this.seoTitle = seoTitle;
		this.seoDescription = seoDescription;
		this.publicationDate = publicationDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSeoTitle() {
		return seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", url=" + url + ", seoTitle="
				+ seoTitle + ", seoDescription=" + seoDescription + ", publicationDate=" + publicationDate + "]";
	}



}
