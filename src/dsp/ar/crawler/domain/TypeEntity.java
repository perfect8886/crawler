package dsp.ar.crawler.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "CRAWLER_TYPE")
@TableGenerator(name = "crawler_type_id", table = "CRAWLER_TABLE_GENERATOR", pkColumnName = "GGEN_NAME", valueColumnName = "GGEN_VALUE", pkColumnValue = "CRAWLER_TYPE_PK", allocationSize = 1)
public class TypeEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "crawler_type_id")
	@Column(name = "IID")
	private int id;

	@Column(name = "NNAME")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MovieEntity> movies;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AdEntity> ads;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieEntity> movies) {
		this.movies = movies;
	}

	public List<AdEntity> getAds() {
		return ads;
	}

	public void setAds(List<AdEntity> ads) {
		this.ads = ads;
	}
}