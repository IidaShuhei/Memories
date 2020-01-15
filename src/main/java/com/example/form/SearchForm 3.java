package com.example.form;

/**
 * 検索フォーム.
 * 
 * @author iidashuhei
 *
 */
public class SearchForm {

	private Integer search;
	private String contents;

	/**
	 * @return the search
	 */
	public Integer getSearch() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(Integer search) {
		this.search = search;
	}

	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "SearchForm [search=" + search + ", contents=" + contents + "]";
	}

}