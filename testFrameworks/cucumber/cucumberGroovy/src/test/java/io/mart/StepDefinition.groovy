package io.mart

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Then(~/^Sum is (\d+)$/) { int expectedValue ->

}
Given(~/^I input (\d+)$/) { int value ->

}
When(~/^I sum$/) { ->

}

Given(~/^greeting$/) { ->
    assert hello() == 'hi'
}