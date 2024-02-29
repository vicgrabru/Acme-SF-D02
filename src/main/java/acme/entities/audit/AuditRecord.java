
package acme.entities.audit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AuditRecord {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "AU-[0-9]{4}-[0-9]{3}")
	private String				code;

	@NotNull
	private Integer				auditPeriod;

	@NotNull
	private Mark				mark;

	@URL
	private String				link;

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Audit				audit;

}
