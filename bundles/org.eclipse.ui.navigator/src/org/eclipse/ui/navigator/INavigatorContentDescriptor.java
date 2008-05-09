/*******************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.ui.navigator;

import java.util.Set;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.internal.navigator.extensions.OverridePolicy;

/**
 * 
 * The descriptor provides a handle to a content extension. Information such as
 * the Id, the name, the priority, and whether the descriptor provides one or
 * more root elements is provided.
 * 
 * 
 * <p>
 * There is one {@link INavigatorContentExtension} for each content service.
 * There is only one {@link INavigatorContentDescriptor} for each extension.
 * </p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * 
 * @since 3.2
 * 
 */
public interface INavigatorContentDescriptor {

	/**
	 * Returns the navgiator content extension id
	 * 
	 * @return the navgiator content extension id
	 */
	String getId();

	/**
	 * Returns the name of this navigator extension
	 * 
	 * @return the name of this navigator extension
	 */
	String getName();

	/**
	 * Returns the priority of the navigator content extension.
	 * 
	 * @return the priority of the navigator content extension. Returns {@link Priority#NORMAL}
	 *         if no priority was specified.
	 */
	int getPriority();

	/**
	 * The enabledByDefault attribute specifies whether an extension should be
	 * activated in the context of a viewer automatically. Users may override
	 * this setting through the "Types of Content" dialog.
	 * 
	 * @return true if the extension is enabled by default.
	 */
	boolean isActiveByDefault();

	/**
	 * Determine if this content extension is enabled for the given element.
	 * 
	 * @param anElement
	 *            The element that should be used for the evaluation.
	 * @return True if and only if the extension is enabled for the element.
	 */
	boolean isTriggerPoint(Object anElement);

	/**
	 * Determine if this content extension could provide the given element as a
	 * child.
	 * 
	 * <p>
	 * This method is used to determine what the parent of an element could be
	 * for Link with Editor support.
	 * </p>
	 * 
	 * @param anElement
	 *            The element that should be used for the evaluation.
	 * @return True if and only if the extension might provide an object of this
	 *         type as a child.
	 */
	boolean isPossibleChild(Object anElement);

	/**
	 * A convenience method to check all elements in a selection.
	 * 
	 * @param aSelection
	 *            A non-null selection
	 * @return True if and only if every element in the selection is a possible
	 *         child.
	 */
	boolean arePossibleChildren(IStructuredSelection aSelection);

	/**
	 * @return Returns the suppressedExtensionId or null if none specified.
	 */
	String getSuppressedExtensionId();

	/**
	 * @return Returns the overridePolicy or null if this extension does not
	 *         override another extension.
	 */
	OverridePolicy getOverridePolicy();

	/**
	 * @return The descriptor of the <code>suppressedExtensionId</code> if
	 *         non-null.
	 */
	INavigatorContentDescriptor getOverriddenDescriptor();

	/**
	 * 
	 * Does not force the creation of the set of overriding extensions.
	 * 
	 * @return True if this extension has overridding extensions.
	 */
	boolean hasOverridingExtensions();

	/**
	 * @return The set of overridding extensions (of type
	 *         {@link INavigatorContentDescriptor}
	 */
	Set getOverriddingExtensions();

	/**
	 * @return true if the extension's content provider may adapt to a {@link SaveablesProvider}.
	 */
	boolean hasSaveablesProvider();

}
