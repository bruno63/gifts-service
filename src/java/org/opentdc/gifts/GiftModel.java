/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Arbalo AG
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.opentdc.gifts;

import java.util.Comparator;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Bruno Kaiser
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class GiftModel {

	private String id;		// sortable
	private String title;	// mandatory
	private String description;
	private Date createdAt;
	private String createdBy;
	private Date modifiedAt;
	private String modifiedBy;

	/**
	 * Empty constructor.
	 */
	public GiftModel() {
	}

	/**
	 * Constructor.
	 * @param title	the title (mandatory)
	 * @param description	a description
	 */
	public GiftModel(String title, String description) {
		this.title = title;
		this.description = description;
	}

	/**
	 * Get the id.
	 * @return the id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the id.
	 * @param id the id to set, normally this is done on the server only (unique id).
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the title.
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title.
	 * @param title  the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description.
	 * @param description  the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
/**
	 * Get the creation date.
	 * @return the creation date
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Set the creation date. This attibute should only be set once at creation time and exclusively by the server.
	 * @param createdAt the date when this object was created.
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/** 
	 * Get the creation date.
	 * @return the creation date
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Set the createdBy attribute, i.e. the user that created the attribute.
	 * This attribute should only be set once at creation time and exclusively by the server.
	 * @param createdBy  the loginId of the user having created the object
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Get the date of the last modification. 
	 * @return the date of the last modification
	 */
	public Date getModifiedAt() {
		return modifiedAt;
	}

	/**
	 * Set the modification date. This should only be change by the server when updating an object.
	 * @param modifiedAt  the date of the last modification
	 */
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	/**
	 * Get the modifiedBy attribute, i.e. the loginId of the user who made the last update.
	 * @return modifiedBy the loginId of the user who made the last update
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Set the modifiedBy attribute, i.e. the loginId of the user who made the last update.
	 * @param modifiedBy the loginId of the user who made the last update
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	/******************************* Comparator *****************************/
	/**
	 * Comparator for comparing two rates based on their id.
	 */
	public static Comparator<GiftModel> GiftComparator = new Comparator<GiftModel>() {

		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 * @return -1 if the first object is null of smaller; otherwise it returns +1
		 */
		public int compare(GiftModel obj1, GiftModel obj2) {
			if (obj1.getId() == null) {
				return -1;
			}
			if (obj2.getId() == null) {
				return 1;
			}

			String _attr1 = obj1.getId();
			String _attr2 = obj2.getId();

			// ascending order
			return _attr1.compareTo(_attr2);

			// descending order
			// return _attr2.compareTo(_attr1);
		}
	};
}
