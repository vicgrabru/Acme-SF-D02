
package acme.entities.sponsorship;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.client.data.datatypes.Money;
import acme.entities.project.Project;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sponsorship extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "[A-Z]{1,3}-[0-9]{3}")
	private String				code;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				moment;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				duration;

	@NotNull
	@Valid
	private Money				amount;

	@NotNull
	private Type				type;

	@Email
	private String				email;

	@URL
	private String				link;

	// Relationships ----------------------------------------------------------

	@OneToMany(mappedBy = "sponsorship")
	private Collection<Invoice>	invoices;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Project			proyect;

}
