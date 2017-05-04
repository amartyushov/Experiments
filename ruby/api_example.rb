require 'rubygems'
require 'httparty'

class Resty
  include HTTParty
  base_uri 'localhost:9292'

  def posts
    self.class.get('/32')
  end
end

var = Resty.new
puts var.posts

response = HTTParty.get('http://api.stackexchange.com/2.2/questions?site=stackoverflow')

puts response.code
puts response.message
puts response.headers.inspect

class StackExchange
  include HTTParty
  base_uri 'api.stackexchange.com'

  def initialize(service, page)
    @options = {query: {site: service}}
  end

  def questions
    self.class.get('/2.2/questions', @options)
  end

  def users
    self.class.get('/2.2/users', @options)
  end
end

instance = StackExchange.new('stackoverflow', 1)
puts instance.users
