package com.pega.platform.impl;

import com.pega.TestEnvironment;

import com.pega.platform.IndividualPortal;
import com.pega.platform.tiles.TopNav;
import com.pega.platform.tiles.impl.TopNavImpl;
import com.pega.page.PortalImpl;

public class PegaIndividualPortal extends PortalImpl implements IndividualPortal{
	private TopNav topNav = null;
	public PegaIndividualPortal(TestEnvironment testEnv) {
		super(testEnv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TopNav getTopNav() {
		if (topNav == null) {
			topNav = new TopNavImpl(testEnv);
		}
		return topNav;
	}

}
