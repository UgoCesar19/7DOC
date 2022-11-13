package br.com.alura.dayscode.model;

import java.util.List;
import java.util.Objects;

public class Top250Result {

	private List<Movie> items;
	
	private String errorMessage;

	public List<Movie> getItems() {
		return items;
	}

	public void setItems(List<Movie> items) {
		this.items = items;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorMessage, items);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Top250Result other = (Top250Result) obj;
		return Objects.equals(errorMessage, other.errorMessage) && Objects.equals(items, other.items);
	}

	@Override
	public String toString() {
		return "Top250Result [items=" + items + ", errorMessage=" + errorMessage + "]";
	}
	
}
