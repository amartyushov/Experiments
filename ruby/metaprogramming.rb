class String
  def censor(word)
    self.gsub! "#{word}", "CENSORED"
  end

  def num_of_chars
    size
  end
end

p 'The bunny was in trouble'.censor('was')
p 'The bunny was in trouble'.num_of_chars