require 'rubygems'
require 'dish'

hash = {
    movie: 'Star Wars',
    actors: [
        { age: 22, name: 'luke'},
        { age: 35, name: 'Han'},
        { age: 400, name: 'Yoda'}
    ],
    favourite: true
}

p media = Dish(hash)
p media.movie
p media.actors.length

