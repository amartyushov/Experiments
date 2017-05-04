full = lambda {|first, second| first + " " + second}
p full.call("my", "lamda")

p '-----------------------------------------------------------'

yourProc = Proc.new {|first, second| first + " " + second}
p yourProc.call("my", "proc")

p '-----------------------------------------------------------'

def method
  p 'method output'
end
method

p '-----------------------------------------------------------'

i=0
while i < 10
  puts i
  i += 1
end

p '-----------------------------------------------------------'

arr = ['a', 'b', 'c']
arr.each do |i|
  p i
end

arr.each {|i| p i}

p '-----------------------------------------------------------'

# for loops not used a lot
for i in 0..3
  p i
end

p '-----------------------------------------------------------'

teams = {
    "Milan" => {
        "goalkeeper" => "abbiati",
        "defender" => "maldini"
    },
    "Juventus" => {
        "goalkeeper" => "buffon",
        "defender" => "zambrotta"
    }
}

teams.each do |team, players|
  p team
  players.each do |position, name|
    p "#{name} plays on #{position}"
  end
end

p '-----------------------------------------------------------'

(1..10).to_a.select do |x|
  x.even?
end

(1..10).to_a.select { |x| x.even? }

(1..10).to_a.select(&:even?)

arr = [1, 2, 3, 4]
arr.select!(&:even?)
p arr

array = %w(The quick brown fox jumped over the lazy dog)
array.select! { |x| x.length > 5}
p array

ar = %w(a d f g h)
ar.select! { |v| v =~ /[ad]/ }
p ar

p '-----------------------------------------------------------'

a = ["1", "2.3", "2", "0"]
a.map {|x| x.to_i}
a.map!(&:to_i)
p a

p ("a".."d").to_a.map! {|i| i*2 }

p '-----------------------------------------------------------'

p Hash[[1, 2.1, 3.33, 0.9].map {|x| [x, x.to_i]}]

p Hash[%w(A dynamic open source programmig language).map {|x| [x, x.length]}]

{:a => "foo", :b => "bar"}.map {|a, b| "#{a}=#{b}"}.join('&')
# => "a=foo&b=bar"

p '-----------------------------------------------------------'

p [3, 2, 10, 4].inject(&:+)

p '-----------------------------------------------------------'
# Array
y = Array.new
y[0]=1
y[2]=5
y[4]=20
p y

y.delete(1)
p y

y.delete_at(2)
p y

t = [3, 4, 5]
t.delete_if {|t| t < 5}
p t

com = %w(Milan Inter Real)
p com.join(',')
p com.push('MU')
p com.push('Liverpool', 'Zenit')
p com.pop

p '-----------------------------------------------------------'
#Hash

positions = {
    first_base: "Chris",
    second_base: "Carlos"
}

positions2 = {
    "first_base" => "Chris",
    "second_base" => "Carlos"
}

positions3 = {
    :first_base => "Chris",
    :second_base => "Carlos"
}

p positions[:second_base]
positions.delete(:second_base)
p positions

p '-----------------------------------------------------------'

positions3.each_key {|r| p r }
positions3.each_value {|r| p r }

p '-----------------------------------------------------------'

positions3[:third_base] = "Mike"
pos4 = positions3.invert
p pos4.merge(positions3)
p pos4.to_a
p pos4.keys
p pos4.values

p '-----------------------------------------------------------'

if 5<4 && 4>1
  p 'Hello'
elsif 4>5
  p 'NO'
else
  p 'R'
end

p '-----------------------------------------------------------'

d = %w(M F L)
unless d.empty?
  d.each {|d| p d}
end

if  !d.empty?
  d.each {|d| puts d}
end

d.each {|d| p d}

p '-----------------------------------------------------------'

class ApiConnector
  attr_accessor :title, :description, :url

  def test_method
    puts "test class call"
  end

  def initialize(title, description, url)
    @title = title
    @description = description
    @url = url
    puts "Invoking constructor"
  end

  def testing_initializers
    puts @title
    puts @description
    puts @url
  end
end

var = ApiConnector.new("My title", "My descr", "My url")
var.url = "http://google.com"
puts var.url
var.test_method
var.testing_initializers

