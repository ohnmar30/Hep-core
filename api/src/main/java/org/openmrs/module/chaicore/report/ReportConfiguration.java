/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.chaicore.report;

import org.openmrs.module.chaicore.AbstractContentConfiguration;
import org.openmrs.module.chaicore.program.ProgramDescriptor;

import java.util.Map;
import java.util.Set;

/**
 * Configuration for reports
 */
public class ReportConfiguration extends AbstractContentConfiguration {

	private Set<ReportDescriptor> commonReports;

	private Map<ProgramDescriptor, Set<ReportDescriptor>> programReports;

	/**
	 * Gets the common reports
	 * @return the report descriptors
	 */
	public Set<ReportDescriptor> getCommonReports() {
		return commonReports;
	}

	/**
	 * Sets the common reports
	 * @param commonReports the report descriptors
	 */
	public void setCommonReports(Set<ReportDescriptor> commonReports) {
		this.commonReports = commonReports;
	}

	/**
	 * Gets the program specific reports
	 * @return the map of program and report descriptors
	 */
	public Map<ProgramDescriptor, Set<ReportDescriptor>> getProgramReports() {
		return programReports;
	}

	/**
	 * Sets the program specific reports
	 * @param programReports the map of program and report descriptors
	 */
	public void setProgramReports(Map<ProgramDescriptor, Set<ReportDescriptor>> programReports) {
		this.programReports = programReports;
	}
}