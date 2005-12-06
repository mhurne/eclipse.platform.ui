/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.ui.internal.dialogs;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

/**
 * A class that handles filtering wizard node items based on a supplied
 * matching string.
 *  
 * @since 3.2
 *
 */
public class WizardPatternFilter extends PatternItemFilter {

	/**
	 * Create a new instance of a WizardPatternFilter 
	 * @param isMatchItem
	 */
	public WizardPatternFilter(boolean isMatchItem) {
		super(isMatchItem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		ITreeContentProvider contentProvider = (ITreeContentProvider) ((TreeViewer) viewer)
				.getContentProvider();

		String text = null;
		Object[] children = null;
		if (element instanceof WizardCollectionElement) {
			WizardCollectionElement desc = (WizardCollectionElement) element;
			children = contentProvider.getChildren(desc);
			text = desc.getLabel();
		} else if (element instanceof WorkbenchWizardElement) {
			WorkbenchWizardElement desc = (WorkbenchWizardElement) element;
			children = contentProvider.getChildren(desc);
			text = desc.getLabel();
		}

		if (wordMatches(text)){
			// make sure the category has at least one matching child 
			// to prevent an empty caategory from appearing
			if (element instanceof WizardCollectionElement && children != null){
				for (int i = 0; i < children.length; i++){
					if (select(viewer, element, children[i]))
						return true;
				}
				return false;	// no matching children
			}
			return true;
		}

		if (matchItem && children != null) {
			// Will return true if any subnode of the element matches the search
			if (filter(viewer, element, children).length > 0)
				return true;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.internal.dialogs.PatternFilter#isElementSelectable(java.lang.Object)
	 */
	protected boolean isElementSelectable(Object element) {
		return element instanceof WorkbenchWizardElement;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.internal.dialogs.PatternFilter#isElementMatch(org.eclipse.jface.viewers.Viewer, java.lang.Object)
	 */
	protected boolean isElementMatch(Viewer viewer, Object element) {
		String text = null;
		if (element instanceof WizardCollectionElement) {
			WizardCollectionElement desc = (WizardCollectionElement) element;
			text = desc.getLabel();
		} else if (element instanceof WorkbenchWizardElement) {
			WorkbenchWizardElement desc = (WorkbenchWizardElement) element;
			text = desc.getLabel();
		}

		if (wordMatches(text))
			return true;

		return false;
	}

}
