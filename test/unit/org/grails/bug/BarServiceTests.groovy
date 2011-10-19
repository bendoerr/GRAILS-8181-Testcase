package org.grails.bug

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin

/*
NOTE: If you replace @TestMixin(DomainClassUnitTestMixin) with @Mock([Thingamabob, Gizmo]) and eliminate the mockDomain
      calls, the integration tests pass.
 */
@TestFor(BarService)
@TestMixin(DomainClassUnitTestMixin)
class BarServiceTests {

    void testMockThingamabob() {
        mockDomain(Thingamabob, [new Thingamabob(name: 'ABC')])
    }

    void testMockAnotherThingamabob() {
        // This mockDomain has to be in a different test method from the one above to trigger the issue.
        // If you comment out the line below, the DomainIntegrationTests pass
        mockDomain(Thingamabob, [new Thingamabob(name: 'DEF')])
    }

    void testMockGizmo() {
        mockDomain(Gizmo, [new Gizmo(name: 'GHI')])
    }

}
