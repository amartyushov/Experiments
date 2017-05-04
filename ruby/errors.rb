#bad code
begin
  puts 9/0
rescue
  puts 'Rescue the error'
end

# ------------------------------------------------------------------------------

begin
  puts 9/0
rescue ZeroDivisionError => e
  puts "Rescue the error: #{e}"
end

# ------------------------------------------------------------------------------

def error_logger(e)
  File.open('files/error_log.txt', 'a') do |file|
    file.puts e
  end
end

begin
  puts nil * 10
rescue StandardError => e
  error_logger("Error: #{e} on #{Time.new}")
end