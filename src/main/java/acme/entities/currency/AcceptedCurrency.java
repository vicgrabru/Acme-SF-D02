
package acme.entities.currency;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AcceptedCurrency extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				currency;

	private boolean				isSystemCurrency;

}
