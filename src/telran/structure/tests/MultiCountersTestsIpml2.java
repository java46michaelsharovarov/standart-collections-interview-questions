package telran.structure.tests;

import telran.structure.MultiCounters;
import telran.structure.MultiCountersImpl2;

class MultiCountersTestsIpml2 extends MultiCountersTests {

	@Override
	MultiCounters creatMultiCounters() {
		return new MultiCountersImpl2();		
	}

}
