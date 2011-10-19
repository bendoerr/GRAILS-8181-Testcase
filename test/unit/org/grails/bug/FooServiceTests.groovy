package org.grails.bug

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(FooService)
@Mock([Foo, Thingamabob, Gizmo])
class FooServiceTests {

    void testCreateFoo() {
        def thing = new Thingamabob(name: 'Thing').save()
        def giz =  new Gizmo(name: 'Gizzy').save()

        def foo = new Foo(thingamabob: thing, name: 'my foo')

        foo.gizmo = Gizmo.findByName('Gizzy')
        // Replacing the line above with this line causes DomainIntegrationTests to pass
//        foo.gizmo = giz
        assert foo.save()
    }

}
