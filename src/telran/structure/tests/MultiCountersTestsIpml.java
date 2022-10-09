package telran.structure.tests;

import telran.structure.MultiCounters;
import telran.structure.MultiCountersImpl;

class MultiCountersTestsIpml extends MultiCountersTests {

	@Override
	MultiCounters creatMultiCounters() {
		return new MultiCountersImpl();		
	}

}
