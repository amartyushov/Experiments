class ApiConnector2
  attr_accessor :title, :description, :url

  def test_method
    puts "test class call"
  end

  def initialize(title, description, url='default value')
    @title = title
    @description = description
    @url = url
    puts "Invoking constructor"
  end

  def override_method
    puts 'method from parent'
  end

  def testing_initializers
    puts @title
    puts @description
    puts @url
  end

  private
  #following method is going to be private as well
  def private_method
    puts 'private method'
  end
end

class SmsConnector < ApiConnector2
  def override_method
    super
    puts 'method from child'
  end

  def send_sms
    p 'Sending sms'
  end
end

var = SmsConnector.new('My title', 'My descr')
var.test_method
var.override_method
#var.testing_initializers
#var.send_sms
