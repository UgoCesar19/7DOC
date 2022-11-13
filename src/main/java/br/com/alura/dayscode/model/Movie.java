package br.com.alura.dayscode.model;

import java.util.Objects;

public class Movie {

	private String id;
	private String rank;
	private String title;
	private String fullTitle;
	private String year;
	private String image;
	private String crew;
	private String imDbRating;
	private String imDbRatingCount;
	
	public String getId() {
		return id;
	}
	
	public String getRank() {
		return rank;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getFullTitle() {
		return fullTitle;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getImage() {
		return image;
	}
	
	public String getCrew() {
		return crew;
	}
	
	public String getImDbRating() {
		return imDbRating;
	}
	
	public String getImDbRatingCount() {
		return imDbRatingCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(crew, fullTitle, id, imDbRating, imDbRatingCount, image, rank, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(crew, other.crew) && Objects.equals(fullTitle, other.fullTitle)
				&& Objects.equals(id, other.id) && Objects.equals(imDbRating, other.imDbRating)
				&& Objects.equals(imDbRatingCount, other.imDbRatingCount) && Objects.equals(image, other.image)
				&& Objects.equals(rank, other.rank) && Objects.equals(title, other.title)
				&& Objects.equals(year, other.year);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", rank=" + rank + ", title=" + title + ", fullTitle=" + fullTitle + ", year=" + year
				+ ", image=" + image + ", crew=" + crew + ", imDbRating=" + imDbRating + ", imDbRatingCount="
				+ imDbRatingCount + "]";
	}
	
}
