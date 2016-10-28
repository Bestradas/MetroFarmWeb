package com.co.farmatech.metrofarm.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a single "page" of data returned to the client along with metadata about the entire data set.
 * 
 * @author cliff.meyers
 */
@XmlRootElement(name="PageResponse")
public class PageData implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8024919761328376524L;

	public int getNumRows() {
		return numRows;
	}

	/** The current page. */
	private int currentPage;
	
	/** The max pages. */
	private int maxPages;
	
	/** The rows per page. */
	private int rowsPerPage = 3;
	
	/** The num rows. */
	private int numRows;
	
	/** The first. */
	private boolean firstQuery = true;
	
	/** The o. */
	private Object object;
	
	/** The s. */
	private String string;

	/**
	 * Gets the current page.
	 *
	 * @return the current page
	 * @see com.todo1.psf.commons.paging.Paging#getCurrentPage()
	 */
	
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * Gets the first row number.
	 *
	 * @return the first row number
	 * @see com.todo1.psf.commons.paging.Paging#getFirstRowNumber()
	 */
	
	public int getFirstRowNumber() {
		return (currentPage - 1) * rowsPerPage;
	}

	/**
	 * Gets the last row number.
	 *
	 * @return the last row number
	 * @see com.todo1.psf.commons.paging.Paging#getLastRowNumber()
	 */
	
	public int getLastRowNumber() {
		int num = (currentPage * rowsPerPage) - 1;
		if (num >= (numRows - 1)) {
			return numRows - 1;
		}
		return num;
	}

	/**
	 * Gets the max pages.
	 *
	 * @return the max pages
	 * @see com.todo1.psf.commons.paging.Paging#getMaxPages()
	 */
	
	public int getMaxPages() {
		return maxPages;
	}

	/**
	 * Gets the rows per page.
	 *
	 * @return the rows per page
	 * @see com.todo1.psf.commons.paging.Paging#getRowsPerPage()
	 */
	
	public int getRowsPerPage() {
		return rowsPerPage;
	}

	/**
	 * Sets the current page.
	 *
	 * @param current the new current page
	 * @see com.todo1.psf.commons.paging.Paging#setCurrentPage()
	 */
	@XmlElement(name="CurrentPage")
	public void setCurrentPage(int current) {
		this.currentPage= current;
	}

	
	/**
	 * Sets the rows per page.
	 *
	 * @param rows the new rows per page
	 * @see com.todo1.psf.commons.paging.Paging#setRowsPerPage()
	 */
	@XmlElement(name="RowsPerPage")
	public void setRowsPerPage(int rows) {
		if (rows > 0) {
			this.rowsPerPage = rows;
			calculatePages();
		}
	}

	/**
	 * Sets the rows.
	 *
	 * @param rows the new rows
	 * @see com.todo1.psf.commons.paging.Paging#setRows(int)
	 */
	@XmlElement(name="NumRows")
	public void setNumRows(int rows) {
		if (rows < 0) {
			return;
		}
		this.numRows = rows;
		calculatePages();
	}

	/**
	 * Calculate pages.
	 */
	private void calculatePages() {
		maxPages = numRows / rowsPerPage;
		if ((numRows % rowsPerPage) > 0) {
			maxPages++;
		}
	}

	/**
	 * Sets the last page.
	 *
	 * @see com.todo1.psf.commons.paging.Paging#setLastPage()
	 */

	public void setLastPage() {
		currentPage = maxPages;
	}

	/**
	 * Checks for next.
	 *
	 * @return true, if successful
	 * @see com.todo1.psf.commons.paging.Paging#hasNext()
	 */
	public boolean hasNext() {
		return currentPage < maxPages;
	}

	/**
	 * Checks for previous.
	 *
	 * @return true, if successful
	 * @see com.todo1.psf.commons.paging.Paging#hasPrevious()
	 */
	
	public boolean hasPrevious() {
		return currentPage > 1;
	}

	/**
	 * Next page.
	 *
	 * @see com.todo1.psf.commons.paging.Paging#nextPage()
	 */
	
	public void nextPage() {
		if (hasNext()) {
			currentPage++;
		}
	}

	/**
	 * Previous page.
	 *
	 * @see com.todo1.psf.commons.paging.Paging#previousPage()
	 */
	
	public void previousPage() {
		if (hasPrevious()) {
			currentPage--;
		}
	}

	/**
	 * Gets the rows.
	 *
	 * @return the rows
	 * @see com.todo1.psf.commons.paging.Paging#getRows()
	 */
	
	public int getRows() {
		return numRows;
	}

	/**
	 * Checks if is first query.
	 *
	 * @return true, if is first query
	 * @see com.todo1.psf.commons.paging.Paging#isFirstQuery()
	 */
	
	public boolean isFirstQuery() {
		return firstQuery;
	}

	/**
	 * Gets the object.
	 *
	 * @return the object
	 * @see com.todo1.psf.commons.paging.Paging#getObject()
	 */
	
	public Object getObject() {
		return object;
	}

	/**
	 * Sets the object.
	 *
	 * @param o the new object
	 * @see com.todo1.psf.commons.paging.Paging#setObject(java.lang.Object)
	 */
	@XmlElement(name="Object")
	public void setObject(Object object) {
		this.object = object;

	}

	/**
	 * Gets the string.
	 *
	 * @return the string
	 * @see com.todo1.psf.commons.paging.Paging#getString()
	 */
	
	public String getString() {
		return string;
	}

	/**
	 * Sets the string.
	 *
	 * @param s the new string
	 * @see com.todo1.psf.commons.paging.Paging#setString(java.lang.String)
	 */
	@XmlElement(name="String")
	public void setString(String string) {
		this.string = string;
	}

	/**
	 * Sets the first query.
	 *
	 * @param first the new first query
	 * @see com.todo1.psf.commons.paging.Paging#setFirstQuery(boolean)
	 */
	@XmlElement(name="FirstQuery")
	public void setFirstQuery(boolean firstQuery) {
		this.firstQuery = firstQuery;
		
	}

	@XmlElement(name="MaxPages")
	public void setMaxPages(int maxPages) {
		this.maxPages = maxPages;
	}

		
	@Override
	public String toString() {
		return "PageData [currentPage=" + currentPage + ", maxPages=" + maxPages + ", rowsPerPage="
				+ rowsPerPage +", numRows=" + numRows + ", firstQuery=" + firstQuery + ", object="
				+ object + ", string=" + string + "]";
	}

	
	
        
        

}


