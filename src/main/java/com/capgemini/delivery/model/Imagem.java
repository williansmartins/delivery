package com.capgemini.delivery.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Imagem {
	
	@Id @GeneratedValue
	private Long id;
	private String url;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "imagens_tags",
        joinColumns = @JoinColumn(name = "imagem_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private List<Tag> tags;
	
	public Imagem(String url, Tag... tags) {
        this.url = url;
        this.tags =  Arrays.asList(tags);
        this.tags.forEach(x -> x.getImagens().add(this));
    }

	public Imagem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Imagem [id=" + id + ", url=" + url + ", tags=" + tags + "]";
	}
	
}