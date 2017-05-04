package io.mart

/**
 * @author Aleksandr Martiushov
 */
class World {
}

class Greeter {
    def hello() {
        'hi'
    }
}

World(){
    World.mixin Greeter
    new World()
}