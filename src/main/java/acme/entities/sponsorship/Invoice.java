
package acme.entities.sponsorship;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Invoice extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "IN-[0-9]{4}-[0-9]{4}")
	private String				code;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				registrationTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				dueDate;

	@NotNull
	@Positive
	private Integer				quantity;

	@NotNull
	@PositiveOrZero
	private Integer				tax;

	@URL
	private String				link;

	// Derived attributes -----------------------------------------------------


	@Transient
	public Integer totalAmount() {
		return this.getQuantity() + (this.getTax()) / 100 * this.getQuantity();
	}
}
