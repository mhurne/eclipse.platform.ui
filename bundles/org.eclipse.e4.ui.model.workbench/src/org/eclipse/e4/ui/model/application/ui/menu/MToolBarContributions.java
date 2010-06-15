/**
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      IBM Corporation - initial API and implementation
 */
package org.eclipse.e4.ui.model.application.ui.menu;

import java.util.List;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool Bar Contributions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.ui.model.application.ui.menu.MToolBarContributions#getToolBarContributions <em>Tool Bar Contributions</em>}</li>
 * </ul>
 * </p>
 *
 * @model
 * @generated
 */
public interface MToolBarContributions {

	/**
	 * Returns the value of the '<em><b>Tool Bar Contributions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.e4.ui.model.application.ui.menu.MToolBarContribution}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Bar Contributions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool Bar Contributions</em>' reference list.
	 * @model
	 * @generated
	 */
	List<MToolBarContribution> getToolBarContributions();
} // MToolBarContributions