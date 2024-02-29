
package acme.entities.audit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Audit {

	// Serialisation identifier -----------------------------------------------

	private static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "[A-Z]{1,3}-[0-9]{3}")
	private String					code;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date					executionDate;

	@NotNull
	private Type					type;

	@NotBlank
	@Length(max = 100)
	private String					correctiveActions;

	@URL
	private String					link;

	// Relationships ----------------------------------------------------------
	@OneToMany(mappedBy = "audit")
	private Collection<AuditRecord>	records;

	// Derived attributes -----------------------------------------------------


	@Transient
	public Mark mark() {
		List<Mark> marksList = new ArrayList<Mark>();
		Set<Mark> marksSet = new TreeSet<Mark>();
		for (AuditRecord record : this.getRecords()) {
			Mark mark = record.getMark();
			marksList.add(mark);
			marksSet.add(mark);
		}
		Map<Mark, Integer> markFrequencies = new HashMap<Mark, Integer>();
		for (Mark mark : marksSet)
			markFrequencies.put(mark, Collections.frequency(marksList, mark));
		return Collections.max(markFrequencies.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
}
