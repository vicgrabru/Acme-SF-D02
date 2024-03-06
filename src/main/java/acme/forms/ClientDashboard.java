
package acme.forms;

import acme.client.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	private Integer				below25CompletnessProgressLogs;
	private Integer				between25and50CompletnessProgressLogs;
	private Integer				between50and75CompletnessProgressLogs;
	private Integer				above75CompletnessProgressLogs;

	private Double				avgContractBudget;
	private Double				stdContractBudget;
	private Double				minContractBudget;
	private Double				maxContractBudget;

}
