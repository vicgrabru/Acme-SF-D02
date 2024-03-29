/*
 * Dashboard.java
 *
 * Copyright (C) 2012-2024 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.forms;

import java.util.Map;

import acme.client.data.AbstractForm;
import acme.entities.project.Priority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	private static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	private Map<Priority, Integer>	totalNumberOfUserStoriesPerPriority;
	private Double					avgEstimatedCostOfUserStories;
	private Double					minEstimatedCostOfUserStories;
	private Double					maxEstimatedCostOfUserStories;
	private Double					stdEstimatedCostOfUserStories;

	private Double					avgEstimatedCostOfProjects;
	private Double					minEstimatedCostOfProjects;
	private Double					maxEstimatedCostOfProjects;
	private Double					stdEstimatedCostOfProjects;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
