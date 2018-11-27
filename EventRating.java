/**
 * 
 */
package com.tis.workshop.lambda;
import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsLast;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author mardubudi Example for comparable
 */
public final class EventRating implements Comparable<EventRating> {

	private Logger _logger = Logger.getLogger(EventRating.class.getName());

	enum Rating {

		Good, Poor, Fair, Ok_to_consider;
	}

	private String galleryName;
	private BigDecimal admissionPrice;
	private LocalDate date;
	private Rating rating;

	public EventRating(String galleryName, BigDecimal admissionPrice, LocalDate date, Rating rating) {
		this.galleryName = galleryName;
		this.admissionPrice = admissionPrice;
		this.date = date;
		this.rating = rating;
		ValidatedInfo();
	}

	@Override
	public boolean equals(Object aThat) {
		_logger.info("Ovrriding the equels method ");
		if (this == aThat)
			return true;
		if (!(aThat instanceof EventRating))
			return false;
		EventRating that = (EventRating) aThat;
		for (int i = 0; i < this.getSigFields().length; i++) {
			if (!Objects.equals(this.getSigFields()[i], that.getSigFields()[i])) {
				return false;
			}
		}
		return true;
	}

	private Object[] getSigFields() {

		_logger.info("Object array to find internal reffred array object and defined variables ");
		return new Object[] { date, galleryName, admissionPrice, rating };
	}

	private void ValidatedInfo() {
		_logger.info("********  Validate Info   ******");
		// Some stub to identify the validation
	}
	
	
	@Override public int hashCode() {
		_logger.info("Getting has for all Ojects of Object Array ");
		return Objects.hashCode(getSigFields());
	}

	private Comparator<EventRating> COMPARATOR = getComparato();
	
	@Override
	public int compareTo(EventRating that) {
		// TODO Auto-generated method stub
		int result = COMPARATOR.compare(this , that);
		 if (result == 0) {
		      assert this.equals(that) : 
		        this.getClass().getSimpleName() + ": compareTo inconsistent with equals."
		      ;
		    }
		    return result;
		  }  

	private Comparator<EventRating> getComparato() {
		// TODO Auto-generated method stub
		return null;
	}
	
	  public String getGalleryName() { return galleryName; }
	  public BigDecimal getAdmissionPrice() { return admissionPrice; }
	  public LocalDate getDate() { return date; }
	  
	  private static Comparator<EventRating> getComparator(){
		    Comparator<EventRating> result = comparing(EventRating::getDate)
		      .thenComparing(EventRating::getGalleryName)
		      .thenComparing(EventRating::getAdmissionPrice)
		      //nullable: no method exists, so use a lambda
		      .thenComparing(t -> t.rating, nullsLast(naturalOrder())) 
		    ;
		    return result;
		  }

}
