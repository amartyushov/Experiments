# r -read
# a - append
# w - write
# w+ - read and write
# a+ - read + append
# r+ - open file foe updating, both reading and writing

File.open('files/newFile.txt', 'w+') {|f| f.write('Line for the file') }

# ------------------------------------------------------------------------------

file_to_save = File.new('files/anotherFile.txt', 'w+')
file_to_save.puts('Line, for, the, file')
file_to_save.close

# ------------------------------------------------------------------------------

text = File.read('files/anotherFile.txt')
master_array = text.split(', ') + text.split(', ') #concatenating arrays


master_array.each {|t| p t.upcase}

# ------------------------------------------------------------------------------

# File.delete('files/newFile.txt')

# ------------------------------------------------------------------------------

10.times do
  sleep(1)
  puts 'Record saved'
  File.open('files/log.txt', 'a'){|f| f.puts "Server started at: #{Time.new}"}
end

