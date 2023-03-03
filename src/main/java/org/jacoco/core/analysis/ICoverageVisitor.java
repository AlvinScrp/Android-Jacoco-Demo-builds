/*******************************************************************************
 * Copyright (c) 2009, 2021 Mountainminds GmbH & Co. KG and Contributors
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.analysis;

/**
 * Interface for coverage data output as a stream of {@link IClassCoverage}
 * instances.
 */
public interface ICoverageVisitor {

	/**
	 * For analyzed class coverage data is emitted to this method.
	 *
	 * @param coverage
	 *            coverage data for a class
	 */
	void visitCoverage(IClassCoverage coverage);

}
