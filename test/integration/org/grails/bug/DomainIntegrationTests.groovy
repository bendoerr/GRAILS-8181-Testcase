package org.grails.bug

class DomainIntegrationTests extends GroovyTestCase {

    void testThatFails() {
        // This works
        Thingamabob t = new Thingamabob(name: "Bob")
        assert t.save(flush: true, failOnError: true)
        assert Thingamabob.findByName(t.name)

        Gizmo g = new Gizmo(name: "Giz")
        assert g.save(flush: true, failOnError: true)

        // These pass
        assert Gizmo.list()[0].name == g.name
        assert Gizmo.get(g.id).name == g.name

        // But this fails (returns null)
        assert Gizmo.findByName(g.name)
    }
}
