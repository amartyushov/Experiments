require 'sinatra'

class HiSinatra < Sinatra::Base

  get '/' do
    'Hey Sinatra!'
  end

  get '/:age' do
    "Hi, I am #{params[:age]}"
  end
end